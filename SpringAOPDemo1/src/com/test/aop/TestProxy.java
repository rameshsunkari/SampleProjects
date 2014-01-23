package com.test.aop;

import com.test.aop.service.FactoryService;
import com.test.aop.service.ShapeService;

public class TestProxy {

	public static void main(String[] args) {
		FactoryService factoryService = new FactoryService();
		ShapeService shapeServiceBean = (ShapeService) factoryService.getBean("shapeService");
		System.out.println(shapeServiceBean.getCircle());
	}

}
