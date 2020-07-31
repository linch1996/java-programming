package cn.blackme.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {

    String value();

    // String desc();

    // String author();

    int age() default 18;

}
