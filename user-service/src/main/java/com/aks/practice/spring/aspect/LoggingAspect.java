package com.aks.practice.spring.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repositoryClassMethods() {}
        
    @Pointcut("execution(public * *(..))")  
	public void publicMethod() {}

	@Pointcut("execution(public User  com.aks.practice.spring.controller.UserController.getUser(Integer))")
	public void controllerMethod() {}

	
	@Around("publicMethod() || repositoryClassMethods || controllerMethod()")
	public Object logData(ProceedingJoinPoint joinPoint) {
		System.out.println("LoggingAspect");
		//if (log.isDebugEnabled()) {
            log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        //}
        try {
            Object result = joinPoint.proceed();
          //  if (log.isDebugEnabled()) {
                log.info("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), result);
          //  }
            return result;
        }catch(Throwable t){
        	log.error("Throwable error occured {} "+t);
        }
		return null;	
	}
	
}