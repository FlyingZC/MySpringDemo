package com.baobaotao.aspectj.fun;

import com.baobaotao.Seller;
import com.baobaotao.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 切点测试类
 */
public class PointcutFunTest {
    @Test
    public void test01() {
        // “切面被正确地织入到NaughtyWaiter#greetTo()方法中”

        // @AfterReturning("@annotation(com.baobaotao.anno.NeedTest)")
        // 后置增强切面 @annotation匹配所有配置了NeedTest注解的方法
        String configPath = "com/baobaotao/aspectj/fun/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
        Waiter naughtyWaiter = (Waiter) ctx.getBean("naughtyWaiter");
        // 方法上未标注@NeedTest注解
        naiveWaiter.greetTo("John");
        // 方法上标注了@NeedTest注解
        naughtyWaiter.greetTo("Tom");
    }

    @Test
    public void test02() {
        String configPath = "com/baobaotao/aspectj/fun/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
        naiveWaiter.greetTo("John");
        naiveWaiter.serveTo("John");
        ((Seller) naiveWaiter).sell("Beer", "John");
    }
}
