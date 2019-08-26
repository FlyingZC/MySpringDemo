package com.baobaotao.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * 异常抛出增强
 */
public class TransactionManager implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
        System.out.println("[异常抛出增强] method:" + method.getName() + ", 抛出异常:" + ex.getMessage());
    }
}
