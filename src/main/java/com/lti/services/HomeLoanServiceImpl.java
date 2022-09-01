package com.lti.services;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.lti.beans.LoanApplication;

import com.lti.beans.IncomeSalaried;
import com.lti.beans.IncomeSelfEmployed;

import com.lti.beans.Property;
import com.lti.beans.User;
import com.lti.dao.HomeLoanDao;



@Service("homeLoanService")
public class HomeLoanServiceImpl implements HomeLoanService {

	@Autowired
	public HomeLoanDao homeLoanDao;
	
	
//	******************************************************1
	@Transactional
	public boolean registerUser(User user) {
		
		return homeLoanDao.registerUser(user);
	}
	

	@Transactional
	public User loginProcess(User users) {

		return homeLoanDao.loginProcess(users);
	}
	
	@Override
	public User getUserInfobyUserId(int userId) {
		// TODO Auto-generated method stub
		return homeLoanDao.getUserInfobyUserId(userId);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return homeLoanDao.getAllUsers();	
		
	}


//	**************************************************************2

	@Transactional
	public boolean addIncomeSalariedInfo(IncomeSalaried incomeSalaried) {
		return homeLoanDao.addIncomeSalariedInfo(incomeSalaried);
	}
	@Transactional
	public boolean addIncomeSelfEmployedInfo(IncomeSelfEmployed incomeSelfEmployed) {
		return homeLoanDao.addIncomeSelfEmployedInfo(incomeSelfEmployed);
	}

	
//	***************************************************************3
	@Transactional
	public boolean addPropertyInfo(Property property) {
		return homeLoanDao.addPropertyInfo(property);
	}
	
//	@Transactional
//	public boolean AddPropertyInfoDTO(Property property) {
//		Property tempProperty = new Property();
//		tempProperty.setPropertyName(property.getPropertyName());
//		tempProperty.setPropertyLocation(property.getPropertyLocation());
//		tempProperty.setAmount(property.getAmount());
//		
//		User  u = new User();
//		u.setUserId(property.getUser().getUserId());
//		
//		tempProperty.setUser(u);
//		 return homeLoanDao.addPropertyInfo(tempProperty);
//		
////		return tempProperty;
//	}
	
//	****************************************************************4

	@Transactional
	public boolean addLoanInfo(LoanApplication appln) {
		return homeLoanDao.addLoanInfo(appln);
	}	
	
	
}
