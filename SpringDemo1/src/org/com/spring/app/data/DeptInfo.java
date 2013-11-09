package org.com.spring.app.data;

public class DeptInfo {

	private int deptNo;
	private String deptName;

	public DeptInfo() {

	}

	public DeptInfo(int deptNo, String deptName) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "DeptInfo [deptNo=" + deptNo + ", deptName=" + deptName + "]";
	}

}
