package com.baobaotao.injectfun;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com.baobaotao.injectfun/beans.xml");
        // lookup-method 注入的car是prototype的,每次的getCar返回都是一个新的对象
        MagicBoss c1 = ctx.getBean("magicBoss", MagicBoss.class);
        System.out.println(c1.getCar());

        MagicBoss c2 = ctx.getBean("magicBoss", MagicBoss.class);
        System.out.println(c2.getCar());

        // replaced-method 替换方法成 调用boss2里的方法
        Boss1 b1 = ctx.getBean("boss1", Boss1.class);
        System.out.println(b1.getCar());
    }
}
