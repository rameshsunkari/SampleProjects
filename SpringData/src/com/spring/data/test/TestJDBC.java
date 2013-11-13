package com.spring.data.test;

import com.spring.data.dao.JDBCDaoImpl;
import com.spring.data.model.Circle;

public class TestJDBC {

	public static void main(String[] args) {
		
		Circle circle = new JDBCDaoImpl().getCircle(1);
		System.out.println(circle.getName());

	}

}
