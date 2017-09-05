package helper;

import annotation.Controller;
import annotation.Service;
import utils.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @Autor: bin.liu
 * @Desciption: 类操作帮助类
 * @Date: Created in 13:09 2017/9/5
 */
public class ClassHelper {

    /**
     * 用于存放所有加载类的集合S
     */
    private  static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigerHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包名下的所有类
     * @return
     */
    public static Set<Class<?>> getClassSet(){
        return  CLASS_SET;
    }

    /**
     * 获取应用包名下的所有service类
     * @return
     */
    public static  Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls: CLASS_SET) {
            if(cls.isAnnotationPresent(Service.class)){
                classSet.add(cls);
            }
        }
        return  classSet;
    }

    /**
     * 获取应用包名下的所有Controller类
     * @return
     */
    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls: CLASS_SET) {
            if(cls.isAnnotationPresent(Controller.class)){
                classSet.add(cls);
            }
        }
        return  classSet;
    }

    /**
     * 获取应用包名下的所有bean类(包括service，controller)
     * @return
     */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        classSet.addAll(getControllerClassSet());
        classSet.addAll(getServiceClassSet());
        return  classSet;
    }
}
