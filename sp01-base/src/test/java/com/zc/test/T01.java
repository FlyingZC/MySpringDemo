package com.zc.test;

import com.zc.entity.Person;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class T01
{
    public static void main(String[] args)
    {
        // 1.创建IoC配置文件的抽象资源,该抽象资源包含了BeanDefinition的定义信息
        ClassPathResource res = new ClassPathResource("applicationContext.xml");
        // 2.创建BeanFactory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // 3.创建一个载入BeanDefinition的 reader.
        // 这里使用XmlBeanDefinitionReader来载入xml文件形式的BeanDefinition
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        // 由xmlBeanDefinitionReader来载入和注册Bean.建立Ioc容器
        reader.loadBeanDefinitions(res);
    }
    
    /** <一句话功能简述>解析xml
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    @Test
    public void testLoadBeanDefinition()
    {
        // 1.创建IoC配置文件的抽象资源,该抽象资源包含了BeanDefinition的定义信息
        ClassPathResource res = new ClassPathResource("applicationContext.xml");
        // !!!debug进入
        new XmlBeanFactory(res);
    }
    
    @Test
    public void testGetBean()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person p=(Person) ctx.getBean("person");
        System.out.println(p);
    }
    
    @Test
    public void test02Resource() throws IOException
    {
        Resource resource = new ClassPathResource("applicationContext.xml");
        InputStream is = resource.getInputStream();
    }
}
