package com.asset_management.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.asset_management.beans.AdminBean;
import com.asset_management.beans.UserBean;
import com.asset_management.models.AdminModel;
import com.asset_management.models.ManagerModel;



@Controller
@SessionAttributes("admin_session")
public class AdminController {

	
ModelAndView mv=null;	
	@RequestMapping("/")
	public ModelAndView start()
	{
		mv=new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("/adminlogout")
	public ModelAndView logout(HttpSession ht)
	{
		ht.invalidate();
		mv=new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("/adminhome")
	public ModelAndView adminhome()
	{
		mv=new ModelAndView("admin_home");
		return mv;
	}
	
	
	
	
	@RequestMapping("/adminlogin")
	public ModelAndView adminlogin()
	{
		mv=new ModelAndView("admin_login");
		return mv;
	}
	
	
	@RequestMapping("/adminlogincheck")
	public ModelAndView adminlogincheck(@ModelAttribute("AdminBean") AdminBean ab)
	{
		
		AdminModel m=new AdminModel();
		int y=m.adminLoginCheck(ab);
		
	
			if(y!=0)
			{			
				mv=new ModelAndView("admin_home");
				mv.addObject("admin_session",ab.getEmailid());			
			}
			else 
			{			
				mv=new ModelAndView("admin_login");
				mv.addObject("errormag","Login Failed");			
			}
		
		return mv;
	}
	
	
	
	@RequestMapping("/createuser")
	public ModelAndView create_user()
	{
		mv=new ModelAndView("create_user");
		return mv;
	}
	
	
	@RequestMapping("/insertuser")
	public ModelAndView insertuser(@ModelAttribute("UserBean") UserBean ub)
	{
//		String designation=ub.getDesignation();
			System.out.println("Testing admmin Controller ------> insertuser()----->managerid="+ub.getManagerid());
			
			Object o=new AdminModel().insertUser(ub);
			
			if(o!=null)
			{	
				mv=new ModelAndView("create_user");
				mv.addObject("user_inserted","user inserted");

				int userid=ub.getUserid();
				String Password=ub.getPassword();
				String designation=ub.getDesignation();
				String email=ub.getEmailid();

				
				AdminModel ad=new AdminModel();
				ad.sendMail(userid,Password,designation,email);
				
			}
			else if(o==null)
			{
				mv=new ModelAndView("create_user");
				mv.addObject("user_inserted","user Id Already Exist");
			}
		
			
		return mv;
	}
	
	
	@RequestMapping("/viewusers")
	public ModelAndView viewusers()
	{
		ArrayList<UserBean> al=new AdminModel().retriveAllUsers();
		if(al!=null)
		{
			mv=new ModelAndView("show_users");
			mv.addObject("users_arraylist", al);
			
		}
		return mv;
	}
	
	@RequestMapping("/backtoviewusers")
	public ModelAndView backtoviewusers()
	{
		ArrayList<UserBean> al=new AdminModel().retriveAllUsers();
		if(al!=null)
		{
			mv=new ModelAndView("show_users");
			mv.addObject("users_arraylist", al);
			
		}
		return mv;
	}
	
	
	@RequestMapping("/activeuser")
	public ModelAndView active_user(@RequestParam("hidden1") String emailid)
	{
		
		System.out.println(emailid);
		
		
		int y=new AdminModel().active(emailid);
		if(y==1)
		{
			System.out.println(y);
			
			ArrayList<UserBean> al=new AdminModel().retriveAllUsers();
			mv=new ModelAndView("show_users");
			mv.addObject("users_arraylist", al);
			
		}
		return mv;
	}
	
	

	@RequestMapping("/deactiveuser")
	public ModelAndView deactive_user(@RequestParam("hidden2") String emailid)
	{
		int y=new AdminModel().deactive(emailid);
		if(y==1)
		{
			ArrayList<UserBean> al=new AdminModel().retriveAllUsers();
			mv=new ModelAndView("show_users");
			mv.addObject("users_arraylist", al);
			
		}
		return mv;
	}
	
	
	
	
	
	@RequestMapping("/updateuser")
	public ModelAndView update_user(@RequestParam("hidden3") String emailid,@RequestParam("hidden4") String auto)
	{
		UserBean eb=new AdminModel().retriveUser(emailid);
		mv=new ModelAndView("update_user");
		mv.addObject("single_user", eb);
		
		return mv;
	}
	
	
	@RequestMapping("/updatesingleuser")
	public ModelAndView update_single_user(@ModelAttribute("UserBean") UserBean ub)
	{
		int y=new AdminModel().update_single_user(ub);
		
		if(y!=0)
		{

			ArrayList<UserBean> al=new AdminModel().retriveAllUsers();
			mv=new ModelAndView("show_users");
			mv.addObject("users_arraylist", al);
			mv.addObject("user_updated","Successfully updated");
		}
		else
		{
			
			ArrayList<UserBean> al=new AdminModel().retriveAllUsers();
			mv=new ModelAndView("show_users");
			mv.addObject("users_arraylist", al);
			mv.addObject("user_updated","Failed to  updated");
		}
		return mv;
	}
	
	

	
	
	
	

	@RequestMapping("/adminchangepassword")
	public ModelAndView adminchangepassword()
	{
		mv=new ModelAndView("admin_change_password");
		return mv;
	}
	@RequestMapping("/adminpasswordchanged")
	public ModelAndView admin_password_changed(HttpSession ss,@RequestParam String password)
	{
		String emailid=(String)ss.getAttribute("admin_session");
		
		int y=new AdminModel().updateNewPassword(emailid,password);
		if(y!=0)
		{
			mv=new ModelAndView("admin_home");
			mv.addObject("passwordchanged","password has been changed");
		}
		
		return mv;
	}
	
	
	
	
	
//	--------------------------04/november/2017------------------------------
	@RequestMapping("/retrivemanagerids")
	public ModelAndView retrivemanagerids()
	{
		ArrayList<Integer> al=new AdminModel().retriveManagerIds();
		System.out.println("Retriving manager ids in controller ");
		if(al!=null)
		{
			mv=new ModelAndView("retrived_manager_ids");
			mv.addObject("managerids", al);
		}
		else
		{
			mv=new ModelAndView("");
			mv.addObject("", al);
		}
		return mv;
	}
	

	@RequestMapping("/retrivesupportids")
	public ModelAndView retrivesupportids()
	{
		ArrayList<Integer> al=new AdminModel().retriveSupportIds();
		if(al!=null)
		{
			mv=new ModelAndView("retrived_support_ids");
			mv.addObject("supportids", al);
		}
		else
		{
			mv=new ModelAndView("");
			mv.addObject("", al);
		}
		return mv;
	}




	//-------------------------------------//--------------
	@RequestMapping("/AdminCheckOldpwd") 
	public void getoldpassword(HttpServletResponse response,@RequestParam String oldpassword,HttpSession ss)
	{
			
		int manager_id=420;
		
		String user=(String)ss.getAttribute("admin_session");
		//int manager_id=(Integer)ss.getAttribute("user_session");

				AdminModel am=new AdminModel();

				System.out.println("oldpassword inside Getoldpassword"+oldpassword);
				System.out.println("admin inside Getoldpassword"+user);
				
				
				int x=am.getMyOldPassword(oldpassword,user);
				System.out.println("Old Pass"+oldpassword);

			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				System.out.println(e);
				e.printStackTrace();
			}
			 	out.println(x);	
			 	System.out.println(x);

		}


}
