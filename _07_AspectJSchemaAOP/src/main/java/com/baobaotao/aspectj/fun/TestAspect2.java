package com.baobaotao.aspectj.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect2 {
    @AfterReturning("this(com.baobaotao.Seller)")
    public void thisTest() {
        System.out.println("thisTest() executed!");
    }
}
