package com.javatechie.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExceptionAlertAdvice {

    @Pointcut("execution (* com.javatechie.*.*.*(..))")
    public void alertFor(){

    }

    @AfterThrowing(value = "alertFor()",throwing = "exception")
    public void captureErrorAndSetAlerts(JoinPoint joinPoint,Exception exception){
        log.error("Exception occurs in {}",joinPoint.getSignature());
        log.error("Exception message  {}",exception.getMessage());

        if(exception instanceof IllegalArgumentException){
            //set the alerts
            //trigger an email to DEV team
            System.out.println("Hi IllegalArgumentException occurs ");
        }
        if(exception instanceof RuntimeException){
            //set the alerts
            //trigger an email to DEV team
            System.out.println("Hi RuntimeException occurs ");
        }

    }
}
