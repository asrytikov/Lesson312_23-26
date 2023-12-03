package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order(2)
public class SecurityAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.info("Security Aspect : Call method");

        Object returnedMethod = joinPoint.proceed();
        logger.info("Method execute and return " + returnedMethod);
        return returnedMethod;
    }
}
