package com.asset_management.controllers;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.asset_management.beans.AllocatedAssetsBean;
import com.asset_management.beans.RequestBean;
import com.asset_management.models.AdminModel;
import com.asset_management.models.SupportModel;

@Controller

public class SupportController {
ModelAndView mv=null;
	@ModelAttribute
	public void addCommonObject(Model m)
	{
		m.addAttribute("oh","Asset Management");
	}
	
	@RequestMapping("/logout") 
	public ModelAndView Logout(HttpSession session)
	{	
		mv=new ModelAndView("user_login");			
		session.invalidate();
		return mv;
	}
	
	@RequestMapping("/supporthome") 
	public ModelAndView supporthome()
	{	
		mv=new ModelAndView("support_home");		
		return mv;
	}
	
	@RequestMapping("/viewassetrequest")
	public ModelAndView viewassetrequest(@RequestParam String usersession)
	{
		ArrayList<RequestBean> al=new SupportModel().retriveRequests(usersession);
		if(al.isEmpty())
		{		
			mv=new ModelAndView("show_requests");
			mv.addObject("requests_arraylist_empty", "No Data To Show!!!!");
		}
		else
		{
			mv=new ModelAndView("show_requests");
			mv.addObject("requests_arraylist", al);
			
		}
		return mv;
	}
	
	
	@RequestMapping("/viewreports")
	public ModelAndView viewreports()
	{
//		int usersession1=Integer.parseInt(usersession);
		ArrayList<AllocatedAssetsBean> al=new SupportModel().retriveReports();
		if(al!=null)
		{
			mv=new ModelAndView("view_reports");
			mv.addObject("reports_arraylist", al);
			
		}
		return mv;
	}
	
	@RequestMapping("/approveandinsert")
	public ModelAndView approveandinsert(@RequestParam String assetname,@RequestParam String dateofallocation,@RequestParam int supportid,@RequestParam String emailid,@RequestParam int employeeid,@RequestParam int requestid)
	{	
		System.out.println("inside supportcontroller---->approveandinsert()");
		
		
		int y=new SupportModel().approve(employeeid,requestid);
		int w=new SupportModel().insert(employeeid,assetname,dateofallocation,supportid,emailid);
//		int y=new SupportModel().approveAndInsert(assetname,dateofallocation,supportid,emailid,employeeid,requestid);
//		String assetname,String dateofallocation,int supportid,String emailid,
		if(w==1 && y==1)
		{
			mv=new ModelAndView("show_requests");
			String support_session1=supportid+"";
			ArrayList<RequestBean> al=new SupportModel().retriveRequests(support_session1);			
			mv.addObject("requests_arraylist", al);
			
		}
		return mv;
	}
	
	
	
	
	@RequestMapping("/cancelrequest")
	public ModelAndView cancelrequest(@RequestParam int supportid,@RequestParam int employeeid,@RequestParam int requestid,HttpSession ss)
	{		
		int support_session=(Integer)ss.getAttribute("support_session");
		
		int y=new SupportModel().cancelRequest(supportid,employeeid,requestid);
		if(y==1)
		{
			mv=new ModelAndView("show_requests");
			String support_session1=supportid+"";
			ArrayList<RequestBean> al=new SupportModel().retriveRequests(support_session1);				
			
			mv.addObject("requests_arraylist", al);
			
		}
		return mv;
	}
	
	
	
	
	@RequestMapping("/changesupportpassword")
	public ModelAndView supportchangepassword()
	{
		mv=new ModelAndView("support_change_password");
		return mv;
	}
	@RequestMapping("/supportpasswordchanged")
	public ModelAndView supportpasswordchanged(HttpSession ss,@RequestParam String password,@RequestParam String user_designation)
	{
		int support_session=(Integer)ss.getAttribute("support_session");
		
		int y=new SupportModel().updateNewPassword(support_session,password,user_designation);
		if(y!=0)
		{
			mv=new ModelAndView("support_home");
			mv.addObject("passwordchanged","password has been changed");
		}
		
		return mv;
	}
	
	
	
	
	
	@RequestMapping("/SupportPasswordExistsOrNot")
	public ModelAndView SupportPasswordExistsOrNot(@RequestParam int supportid)
	{
		System.out.println("Controller mai Password checking chala.......");
		 
		 String password=new SupportModel().checkExistanceOfSupportPassword(supportid);
		 mv=new ModelAndView("support_change_password");
		 mv.addObject("see",password);
		return mv;
	}
	
	
	
	
	
	
	
	

	
}
