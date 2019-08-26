package com.zc.entity;

import org.springframework.stereotype.Component;

@Component
public class NaiveWaiter extends Waiter {
    @Override
    public void sayHello() {
        System.out.println("NaiveWaiter.sayHello()方法");
    }
}
