package com.baobaotao.fb;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo = "宝马,500,200000";

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    /**
     * 返回由FactoryBean创建的Bean实例，如果isSingleton()返回true，则该实例会放到Spring容器的单实例缓存池中
     * @return
     * @throws Exception
     */
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.parseInt(infos[1]));
        car.setPrice(Double.parseDouble(infos[2]));
        return car;
    }

    /**
     * 返回FactoryBean创建Bean的类型
     * @return
     */
    public Class<?> getObjectType() {
        return Car.class;
    }

    /**
     * 确定由FactoryBean创建的Bean的作用域是singleton还是prototype
     * @return
     */
    public boolean isSingleton() {
        return false;
    }
}
