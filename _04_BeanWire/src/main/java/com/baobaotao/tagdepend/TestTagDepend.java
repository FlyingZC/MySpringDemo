package com.baobaotao.tagdepend;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTagDepend {
    public static void main(String[] args) {
        // parent
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com.baobaotao.tagdepend/beans.xml");
        Car car3 = ctx.getBean("car3", Car.class);
        Car car4 = ctx.getBean("car4", Car.class);
        System.out.println(car3);
        System.out.println(car4);

        // depends-on

        //
    }
}

