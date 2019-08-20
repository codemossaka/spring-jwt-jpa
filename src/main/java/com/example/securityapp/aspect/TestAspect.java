package com.example.securityapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    String name;
    private Logger myLogger = LoggerFactory.getLogger(getClass().getName());

    public TestAspect() {
        System.out.println("TestAspect created");
    }

    @Pointcut("execution(* com.example.securityapp.controller.*.*(..))")
    private void forControllerPackage() {
    }


    @Pointcut("execution(* com.example.securityapp.service.*.*(..))")
    private void forServicePackage() {
    }


    @Pointcut("forControllerPackage() || forServicePackage()")
    private void forAppFlow() {
    }


    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String theMethod = joinPoint.getSignature().toShortString();
        myLogger.info("========> in @Before: calling method: " + theMethod);


        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            myLogger.info("========> in @Before: arguments passed: " + arg);
        }
    }


    @AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
    public void afterReturning(JoinPoint joinPoint, Object theResult) {
        String theMethod = joinPoint.getSignature().toShortString();
        myLogger.info("========> in @AfterReturning: from method: " + theMethod);

        myLogger.info("========> in @AfterReturning: result : " + theResult);

    }
}
