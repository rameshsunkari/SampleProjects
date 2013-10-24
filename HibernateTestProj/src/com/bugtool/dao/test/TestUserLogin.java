package com.bugtool.dao.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.bugtool.model.UserInfo;

public class TestUserLogin {

	public static void main(String[] args) {
		
		Session session =  HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(UserInfo.class);
		
		String email = "test.test@test.com";
		String password = "test";
		Criterion criterion = Restrictions.and(Restrictions.eq("emailid", email),
				Restrictions.eq("pswd", password));
		criteria.add(criterion);
		List<UserInfo> userList = criteria.list();
		for (UserInfo user : userList) {
			System.out.println(user.getUserid());
		}
	}
}
