package com.baobaotao.advisor;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAdvisor {

    private ApplicationContext ctx;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("com/baobaotao/advisor/beans.xml");
    }

    @Test
    public void test1() {
        // 普通方法名匹配切面
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");
        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");

    }

    @Test
    public void test2() {
        // 正则表达式方法名匹配切面
        Waiter waiter = (Waiter) ctx.getBean("waiter1");
        // 正则表达式只匹配了 greetTo()方法
        waiter.greetTo("John");
        waiter.serveTo("John");
    }

    @Test
    public void test3() {
        //动态切面
        Waiter waiter = (Waiter) ctx.getBean("waiter2");
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        waiter.serveTo("John");
        waiter.greetTo("John");

/*
输出结果
1.以下10行输出信息 反应了在织入切面前 spring对目标类中所有方法进行的静态切点检查
调用getClassFilter()对com.baobaotao.advisor.Waiter做静态检查.
调用matches(method,clazz)对com.baobaotao.advisor.Waiter.greetTo做静态检查.
调用getClassFilter()对com.baobaotao.advisor.Waiter做静态检查.
调用matches(method,clazz)对com.baobaotao.advisor.Waiter.serveTo做静态检查.
调用getClassFilter()对com.baobaotao.advisor.Waiter做静态检查.
调用matches(method,clazz)对com.baobaotao.advisor.Waiter.toString做静态检查.
调用getClassFilter()对com.baobaotao.advisor.Waiter做静态检查.
调用matches(method,clazz)对com.baobaotao.advisor.Waiter.clone做静态检查.
调用getClassFilter()对com.baobaotao.advisor.Waiter做静态检查.
调用matches(method,clazz)对com.baobaotao.advisor.Waiter.serveTo做静态检查.
waiter serving Peter...
调用getClassFilter()对com.baobaotao.advisor.Waiter做静态检查.
调用matches(method,clazz)对com.baobaotao.advisor.Waiter.greetTo做静态检查.
调用matches(method,clazz)对com.baobaotao.advisor.Waiter.greetTo做动态检查.
waiter greet to Peter...
waiter serving John...
调用matches(method,clazz)对com.baobaotao.advisor.Waiter.greetTo做动态检查.
[前置增强] [GreetingBeforeAdvice] [目标类: com.baobaotao.advisor.Waiter] [greetTo, How are you！Mr.John]
waiter greet to John...
*/
    }

    @Test
    public void test4() {
        //控制流程切面
        Waiter waiter = (Waiter) ctx.getBean("waiter3");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        wd.service("Peter");
    }

    @Test
    public void test5() {
        //复合切点切面
        Waiter waiter = (Waiter) ctx.getBean("waiter4");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);
        waiter.serveTo("Peter");
        waiter.greetTo("Peter");
        wd.service("Peter");
    }


}
