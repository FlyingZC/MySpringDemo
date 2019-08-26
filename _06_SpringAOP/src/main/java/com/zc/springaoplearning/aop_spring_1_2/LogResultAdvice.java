package com.zc.springaoplearning.aop_spring_1_2;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;


public class LogResultAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target)
            throws Throwable {
        System.out.println("[后置增强] [LogResultAdvice] 方法返回：" + returnValue);
    }
}
