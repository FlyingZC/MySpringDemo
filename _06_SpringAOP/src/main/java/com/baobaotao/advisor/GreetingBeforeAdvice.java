package com.baobaotao.advisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前置增强
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        String clientName = (String) args[0];
        System.out.println("[前置增强] [GreetingBeforeAdvice] [目标类: " + target.getClass().getName() + "] ["
                + method.getName() + ", How are you！Mr." + clientName + "]");
    }
}
