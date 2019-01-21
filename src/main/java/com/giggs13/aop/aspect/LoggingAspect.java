package com.giggs13.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Before("com.giggs13.aop.aspect.AopExpressions.daoPackageExcludingGettersAndSetters()")
    private void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n---> Executing @Before advice on method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println(methodSignature);

        Arrays.stream(joinPoint.getArgs())
                .forEach(System.out::println);
    }
}
