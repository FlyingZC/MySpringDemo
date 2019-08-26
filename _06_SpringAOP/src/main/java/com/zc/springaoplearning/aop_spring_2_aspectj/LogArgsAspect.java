package com.zc.springaoplearning.aop_spring_2_aspectj;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 配置 @Aspect 注解的 bean 会被 Spring 当做用来实现 AOP 的配置类
@Aspect
public class LogArgsAspect {

    // 这里可以设置一些自己想要的属性，到时候在配置的时候注入进来
    private boolean trace = true;

    // 配置切面
    @Before("com.zc.springaoplearning.aop_spring_2_aspectj.SystemArchitecture.businessService()")
    public void logArgs(JoinPoint joinPoint) {
        if (trace) {
            System.out.println("[@AspectJ] [LogArgsAspect] 方法执行前，打印入参：" + Arrays.toString(joinPoint.getArgs()));
        }
    }

    public void setTrace(boolean trace) {
        this.trace = trace;
    }

}
