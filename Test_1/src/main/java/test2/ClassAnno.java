package test2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//.TYPE表示该注解只能作用于类上
@Retention(RetentionPolicy.RUNTIME)//表示运行时加载该注解
public @interface ClassAnno {
    //声明注解中的属性
    boolean type();
    String name();
}
