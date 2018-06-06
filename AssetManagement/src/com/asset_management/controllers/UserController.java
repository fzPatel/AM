package com.asset_management.controllers;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.asset_management.beans.UserBean;
import com.asset_management.models.EmployeeModel;
import com.asset_management.models.ManagerModel;
import com.asset_management.models.UserModel;

@Controller
@SessionAttributes({"support_session","manager_session","employee_session","user_designation","My_Request_To_Id","My_Request_To_Id&MyEmail","user_session","Emailid"})
public class UserController {
	ModelAndView mv=null;
	
	@ModelAttribute
	public void addCommonObject(Model m)
	{
		m.addAttribute("common","Asset Management");
	}
		
	
	
	//----------Back button---------//

	@RequestMapping("/backtoindex")
	public ModelAndView backtoindex()
	{
		ModelAndView mv=new ModelAndView("index");
			return mv;
	}
	
	
	
	
	@RequestMapping("/otheruser")
	public ModelAndView adminlogin()
	{
		mv=new ModelAndView("user_login");
		return mv;
	}
	

	//---------- Check Userlogin---------//

	
	@RequestMapping("/userlogin")
	protected ModelAndView userlogin(@RequestParam  int userid,@RequestParam String password)
	{ 
		System.out.println("before login_check.....................");
		int y=new UserModel().user_login_check(userid,password);
		
		if(y==1)
		{
			System.out.println("login check success huaaaaa.....      y="+y);
			String designation=new UserModel().fetchDesignation(userid);
		
		if(designation.equals("employee"))
		{

	        EmployeeModel em=new EmployeeModel();
			int retrivedId=em.View_PerticularId(userid,designation);
		    String ab =	em.get_Perticulardesignation( userid, designation);

				mv=new ModelAndView("employee_home");
				mv.addObject("My_Request_To_Id" ,retrivedId);
				mv.addObject("user_session",userid);	
				mv.addObject("user_designation",designation);
				mv.addObject("Emailid", ab);
				System.out.println("emailidcoming"+ab);
			}
			else if(designation.equals("manager"))
			{
				
				ManagerModel mm=new ManagerModel();
				UserBean retrivedId=mm.View_PerticularId(userid,designation);

				
				mv=new ModelAndView("manager_home");
				mv.addObject("user_session",userid);
				mv.addObject("user_designation",designation);
				mv.addObject("My_Request_To_Id&MyEmail" ,retrivedId);
						
			}
			else if(designation.equals("support"))
			{
				mv=new ModelAndView("support_home");
				mv.addObject("support_session",userid);
			}
			mv.addObject("user_designation",designation);
				
		}
		else
			mv=new ModelAndView("index");
		mv.addObject("loginFailedmsg","Login Failed Try again");

		return mv;
	}
	
//@RequestMapping("/logout") 
//public String Logout(HttpSession session,@RequestParam int usersession)
//{	
//int ss=(int)session.getAttribute("user_session");
//
//session.invalidate();
//
//	System.out.println("inside logout after invalidate"+ss);
//
//	return "check_session";
//}
		
	@RequestMapping("/UserAlreadyExistsOrNot")
	protected ModelAndView userAlreadyExistsOrNot(@RequestParam  String emailid,HttpServletResponse response )throws Exception
	{ 
		ModelAndView mv=null;
		int x=new UserModel().checkExistanceOfUser(emailid);
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=null;
		if(x==1)
		{
			mv=new ModelAndView("user_data_exist");
			mv.addObject("user_data_exist",x);
		}
		return mv;
	}
	
	
	
	//---------- Check userMobileAlreadyExistsOrNot---------//

	
	@RequestMapping("/UserMobileAlreadyExistsOrNot")
	protected ModelAndView 	userMobileAlreadyExistsOrNot(@RequestParam  String mobile,HttpServletResponse response )throws Exception
	{ 
		System.out.println("Mobile number check karne aaya................");
		ModelAndView mv=null;
		int x=new UserModel().checkMobileExistanceOfUser(mobile);
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=null;
		if(x==1)
		{
			mv=new ModelAndView("user_data_exist");
			mv.addObject("user_data_exist",x);
		}
		return mv;
	}
	

	
	//==============forgetpwd----------------//

	@RequestMapping("/forgetpwd")
	public ModelAndView forget()
	{
		mv=new ModelAndView("forgetPassword");
		return mv;
	}
	
	@RequestMapping("/forgetpwdSubmit")
	public ModelAndView forgetsubmit(@RequestParam  String emailid)
	{
	
		int x=new UserModel().forgetPassword(emailid);

		if(x!=0) 
		{
			mv=		mv=new ModelAndView("forgetPassword");
			mv.addObject("send mail","mailmsg");
			
		}
		
		
		return mv;
	}
	
	//forgetpasswordUserAlreadyExistsOrNot//
	
	@RequestMapping("/forgetpasswordUserAlreadyExistsOrNot")
	protected void forgetpasswordUserAlreadyExistsOrNot(@RequestParam  String emailid,HttpServletResponse response )throws Exception
	{ 
		int x=new UserModel().checkExistanceOfUser(emailid);
		PrintWriter out=response.getWriter();
		if(x==1)
		{
			out.println(x);			
		}
		
	}
	
	

}
