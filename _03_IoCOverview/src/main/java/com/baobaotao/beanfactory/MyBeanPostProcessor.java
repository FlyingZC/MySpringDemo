package com.baobaotao.beanfactory;

import com.baobaotao.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 为容器提供对Bean进行后续加工处理的切入点，Spring容器所提供的各种“神奇功能”（如AOP，动态代理等）都通过BeanPostProcessor实施
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 入参bean是当前正在处理的Bean，而beanName是当前Bean的配置名，返回的对象为加工处理后的Bean
        if (beanName.equals("car")) {
            Car car = (Car) bean;
            System.out.println("调用 BeanPostProcessor.postProcessBeforeInitialization()");
            if (car.getColor() == null) {
                // System.out.println("调用 BeanPostProcessor.postProcessBeforeInitialization() , color为空,设置为默认黑色");
                car.setColor("黑色");
            }

        }
        return bean;// 返回加工处理后的bean
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {// 容器再次获得对Bean进行加工处理的机会
        if (beanName.equals("car")) {
            Car car = (Car) bean;
            System.out.println("调用 BeanPostProcessor.postProcessAfterInitialization()");
            if (car.getMaxSpeed() >= 200) {
                // System.out.println("调用 BeanPostProcessor.postProcessAfterInitialization() , 将maxSpeed调整为200");
                car.setMaxSpeed(200);
            }
        }
        return bean;
    }
}
