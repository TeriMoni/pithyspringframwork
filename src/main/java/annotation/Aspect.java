package annotation;

import java.lang.annotation.*;

/**
 * @Autor: bin.liu
 * @Desciption: ÇÐÃæ×¢½âÀà
 * @Date: Created in 14:31 2017/9/26
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
