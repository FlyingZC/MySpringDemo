package com.zc.springaction.p02.springidol;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 排练
 */
public class T01RehearsalMain
{
    private static final String BASE_TEST_DIR = "/p02/";

    private ApplicationContext context = new ClassPathXmlApplicationContext(BASE_TEST_DIR + "spring-idol.xml");

    @Test
    public void test00() throws Exception
    {
        Performer performer1 = (Performer) context.getBean("duke");

        Performer performer = (Performer) context.getBean("carl2");
        performer.perform();
    }

    @Test
    public void test02() throws Exception
    {
        Performer performer1 = (Performer) context.getBean("poeticDuke");
        performer1.perform();
    }

    @Test
    public void test03()
    {
        // scope="prototype",每次请求会创建一个新的对象
        for (int i = 0; i < 10; i++)
        {
            System.out.println(context.getBean("ticket"));
        }
    }
    
    /**
     * 属性注入
     * @throws Exception 
     */
    @Test
    public void test04() throws Exception
    {
        Performer p = (Performer) context.getBean("kenny2");
        p.perform();
    }
    
    @Test
    public void test05() throws Exception
    {
        Performer p = (Performer) context.getBean("kenny4");
        p.perform();
    }
    
    @Test
    public void test06()
    {
        context.getBean("hank3");
    }
}
