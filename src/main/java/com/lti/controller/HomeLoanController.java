package com.lti.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lti.beans.IncomeSalaried;
import com.lti.beans.IncomeSelfEmployed;
import com.lti.beans.LoanApplication;
import com.lti.beans.Property;
import com.lti.beans.User;
import com.lti.services.HomeLoanService;

@CrossOrigin(origins="*")
@RequestMapping("/homeloanappln")
@RestController
public class HomeLoanController {

	@Autowired
	public HomeLoanService hlservice;
	

	@Autowired
	private MailSender mailsender;
	
//	*********************************************************1
//  Registering new User	
//  http://localhost:8090/homeloanappln/adduser
	
	@PostMapping("/adduser")
	public User registerUser(@RequestBody User user) {
		 hlservice.registerUser(user);
		return user;
	}
	
//  User Login
//  http://localhost:8090/homeloanappln/userlogin
	@PostMapping("/userlogin")
	public User userlogin(@RequestBody User user) {
		return hlservice.loginProcess(user);
		
	}
	

	@GetMapping("/forgot_password/{email}")
	public String forgotPassword(@PathVariable String email) {
		System.out.println(email);
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("cdharmvatsal89@gmail.com");
		message.setTo(email);
		message.setSubject("Password Reset");
		message.setText("Need to reset your password? No Problem!\nClick on the link below and you will be on your way!\nhttp://localhost:4200/forget_password\nIf you did not make this request please ignore this email!");
		mailsender.send(message);
		
		return "Welcome to Spring REST";
	}
	
//  Fetching the list of all users	
//	http://localhost:8090/homeloanappln/users
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		List<User> usrList=hlservice.getAllUsers();
		return usrList;
	}

	
//  Fetching user details through user id	
//  http://localhost:8090/homeloanappln/users/{uid}	
	
	@GetMapping("/users/{uid}")
	public User getUserbyId(@PathVariable("uid")int userId) {
		User u=hlservice.getUserInfobyUserId(userId);
		return u;
	}
	
//	********************************************************************2
	
	// Adding the details of income salary of registered user	
//  http://localhost:8090/homeloanappln/addincome-salaried		
	
//	@PostMapping("/addincome-salaried")
//	public boolean AddIncomeSalariedInfo(@RequestBody IncomeSalaried incomeSalaried) {
//		return hlservice.addIncomeSalariedInfo(incomeSalaried);
//	}
//	
//	Adding the details of self employed income of registered user 
//  http://localhost:8090/homeloanappln/addincome-selfemp	
	
//	@PostMapping("/addincome-selfemp")
//	public boolean AddIncomeSelfEmpInfo(@RequestBody IncomeSelfEmployed incomeSelfEmployed) {
//		return hlservice.addIncomeSelfEmployedInfo(incomeSelfEmployed);
//	}
	
//  http://localhost:8090/homeloanappln/incomesalary	
	
	@PostMapping("/incomesalary")
	public IncomeSalaried AddIncomeSalariedInfo(@RequestBody IncomeSalaried incomesalaried)
	{
		IncomeSalaried tempIncomeSalaried = new IncomeSalaried();
		tempIncomeSalaried.setRetirementAge(incomesalaried.getRetirementAge());
		tempIncomeSalaried.setMonthlySalary(incomesalaried.getMonthlySalary());
		tempIncomeSalaried.setOrganization(incomesalaried.getOrganization());
		
		User u = new User();
		u.setUserId(incomesalaried.getUser().getUserId());
		tempIncomeSalaried.setUser(u);
		hlservice.addIncomeSalariedInfo(tempIncomeSalaried);
		return tempIncomeSalaried;
	}
	
//  http://localhost:8090/homeloanappln/selfemployedincome
	@PostMapping("/selfemployedincome")
	public IncomeSelfEmployed AddSelfIncomeSalariedInfo(@RequestBody IncomeSelfEmployed incomeselfemployed) {
		IncomeSelfEmployed incomeSelfEmployed = new IncomeSelfEmployed();
		incomeSelfEmployed.setTurnover(incomeselfemployed.getTurnover());
		incomeSelfEmployed.setNatureOfBusiness(incomeselfemployed.getNatureOfBusiness());
		
		User u = new User();
		u.setUserId(incomeselfemployed.getUser().getUserId());
		
		incomeSelfEmployed.setUser(u);
		hlservice.addIncomeSelfEmployedInfo(incomeSelfEmployed);
		return incomeSelfEmployed;
	}
	
	
//	***********************************************************************3
	
	// Adding property details of registered user
	// http://localhost:8090/homeloanappln/addpropertydet	
	
//	@PostMapping("/addpropertydet")
//	public boolean AddPropertyInfo(@RequestBody Property property) {
//	return hlservice.addPropertyInfo(property);
//	}

	
//  http://localhost:8090/homeloanappln/property	
	@PostMapping("/property")
	public Property AddPropertyInfo(@RequestBody Property property) {
		Property tempProperty = new Property();
		tempProperty.setPropertyName(property.getPropertyName());
		tempProperty.setPropertyLocation(property.getPropertyLocation());
		tempProperty.setAmount(property.getAmount());
		
		User  u = new User();
		u.setUserId(property.getUser().getUserId());
		
		tempProperty.setUser(u);
		hlservice.addPropertyInfo(tempProperty);
		
		return tempProperty;
	}
	
//	************************************************************************4
	
// Adding the loan application details of registered user	
	
// http://localhost:8090/homeloanappln/addloanappdet
//	@PostMapping("/addloanappdet")
//	public boolean addLoanInfo(@RequestBody LoanApplication appln) {
//		return hlservice.addLoanInfo(appln);
//	}

	
//  http://localhost:8090/homeloanappln/loanapplication
	@PostMapping("/loanapplication")
	public LoanApplication AddLoanApplicationInfo(@RequestBody LoanApplication loanapplication) {
		LoanApplication tempLoanApplication = new LoanApplication();
		tempLoanApplication.setLoanAmount(loanapplication.getLoanAmount());
		tempLoanApplication.setTenure(loanapplication.getTenure());
		tempLoanApplication.setInterest(loanapplication.getInterest());
		tempLoanApplication.setStatus(loanapplication.getStatus());
		
		User  u = new User();
		u.setUserId(loanapplication.getUser().getUserId());
		
		tempLoanApplication.setUser(u);
		hlservice.addLoanInfo(tempLoanApplication);
		return tempLoanApplication;
	}
	
	
	

}