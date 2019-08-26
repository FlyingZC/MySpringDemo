package com.baobaotao.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态切点
 *
 * GreetingDynamicPointcut类既有用于静态切点检查的方法，也有用于动态切点检查的方法。
 * 由于动态切点检查会对性能造成很大的影响，我们应当尽量避免在运行时每次都对目标类的各个方法进行动态检查。
 *
 * Spring采用这样的机制：
 * 在创建代理时对目标类的每个连接点使用静态切点检查，
 * 如果仅通过静态切点检查就可以知道连接点是不匹配的，则在运行时就不再进行动态检查了；
 * 如果静态切点检查是匹配的，在运行时才进行动态切点检查。
 *
 * Spring会在创建代理织入切面时，对目标类中所有方法进行静态切点检查；在生成织入切面的代理对象后，第一次调用代理类的每一个方法都会进行一次静态检查，
 * 如果本次检查就能从候选者列表中将该方法排除，以后对该方法的调用就不再执行静态切点检查；
 * 对于那些在静态检查时匹配的方法，在后续调用该方法时，将执行动态切点检查的操作。
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {

    private static List<String> specialClientList = new ArrayList<String>();

    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                System.out.println("调用getClassFilter()对" + clazz.getName() + "做静态检查.");
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("调用matches(method,clazz)对" + targetClass.getName() + "." + method.getName() + "做静态检查.");
        return "greetTo".equals(method.getName());
    }

    public boolean matches(Method method, Class<?> targetClass, Object[] args) {
        System.out.println("调用matches(method,clazz)对" + targetClass.getName() + "." + method.getName() + "做动态检查.");
        String clientName = (String) args[0];
        return specialClientList.contains(clientName);
    }
}
