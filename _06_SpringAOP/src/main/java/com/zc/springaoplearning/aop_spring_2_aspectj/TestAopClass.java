package com.zc.springaoplearning.aop_spring_2_aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAopClass {
    @Pointcut("within(com.javadoop.springaoplearning.web..*)")
    public void inWebLayer() {
    }
}
