package com.baobaotao.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * 切面
 * StaticMethodMatcherPointcutAdvisor是 静态方法匹配器切点定义的切面，默认情况下，匹配所有的目标类
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

    public boolean matches(Method method, Class<?> targetClass) {
        return "greetTo".equals(method.getName());// 匹配目标类中的 greetTo方法
    }

    // 匹配 Waiter类及其子类
    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }
}
