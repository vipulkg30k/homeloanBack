package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.beans.Admin;
import com.lti.beans.LoanApplication;

import com.lti.excep.AppExcep;
import com.lti.services.AdminServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public AdminServiceImpl adminServiceIntf;
	
	//THIS METHOD IS USED FOR ADMIN LOGIN IN WHICH WE ARE 
	//POSTING THE DATA
	
	//http://localhost:8090/admin/adminlogin
	
	@PostMapping(value="/adminlogin")
	public boolean adminlogin(@RequestBody Admin admin) 
	{
		return adminServiceIntf.adminLogin(admin);
		
		
	}
	
	//THIS FUNCTION IS USED TO RETURN THE PENDING LOAN APPLICATIONS IN THE LIST ON ADMIN DASHBOARD
	
	@GetMapping(value="/pendingapplns")
	public List<LoanApplication> getPendingList(){
		List<LoanApplication> penlst=adminServiceIntf.viewPendingApprovals();
		return penlst;
		
	}
	
	//THIS FUNCTION IS USED TO RETURN THE APPROVED LOAN APPLICATIONS IN THE LIST ON ADMIN DASHBOARD
	
	
	@GetMapping(value="/approvedapplns")
	public List<LoanApplication> getApprovedList(){
		List<LoanApplication> approvedlist=adminServiceIntf.approvedApplications();
		return approvedlist;
		
	}
	
	//THIS FUNCTION IS USED TO RETURN THE REJECTED LOAN APPLICATIONS IN THE LIST ON ADMIN DASHBOARD
	
	@GetMapping(value="/rejectedapplns")
	public List<LoanApplication> getRejectedList(){
		List<LoanApplication> rejectlist=adminServiceIntf.rejectedApplications();
		return rejectlist;
		
	}
	
	//THIS FUNCTION IS USED TO RETURN ALL THE LAON APPLICATIONS IN THE LIST ON ADMIN DASHBOARD
	
	
	@GetMapping(value="/allapplns")
	public List<LoanApplication> getApplnList(){
		List<LoanApplication> applnlist=adminServiceIntf.getAllApplications();
		return applnlist;
		
	}
	
	//THIS FUNCTION IS USED TO UPDATE THE STATUS OF LOAN APPLICATION THROUGH APPLICATION ID
	
	@PutMapping("/update-application-status/{application_id}/{status}")
	public boolean updateEmp(@PathVariable("application_id") int applicationId, @PathVariable("status") String status)
			throws AppExcep {
		boolean response = adminServiceIntf.updatestatus(applicationId, status);
		return response;
	}
	
	//THIS FUNCTION IS USED TO RETURN THE LOAN APPLICATION DATA WITH THE HELP OF USERID 
	
	@GetMapping(path = "/get-application-by-userId/{userId}")
	public LoanApplication findApplicationByUserId(@PathVariable("userId") int userId) throws AppExcep {
		System.out.println(userId+"controller");
		LoanApplication application = adminServiceIntf.findApplicationByUserId(userId);
		System.out.println(application);
	    return application;
	}
}
	


