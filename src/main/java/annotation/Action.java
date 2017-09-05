package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Autor: bin.liu
 * @Desciption: Action ����ע��
 * @Date: Created in 11:44 2017/9/5
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {

    /**
     * ����������·��
     * @return
     */
    String value();
}
