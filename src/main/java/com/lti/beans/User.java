package com.lti.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {

	@Id
	@SequenceGenerator(name = "usr_seq", initialValue = 10001, allocationSize = 1)
	@GeneratedValue(generator = "usr_seq", strategy = GenerationType.SEQUENCE)
	@Column(name="USERID")
	private int userId;
	
	@Column(name="FIRSTNAME",length=30)
	private String firstName;
	
	@Column(name="LASTNAME",length=30)
	private String lastName;
	
	@Column(name="MIDDLENAME",length=30)
	private String middleName;
	
	@Column(name="EMAILID",length=50, unique=true)
	private String email;
	
	@Column(name="PASSWORD",length=15)
	private String password;
	
	@Column(name="PHONE",length=10)
	private String phone;
	
	@Column(name="DOB", length = 15)
	private String dob;
	
	@Column(name="GENDER",length=15)
	private String gender;
	
	@Column(name="NATIONALITY",length=15)
	private String nationality;
	
	@Column(name="AADHARNO",length=12)
	private String aadharNo;
	
	@Column(name="PANNO",length=10)
	private String panNo;
	
	
	
	public User(int userId, String firstName, String lastName, String middleName, String email, String password,
			String phone, String dob, String gender, String nationality, String aadharNo, String panNo) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
		this.nationality = nationality;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
	}

	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", email=" + email + ", password=" + password + ", phone=" + phone + ", dob=" + dob
				+ ", gender=" + gender + ", nationality=" + nationality + ", aadharNo=" + aadharNo + ", panNo=" + panNo
				+ "]";
	}

	

	
}