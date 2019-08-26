package com.baobaotao.aspectj.example;

import com.baobaotao.NaiveWaiter;
import com.baobaotao.Waiter;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJProxyTest {

    // PreGreetingAspect切面 拦截所有 greeTo()方法
    @Test
    public void test1() {
        Waiter waiter = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(waiter);
        factory.addAspect(PreGreetingAspect.class);
        Waiter proxy = factory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("John");
    }

    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/baobaotao/aspectj/example/beans.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John");
        waiter.serveTo("John");
    }
}
