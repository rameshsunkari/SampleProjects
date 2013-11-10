package com.test.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.aop.service.ShapeService;

public class TestAOP {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
		/*System.out.println(shapeService.getCircle().getName());
		System.out.println(shapeService.getTriangle().getName());*/
		shapeService.getTriangle().setName("Test Circle");

	}

}
