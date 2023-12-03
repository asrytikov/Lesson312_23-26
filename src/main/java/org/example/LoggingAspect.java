package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Order(1)
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    //@Before()
    //@After()
    //@AfterThrowing
    //@AfterReturning

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Method " + methodName +" will execute with params: "  + Arrays.asList(args));

        Object returnedMethod = joinPoint.proceed();
        logger.info("Method execute and return " + returnedMethod);
        return returnedMethod;
    }

}
