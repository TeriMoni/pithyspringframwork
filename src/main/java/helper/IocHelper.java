package helper;

import annotation.Inject;
import utils.ArrayUtil;
import utils.CollecionUtil;
import utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @Autor: bin.liu
 * @Desciption: 依赖注入帮助类
 * @Date: Created in 14:07 2017/9/5
 */
public class IocHelper {

    static {
        //获取bean类与bean实例的映射关系
        Map<Class<?>,Object> beanMap = BeanHelper.getBenMap();
        if(CollecionUtil.isEmpty(beanMap)){
            //遍历beanMap
            for (Map.Entry<Class<?>,Object> beanEntry: beanMap.entrySet()) {
                //从beanMap中获取对应的实例
                Class<?> beanClass= beanEntry.getKey();  //bean类
                Object beanInstance = beanEntry.getValue(); //bean实例
                //获取bean类的所有字段
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtil.isNotEmpty(beanFields)){
                    //遍历beanFields
                    for (Field beanField: beanFields) {
                        //判断次beanField是否有Inject注解
                        if(beanField.isAnnotationPresent(Inject.class)){
                            //在beanMap 中获取bean对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(beanFieldInstance != null){
                                //通过反射初始化beanField值
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
