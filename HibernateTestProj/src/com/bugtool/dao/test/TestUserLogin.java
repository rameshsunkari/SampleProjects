package com.bugtool.dao.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.bugtool.model.UserInfo;

public class TestUserLogin {

	public static void main(String[] args) {
		
		Session session =  HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(UserInfo.class);
		criteria.setMaxResults(10);
		List<UserInfo> userList = criteria.list();
		for (UserInfo user : userList) {
			System.out.println(user.getEmailid());
		}
	}
}
