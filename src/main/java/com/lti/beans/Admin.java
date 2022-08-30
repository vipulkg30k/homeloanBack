package com.lti.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADMINS")
public class Admin {

	
	@Id
	@Column(name="ADMINID")
	private int adminId;
	
	@Column(name="USERNAME",length=20)
	private String userName;
	
	@Column(name="PASSWORD",length=20)
	private String password;
	
	public Admin() {
		super();
	}

	public Admin(int adminId, String userName, String password) {
		super();
		this.adminId = adminId;
		this.userName = userName;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return " /n Admin [adminId=" + adminId + ", userName=" + userName + ", password=" + password + "]";
	}

	

	

	
	
}
