package com.baobaotao.placeholder;

import com.baobaotao.editor.Boss;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 */
public class TestPlaceholder {
    public static void main(String[] args) {
        String resourceFile = "com/baobaotao/placeholder/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);
        System.out.println(ctx.getBean("myDataSource"));
    }
}
