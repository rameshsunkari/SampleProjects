package com.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspectInXML {

	public Object myAroundAdvice(ProceedingJoinPoint joinPoint) {
		Object returnValue = null;

		System.out.println("Before the Target method called");
		try {
			returnValue = joinPoint.proceed();
			System.out.println("returned value is " + returnValue);
		} catch (Throwable e) {
			System.out.println("Exception caught");
		}
		System.out.println("After the Target method called");

		return returnValue;

	}

}
