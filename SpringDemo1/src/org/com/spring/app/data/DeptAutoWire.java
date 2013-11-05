package org.com.spring.app.data;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class DeptAutoWire implements InitializingBean, DisposableBean {

	private Member member1;
	private Member member2;
	private Member member3;
	private Member member4;

	public Member getMember4() {
		return member4;
	}

	@Autowired
	@Qualifier(value = "member6")
	public void setMember4(Member member4) {
		this.member4 = member4;
	}

	private DeptInfo deptInfo;

	public DeptAutoWire() {

	}

	public DeptAutoWire(Member member1, Member member2, Member member3,
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

	@Resource(name = "member1")
	public void setMember1(Member member1) {
		this.member1 = member1;
	}

	public Member getMember2() {
		return member2;
	}

	@Autowired
	public void setMember2(Member member2) {
		this.member2 = member2;
	}

	public Member getMember3() {
		return member3;
	}

	@Autowired
	public void setMember3(Member member3) {
		this.member3 = member3;
	}

	@Override
	public String toString() {
		return "DeptAutoWire [member1=" + member1 + ", member2=" + member2
				+ ", member3=" + member3 + ", member4=" + member4
				+ ", deptInfo=" + deptInfo + "]";
	}

	public DeptInfo getDeptInfo() {
		return deptInfo;
	}

	public void setDeptInfo(DeptInfo deptInfo) {
		this.deptInfo = deptInfo;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Bean Called for the Department Bean");

	}

	@Override
	public void destroy() throws Exception {
		System.out
				.println("Destroying the Beans as the Application Context is shutting down");

	}

	@PostConstruct
	public void initDept() {
		System.out.println("init through annotation");
	}

	@PreDestroy
	public void destroyDept() {
		System.out.println("destroy through annotation");
	}

}
