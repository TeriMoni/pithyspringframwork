package helper;

import annotation.Action;
import bean.Hander;
import bean.Request;
import utils.ArrayUtil;
import utils.CollecionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Autor: bin.liu
 * @Desciption: 控制器帮助类
 * @Date: Created in 16:40 2017/9/5
 */
public class ControllerHelper {

    private static final Map<Request, Hander> ACTION_MAP = new HashMap<Request, Hander>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if(CollecionUtil.isNotEmpty(controllerClassSet)){
            for (Class<?> controllerClass:controllerClassSet) {
                //获取controller中的所有方法
                Method[] methods = controllerClass.getMethods();
                if(ArrayUtil.isNotEmpty(methods)){
                    //遍历controller中的所有方法
                    for (Method method:methods) {
                        //判断方法是否有action注解
                        if(method.isAnnotationPresent(Action.class)){
                            //从action中获取url映射内容
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            if(mapping.matches("\\w+:/\\w*")){
                                String[] array = mapping.split(":");
                                if(ArrayUtil.isNotEmpty(array) && array.length == 2){
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod,requestPath);
                                    Hander hander = new Hander(controllerClass,method);
                                    //初始化action map
                                    ACTION_MAP.put(request,hander);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取请求hander
     * @param requestMethod
     * @param requestPath
     * @return
     */
    public static Hander getHander(String requestMethod,String requestPath){
        Request request = new Request(requestMethod,requestPath);
        return  ACTION_MAP.get(request);
    }
}
