package com.lti.services;

import java.util.List;

import com.lti.beans.Admin;
import com.lti.beans.LoanApplication;
import com.lti.excep.AppExcep;



public interface AdminService {

	public boolean adminLogin(Admin admin);
	
	public List<LoanApplication> viewPendingApprovals();
	List<LoanApplication> getAllApplications();
	List<LoanApplication> approvedApplications();
	List<LoanApplication> rejectedApplications();
	boolean updatestatus(int applicationId, String status) throws AppExcep;
	LoanApplication findApplicationByUserId(int userId) throws AppExcep;
}
