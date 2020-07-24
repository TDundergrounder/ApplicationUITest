package com.aiways.utilities;

import java.lang.annotation.*;

/**
 * @author gyliang
 */ //用于描述类、接口(包括注解类型) 或enum声明
@Target(ElementType.TYPE)
//Inherited作用是，使用此注解声明出来的自定义注解，在使用此自定义注解时，如果注解在类上面时，子类会自动继承此注解，
//否则的话，子类不会继承此注解。这里一定要记住，使用Inherited声明出来的注解，只有在类上使用时才会有效，对方法，属性等其他无效
@Inherited
//RUNTIME:在运行时有效（即运行时保留）
@Retention(RetentionPolicy.RUNTIME )
public @interface ClientGroup {
    String value() default  "";
}
