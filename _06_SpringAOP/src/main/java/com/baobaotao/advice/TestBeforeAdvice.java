package com.baobaotao.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeforeAdvice {

    /**
     * 硬编码使用 advice 和 interceptor
     */
    @Test
    public void test01() {
        // 目标类
        Waiter target = new NaiveWaiter();
        // 前置增强
        BeforeAdvice beforeAdvice = new GreetingBeforeAdvice();

        // 后置增强
        AfterReturningAdvice afterReturningAdvice = new GreetingAfterAdvice();

        // 环绕增强
        MethodInterceptor aroundInterceptor = new GreetingInterceptor();

        // 异常抛出增强
        ThrowsAdvice throwsAdvice = new TransactionManager();

        // 代理工厂
        ProxyFactory pf = new ProxyFactory();
        // 如果通过ProxyFactory的setInterfaces(Class[] interfaces)指定针对接口进行代理，ProxyFactory就使用JdkDynamicAopProxy
        pf.setInterfaces(target.getClass().getInterfaces());
        // ProxyFactory的setOptimize(true)方法，让ProxyFactory启动优化代理方式，这样，针对接口的代理也会使用Cglib2AopProxy
        pf.setOptimize(true);
        // 被代理的目标类
        pf.setTarget(target);
        // 可以增加多个advice增强
        pf.addAdvice(beforeAdvice);
        pf.addAdvice(afterReturningAdvice);
        pf.addAdvice(aroundInterceptor);
        pf.addAdvice(throwsAdvice);

        // 获取代理类
        Waiter proxy = (Waiter) pf.getProxy();
        System.out.println("=================== 调用 proxy.greetTo() ===================");
        proxy.greetTo("John");

        System.out.println("=================== 调用 proxy.serveTo() ===================");
        proxy.serveTo("Tom");
    }

    /**
     * 使用 xml配置 ProxyFactoryBean,使用 advice 和 interceptor
     */
    @Test
    public void test02() throws Exception {
        String configPath = "com/baobaotao/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John");

        ForumService forumService = (ForumService) ctx.getBean("forumService");
        forumService.removeForum(1024);
        forumService.updateForum(new Forum());
    }
}
