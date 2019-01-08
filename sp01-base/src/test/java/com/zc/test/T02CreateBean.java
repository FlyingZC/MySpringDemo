package com.zc.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T02CreateBean {
    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleByConstructor() throws Throwable {
        try {
            new ClassPathXmlApplicationContext("test01.xml");
        } catch (Exception e) {
            // 因为要在创建testC时抛出
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

}
