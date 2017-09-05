package helper;

import annotation.Controller;
import annotation.Service;
import utils.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @Autor: bin.liu
 * @Desciption: �����������
 * @Date: Created in 13:09 2017/9/5
 */
public class ClassHelper {

    /**
     * ���ڴ�����м�����ļ���S
     */
    private  static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigerHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * ��ȡӦ�ð����µ�������
     * @return
     */
    public static Set<Class<?>> getClassSet(){
        return  CLASS_SET;
    }

    /**
     * ��ȡӦ�ð����µ�����service��
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
     * ��ȡӦ�ð����µ�����Controller��
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
     * ��ȡӦ�ð����µ�����bean��(����service��controller)
     * @return
     */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        classSet.addAll(getControllerClassSet());
        classSet.addAll(getServiceClassSet());
        return  classSet;
    }
}
