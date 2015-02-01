package main.java.org.thinkadv.spring.app.data;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;

public class DeptACAware implements ApplicationContextAware, BeanNameAware {

	private Member member1;
	private Member member2;
	private Member member3;
	private DeptInfo deptInfo;
	private ApplicationContext context = null;

	@Autowired
	private MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public DeptACAware() {

	}

	public DeptACAware(Member member1, Member member2, Member member3,
			DeptInfo deptInfo) {
		super();
		this.member1 = member1;
		this.member2 = member2;
		this.member3 = member3;
		this.deptInfo = deptInfo;
	}

	public Member getMember1() {
		return member1;
	}

	public void setMember1(Member member1) {
		this.member1 = member1;
	}

	public Member getMember2() {
		return member2;
	}

	public void setMember2(Member member2) {
		this.member2 = member2;
	}

	public Member getMember3() {
		return member3;
	}

	public void setMember3(Member member3) {
		this.member3 = member3;
	}

	@Override
	public String toString() {
		return "DeptAutoWire [member1=" + member1 + ", member2=" + member2
				+ ", member3=" + member3 + ", deptInfo=" + deptInfo + "]";
	}

	public DeptInfo getDeptInfo() {
		return deptInfo;
	}

	public void setDeptInfo(DeptInfo deptInfo) {
		this.deptInfo = deptInfo;
	}

//	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		this.context = arg0;

	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

//	@Override
	public void setBeanName(String name) {
		System.out.println("Bean name is:" + name);

	}

}
