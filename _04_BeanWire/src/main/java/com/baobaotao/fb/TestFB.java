package com.baobaotao.fb;

import com.baobaotao.injectfun.MagicBoss;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFB {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com.baobaotao.fb/beans.xml");
        // lookup-method 注入的car是prototype的,每次的getCar返回都是一个新的对象
        // 通过factoryBean获取的是它创建的具体对象
        Car c1 = ctx.getBean("carFactoryBean", Car.class);
        System.out.println(c1.getClass());

        // 通过 & 获取 FactoryBean对象本身
        Object c2 = ctx.getBean("&carFactoryBean");
        System.out.println(c2.getClass());
    }
}
