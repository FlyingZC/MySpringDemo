package com.baobaotao.aspectj.basic;

import com.baobaotao.Seller;
import com.baobaotao.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeclaredParentsTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/baobaotao/aspectj/basic/beans.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John");

        // EnableSellerAspect为waiter添加了Seller接口的实现
        Seller seller = (Seller) waiter;
        seller.sell("Beer", "John");
    }
}
