package com.spring.data.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;

	public int getCircleCount() {

		Session session = getSessionFactory().openSession();
		String hql = "select count(*) from Circle";
		Query query = session.createQuery(hql);
		return (Integer) query.uniqueResult();

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
