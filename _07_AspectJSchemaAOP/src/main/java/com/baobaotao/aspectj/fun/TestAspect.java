package com.baobaotao.aspectj.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect {
    // 后置增强切面
    // @annotation注解 表示 标注了某个注解的所有方法
    @AfterReturning("@annotation(com.baobaotao.anno.NeedTest)")
    public void needTestFun() {
        System.out.println("needTestFun() executed!");
    }

}
