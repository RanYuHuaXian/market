package test2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)//表示该注解作用于成员变量上
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnno {
    String name() default "";
    int age() default 0;
}
