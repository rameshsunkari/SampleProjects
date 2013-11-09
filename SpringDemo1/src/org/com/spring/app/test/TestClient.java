package org.com.spring.app.test;

import org.com.spring.app.data.Department;
import org.com.spring.app.data.DeptAutoWire;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClient {

	public static void main(String[] args) {
		
		// Executes only when the spring.xml is there in the root.
		/*BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Department dept = (Department) factory.getBean("department");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		Department dept1 = (Department) ctx.getBean("dept-alias");
		System.out.println("Size of the list is :" + dept1.getMemberList().size() + "\n The Members list is : "+ dept1);
		DeptAutoWire deptAutoWire = (DeptAutoWire) ctx.getBean("deptAutoWire");
		System.out.println(deptAutoWire);
		deptACAware = (DeptACAware) ctx.getBean("deptACAware");
		System.out.println(deptACAware);
		DeptInheritance deptObj1 = (DeptInheritance) ctx.getBean("dept1");
		System.out.println(deptObj1);
		
		
		DeptInheritance deptObj2 = (DeptInheritance) ctx.getBean("dept2");
		System.out.println(deptObj2);
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ctx.registerShutdownHook();
		Department dept1 = (Department) ctx.getBean("dept-alias");
		System.out.println("Size of the list is :" + dept1.getMemberList().size() + "\n The Members list is : "+ dept1);*/
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ctx.registerShutdownHook();
		DeptAutoWire deptAutoWire = (DeptAutoWire) ctx.getBean("deptAutoWire");
		System.out.println("The Members list is : "+ deptAutoWire);
		System.out.println(ctx.getMessage("greeting_message", null, "Default Hello", null));

	}

}
