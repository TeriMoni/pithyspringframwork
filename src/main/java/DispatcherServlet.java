import annotation.Controller;
import bean.Data;
import bean.Hander;
import bean.Param;
import bean.View;
import helper.BeanHelper;
import helper.ConfigerHelper;
import helper.ControllerHelper;
import org.apache.commons.lang3.StringUtils;
import utils.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Autor: bin.liu
 * @Desciption: 请求分发器
 * @Date: Created in 18:30 2017/9/5
 */
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        //初始化相关helper类
        HelpLoader.init();
        //获取ServerletContext对象
        ServletContext servletContext = config.getServletContext();
        //注册处理请求的jsp的servlet
        ServletRegistration jspServlet =  servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigerHelper.getAppJspPath()+"*");
        //注册处理静态资源的servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigerHelper.getAppResourcePath()+"*");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方法和请求路径
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();
        //获取Action处理器
        Hander hander = ControllerHelper.getHander(requestMethod,requestPath);
        if(hander != null){
            //获取Controller类和bean实例
            Class<?> controllerClass= hander.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
            //创建请求参数对象
            Map<String,Object> paramMap = new HashMap<String,Object>();
            Enumeration<String> paramNames = req.getParameterNames();
            while (paramNames.hasMoreElements()){
                String paramName = paramNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName,paramValue);
            }
            //获取请求体中的对象
            //请求示例，https://www.liq83.com/getInfo?name="张三"&age=1
            String body = CodeUtil.deocdeURL(StreamUtil.getString(req.getInputStream()));
            if(StringUtils.isNotEmpty(body)){
                String[] params = StringUtils.split(body,"&");
                if(ArrayUtil.isNotEmpty(params)){
                    for (String param:params) {
                        String[] array = StringUtils.split(param,"=");
                        //请求地址的键值对 name="张三"
                        if(ArrayUtil.isNotEmpty(array) && array.length == 2){
                            paramMap.put(array[0],array[1]);
                        }
                    }
                }
            }
            Param param = new Param(paramMap);
            //利用反射调用方法
            Method actionMethod = hander.getActionMethod();
            Object result = ReflectionUtil.invokeMethod(controllerBean,actionMethod,param);
            //处理Action方法返回值
            if(result instanceof View){
                //返回View
                View view = (View) result;
                String path = view.getPath();
                if(StringUtils.isNotEmpty(path)){
                    if(path.startsWith("/")){
                        resp.sendRedirect(req.getContextPath()+path);
                    }else{
                        Map<String,Object> model = view.getModel();
                        for (Map.Entry<String,Object> entry:model.entrySet()) {
                            req.setAttribute(entry.getKey(),entry.getValue());
                        }
                        req.getRequestDispatcher(ConfigerHelper.getAppJspPath()+path).forward(req,resp);
                    }
                }
            }else if(result instanceof Data){
                //返回json数据
                Data data = (Data) result;
                Object model = data.getModel();
                if(model != null){
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("utf-8");
                    PrintWriter writer = resp.getWriter();
                    String json = JsonUtil.toJson(model);
                    writer.write(json);
                    writer.flush();
                    writer.close();
                }
            }
        }
    }


}
