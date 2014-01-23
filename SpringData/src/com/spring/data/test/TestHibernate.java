package com.spring.data.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.data.dao.CircleDAO;
import com.spring.data.dao.HibernateDAOImpl;
import com.spring.data.dao.SimpleJDBCDAO;
import com.spring.data.model.Circle;

public class TestHibernate {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		HibernateDAOImpl dao = ctx.getBean("hibernateDAOImpl", HibernateDAOImpl.class);
		System.out.println(dao.getCircleCount());
	} 

}
