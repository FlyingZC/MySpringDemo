package com.baobaotao.proxy.z03cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cblib 代理
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);// 设置需要创建子类的 类
        enhancer.setCallback(this);
        return enhancer.create();// 通过字节码技术 动态创建子类
    }

    // 拦截被代理的父类中 所有方法的调用
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        PerformanceMonitor.begin(o.getClass().getName() + "." + method.getName());
        // 通过代理类调用 被代理的父类中的方法
        Object result = methodProxy.invokeSuper(o, objects);
        PerformanceMonitor.end();
        return result;
    }
}
