package com.baobaotao.advice;

public interface Waiter {
    /**
     * 欢迎顾客
     * @param name
     */
    void greetTo(String name);

    /**
     * 对顾客提供服务
     * @param name
     */
    void serveTo(String name);
}
