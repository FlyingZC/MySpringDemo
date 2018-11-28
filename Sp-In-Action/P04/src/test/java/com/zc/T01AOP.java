package com.zc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T01AOP {
    @Test
    public void test01() {
        ApplicationContext bf = new ClassPathXmlApplicationContext("applicationContext-1.xml");
        TestBean bean=(TestBean) bf.getBean("test");
        bean.test();
    }
}
