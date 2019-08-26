package com.baobaotao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created by flyingzc on 16/4/20.
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("调用 Car()构造函数");
    }

    public void introduce() {
        System.out.println("car.introduce() brand:" + brand + ";color:" + color + ";maxSpeed:" + maxSpeed);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用 BeanFactoryAware.setBeanFactory() ,该方法能获取到beanFactory");
        this.beanFactory = beanFactory;
    }

    public void setBeanName(String name) {
        System.out.println("调用 BeanNameAware.setBeanName() ,能获取到配置该bean的beanName");
        this.beanName = name;
    }

    public void destroy() throws Exception {
        System.out.println("调用 DisposableBean.destroy() ");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("调用 InitializingBean.afterPropertiesSet() ");
    }

    public void myInit() {
        System.out.println("调用 init-method 所指定的myInit(),将maxSpeed设置为240");
        this.maxSpeed = 240;
    }

    public void myDestroy() {
        System.out.println("调用 destroy-method 所指定的myDestroy()");
    }

    public void setBrand(String brand) {
        System.out.println("调用 setBrand() 设置属性为: " + brand);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        System.out.println("调用 setColor() 设置属性为: " + color);
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        System.out.println("调用 setMaxSpeed() 设置属性为: " + maxSpeed);
        this.maxSpeed = maxSpeed;
    }
}
