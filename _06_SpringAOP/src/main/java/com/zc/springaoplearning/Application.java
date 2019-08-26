package com.zc.springaoplearning;

import com.zc.springaoplearning.aop_spring_2_aspectj.TestTarget;
import com.zc.entity.A;
import com.zc.entity.NaiveWaiter;
import com.zc.entity.Waiter;
import com.zc.service.MyService;
import com.zc.springaoplearning.service.OrderService;
import com.zc.springaoplearning.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

//    public  void main(String[] args) {
//
//        test_Spring_1_2_Advice();
//        test_Spring_1_2_Advisor();
//        test_Spring_1_2_BeanNameAutoProxy();
//        test_Spring_1_2_DefaultAdvisorAutoProxy();
//        test_Spring_2_0_AspectJ();
//        test_Spring_2_0_Schema_Based();
//    }

    @Test
    public  void test_Spring_1_2_Advice() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springaoplearning/spring_1_2_advice.xml");
        // 我们这里要取 AOP 代理：userServiceProxy，这非常重要
        UserService userService = (UserService) context.getBean("userServiceProxy");
        userService.createUser("Tom", "Cruise", 55);
        userService.queryUser();
    }

    @Test
    public  void test_Spring_1_2_Advisor() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springaoplearning/spring_1_2_advisor.xml");
        // 我们这里要取 AOP 代理：userServiceProxy，这非常重要
        UserService userService = (UserService) context.getBean("userServiceProxy");
        userService.createUser("Tom", "Cruise", 55);
        userService.queryUser();
    }

    @Test
    public  void test_Spring_1_2_BeanNameAutoProxy() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springaoplearning/spring_1_2_BeanNameAutoProxy.xml");
        // 注意这里，不再需要根据代理找 bean
        UserService userService = context.getBean(UserService.class);
        OrderService orderService = context.getBean(OrderService.class);
        userService.createUser("Tom", "Cruise", 55);
        userService.queryUser();
        orderService.createOrder("Leo", "随便买点什么");
        orderService.queryOrder("Leo");
    }

    @Test
    public  void test_Spring_1_2_DefaultAdvisorAutoProxy() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springaoplearning/spring_1_2_DefaultAdvisorAutoProxy.xml");
        UserService userService = context.getBean(UserService.class);
        OrderService orderService = context.getBean(OrderService.class);
        userService.createUser("Tom", "Cruise", 55);
        userService.queryUser();
        orderService.createOrder("Leo", "随便买点什么");
        orderService.queryOrder("Leo");
    }

    @Test
    public  void test_Spring_2_0_AspectJ() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springaoplearning/spring_2_0_aspectj.xml");
        UserService userService = context.getBean(UserService.class);
        userService.createUser("Tom", "Cruise", 55);
        userService.queryUser();
    }

    @Test
    public  void test_Spring_2_0_AspectJ2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springaoplearning/spring_2_0_aspectj.xml");
        TestTarget target = context.getBean(TestTarget.class);
        target.testNestTestAnno();
        System.out.println("=====================");
        target.testArgsWaiter(new Waiter());
        System.out.println("=====================");
        target.testAtArgsMonitorable(new A());
        System.out.println("=====================");
        MyService myService = context.getBean(MyService.class);
        myService.testWithIn();
        System.out.println("=====================");
        NaiveWaiter waiter = context.getBean(NaiveWaiter.class);
        waiter.sayHello();
        System.out.println("=====================");
        Waiter waiter1 = context.getBean(Waiter.class);
        waiter1.sayHello();

    }

    @Test
    public  void test_Spring_2_0_Schema_Based() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springaoplearning/spring_2_0_schema_based.xml");
        UserService userService = context.getBean(UserService.class);
        userService.createUser("Tom", "Cruise", 55);
    }

}
