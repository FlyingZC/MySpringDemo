package com.baobaotao.beanfactory;

import com.baobaotao.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * BeanFactory中bean的生命周期
 * XmlBeanFactory test
 * XmlBeanFactory通过Resource装载Spring配置信息并启动IoC容器
 * 通过BeanFactory启动IoC容器时，并不会初始化配置文件中定义的Bean，初始化动作发生在第一个调用时。对于单实例（singleton）的Bean来说，BeanFactory会缓存Bean实例
 * Spring在DefaultSingletonBeanRegistry类中提供了一个用于缓存单实例Bean的缓存器，它是一个用HashMap实现的缓存器，单实例的Bean以beanName为键保存在这个HashMap中。
 */
public class BeanFactoryTest {
    public static void main(String[] args) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:com/baobaotao/beanfactory/beans.xml");
        BeanFactory bf = new XmlBeanFactory(res);
        System.out.println("测试用例BeanFactoryTest中 - init BeanFactory");

        Car car = bf.getBean("car", Car.class);
        System.out.println("测试用例BeanFactoryTest中 - car bean is ready for use!");
    }
}
