package com.lti.dao;


import com.lti.beans.LoanApplication;

import java.util.List;

import com.lti.beans.IncomeSalaried;
import com.lti.beans.IncomeSelfEmployed;
import com.lti.beans.Property;
import com.lti.beans.User;

public interface HomeLoanDao {
	
//   ************************************************1
	public boolean registerUser(User user);
	public User loginProcess(User users);
	public User getUserInfobyUserId(int userId);
	public List<User> getAllUsers();
	public User send(String to);
	
//	**************************************************2
	public boolean addIncomeSalariedInfo(IncomeSalaried incomeSalaried);
	public boolean addIncomeSelfEmployedInfo(IncomeSelfEmployed incomeSelfEmployed);
	
//	***************************************************3
	public boolean addPropertyInfo(Property property);
	
//	***************************************************4
	public boolean addLoanInfo(LoanApplication appln);
	
}
