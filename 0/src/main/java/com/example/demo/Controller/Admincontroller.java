package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Dao.Admindao;
import com.example.demo.Dao.SupportAnalystdao;
import com.example.demo.Model.Admin;
import com.example.demo.Model.AdminLogin;
import com.example.demo.Model.Feedbackquestions;
import com.example.demo.Model.ForgotUid;
import com.example.demo.Model.SupportAnalyst;
import com.example.demo.Service.AdminServices;

@Controller
public class Admincontroller {
	@Autowired
	private Admindao dao;
	@Autowired
	private SupportAnalystdao sdao;
   
    @Autowired
    private AdminServices adminservices;
    
	@GetMapping(value="/admin")
	 public String admin(Model model) {
		 model.addAttribute("admin",new Admin());
		 return "Admin";
	 }
	@PostMapping(value="/adminreg")
	public String adminreg(@ModelAttribute("admin") Admin adminreg,Model model) {
		Admin ar= dao.save(adminreg);
		if(ar!=null) {
			model.addAttribute("message","Your details are submitted successfully.");
			return "Admin";
		}else {
			model.addAttribute("message","Something went wrong.");
			return "failure";
		}		
	}	
	@GetMapping(value="/adminlogin")
	public String adminlogin(Model model) {
		model.addAttribute("adminlogin", new AdminLogin());
		return "AdminLogin";
	}
	
	@PostMapping(value="/loginverify")
	public String loginverify(@ModelAttribute("adminlogin") AdminLogin adminlogin,Model model,HttpSession session)
	{
		Optional<Admin> al=dao.findById(adminlogin.getUserId());
		if(al.isPresent())
			
		{
			Admin a1=al.get();
			if(a1.getPassword().equals(adminlogin.getPassword()))
			{
				session.setAttribute("name", a1.getAdminId());
				return "AdminHome";
			}		
		}
		
		model.addAttribute("message", "Invalid userId or password");
		return "AdminLogin";
		
	}	
	@GetMapping(value="/req")
	public String req(Model model) {
		List<SupportAnalyst> list=(List<SupportAnalyst>) sdao.findAll();
	    List<String> headerList = new ArrayList<String>();
	    headerList.add("AdminId");
	    headerList.add("First Name");
	    headerList.add("Last Name");
	    headerList.add("Age");
	    headerList.add("Gender");
	    headerList.add("Contact Number");
	    headerList.add("Support Level");
	    headerList.add("Status");
	    headerList.add("Action");
	    model.addAttribute("title","Support Analyst Activation Request");
	    model.addAttribute("headersList",headerList);
		model.addAttribute("list",list);
		model.addAttribute("sa",1);
		return "RequestList";
	}
	
	@GetMapping(value="/accept")
	public String acceptreq(@RequestParam("name") String name,Model model) {
		SupportAnalyst sadmin=sdao.findByAnalystId(name);
		System.out.println(sadmin);
		String status=sadmin.getStatus();
		sadmin.setStatus("Yes");
		sdao.save(sadmin);
		if(sadmin.getStatus().equals(status)) {
			model.addAttribute("message","Unable to update");
		}
		return "AdminHome";
	}
	
	@GetMapping(value="/reject")
	public String rejectreq(@RequestParam("name") String name,Model model) {
		SupportAnalyst badmin=sdao.findByAnalystId(name);
		String status=badmin.getStatus();
		badmin.setStatus("no");
		sdao.save(badmin);
		if(badmin.getStatus().equals(status)) {
			model.addAttribute("message","Unable to update");
		}
		return "AdminHome";
		
	}	
	@GetMapping(value="/adminlogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/adminLogout")
	public String adminLogOut(HttpSession session)
	{
		session.invalidate();	
		return "redirect:/";
	}
	
	
	@GetMapping("/remedyAssign")
	public String assignRemedy(@RequestParam("assign") String query,HttpSession session,Model model,RedirectAttributes redirectAttribites)
	{
		if(adminservices.assignRemedy(query))
		{
			//model.addAttribute();
			
			redirectAttribites.addFlashAttribute("message", "Remedy Assigned Successfully");
			return "redirect:/remedyinfo";
		}
		else
		{
			model.addAttribute("message", "Remedy Not Assigned Successfully");
			return "redirect:remedyinfo";
		}
	}
	
	
	
	@GetMapping("/getAdminids")
	public @ResponseBody String getAdminIDS(HttpServletRequest requset,HttpServletResponse response)
	{
		List<String> admin_ids = adminservices.getAllAdminIDs();
		
		String ids="";
		for(String id:admin_ids)
		{
			ids+="<option value='"+id+"'>"+id+"</option>";
		}
		return ids;
	}
	@GetMapping("/forgotuid")
	public String fid(Model model){
		//model.addAttribute("name",new ForgotUid());
		return "forgotid";
	}
	@PostMapping("/forgotuid1")
	public String fid1(@RequestParam("phno") String phone,Model model)
	{
		Admin b=adminservices.getAdminByContactNumber(phone);
		System.out.println(b+" :"+phone);
		if(b!=null)
		{
			
			ForgotUid fid = new ForgotUid();
			fid.setUid(b.getAdminId());
			fid.setPhno(phone);
			model.addAttribute("name3", fid);
	  	return "forid";
		}
		else
		{
			model.addAttribute("message","Incorrect credentials");
			
		}
		return "forgotid";
	}
	@PostMapping("/forgotuid4")
	public String fid2(@ModelAttribute("name3") ForgotUid fid,Model model)
	{
		
		System.out.println("in controller "+fid);
		String b=adminservices.fid(fid);
		if(b!=null)
		{
	  	model.addAttribute("message",b);
	  	
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
		}
		return "forgotid";
	}
	@GetMapping("/forgotpswd")
	public String fpwd(Model model){
		model.addAttribute("name1",new ForgotUid());
		return "forgotpwd";
	}
	@PostMapping("/getpwd1")
	public String  pwd1(Model model,@RequestParam("uid") String uid)
	{
		Admin admin = adminservices.getAdmin(uid);
		System.out.println(admin);
		if(admin!=null)
		{
			ForgotUid fuid = new ForgotUid();
			fuid.setUid(uid);
			model.addAttribute("name2", fuid);
			return "forpass";
		}else
		{
			return "forgotpwd";
		}
	}
	@PostMapping("/forgotpwd1")
	public String fpwd1(@ModelAttribute("name2") ForgotUid fid,Model model)
	{
		
		System.out.println(fid);
		boolean b=adminservices.fpwd(fid);
		
		
		if(b==true)
		{
			model.addAttribute("name1", fid);
	  	  return "resetPwd";
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
			return "forgotpwd";
		}
		}@PostMapping("/forgotpwd2")
		public String fpwd2(@ModelAttribute("name2") ForgotUid fid,Model model)
		{
			boolean b=adminservices.fpwd1(fid);
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
	@PostMapping("/updatepwd")
	public String updatePassword(@ModelAttribute("name1") ForgotUid forgetUID,Model model)
	{
		Admin ad =dao.findByAdminId(forgetUID.getUid());
		System.out.println(ad);
		ad.setPassword(forgetUID.getPwd());
		dao.save(ad);
		model.addAttribute("message","your password has been updated");
		return "resetPwd";

	}
	@GetMapping("/feedbkcustomers")
	public String getAllfeedbacks(Model model,HttpSession session)
	{
		List<Feedbackquestions> cusList=adminservices.feedbackList();
		model.addAttribute("feedlist", cusList);
		return "feed";
	}
	
	

}