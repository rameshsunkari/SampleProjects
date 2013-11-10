package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.spring.aop.model.Circle;

@Aspect
public class LoggingAspect {

	@Pointcut("execution(* get*())")
	public void allGetters() {

	}

	@Pointcut("within(com.spring.aop.model.Circle)")
	public void allCircleMethods() {

	}

	@Before("allGetters() && allCircleMethods()")
	public void LoggingAdviceBefore() {
		System.out.println("Advice run. Before Get Method Called");
	}

	@Before("allGetters()")
	public void LoggingAdviceAgain() {
		System.out.println("Advice run. Again Get Method Called");
	}

	@Before("allCircleMethods()")
	public void LogCircleMethods(JoinPoint joinPoint) {
		Circle circle = (Circle) joinPoint.getTarget();
		// if (circle != null) {
		System.out.println("Advice run. For all the circle Methos"
				+ joinPoint.toString());

		// }
	}

	@Before("args(name)")
	public void stringArgmethod(String name) {
		System.out
				.println("Advice Before run. For the method that takes string argument. The arg is :"
						+ name);
	}
	
	
	@AfterReturning("args(name)")
	public void LoggingAdviceAfter(String name){
		System.out.println("Advice run. For all the setter methods and is after the pointuct");
	}
	
	@AfterThrowing("args(name)")
	public void LoggingAdviceAfterThrowing(String name){
		System.out.println("Advice run after throwing. For all the setter methods and is after the pointuct");
	}


}
