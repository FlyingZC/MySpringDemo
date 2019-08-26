package com.zc.context.cycle.construct;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycleConstruct {
    /**
     * 构造器循环依赖,解决不了
     */
    @Test
    public void test01Cycle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/baobaotao/beanfactory/beans-02-cycle-constructor.xml");
        CircularityC c = applicationContext.getBean("c", CircularityC.class);
        System.out.println(c);
    }
}
