package com.example.demo.aspect;

import com.example.demo.annotation.InterceptorMarker;
import com.example.demo.entity.DemoEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class DemoAspect {

    @Around("@annotation(com.example.demo.annotation.Interceptor)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        //joinPoint.getArgs()

        long executionTime = System.currentTimeMillis() - start;

        log.info("Logger aspect example executed " + joinPoint.getSignature() + " executed in " + executionTime + "ms : " + joinPoint.getTarget().getClass());
        return proceed;
    }

    //@Around("execution(* com.example.demo.model.*Repository.findAll(..))")
    //args(entity,..)

    @Around("execution(* com.example.demo.repository.*.foo(..)) && args(entity)")
    public Object proxy(ProceedingJoinPoint joinPoint, DemoEntity entity) throws Throwable {
        log.info("Proxy starts");
        Object proceed = null;


        if (joinPoint.getTarget().getClass().isAnnotationPresent(InterceptorMarker.class)) {
            log.info("Not calling... Making a proxy");
        } else {
            proceed = joinPoint.proceed();
        }

        log.info("Proxy ends");
        return proceed;
    }

}
