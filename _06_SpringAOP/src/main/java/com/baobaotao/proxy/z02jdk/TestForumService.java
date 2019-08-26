package com.baobaotao.proxy.z02jdk;

import com.baobaotao.proxy.CglibProxy;

import java.lang.reflect.Proxy;

/**
 */
public class TestForumService {
    public static void main(String[] args) {
        // JDK动态代理
        ForumService target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);
        // 为目标类生成 代理类
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        // 通过代理对象 调用 原来目标类的相应方法
        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }
}
