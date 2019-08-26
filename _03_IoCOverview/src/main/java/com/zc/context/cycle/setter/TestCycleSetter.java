package com.zc.context.cycle.setter;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycleSetter {
    /**
     * setter循环依赖
     */
    @Test
    public void test01Cycle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/baobaotao/beanfactory/beans-02-cycle-setter.xml");
        CircularityC c = applicationContext.getBean("c", CircularityC.class);
        System.out.println(c);
    }
}
