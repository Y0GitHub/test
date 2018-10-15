package utlis;

/**
 * @Author: ky
 * @Date: 2018/10/15 13:05
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Json {
    Class<?> type();
    String include() default "";
    String filter() default "";
}
