package com.zc.springaoplearning.aop_spring_2_aspectj;

import com.zc.anno.NestTest;
import com.zc.entity.A;
import com.zc.entity.Waiter;
import org.springframework.stereotype.Service;

@Service
public class TestTarget {
    private static final String CLASS_NAME = "TestTarget";
    @NestTest
    public void testNestTestAnno() {
        System.out.println(CLASS_NAME + "类的标注了@NestTest注解的 testNestTestAnno()方法");
    }


    public void testArgsWaiter(Waiter waiter) {
        System.out.println(CLASS_NAME + "中入参为Waiter类型的 testArgsWaiter()方法");
    }

    public void testAtArgsMonitorable(A a) {
        System.out.println(CLASS_NAME + "中入参类型上标注了@Monitorable注解的 testAtArgsMonitorable()方法");
    }
}
