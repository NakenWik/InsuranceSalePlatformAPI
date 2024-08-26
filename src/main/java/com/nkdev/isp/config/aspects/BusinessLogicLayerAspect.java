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
public class BusinessLogicLayerAspect
{

    @Before("execution(* com.nkdev.isp.bao.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("Before method:" + joinPoint.getSignature());
    }

    @After(value = "execution(* com.nkdev.isp.service.*.*(..))")
    public void  afterAdvice(JoinPoint joinPoint) {
        log.info("After method:" +joinPoint.getSignature());
    }
}
