package com.bugtool.dao.test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Clob;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.bugtool.model.BugInfo;

public class TestBugInsert {

	public static void main(String[] args) {
		System.out.println("Hibernate save bug into database");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

//		String filePath = "D:\\Ramesh\\Personal\\pics\\uploadPic.jpg";
		String filePath="C:\\Users\\rsunkari\\Desktop\\whirlpool.txt";

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
		
		BugInfo bugInfo = null;
		for (int i=0;i<20;i++){
			bugInfo = new BugInfo();
//			bugInfo.setId(new Long(1));
			bugInfo.setDescription("test");
			bugInfo.setDeveloperEffort("test");
			bugInfo.setDomainLearning("test");
			bugInfo.setEnvInfo("test");
			bugInfo.setRootcause("test");
			bugInfo.setSolution("test");
			bugInfo.setStatus("test");
			bugInfo.setSteps("test");
			bugInfo.setTechnicalLearning("test");
			bugInfo.setWorkaround("test");
			bugInfo.setSupportFile(bFile);
			session.save(bugInfo);
			
			/*Criteria criteria = session.createCriteria(BugInfo.class);
			System.out.println(criteria.list());*/
			
			
			
		}
		session.getTransaction().commit();	
		
		session.close();

	}

}
