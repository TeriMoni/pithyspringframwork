package helper;

import utils.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Autor: bin.liu
 * @Desciption: bean������
 * @Date: Created in 13:51 2017/9/5
 */
public class BeanHelper {

    /**
     * ����beanӳ���ϵ�����ڴ��bean���beanʵ����ӳ���ϵ��
     */
    public static final Map<Class<?>,Object> BEN_MAP = new HashMap<Class<?>,Object>();

    static {
        Set<Class<?>> beanSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass:beanSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEN_MAP.put(beanClass,obj);
        }
    }

    /**
     * ��ȡbeanӳ��
     * @return
     */
    public static Map<Class<?>,Object> getBenMap(){
        return  BEN_MAP;
    }

    /**
     * ����beanʵ��
     * @param cls
     * @param object
     */
    public static void setBenMap(Class<?> cls, Object object) {
        BEN_MAP.put(cls,object);
    }

    /**
     * �������ȡbeanʵ��
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<?> cls){
        if(!BEN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not find bean by class:"+cls);
        }
        return (T) BEN_MAP.get(cls);
    }
}
