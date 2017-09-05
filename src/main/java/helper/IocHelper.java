package helper;

import annotation.Inject;
import utils.ArrayUtil;
import utils.CollecionUtil;
import utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @Autor: bin.liu
 * @Desciption: ����ע�������
 * @Date: Created in 14:07 2017/9/5
 */
public class IocHelper {

    static {
        //��ȡbean����beanʵ����ӳ���ϵ
        Map<Class<?>,Object> beanMap = BeanHelper.getBenMap();
        if(CollecionUtil.isEmpty(beanMap)){
            //����beanMap
            for (Map.Entry<Class<?>,Object> beanEntry: beanMap.entrySet()) {
                //��beanMap�л�ȡ��Ӧ��ʵ��
                Class<?> beanClass= beanEntry.getKey();  //bean��
                Object beanInstance = beanEntry.getValue(); //beanʵ��
                //��ȡbean��������ֶ�
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtil.isNotEmpty(beanFields)){
                    //����beanFields
                    for (Field beanField: beanFields) {
                        //�жϴ�beanField�Ƿ���Injectע��
                        if(beanField.isAnnotationPresent(Inject.class)){
                            //��beanMap �л�ȡbean��Ӧ��ʵ��
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(beanFieldInstance != null){
                                //ͨ�������ʼ��beanFieldֵ
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
