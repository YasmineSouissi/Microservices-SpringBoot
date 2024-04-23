package com.Microservices.ProducerService.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

        @Before("execution(* com.Microservices.ProducerService.Service.*.*(..))")
        public void logBeforeServiceMethods(JoinPoint joinPoint) {
            String methodName = joinPoint.getSignature().getName();
            System.out.println("Method '" + methodName + "' called.");
        }
    }





