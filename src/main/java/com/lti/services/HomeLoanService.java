package com.lti.services;

import com.lti.beans.LoanApplication;

import java.util.List;

import com.lti.beans.IncomeSalaried;
import com.lti.beans.IncomeSelfEmployed;

import com.lti.beans.Property;
import com.lti.beans.User;

public interface HomeLoanService {

//	**********************************************1
	public boolean registerUser(User users);
	public User loginProcess(User user);
	public User getUserInfobyUserId(int userId);
	public List<User> getAllUsers();
	
//	**************************************************2
	public boolean addIncomeSalariedInfo(IncomeSalaried incomeSalaried);
	public boolean addIncomeSelfEmployedInfo(IncomeSelfEmployed incomeSelfEmployed);
	
//	***************************************************3
	public boolean addPropertyInfo(Property property);
	
//	****************************************************4
	public boolean addLoanInfo(LoanApplication appln);

	
}
