package com.lti.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.beans.IncomeSalaried;
import com.lti.beans.IncomeSelfEmployed;
import com.lti.beans.LoanApplication;
import com.lti.beans.Property;
import com.lti.beans.User;



@Repository("homeLoanDao")
public class HomeLoanDaoImpl implements HomeLoanDao {

	@PersistenceContext
	EntityManager em;
	
//	**************************************************************1
	@Transactional
	@Override
	public boolean registerUser(User user) {
		
		 boolean flag=false;
		    try {
			   
				em.persist(user);
				
				System.out.println("end");
				flag=true;
		    }
		    catch(Exception e) { 
		    	System.out.println("Error:"+e);
		    }
		    return flag;
	}
	

	@Transactional
	@Override
	public User loginProcess(User user) {
		
		int flag = 0;
		User u = null;
		 try {
			   
				String emailid =  user.getEmail();
				String password = user.getPassword();
				u = (User)em.createQuery("select u from User u where  u.email=:emailid").setParameter("emailid", emailid).getSingleResult();
				if(( u.getEmail().equals(emailid) ) && ( u.getPassword().equals(password) ) ) {
					
					flag = 1;
				}
				else flag = 0;
			
		    }
		    catch(Exception e) { 
		    	System.out.println("Error:"+e);
		    }
		 if(flag == 1)
		 	return u;
		 else return null;
		}
	

	public User send(String to) {
		User u = (User)em.createQuery( "select u from Users u where u.email=:email").setParameter("email", to).getSingleResult();
		return u;
	}

	@Override
	public User getUserInfobyUserId(int userId) {
		User u=em.find(User.class, userId);
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		TypedQuery<User> qry = em.createQuery("select u from User u", User.class);
        List<User> usrList = qry.getResultList();
        return usrList;
	
	}


//	************************************************************2
	@Transactional
	public boolean addIncomeSalariedInfo(IncomeSalaried incomeSalaried) {

		 boolean flag=false;
		    try {
			   
				em.persist(incomeSalaried);
				
				System.out.println("end");
				flag=true;
		    }
		    catch(Exception e) { 
		    	System.out.println("Error:"+e);
		    }
		    return flag;
	}

	@Transactional
	public boolean addIncomeSelfEmployedInfo(IncomeSelfEmployed incomeSelfEmployed) {
		 boolean flag=false;
		    try {
			   
				em.persist(incomeSelfEmployed);
				
				System.out.println("end");
				flag=true;
		    }
		    catch(Exception e) { 
		    	System.out.println("Error:"+e);
		    }
		    return flag;
	}

	
//	******************************************************************3
	@Transactional
	public boolean addPropertyInfo(Property property) {
		 boolean flag=false;
		    try {
			   
				em.persist(property);
				
				System.out.println("end");
				flag=true;
		    }
		    catch(Exception e) { 
		    	System.out.println("Error:"+e);
		    }
		    return flag;
	}

	
//	*********************************************************************4
	@Transactional
	public boolean addLoanInfo(LoanApplication appln) {
		 boolean flag=false;
		    try {
			   
				em.persist(appln);
				
				System.out.println("end");
				flag=true;
		    }
		    catch(Exception e) { 
		    	System.out.println("Error:"+e);
		    }
		    return flag;
	}

	
}
