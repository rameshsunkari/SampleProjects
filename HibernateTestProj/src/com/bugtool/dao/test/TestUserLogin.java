package com.bugtool.dao.test;

import java.io.FileOutputStream;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.bugtool.model.UserInfo;

public class TestUserLogin {

	public static void main(String[] args) {
		
		Session session =  HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(UserInfo.class);
		System.out.println(criteria.list());
		/*String email = "test.test@test.com";
		String password = "test";
		Criterion criterion = Restrictions.and(Restrictions.eq("emailid", email),
				Restrictions.eq("pswd", password));
		criteria.add(criterion);
		System.out.println(criteria.list().size());
		List<UserInfo> userList = criteria.list();
		for (UserInfo user : userList) {
			System.out.println(user.getUserid());
		}
		
		Query query = session.getNamedQuery("checkUserLogin");
		query.setString("emailid", email);
		query.setString("password", password);
		
		List<UserInfo> userList = query.list();
		for (UserInfo user : userList) {
			System.out.println(user.getUserid());
		}*/
		
		UserInfo userInfo = (UserInfo) session.get(UserInfo.class, 43701);
		
		 byte[] bAvatar = userInfo.getPic();
		 
	        try{
	            FileOutputStream fos = new FileOutputStream("D:\\test.jpg"); 
	            fos.write(bAvatar);
	            fos.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	}
}
