package com.bugtool.dao.test;

import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.bugtool.model.UserInfo;

public class TestUserInsert {

	public static void main(String[] args) {
		System.out.println("Hibernate save image into database");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		String filePath = "D:\\Ramesh\\Personal\\pics\\uploadPic.jpg";
//		String filePath="C:\\Users\\rsunkari\\Pictures\\Google Talk\\Hitchcock.bmp";

		// save image into database
		File file = new File(filePath);
		byte[] bFile = new byte[(int) file.length()];

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			// convert file into array of bytes
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*UserInfo userInfo = new UserInfo();
		userInfo.setFName("Ramesh");
		userInfo.setLName("Sunkari");
		userInfo.setEmailid("ramesh.sunkari@oracle.com");
		userInfo.setProject("Unifier");
		userInfo.setUserid(43701);
		userInfo.setPic(bFile);
		userInfo.setPswd("ramesh");
		
		session.save(userInfo);*/
		
		// Update
		UserInfo userInfo = (UserInfo) session.get(UserInfo.class, 43701);
		userInfo.setPic(bFile);
		session.update(userInfo);
		
		session.getTransaction().commit();
		session.close();

	}

}
