package com.baobaotao.editor;

import com.baobaotao.event.MailSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 */
public class TestCustomCarEditor {
    public static void main(String[] args) {
        String resourceFile = "com/baobaotao/editor/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);
        Boss b1 = ctx.getBean("boss", Boss.class);
        System.out.println(b1.getCar());
    }
}
