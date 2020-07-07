package com.example.demo.Service;
import java.util.List;

import com.example.demo.Model.Feedbackquestions;
import com.example.demo.Model.ForgotUid;
import com.example.demo.Model.SupportAnalyst;
import com.example.demo.Model.SupportAnalystLogin;

public interface SupportAnalystServices {
	public int CreateSupportAnalyst(SupportAnalyst supportanalyst);
	public int login(SupportAnalystLogin supportanalystlogin);
	public String f1id(ForgotUid f1uid);
	public boolean f1pwd(ForgotUid f1uid);
	public List<SupportAnalyst> getSupportAnalystList();
	public SupportAnalyst getSupportAnalystById(String id);
	public boolean updateSupportAnalyst(SupportAnalyst sanalyst);
	public int CreateFeedback(Feedbackquestions fq);
	public SupportAnalyst getAnalystByContactNumber(String contactNumber);
	public SupportAnalyst getSupportAnalyst(String username);

}
