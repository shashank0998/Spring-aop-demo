package com.springaop.aspects;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalcLoggingAscpect 
{
/*	@Before("execution (* com.springaop.service.Calculator.print(..))") // point-cut expression
	public void logBeforeAddition(JoinPoint joinPoint)
	{
		System.out.println("Calculator Addition() :"+joinPoint.getSignature().getName());
		System.out.println("hijakced :"+joinPoint.getSignature().getName());
		System.out.println("*******");
	}*/
	
	
	@Before("execution (* com.springaop.service.Calculator.addition(long,long))")
	public void logBefore(JoinPoint joinPoint)
	{
		System.out.println("logBefore Addition() is running");
		System.out.println("hijakced :"+joinPoint.getSignature().getName());
		System.out.println("*******");
	}
	
	
	@AfterReturning("execution (* com.springaop.service.Calculator.addition(long,long))")
	public void logAfterReturning(JoinPoint joinPoint)
	{
		System.out.println("log After Returning Addition() is running");
		System.out.println("hijakced :"+joinPoint.getSignature().getName());
		System.out.println("*******");
	}
	
	@AfterThrowing("execution(* com.springaop.service.Calculator.addition(long,long))")
	public void logAfterThrowing(JoinPoint joinPoint)
	{
		System.out.println("After Throwing addition() is running");
		System.out.println("hijacked :"+joinPoint.getSignature().getName());
		System.out.println("+++++++++");
	}
	
	@After("execution(* com.springaop.service.Calculator.addition(long,long))")
	public void logAfter(JoinPoint joinPoint)
	{
		System.out.println("After  addition() is running");
		System.out.println("hijacked :"+joinPoint.getSignature().getName());
		System.out.println("+++++++++");
	}
	
	@Around("execution(* com.springaop.service.Calculator.sum(..))")
	public void logAroundSum(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("****LoggingAspect.logAroundMethod() - Before Method Call****");
		
		
		long start = System.nanoTime();
		
		Integer result =(Integer) pjp.proceed();
		System.out.println(result);
		
		long end = System.nanoTime();
		String methodName = pjp.getSignature().getName();
		System.out.println("Execution of "+ methodName +" took " + TimeUnit.NANOSECONDS.toMillis(end-start)+" ms ");
		
		
		System.out.println("****LoggingAspect.logAroundMethod() - Aftere Method Call****");

	}
}
