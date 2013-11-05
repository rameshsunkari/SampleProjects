package org.com.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		Shape triangle = (Shape) ctx.getBean("triangle");
		triangle.area();

		Shape square = (Shape) ctx.getBean("square");
		square.area();
		
		Shape shape = (Shape) ctx.getBean("shape");
		shape.area();


	}

}
