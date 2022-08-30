package com.lti.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INCOMESELFEMPLOYEDS")
public class IncomeSelfEmployed {

	@Id
	@SequenceGenerator(name = "srno_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "srno_seq", strategy = GenerationType.SEQUENCE)
	@Column(name="SRNO")
	private int srNo;
	
	@Column(name="TURNOVER",length=50)
	private double turnover;
	
	@Column(name="NATUREOFBUSINESS",length=50)
	private String natureOfBusiness;
	
	@OneToOne
	@JoinColumn(name="USERID")
	private User user;



public IncomeSelfEmployed(int srNo, double turnover, String natureOfBusiness, User user) {
		super();
		this.srNo = srNo;
		this.turnover = turnover;
		this.natureOfBusiness = natureOfBusiness;
		this.user = user;
	}

public IncomeSelfEmployed() {
	super();
	// TODO Auto-generated constructor stub
}

public int getSrNo() {
	return srNo;
}

public void setSrNo(int srNo) {
	this.srNo = srNo;
}

public double getTurnover() {
	return turnover;
}

public void setTurnover(double turnover) {
	this.turnover = turnover;
}

public String getNatureOfBusiness() {
	return natureOfBusiness;
}

public void setNatureOfBusiness(String natureOfBusiness) {
	this.natureOfBusiness = natureOfBusiness;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

@Override
public String toString() {
	return "IncomeSelfEmployed [srNo=" + srNo + ", turnover=" + turnover + ", natureOfBusiness=" + natureOfBusiness
			+ ", user=" + user + "]";
}


	
	
}
