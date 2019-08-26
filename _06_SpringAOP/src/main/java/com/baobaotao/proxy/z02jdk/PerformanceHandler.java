package com.baobaotao.proxy.z02jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理
 */
public class PerformanceHandler implements InvocationHandler {
    // 被代理的对象
    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 新插入方法中的逻辑
        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        // 被代理的方法
        Object obj = method.invoke(target, args);
        PerformanceMonitor.end();
        return obj;
    }
}
