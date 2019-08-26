package com.baobaotao.advice;
import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

/**
 * 对 NaiveWaiter的服务行为进行规范，让他们在打招呼和提供服务之前，都必须先对顾客使用礼貌用语。
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    // 在目标类方法调用前执行
    public void before(Method method, Object[] args, Object target) throws Throwable {
        String clientName = (String) args[0];
        System.out.println("[前置增强] [GreetingBeforeAdvice] How are you！Mr."+clientName+".");
    }
}
