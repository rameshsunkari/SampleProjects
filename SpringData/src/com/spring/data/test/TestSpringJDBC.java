package com.spring.data.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.data.dao.CircleDAO;
import com.spring.data.model.Circle;

public class TestSpringJDBC {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		CircleDAO dao = ctx.getBean("circleDAO",CircleDAO.class);
		/*Circle circle = dao.getCircleById(1);
		System.out.println(circle.getName());
		System.out.println("Circle Name is:" + dao.getCircleName(1) );
		System.out.println("Circle Table count is : " + dao.getCircleCount());*/
		
//		dao.insertCircleNamedParams(new Circle(5, "Test Insert Again"));
		dao.simpleJdbcInsert(new Circle(6, "Test 6"));
		System.out.println(dao.getAllCircles());
//		dao.createTriangleTable();
	} 

}
