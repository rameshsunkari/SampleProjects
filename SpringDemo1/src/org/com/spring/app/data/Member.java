package org.com.spring.app.data;

public class Member {

	private int num;
	private String name;
	private double Salary;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}

	public Member() {

	}

	public Member(int num, String name, double salary) {
		super();
		this.num = num;
		this.name = name;
		Salary = salary;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", Salary=" + Salary
				+ "]";
	}

}
