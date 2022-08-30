package com.lti.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.beans.Admin;
import com.lti.beans.LoanApplication;
import com.lti.dao.AdminDao;
import com.lti.excep.AppExcep;


@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	public AdminDao adminDao;
	
	@Transactional
	public boolean adminLogin(Admin admin) {
		
		return adminDao.adminLogin(admin);
	}

	@Override
	@Transactional
	public List<LoanApplication> viewPendingApprovals() {
		// TODO Auto-generated method stub
		return adminDao.viewPendingApprovals();
	}

	@Override
	@Transactional
	public List<LoanApplication> getAllApplications() {
		// TODO Auto-generated method stub
		return adminDao.getAllApplications();
	}

	@Override
	@Transactional
	public List<LoanApplication> approvedApplications() {
		// TODO Auto-generated method stub
		return adminDao.approvedApplications();
	}

	@Override
	@Transactional
	public List<LoanApplication> rejectedApplications() {
		// TODO Auto-generated method stub
		return adminDao.rejectedApplications();
	}

	@Override
	public boolean updatestatus(int applicationId, String status) throws AppExcep {
		return adminDao.updatestatus(applicationId, status);
	}

	@Override
	public LoanApplication findApplicationByUserId(int userId) throws AppExcep {
		return adminDao.findApplicationByUserId(userId);
	}
	

	

	
	
}
