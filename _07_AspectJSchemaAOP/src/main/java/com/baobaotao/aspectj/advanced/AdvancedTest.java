package com.baobaotao.aspectj.advanced;

import com.baobaotao.SmartSeller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvancedTest {
    public static void main(String[] args) {
        String configPaht = "com/baobaotao/aspectj/advanced/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPaht);
//        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
//        naiveWaiter.greetTo("John");

//        NaiveWaiter naiveWaiter = (NaiveWaiter) ctx.getBean("naiveWaiter");
//        naiveWaiter.smile("John", 2);

        SmartSeller seller = (SmartSeller) ctx.getBean("seller");
//        seller.sell("Beer", "John");
        seller.checkBill(1);
    }
}
