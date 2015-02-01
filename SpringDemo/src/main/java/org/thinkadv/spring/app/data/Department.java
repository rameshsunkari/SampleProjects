package main.java.org.thinkadv.spring.app.data;

import java.util.ArrayList;
import java.util.List;

public class Department  {
	private DeptInfo deptInfo;
	private List<Member> memberList = new ArrayList<Member>();

	public Department() {

	}

	public Department(DeptInfo deptInfo, List<Member> memberList) {
		super();
		this.deptInfo = deptInfo;
		this.memberList = memberList;
	}

	public DeptInfo getDeptInfo() {
		return deptInfo;
	}

	public void setDeptInfo(DeptInfo deptInfo) {
		this.deptInfo = deptInfo;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	@Override
	public String toString() {
		return "Department [deptInfo=" + deptInfo + ", memberList="
				+ memberList + "]";
	}

	
	public void myInit(){
		System.out.println("Initialization Method called through spring.xml");
	}
	
	public void myDestroy(){
		System.out.println("Destroying the Bean through spring.xml");
	}
	

}
