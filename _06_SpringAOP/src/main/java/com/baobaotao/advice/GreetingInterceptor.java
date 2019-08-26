package com.baobaotao.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕增强
 */
public class GreetingInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String clientName = (String) args[0];
        System.out.println("[环绕增强] [GreetingInterceptor] How are you！Mr." + clientName + ".");
        Object obj = methodInvocation.proceed();
        System.out.println("[环绕增强] [GreetingInterceptor] Please enjoy yourself!");
        return obj;
    }
}
