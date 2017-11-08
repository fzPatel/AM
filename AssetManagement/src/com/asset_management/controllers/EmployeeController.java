package com.asset_management.controllers;
 
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.asset_management.beans.AdminBean;
import com.asset_management.beans.RequestBean;
import com.asset_management.beans.UserBean;
import com.asset_management.models.EmployeeModel;
import com.asset_management.models.ManagerModel;

@SessionAttributes({"employeeid","managerid", "designation","user_session"})
@Controller

public class EmployeeController 
{
	ModelAndView mv=null;
	@RequestMapping("/hello")
	public ModelAndView welcome()
	{
		mv=new ModelAndView("index");
			return mv;
	}
	
	@RequestMapping("/backs")
	public ModelAndView back()
{
	ModelAndView mv=new ModelAndView("employee_home");
		return mv;
}

//	@RequestMapping("/userlogin")
//	public ModelAndView Emplogin(@RequestParam int employeeid , @RequestParam String password , @RequestParam String designation  )
//	{
//		UserBean ab= new UserBean();
//		System.out.println(employeeid+"   "+password+"   "+designation);
//		ab.setEmployeeid(employeeid);
//		ab.setPassword(password);
//		ab.setDesignation(designation);
//		EmployeeModel ud = new EmployeeModel();
//		int y= ud.Userlogin(ab);
//		if (y!=0)
//		{
//			mv=new ModelAndView("Userhome");
//			mv.addObject("employeeid",ab.getEmployeeid());
//			String mid=ud.Managerid(ab);
//			System.out.println(ab.getManager_id());
//			mv.addObject("managerid", mid);
//			mv.addObject("designation",ab.getDesignation());
//			
//		}
//		
//		return mv;
//	}
	
	
//	
//	@RequestMapping("/change_password")
//	
//public ModelAndView changepwd()
//	{
//		
//		ModelAndView mv = new ModelAndView("changeuserpassword");
//			return mv;
//}
//	//@RequestMapping
//	@RequestMapping("/changeuserpassword") 
//	public ModelAndView changepassword(@RequestParam int employeeid ,@RequestParam String password , String designation)
//	{
//			
//			ModelAndView mv=null;
//			EmployeeModel d=new EmployeeModel();
//			
//		int y=d.changeUpassword(employeeid, password, designation);
//		if(y==1)
//		{
//			ModelAndView m1=new ModelAndView("changeuserpassword");	
//			{
//				m1.addObject("msg", "change password successfully");
//			}}
//		return mv;	
//		}
	

	
	@RequestMapping ("/createrequestbyemp")
	public ModelAndView Createreq1()
	{
        ModelAndView mv = null;
      
    	   mv= new ModelAndView("Createrequestemployee");
    	  
    	  return mv;
	}
	
	
	
	@RequestMapping ("/requestcreatetomanagerbyemp")
	
	public ModelAndView Createreq(@ModelAttribute ("Requestbeans")RequestBean ab)
	{
        ModelAndView mv = null;
       
       EmployeeModel um = new EmployeeModel ();
       
   	int day, month, year;
   	GregorianCalendar date = new GregorianCalendar();
   	day = date.get(Calendar.DAY_OF_MONTH);
   	month = date.get(Calendar.MONTH);
   	year = date.get(Calendar.YEAR);
   	String request_date= (year+"/"+(month+1)+"/"+day);
   	ab.setRequestdate(request_date);
   	
   	System.out.println(ab.getManagerid());
   	System.out.println(ab.getAssetname());
   	System.out.println(ab.getRequestdate());
       
       
       int y= um.createrequest(ab);
       
       if(y==1)
       {
    		
    	   mv= new ModelAndView("Createrequestemployee");
    	   
    	   
    	  mv.addObject("msg", "user successfully created");
    	  
       }
	return mv;
		
	}
	@RequestMapping("/EmpViewmyrequest") 
	public ModelAndView view(HttpSession ss)
	{		
	int employeeid=(Integer)ss.getAttribute("user_session");

		ModelAndView mv=null;
		EmployeeModel am=new EmployeeModel();
	
	List<RequestBean> list=am.Viewrequest(employeeid) ;
	 mv=new ModelAndView("EmpViewmyrequestpage");
		 mv.addObject("LIST",list);
	return mv;
	}

	@RequestMapping("/Myasset") 
	public ModelAndView myasset(HttpSession session)
	{	
		System.out.println("Myasset");

		
		int employeeid=(Integer)session.getAttribute("user_session");

		

		System.out.println(employeeid);
		
		ModelAndView mv=null;
		EmployeeModel am=new EmployeeModel();
	
		List<RequestBean> list=am.myasset(employeeid);
	 mv=new ModelAndView("EmpMyasset");
		 mv.addObject("LIST",list);
	return mv;
	}
	
		
	
@RequestMapping("/Empviewmyprofile")	
		public ModelAndView viewprofile(HttpSession ss)
	{
		int s=(int)ss.getAttribute("user_session");
	System.out.println(s+"usersession");
	
		System.out.println("session id" +s );
		ModelAndView mv= null;
		EmployeeModel um = new EmployeeModel();
	List <UserBean> list= um.viewprofile(s);
		mv=new ModelAndView("Empviewmyprofile");
		mv.addObject("List", list);
		return mv;
		}
	
	
	@RequestMapping("/updateprofiletojsp") 
	public ModelAndView updateprofile1(@RequestParam int id ,@RequestParam String fname ,@RequestParam String lname ,@RequestParam String email,String mobile)
	{
		
		ModelAndView mv=new ModelAndView("update_profile_to_jsp");
			UserBean ub=new UserBean();
			ub.setEmployeeid(id);
			ub.setFirstname(fname);
			ub.setLastname(lname);
			ub.setEmailid(email);
			ub.setMobile(mobile);
			
			mv.addObject("forupdate",ub);
		return mv;

	}
	
	
	
	
	
	@RequestMapping("/updateprofile") 
	public ModelAndView Updaterecords(HttpSession ss, @RequestParam int id ,@RequestParam String fname ,@RequestParam String lname ,@RequestParam String email,String mobile)
	{
		ModelAndView mv=null;
		
		EmployeeModel am=new EmployeeModel();
		int x=am.update_profile(id,fname,lname,email,mobile);
		
		
		int s=(int)ss.getAttribute("user_session");
		
		
		
			EmployeeModel um = new EmployeeModel();
		List <UserBean> list= um.viewprofile(s);
			mv=new ModelAndView("Empviewmyprofile");
			mv.addObject("List", list);
	 
		

		
	return mv;
	}


	
	
	@RequestMapping("/change_password ") 
	public String changepwd()
	{
		return "Employee_change_password";
		
	}
	@RequestMapping("/EmpchangePassword")
	public ModelAndView Employee_change_pwd(HttpSession session ,@RequestParam String current,@RequestParam String New, @RequestParam String confirm  )
{
	int s1=(int)session.getAttribute("user_session");
	
	int y= new EmployeeModel().changepwds(current, New, s1);
		if(y!=0)
		{
			mv=new ModelAndView("Employee_change_password");
			mv.addObject("passwordchanged","Password Has Been Changed");
		}
		
		return mv;
	}
	
	      
	}
	
	
