package com.zc.springaoplearning.aop_spring_2_aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class TestAspect {
    @Before("com.zc.springaoplearning.aop_spring_2_aspectj.SystemArchitecture.annoNestTest()")
    public void annoNestTestAspect(JoinPoint joinPoint) {
        System.out.println("[@AspectJ] [含有@NestTest注解的方法] 方法执行前，打印入参：" + Arrays.toString(joinPoint.getArgs()));
    }

    @Before("com.zc.springaoplearning.aop_spring_2_aspectj.SystemArchitecture.argsWaiter()")
    public void argsWaiterAspect(JoinPoint joinPoint) {
        System.out.println("[@AspectJ] [入参为Waiter类型的方法] 方法执行前，打印入参：" + Arrays.toString(joinPoint.getArgs()));
    }

    @Before("com.zc.springaoplearning.aop_spring_2_aspectj.SystemArchitecture.atArgsMonitorable()")
    public void atArgsMonitorableAspect(JoinPoint joinPoint) {
        System.out.println("[@AspectJ] [入参对象类上还有@Monitor注解] 方法执行前，打印入参：" + Arrays.toString(joinPoint.getArgs()));
    }

    @Before("com.zc.springaoplearning.aop_spring_2_aspectj.SystemArchitecture.withinService()")
    public void withinServiceAspect(JoinPoint joinPoint) {
        System.out.println("[@AspectJ] [com.zc.service包下的方法] 方法执行前，打印入参：" + Arrays.toString(joinPoint.getArgs()));
    }

    @Before("com.zc.springaoplearning.aop_spring_2_aspectj.SystemArchitecture.targetWaiter()")
    public void targetWaiterAspect(JoinPoint joinPoint) {
        System.out.println("[@AspectJ] [Waiter子类NaiveWatier中的方法] 方法执行前，打印入参：" + Arrays.toString(joinPoint.getArgs()));
    }

    @Before("com.zc.springaoplearning.aop_spring_2_aspectj.SystemArchitecture.atWithinMonitorable()")
    public void atWithinMonitorableAspect(JoinPoint joinPoint) {
        System.out.println("[@AspectJ] [Waiter子类NaiveWatier中的方法,由于父类Waiter标注了注解@Monitorable] 方法执行前，打印入参：" + Arrays.toString(joinPoint.getArgs()));
    }

}
