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
@Table(name="LOANAPPLICATIONS")
public class LoanApplication {

	@Id
	@SequenceGenerator(name = "appid_seq", initialValue = 6001, allocationSize = 1)
	@GeneratedValue(generator = "appid_seq", strategy = GenerationType.SEQUENCE)
	@Column(name="APPLICATIONID", length = 20)
	private int applicationId;
	
	
	public LoanApplication(int applicationId, double loanAmount, int tenure, int interest, String status, User user) {
		super();
		this.applicationId = applicationId;
		this.loanAmount = loanAmount;
		this.tenure = tenure;
		this.interest = interest;
		this.status = status;
		this.user = user;
	}

	public LoanApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="LOANAMOUNT",length=30)
	private double loanAmount;
	
	@Column(name="TENURE",length=30)
	private int tenure;
	
	@Column(name="INTEREST",length=10)
	private int interest;
	
	@Column(name="STATUS")
	private String status;
	 	
	@OneToOne
	@JoinColumn(name="USERID")
	private User user;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status2) {
		this.status = status2;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LoanApplication [applicationId=" + applicationId + ", loanAmount=" + loanAmount + ", tenure=" + tenure
				+ ", interest=" + interest + ", status=" + status + ", user=" + user + "]";
	}

    


	
	
	
}