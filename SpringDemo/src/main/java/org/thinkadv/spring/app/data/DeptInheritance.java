package main.java.org.thinkadv.spring.app.data;

import java.util.ArrayList;
import java.util.List;

public class DeptInheritance {
	private Member member1;
	private Member member2;
	private Member member3;

	public DeptInheritance() {
		// TODO Auto-generated constructor stub
	}

	public DeptInheritance(Member member1, Member member2, Member member3) {
		super();
		this.member1 = member1;
		this.member2 = member2;
		this.member3 = member3;
	}

	@Override
	public String toString() {
		return "DeptInheritance [member1=" + member1 + ", member2=" + member2
				+ ", member3=" + member3 + "]";
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

}
