package com.baobaotao.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CarOwner {
    // @Resource 注解要求提供一个 Bean 名称的属性,若该属性为空,则自动采用标注处的变量或方法名作为 Bean 的名称.
    // 只有当找不到与名称匹配的bean才会按照类型来装配注入
    @Resource
    private Car carCar;

    @Autowired
    private Car car;

    public Car getCarCar() {
        return carCar;
    }

    public void setCarCar(Car carCar) {
        this.carCar = carCar;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
