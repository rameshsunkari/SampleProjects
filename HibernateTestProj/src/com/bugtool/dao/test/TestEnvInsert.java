package com.bugtool.dao.test;

import org.hibernate.Session;

import com.bugtool.model.EnvInfo;

public class TestEnvInsert {

	public static void main(String[] args) {
		System.out.println("Hibernate save env into database");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		EnvInfo env = new EnvInfo();

		env.setBugid(1);
		env.setCreatedby(43701);
		env.setCustomer("Xcel Energy");
		env.setName("Debug");
		env.setUsername("test");
		env.setPswd("test");
		env.setRelease("1");

		session.save(env);

		session.getTransaction().commit();
		session.close();

	}

}
