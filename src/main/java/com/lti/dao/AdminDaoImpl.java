package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.beans.Admin;
import com.lti.beans.LoanApplication;
import com.lti.excep.AppExcep;




@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public boolean adminLogin(Admin admin) {
		
		boolean flag = false;
		
		Admin a = null;
		 try {
			
				String username =  admin.getUserName();
				String password = admin.getPassword();
				
				a = (Admin)em.createQuery("select a from Admin a where a.userName=:userName").setParameter("userName", username).getSingleResult();
				
				if(( a.getUserName().equals(username) ) && ( a.getPassword().equals(password) ) ) {
					
					flag = true;
				}
				else flag = false;
			
		    }
		    catch(Exception e) { 
		    	System.out.println("Error:"+e);
		    	 
			}
		return flag;
	}
               

	public List<LoanApplication> viewPendingApprovals() {
		//String prm ="pending";
		
		//TypedQuery<Product> qr = em.createQuery("select p from Product p where p.category.id=:category_id",Product.class);
		
		Query qry = em.createQuery("Select l from LoanApplication l where status=:prm");
		qry.setParameter("prm", "pending");
		List<LoanApplication> applist=qry.getResultList();
		return applist;
	}


	@Override
	public List<LoanApplication> getAllApplications() {
		
		Query q1=em.createQuery("Select l from LoanApplication l",LoanApplication.class);
		List<LoanApplication> applist=q1.getResultList();
		return applist;
	}


	@Override
	public List<LoanApplication> approvedApplications() {
		Query qry2 = em.createQuery("Select l from LoanApplication l where status=:prm");
		qry2.setParameter("prm", "approved");
		List<LoanApplication> applist=qry2.getResultList();
		return applist;
	}


	@Override
	public List<LoanApplication> rejectedApplications() {
		Query qry3 = em.createQuery("Select l from LoanApplication l where status=:prm");
		qry3.setParameter("prm", "rejected");
		List<LoanApplication> applist=qry3.getResultList();
		return applist;
	}
	
	@Override
	@Transactional
	public boolean updatestatus(int applicationId, String status) throws AppExcep{
		System.out.println("dao layer");
		LoanApplication lapp=em.find(LoanApplication.class,applicationId);
		lapp.setStatus(status);
		LoanApplication tempEmp=em.merge(lapp);
		return true;

	}
	
	@Override
	@Transactional
	public LoanApplication findApplicationByUserId(int userId) throws AppExcep {
		
		TypedQuery<LoanApplication> qry = em.createQuery("Select a from LoanApplication a join a.user u where u.userId=:userId", LoanApplication.class);
		qry.setParameter("userId", userId);
		LoanApplication a = (LoanApplication)qry.getSingleResult();
		return a;
		
		

		
		

	}
	
}

