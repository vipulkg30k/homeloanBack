package com.lti;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lti.beans.Admin;
import com.lti.beans.IncomeSalaried;
import com.lti.beans.IncomeSelfEmployed;
import com.lti.beans.LoanApplication;
import com.lti.beans.Property;
import com.lti.beans.User;
import com.lti.dao.AdminDao;
import com.lti.dao.HomeLoanDao;
import com.lti.excep.AppExcep;
import com.lti.services.AdminService;
import com.lti.services.HomeLoanService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class HomeLoanApplicationTests {

	@Autowired
	HomeLoanService homeser;
	
	@Autowired
	AdminService adminser;
	
	
	@MockBean
	HomeLoanDao homeapp;
	
	@MockBean
	AdminDao adminapp;
	
//	****************************************************************************************1
	
	@Test
	void testGetUser() {
		
		
		User u1=new User(10001,"ankit","U","pandey","ankitanpandey1@gmail.com","ABCD12","8975964417","2000-10-27","Male",
				"Indian","842296589741","AZZOJ0559T");
		
		
		User u2=new User(10002,"vipul","kumar","goyal","vipulgoyal@gmail.com","ABCD@312","8975964417","2000-10-27","Female",
				"Indian","842516589741","APZOJ0559T");
          List<User> usrList = new ArrayList<>();
		
          usrList.add(u1);
          usrList.add(u2);	
		
		Mockito.when(homeapp.getAllUsers()).thenReturn(usrList);
		assertThat(homeser.getAllUsers()).isEqualTo(usrList);
		
	}
	
    @Test
    void testaddUser() {
    	User u1=new User(10001,"ankit","U","pandey","ankitanpandey1@gmail.com","ABCD12","8975964417","2000-10-27","Male",
				"Indian","842296589741","AZZOJ0559T");
		System.out.println(u1);
		Mockito.when(homeapp.registerUser(u1)).thenReturn(true);
		Assertions.assertThat(homeser.registerUser(u1)).isEqualTo(true);
	}
    
    @Test
    void testLogin() {
    	User u1=new User(10001,"ankit","U","pandey","ankitanpandey1@gmail.com","ABCD12","8975964417","2000-10-27","Male",
				"Indian","842296589741","AZZOJ0559T");
    	System.out.println(u1);
    	Mockito.when(homeapp.loginProcess(u1)).thenReturn(u1);
    	Assertions.assertThat(homeser.loginProcess(u1)).isEqualTo(u1);
    	
    	
    }
    
    @Test
    void testgetUserInfoByUserId() {
    	User u1=new User(10001,"ankit","U","pandey","ankitanpandey1@gmail.com","ABCD12","8975964417","2000-10-27","Male",
				"Indian","842296589741","AZZOJ0559T");
    	System.out.println(u1);
    	Mockito.when(homeapp.getUserInfobyUserId(u1.getUserId())).thenReturn(u1);
    	Assertions.assertThat(homeser.getUserInfobyUserId(u1.getUserId())).isEqualTo(u1);
    }
    
    
    
//    ************************************************************************************2
    @Test
	void testaddIncomeSalary() {
    	User u1=new User(10001,"ankit","U","pandey","ankitanpandey1@gmail.com","ABCD12","8975964417","2000-10-27","Male",
				"Indian","842296589741","AZZOJ0559T");
    	IncomeSalaried incomeSalaried = new IncomeSalaried(1,60,40000.00,"LTI",u1);
    	System.out.println(u1);
    	System.out.println(incomeSalaried);
    	Mockito.when(homeapp.addIncomeSalariedInfo(incomeSalaried)).thenReturn(true);
    	Assertions.assertThat(homeser.addIncomeSalariedInfo(incomeSalaried)).isEqualTo(true);
    	
    }
    
    @Test
    void testaddSelfEmployed() {
    	User u1=new User(10001,"ankit","U","pandey","ankitanpandey1@gmail.com","ABCD12","8975964417","2000-10-27","Male",
				"Indian","842296589741","AZZOJ0559T");
    	IncomeSelfEmployed incomeSelfEmployed = new IncomeSelfEmployed(1,30000.00,"Import Export",u1);
    	System.out.println(u1);
    	System.out.println(incomeSelfEmployed);
    	Mockito.when(homeapp.addIncomeSelfEmployedInfo(incomeSelfEmployed )).thenReturn(true);
    	Assertions.assertThat(homeser.addIncomeSelfEmployedInfo(incomeSelfEmployed )).isEqualTo(true);
    	
    }
    
    
//    ****************************************************************************************3
    
    @Test
    void testaddProperty() {
    	User u1=new User(10001,"ankit","U","pandey","ankitanpandey1@gmail.com","ABCD12","8975964417","2000-10-27","Male",
				"Indian","842296589741","AZZOJ0559T");
    	Property property = new Property(101,"Lakshmi Apartments","Bhubaneswar",6000000.00,u1);
    	System.out.println(u1);
    	System.out.println(property);
    	Mockito.when(homeapp.addPropertyInfo(property)).thenReturn(true);
    	Assertions.assertThat(homeser.addPropertyInfo(property)).isEqualTo(true);
    	
    }
    
    
    
//    *********************************************************************************************4
    @Test
    void testaddLoanApplication() {
    	User u1=new User(10001,"ankit","U","pandey","ankitanpandey1@gmail.com","ABCD12","8975964417","2000-10-27","Male",
				"Indian","842296589741","AZZOJ0559T");
    	LoanApplication loanApp = new LoanApplication(6001,20000.00,30,10,"pending",u1);
    	System.out.println(u1);
    	System.out.println(loanApp);
    	Mockito.when(homeapp.addLoanInfo(loanApp)).thenReturn(true);
    	Assertions.assertThat(homeser.addLoanInfo(loanApp)).isEqualTo(true);
    	
    }
    
    
    @Test
    void testAdminLogin() {
    	Admin a1  = new Admin(201,"ankitan","byebye1@2");
    	System.out.println(a1);
    	Mockito.when(adminapp.adminLogin(a1)).thenReturn(true);
    	Assertions.assertThat(adminser.adminLogin(a1)).isEqualTo(true);
    }
    	
    @Test
    void testpendingApprovals()
    {
    	User u1=new User(10001,"ankit","U","pandey","ankitanpandey1@gmail.com","ABCD12","8975964417","2000-10-27","Male",
				"Indian","842296589741","AZZOJ0559T");
    	LoanApplication loanApp1 = new LoanApplication(6001,20000.00,30,10,"pending",u1);
    	User u2=new User(10002,"vipul","kumar","goyal","vipulgoyal@gmail.com","ABCD@312","8975964417","2000-10-27","Female",
				"Indian","842516589741","APZOJ0559T");
    	
    	LoanApplication loanApp2 = new LoanApplication(6002,30000.00,35,10,"pending",u2);
    	List<LoanApplication> pendingLoanApplicationList = new ArrayList<>();
    	
    	pendingLoanApplicationList.add(loanApp1);
    	pendingLoanApplicationList.add(loanApp2);
    	
    	
    	Mockito.when(adminapp.viewPendingApprovals()).thenReturn(pendingLoanApplicationList);
		assertThat(adminser.viewPendingApprovals()).isEqualTo(pendingLoanApplicationList);
    	
    }
    
    
    @Test
    void testgetAllAppplications() {
    	
    	User u1=new User(10001,"ankit","U","pandey","ankitanpandey1@gmail.com","ABCD12","8975964417","2000-10-27","Male",
				"Indian","842296589741","AZZOJ0559T");
    	LoanApplication loanApp1 = new LoanApplication(6001,20000.00,30,10,"approved",u1);
    	User u2=new User(10002,"Vipul","Kumar","Goyal","vipulgoyal@gmail.com","ABCD@312","8975964417","2000-10-27","Female",
				"Indian","842516589741","APZOJ0559T");
    	
    	LoanApplication loanApp2 = new LoanApplication(6002,30000.00,35,10,"pending",u2);
    	List<LoanApplication> LoanApplicationList = new ArrayList<>();
    	
    	LoanApplicationList.add(loanApp1);
        LoanApplicationList.add(loanApp2);
    	
    	
    	Mockito.when(adminapp.getAllApplications()).thenReturn(LoanApplicationList);
		assertThat(adminser.getAllApplications()).isEqualTo(LoanApplicationList);
    	
    	
    }
    
    
    @Test
    void testApprovedApplications() {
    	User u1=new User(10001,"ankit","U","pandey","ankitanpandey1@gmail.com","ABCD12","8975964417","2000-10-27","Male",
				"Indian","842296589741","AZZOJ0559T");
    	LoanApplication loanApp1 = new LoanApplication(6001,20000.00,30,10,"approved",u1);
    	User u2=new User(10002,"vipul","kumar","goyal","vipulgoyal@gmail.com","ABCD@312","8975964417","2000-10-27","Female",
				"Indian","842516589741","APZOJ0559T");
    	
    	LoanApplication loanApp2 = new LoanApplication(6002,30000.00,35,10,"approved",u2);
    	List<LoanApplication> approvedLoanApplicationList = new ArrayList<>();
    	
    	approvedLoanApplicationList.add(loanApp1);
        approvedLoanApplicationList.add(loanApp2);
    	
    	
    	Mockito.when(adminapp.approvedApplications()).thenReturn(approvedLoanApplicationList);
		assertThat(adminser.approvedApplications()).isEqualTo(approvedLoanApplicationList);
    }
    
    
    @Test
    void testRejectedApplications() {
    	User u1=new User(10001,"ankit","U","pandey","ankitanpandey1@gmail.com","ABCD12","8975964417","2000-10-27","Male",
				"Indian","842296589741","AZZOJ0559T");
    	LoanApplication loanApp1 = new LoanApplication(6001,20000.00,30,10,"rejected",u1);
    	User u2=new User(10002,"vipul","kumar","goyal","vipulgoyal@gmail.com","ABCD@312","8975964417","2000-10-27","Female",
				"Indian","842516589741","APZOJ0559T");
    	LoanApplication loanApp2 = new LoanApplication(6002,30000.00,35,10,"rejected",u2);
    	
    	List<LoanApplication> rejectedLoanApplicationList = new ArrayList<>();
    	rejectedLoanApplicationList.add(loanApp1);
        rejectedLoanApplicationList.add(loanApp2);
        
        Mockito.when(adminapp.rejectedApplications()).thenReturn(rejectedLoanApplicationList );
		assertThat(adminser.rejectedApplications()).isEqualTo(rejectedLoanApplicationList );
    	
    	}
    
    @Test
    void testUpdateStatus() throws AppExcep {
    	
    	User u1=new User(10001,"ankit","U","pandey","ankitanpandey1@gmail.com","ABCD12","8975964417","2000-10-27","Male",
				"Indian","842296589741","AZZOJ0559T");
    	LoanApplication loanApp = new LoanApplication(6001,20000.00,30,10,"pending",u1);
    	
    	System.out.println(u1);
    	System.out.println(loanApp);
    	
    	Mockito.when(adminapp.updatestatus(6001,"approved")).thenReturn(true);
    	Assertions.assertThat(adminser.updatestatus(6001,"approved")).isEqualTo(true);
    	
    }
    
    
    @Test
    void testGetApplicationByUserId() throws AppExcep {
    	User u1=new User(10001,"ankit","U","pandey","ankitanpandey1@gmail.com","ABCD12","8975964417","2000-10-27","Male",
				"Indian","842296589741","AZZOJ0559T");
    	LoanApplication loanApp = new LoanApplication(6001,20000.00,30,10,"pending",u1);
    	
    	System.out.println(u1);
    	System.out.println(loanApp);
    	
    	Mockito.when(adminapp.findApplicationByUserId(u1.getUserId())).thenReturn(loanApp);
    	Assertions.assertThat(adminser.findApplicationByUserId(u1.getUserId())).isEqualTo(loanApp);
    }
  
}
