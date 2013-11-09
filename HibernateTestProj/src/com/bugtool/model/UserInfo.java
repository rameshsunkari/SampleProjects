package com.bugtool.model;

import java.sql.Blob;

/**
 * UserInfo generated by rsunkari
 */
public class UserInfo implements java.io.Serializable {

	private Integer userid;
	private String FName;
	private String LName;
	private String emailid;
	private String pswd;
	private String project;
	private byte[] pic;

	public UserInfo() {
	}

	public UserInfo(Integer userid, String FName, String LName, String emailid,
			String pswd, String project) {
		this.userid = userid;
		this.FName = FName;
		this.LName = LName;
		this.emailid = emailid;
		this.pswd = pswd;
		this.project = project;
	}

	public UserInfo(Integer userid, String FName, String LName, String emailid,
			String pswd, String project, byte[] pic) {
		this.userid = userid;
		this.FName = FName;
		this.LName = LName;
		this.emailid = emailid;
		this.pswd = pswd;
		this.project = project;
		this.pic = pic;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFName() {
		return this.FName;
	}

	public void setFName(String FName) {
		this.FName = FName;
	}

	public String getLName() {
		return this.LName;
	}

	public void setLName(String LName) {
		this.LName = LName;
	}

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPswd() {
		return this.pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public byte[] getPic() {
		return this.pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((FName == null) ? 0 : FName.hashCode());
		result = prime * result + ((LName == null) ? 0 : LName.hashCode());
		result = prime * result + ((emailid == null) ? 0 : emailid.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((pswd == null) ? 0 : pswd.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (FName == null) {
			if (other.FName != null)
				return false;
		} else if (!FName.equals(other.FName))
			return false;
		if (LName == null) {
			if (other.LName != null)
				return false;
		} else if (!LName.equals(other.LName))
			return false;
		if (emailid == null) {
			if (other.emailid != null)
				return false;
		} else if (!emailid.equals(other.emailid))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (pswd == null) {
			if (other.pswd != null)
				return false;
		} else if (!pswd.equals(other.pswd))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

}
