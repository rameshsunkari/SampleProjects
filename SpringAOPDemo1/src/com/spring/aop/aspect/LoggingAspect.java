package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	@After("args(name)")
	public void LogginAdviceAfter(String name) {
		System.out
				.println("Advice After run. For the method that takes string argument. The arg is :"
						+ name);
	}

	@AfterReturning(pointcut = "args(name)", returning = "returnString")
	public void LoggingAdviceAfterReturning(String name, String returnString) {
		System.out.println("AdviceReturning run. input = " + name
				+ "\t output = " + returnString);
	}

	@AfterThrowing(pointcut = "args(name)", throwing = "ex")
	public void LoggingAdviceAfterThrowing(String name, RuntimeException ex) {
		System.out.println("AdviceThrowing run. exception is " + ex);
	}

	@Around("@annotation(com.spring.aop.aspect.Loggable)")
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
 