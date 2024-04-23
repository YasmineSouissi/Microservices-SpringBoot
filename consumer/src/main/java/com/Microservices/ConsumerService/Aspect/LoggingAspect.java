package com.Microservices.ConsumerService.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @AfterReturning(pointcut = "execution(* com.Microservices.ConsumerService.Service.*.*(..))", returning = "result")
    public void logAfterReturningServiceMethods(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Method '" + methodName + "' returned: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.Microservices.ConsumerService.Service.*.*(..))", throwing = "exception")
    public void logAfterThrowingServiceMethods(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        System.err.println("Method '" + methodName + "' threw an exception: " + exception.getMessage());
    }
}
