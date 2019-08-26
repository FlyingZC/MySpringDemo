package com.zc.entity;

import com.zc.anno.Monitorable;

@Monitorable
public class Waiter {
    public void sayHello() {
        System.out.println("waiter.sayHello()..");
    }
}
