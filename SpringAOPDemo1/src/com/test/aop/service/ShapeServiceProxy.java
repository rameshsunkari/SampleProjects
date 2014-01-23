package com.test.aop.service;

import com.spring.aop.aspect.LoggingAspectInXML;
import com.spring.aop.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	@Override
	public Circle getCircle() {
		Circle circle = new Circle();
		circle.setName("Proxy Circle");
		new LoggingAspectInXML().loggingAdvice();
//		return super.getCircle();
		return circle;
	}
}
