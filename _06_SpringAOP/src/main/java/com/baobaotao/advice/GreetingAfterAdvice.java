package com.baobaotao.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后置增强
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("[后置增强] [GreetingAfterAdvice] Please enjoy yourself!");
    }
}
