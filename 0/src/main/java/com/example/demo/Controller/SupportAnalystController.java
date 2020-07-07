package com.example.demo.Controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Dao.SupportAnalystdao;

import com.example.demo.Model.Feedbackquestions;
import com.example.demo.Model.ForgotUid;
import com.example.demo.Model.SupportAnalyst;
import com.example.demo.Model.SupportAnalystLogin;
import com.example.demo.Service.SupportAnalystServices;


@Controller
public class SupportAnalystController {
	@Autowired
	private SupportAnalystdao dao;
	
	@Autowired
	private SupportAnalystServices supportanalystservice;
	@GetMapping(value = "/supportanalyst")
	public String supportanalyst(Model model) {
		model.addAttribute("supportanalyst", new SupportAnalyst());
		return "SupportAnalyst";
	}

	@PostMapping(value = "/supportanalystreg")
	public String adminreg(@ModelAttribute("supportanalyst") SupportAnalyst adminreg, Model model) {
		adminreg.setStatus("no");
		SupportAnalyst ar = dao.save(adminreg);
		if (ar != null) {
			model.addAttribute("message", "Your details are submitted successfully.");
			return "SupportAnalyst";
		} else {
			model.addAttribute("message", "Oops...Something went wrong.");
			return "failure";
		}
	}

	@GetMapping(value = "/supportanalystlogin")
	public String adminlogin(Model model) {
		model.addAttribute("supportanalystlogin", new SupportAnalystLogin());
		return "SupportAnalystLogin";
	}

	@PostMapping(value = "/supportanalystverify")
	public String branchloginverify(@ModelAttribute("supportanalystlogin") SupportAnalystLogin adminlogin, Model model,
			HttpSession session) {
		Optional<SupportAnalyst> al = dao.findById(adminlogin.getUserId());
	
		if (al.isPresent()) {
			SupportAnalyst badmin = al.get();
			if (badmin.getPassword().equals(adminlogin.getPassword()) && badmin.getStatus().equalsIgnoreCase("yes")) {
				session.setAttribute("username", badmin.getAnalystId());
				return "SupportAnalystHome";
			} else if (badmin.getStatus().equalsIgnoreCase("no")) {
				model.addAttribute("message", "admin didn't conform the request");
				return "SupportAnalystLogin";
			}
			
		}
		model.addAttribute("message", "Invalid userId or password");
		return "SupportAnalystLogin";
	}
	@GetMapping(value="/supportanalystlogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/Aforgotuid")
	public String fid(Model model){
		//model.addAttribute("name",new ForgotUid());
		return "forgotid1";
	}
	@PostMapping("/Aforgotuid2")
	public String fid1(@RequestParam("phno") String phone,Model model)
	{
		SupportAnalyst b=supportanalystservice.getAnalystByContactNumber(phone);
		System.out.println(b+" :"+phone);
		if(b!=null)
		{
			ForgotUid fid = new ForgotUid();
			fid.setUid(b.getAnalystId());
			fid.setPhno(phone);
			
			model.addAttribute("name2", fid);
		}
		else
		{
		model.addAttribute("message", "Incorrect credentials");
		
		}
		return "forid11";
	}
	@PostMapping("/Aforgotuid3")
	public String fid2(@ModelAttribute("name2") ForgotUid fid,Model model)
	{
		System.out.println("in controller "+fid);
		String b=supportanalystservice.f1id(fid);
		if(b!=null)
		{
	  	model.addAttribute("message",b);
	  	
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
		}
		return "forgotid1";
	}
	
	
	@GetMapping("/Aforgotpswd")
	public String fpwd(Model model){
		model.addAttribute("name1",new ForgotUid());
		return "forgotpwd1";
	}
	@PostMapping("/getpwd2")
	public String  pwd1(Model model,@RequestParam("uid") String uid)
	{
		SupportAnalyst supportanalyst = supportanalystservice.getSupportAnalyst(uid);
		System.out.println(supportanalyst);
		if(supportanalyst!=null)
		{
			ForgotUid fuid = new ForgotUid();
			fuid.setUid(uid);
			model.addAttribute("name2", fuid);
			return "forpass";
		}else
		{
			return "forgotpwd1";
		}
	
	}
	
	
	@PostMapping("/Aforgotpwd1")
	public String f1pwd(@ModelAttribute("name2") ForgotUid fid,Model model)
	{
		System.out.println(fid);
		boolean b=supportanalystservice.f1pwd(fid);
		if(b==true)
		{
			model.addAttribute("name1", fid);
	  	  return "resetPwd1";
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
			return "resetPwd1";
		}
	}
	
	@PostMapping("/Aforgotpwd2")
	public String fpwd2(@ModelAttribute("name2") ForgotUid fid,Model model)
	{
		boolean b=supportanalystservice.f1pwd(fid);
		if(b==true)
		{
			
			
	  	  return "resetPwd";
	  	  
	  	  
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
			return "resetPwd";
		}
		
}
	
	@PostMapping("/Aupdatepwd")
	public String updatePassword(@ModelAttribute("name1") ForgotUid forgetUID,Model model)
	{
SupportAnalyst sa =dao.findByAnalystId(forgetUID.getUid());
System.out.println(sa);
		sa.setPassword(forgetUID.getPwd());
		dao.save(sa);
		model.addAttribute("message","your password has been updated");
		return "resetPwd1";
	}

	@GetMapping("/supportanalystLogout")
	public String supportanalystLogOut(HttpSession session)
	{
		session.invalidate();
		
		return "redirect:/";
	}
	@GetMapping("/feedback1")
	public String feedback1(Model model,HttpSession session)
	{
		Feedbackquestions f=new Feedbackquestions();
		String username=(String)session.getAttribute("username");
		f.setSaname(username);
		model.addAttribute("feedbk", f);
		return "FeedBackpage";
	}
   @PostMapping(value="/feedbackques")
	public String feedback(@ModelAttribute("feedbk")Feedbackquestions fdq,BindingResult result,Model model) {
		if(result.hasErrors())
		{
			return "FeedBackpage";
			
		}
		else {
			int res=supportanalystservice.CreateFeedback(fdq);
			if(res==0)
			{
				
				model.addAttribute("message",fdq.getCustomerId()+" you are already submitted the feedback");
				return "FeedBackpage";
			}
			else if(res==1)
			{
				model.addAttribute("message",fdq.getCustomerId()+" you are successfully submitted the feedback");
				return "FeedBackpage";
			}
			else {
				model.addAttribute("message","something went wrong");
				return "FeedBackpage";
			}
		}
	}
   @GetMapping("/help")
   public String help(Model model)
   { 
	   return "help";
   }
	
}
