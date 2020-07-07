package com.example.demo.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.example.demo.Dao.SupportAnalystdao;
import com.example.demo.Dao.feedbackdao;
import com.example.demo.Model.Feedbackquestions;
import com.example.demo.Model.ForgotUid;
import com.example.demo.Model.SupportAnalyst;
import com.example.demo.Model.SupportAnalystLogin;

@Service
@Component
public class SupportAnalystServicesImpl implements SupportAnalystServices {
   @Autowired
   private SupportAnalystdao dao;
   @Autowired
   private feedbackdao fdao;
   
	@Override
	public int CreateSupportAnalyst(SupportAnalyst supportanalyst) {
		SupportAnalyst e=dao.findByAnalystId(supportanalyst.getAnalystId());
		if(e==null) {
			SupportAnalyst sa1=dao.save(supportanalyst);
			if (sa1 != null) {
				return 1;
			} else {
				return 2;
			}
		}
		return 0;
		
	}

	@Override
	public int login(SupportAnalystLogin supportanalystlogin) {
		SupportAnalyst sa=dao.findByAnalystId(supportanalystlogin.getUserId());
		 if(sa==null)
		 {
		   return 1;
		 }
		 else
		 {
		 return 2;
		 }

	}


	@Override
	public String f1id(ForgotUid f1uid) {
		SupportAnalyst sa=dao.findBycontactNumber(f1uid.getPhno());
		//System.out.println(sa);
		  if(sa!=null)
		  {
			//int a2= sa.getSecretquestion1().compareTo(f1uid.getQstn1());
			//int a3= sa.getSecretquestion2().compareTo(f1uid.getQstn2());
			//int a4= sa.getSecretquestion3().compareTo(f1uid.getQstn3());
			//if((a2==0) && (a3==0) && (a4==0))
			  if((sa.getSecretquestion1().equals(f1uid.getQstn1()) && sa.getSecretquestion2().equals(f1uid.getQstn2())) )

			{
				  System.out.println("x1");
				boolean a5=sa.getAnswer1().equalsIgnoreCase(f1uid.getAns1());
				boolean a6=sa.getAnswer2().equalsIgnoreCase(f1uid.getAns2());
				
				if((a5==true) &&(a6==true) )
				{
					System.out.println(sa.getAnalystId());
					return sa.getAnalystId();
				}
			}
		  }
		  return null;
		}
	@Override
	public boolean f1pwd(ForgotUid f1uid) {
		SupportAnalyst sa=dao.findByAnalystId(f1uid.getUid());
		  if(sa!=null)
		  {
			int a2= sa.getSecretquestion1().compareTo(f1uid.getQstn1());
			int a3= sa.getSecretquestion2().compareTo(f1uid.getQstn2());
			
			if((a2==0) && (a3==0))
			 
			{
				boolean a5=sa.getAnswer1().equalsIgnoreCase(f1uid.getAns1());
				boolean a6=sa.getAnswer2().equalsIgnoreCase(f1uid.getAns2());
				
				if((a5==true) &&(a6==true))
				{
					return true;
				}
			}
		  }
		  return false;
		}

	@Override
	public List<SupportAnalyst> getSupportAnalystList() {
		// TODO Auto-generated method stub
		Iterable<SupportAnalyst>list=dao.findAll();
		if(list==null) {
			return null;
		}
		return (List<SupportAnalyst>) list;
	}

	@Override
	public SupportAnalyst getSupportAnalystById(String id) {
		// TODO Auto-generated method stub
		
		SupportAnalyst sanalyst=dao.findByAnalystId(id);
		return sanalyst;
	}

	
	@Override
	public boolean updateSupportAnalyst(SupportAnalyst sanalyst) {
		// TODO Auto-generated method stub
		SupportAnalyst sanalyst1=dao.save(sanalyst);
		if(sanalyst1!=null) {
			return true;
		}
		return false;
	}


	@Override
	public int CreateFeedback(Feedbackquestions fq) {
		Feedbackquestions f=fdao.findBycustomerId(fq.getCustomerId());
		if(f==null) {
		Feedbackquestions f1=fdao.save(fq);
		if(f1!=null) {
			return 1;
		}else {
			return 2;
		}
		
	}
		return 0;
	}

	@Override
	public SupportAnalyst getSupportAnalyst(String username) {
		
		return dao.findByAnalystId(username);
	}

	@Override
	public SupportAnalyst getAnalystByContactNumber(String contactNumber) {
		// TODO Auto-generated method stub
		return dao.findBycontactNumber(contactNumber);
	}

	

}
