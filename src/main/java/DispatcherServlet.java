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
 * @Desciption: ����ַ���
 * @Date: Created in 18:30 2017/9/5
 */
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        //��ʼ�����helper��
        HelpLoader.init();
        //��ȡServerletContext����
        ServletContext servletContext = config.getServletContext();
        //ע�ᴦ�������jsp��servlet
        ServletRegistration jspServlet =  servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigerHelper.getAppJspPath()+"*");
        //ע�ᴦ��̬��Դ��servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigerHelper.getAppResourcePath()+"*");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //��ȡ���󷽷�������·��
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();
        //��ȡAction������
        Hander hander = ControllerHelper.getHander(requestMethod,requestPath);
        if(hander != null){
            //��ȡController���beanʵ��
            Class<?> controllerClass= hander.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
            //���������������
            Map<String,Object> paramMap = new HashMap<String,Object>();
            Enumeration<String> paramNames = req.getParameterNames();
            while (paramNames.hasMoreElements()){
                String paramName = paramNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName,paramValue);
            }
            //��ȡ�������еĶ���
            //����ʾ����https://www.liq83.com/getInfo?name="����"&age=1
            String body = CodeUtil.deocdeURL(StreamUtil.getString(req.getInputStream()));
            if(StringUtils.isNotEmpty(body)){
                String[] params = StringUtils.split(body,"&");
                if(ArrayUtil.isNotEmpty(params)){
                    for (String param:params) {
                        String[] array = StringUtils.split(param,"=");
                        //�����ַ�ļ�ֵ�� name="����"
                        if(ArrayUtil.isNotEmpty(array) && array.length == 2){
                            paramMap.put(array[0],array[1]);
                        }
                    }
                }
            }
            Param param = new Param(paramMap);
            //���÷�����÷���
            Method actionMethod = hander.getActionMethod();
            Object result = ReflectionUtil.invokeMethod(controllerBean,actionMethod,param);
            //����Action��������ֵ
            if(result instanceof View){
                //����View
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
                //����json����
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
