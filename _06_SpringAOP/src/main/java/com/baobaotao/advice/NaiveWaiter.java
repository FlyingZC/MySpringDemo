package com.baobaotao.advice;

/**
 * 目标类, 训练不足的服务生
 */
public class NaiveWaiter implements Waiter {
    public void greetTo(String name) {
        System.out.println("greet to "+name+"...");
    }

    public void serveTo(String name) {
        System.out.println("serving "+name+"...");
        throw new RuntimeException("我抛异常了");
    }
}
