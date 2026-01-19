package com.ali.fitness.FitAccount.config.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(* com.ali.fitness.FitAccount.service.*(..))")
    private void serviceMethods() {
    }

    @Before("serviceMethods()")
    public void logBefore() {
        System.out.println("Executing @Before advice before service method.");
    }

    @After("serviceMethods()")
    public void logAfter() {
        System.out.println("Executing @After advice after service method.");
    }

    @AfterReturning(value = "serviceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("Method returned successfully: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "serviceMethods()", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, Exception ex) {
        System.out.println("Exception in method: " + joinPoint.getSignature().getName());
        System.out.println("Error: " + ex.getMessage());
    }

    @Around("serviceMethods()")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before executing method: " + joinPoint.getSignature().getName());
        joinPoint.proceed();
        System.out.println("After executing method: " + joinPoint.getSignature().getName());
    }
}
