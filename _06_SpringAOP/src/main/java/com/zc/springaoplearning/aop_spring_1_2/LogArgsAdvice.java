package com.zc.springaoplearning.aop_spring_1_2;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;

public class LogArgsAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("[前置增强] [LogArgsAdvice] 准备执行方法: " + method.getName() + ", 参数列表：" + Arrays.toString(args));
    }
}
