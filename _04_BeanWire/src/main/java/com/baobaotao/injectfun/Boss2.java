package com.baobaotao.injectfun;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class Boss2 implements MethodReplacer {
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        Car car = new Car();
        car.setBrand("美人豹");
        System.out.println("boss2's reimplement方法");
        return car;
    }
}
