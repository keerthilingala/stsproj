package com.example.demo.Service;



import java.security.Security;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.Admindao;
import com.example.demo.Dao.SupportAnalystdao;
import com.example.demo.Dao.feedbackdao;
import com.example.demo.Model.Admin;
import com.example.demo.Model.AdminLogin;
import com.example.demo.Model.Feedbackquestions;
import com.example.demo.Model.ForgotUid;

import com.example.demo.Model.SupportAnalyst;

@Service
@Component
public class AdminServicesImpl implements AdminServices {
	@Autowired
	private Admindao dao;
	
	@Autowired
	private SupportAnalystdao supportDao;

	@Autowired 
	private feedbackdao fdao;
	
	@Override
	public int CreateAd(Admin admin) {
		Admin a=dao.findByAdminId(admin.getAdminId());
		if(a==null) {
			Admin a1=dao.save(admin);
			if (a1 != null) {
				return 1;
			} else {
				return 2;
			}
		}
		return 0;
	}

	@Override
	public int login(AdminLogin adminlogin) {
		Admin a =dao.findByAdminId(adminlogin.getUserId());
		 if(a==null)
		 {
		   return 1;
		 }
		 else
		 {
		 return 2;
		 }
}
	
	@Override
	public List<SupportAnalyst> listsupportanalyst() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	@Override
	public List<String> getAllAdminIDs() {

         List<String> ids = new ArrayList<String>();
		
		
         dao.findAll().forEach(t->{
        	 
        	 ids.add(t.getAdminId());
        	 
         });
		return ids;
	}
	
	@Override
	public String fid(ForgotUid fuid) {
		Admin a1=dao.findBycontactNumber(fuid.getPhno());
		//System.out.println("Admin "+a1);
		  if(a1!=null)
		  {
			
			  if((a1.getSecretquestion1().equals(fuid.getQstn1()) && a1.getSecretquestion2().equals(fuid.getQstn2())) )

			{
				  System.out.println("x1");
				boolean a5=a1.getAnswer1().equalsIgnoreCase(fuid.getAns1());
				boolean a6=a1.getAnswer2().equalsIgnoreCase(fuid.getAns2());
				
				if((a5==true) &&(a6==true) )
				{
					return a1.getAdminId();
				}
			}
		  }
		  return null;
		}
	
	
	
	@Override
	public boolean fpwd(ForgotUid fuid) {
		Admin a1=dao.findByAdminId(fuid.getUid());
		  if(a1!=null)
		  {
			int a2= a1.getSecretquestion1().compareTo(fuid.getQstn1());
			int a3= a1.getSecretquestion2().compareTo(fuid.getQstn2());
			
			if((a2==0) && (a3==0))
			{
				boolean a5=a1.getAnswer1().equalsIgnoreCase(fuid.getAns1());
				boolean a6=a1.getAnswer2().equalsIgnoreCase(fuid.getAns2());
				
				if((a5==true) &&(a6==true) )
				{
					return true;
				}
			}
		  }

		 
		  return false;
		}
	@Override
	public List<Feedbackquestions> feedbackList() {
		return fdao.findAll();
	}

	@Override
	public boolean assignRemedy(String inputString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fpwd1(ForgotUid fuid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin getAdmin(String username) {
		
		return dao.findByAdminId(username);
	}

	@Override
	public Admin getAdminByContactNumber(String contactNumber) {
		// TODO Auto-generated method stub
		return dao.findBycontactNumber(contactNumber);
	}

}
	

	
	