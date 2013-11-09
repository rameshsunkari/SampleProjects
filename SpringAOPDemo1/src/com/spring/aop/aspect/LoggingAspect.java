package com.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class LoggingAspect {

	
	@Before("execution(public String com.spring.aop.model.Circle.getName())")
	public void LoggingAdviceBefore(){
		System.out.println("Advice run. Before Get Method Called");
	}
	
	/*@Around("execution(public String getName())")
	public void LoggingAdviceAround(){
		System.out.println("Advice run. Around Get Method Called");
	}*/
	
}
