package com.zc.springaoplearning.aop_spring_2_aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// 配置 @Aspect 注解的 bean 会被 Spring 当做用来实现 AOP 的配置类
@Aspect
public class SystemArchitecture {

    // =============== 这个类里全部用于定义 切点
    // Pointcut切点配置,用来匹配 Spring 容器中的 bean中的方法. 配置 pointcut 就是配置我们需要拦截哪些方法
    // 切点, 匹配所有service包下所有类中的所有方法
    // execution()切点表达式
    @Pointcut("execution(* com.javadoop.springaoplearning.service.*.*(..))")
    public void businessService() {
    }

    @Pointcut("execution(* com.javadoop.springaoplearning.dao.*.*(..))")
    public void dataAccessOperation() {
    }

    // @annotation() 表示标注了特定注解的目标方法连接点.
    // @annotation(com.zc.anno.NestTest),表示任何标注了 @NestTest 注解的目标类方法.
    @Pointcut("@annotation(com.zc.anno.NestTest)")
    public void annoNestTest() {

    }

    // args()
    // 通过判别目标类方法运行时 入参对象的类型 定义指定连接点.
    // args(com.zc.entity.Waiter)表示所有 有且仅有一个按类型匹配于 Waiter 入参的方法.
    @Pointcut("args(com.zc.entity.Waiter)")
    public void argsWaiter() {

    }

    // @args()
    // 通过判别目标方法运行时 入参对象的类 是否标注特定注解 来指定连接点.
    // 如 @args(com.zc.Monitorable) 表示任何这样的一个目标方法,它有一个入参且入参对象的类标注 @Monitorable 注解.
    @Pointcut("@args(com.zc.anno.Monitorable)")
    public void atArgsMonitorable() {

    }

    // within()
    // 表示特定域下的所有连接点.
    // 如 within(com.zc.service.*) 表示 com.zc.service 包中的所有连接点,即包中所有类的所有方法.
    // 而(com.baobaotao.service.*Service) 表示在 com.zc.service 包中所有以 Service 结尾的类的所有连接点.
    @Pointcut("within(com.zc.service.*)")
    public void withinService() {

    }

    // target()
    // 假如目标类按类型匹配于指定类,则目标类的所有连接点匹配这个切点.
    // 如通过 target(com.zc.entity.Waiter) 定义的切点. Waiter 以及 Waiter 实现类 NaiveWaiter 中所有连接点都匹配该切点.
    @Pointcut("target(com.zc.entity.Waiter)")
    public void targetWaiter() {

    }

    // @within()
    // 假如目标类按类型匹配于某个类 A,且类 A标注了特定注解,则目标类的所有连接点匹配这个切点.
    // 如 @within(com.zc.anno.Monitorable) 定义的切点,假如 Waiter 类标注了 @Monitorable注解,则 Waiter 以及 Waiter 实现类 NaiveWaiter 类的所有连接点都匹配.
    @Pointcut("@within(com.zc.anno.Monitorable)")
    public void atWithinMonitorable() {

    }

    @Pointcut("within(com.javadoop.springaoplearning.web..*)")
    public void inWebLayer() {
    }

    @Pointcut("within(com.javadoop.springaoplearning.service..*)")
    public void inServiceLayer() {
    }

    @Pointcut("within(com.javadoop.springaoplearning.dao..*)")
    public void inDataAccessLayer() {
    }



}
