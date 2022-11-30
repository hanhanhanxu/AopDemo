package com.example.aopdemo.annotation;

import com.example.aopdemo.entity.Convert;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
//运行时也生效，否则编译期就消失了
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecordOperate {
    //一个属性是String类型的，用desc指定
    String desc() default "";
    //一个属性是一个Class，并且这个类是Convert的子类，使用convert指定
    Class<? extends Convert> convert();
}
