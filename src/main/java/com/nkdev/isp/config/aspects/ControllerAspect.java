package com.nkdev.isp.config.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ControllerAspect {

    @Before("execution(* com.nkdev.isp.controller.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("Before Method: " + joinPoint.getSignature());
    }
    @After("execution(* com.nkdev.isp.controller.*.*(..))")
    public  void afterAdvice(JoinPoint joinPoint){
        log.info("After Method:"+ joinPoint.getSignature());
    }
}
