package com.asset_management.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.asset_management.beans.AssetTransferBean;
import com.asset_management.beans.RequestBean;
import com.asset_management.beans.UserBean;
import com.asset_management.models.ManagerModel;
import com.asset_management.models.SupportModel;
@SessionAttributes({"user_session","My_Request_To_Id&MyEmail"})
@Controller
public class ManagerController {
	ModelAndView mv=null;
	@RequestMapping("/")
	public ModelAndView welcome()
{
	ModelAndView mv=new ModelAndView("index");
		return mv;
}
	
	//---------------- Manager Profile--------------------

	
	@RequestMapping("/managerprofile") 
	public ModelAndView view(HttpSession ss)

	{	
		int manager_id =(int) ss.getAttribute("user_session");

		ManagerModel am=new ManagerModel();
		
			UserBean ub=am.ViewProfile_Manager(manager_id); 
		 mv=new ModelAndView("Manager_profile");
			 mv.addObject("Profile",ub);
		return mv;
		}


@RequestMapping("/managerprofileUpdateGet") 
public ModelAndView managerUpdateprofileGet(HttpSession ss)

{	
	
	int manager_id =(int) ss.getAttribute("user_session");

	System.out.println(manager_id);
	
	ManagerModel am=new ManagerModel();
	

	UserBean ub=am.ViewProfile_Manager(manager_id); 
 mv=new ModelAndView("manager_profile_update");
	 mv.addObject("Profile",ub);
return mv;
}


@RequestMapping("/managerprofileUpdate") 
public ModelAndView managerUpdateprofile(@ModelAttribute("UserBean") UserBean ub,HttpSession ss)

{	
	
	int manager_id=(int) ss.getAttribute("user_session");
	
	
	System.out.println("managerprofileUpdate");
	System.out.println(manager_id);
	System.out.println(ub.getFirstname());
	System.out.println(ub.getLastname());
	System.out.println(manager_id);
	
	
	ManagerModel am=new ManagerModel();
	int x=am.UpdateProfile_Manager(ub,manager_id); 
	 
	if(x!=0) {
		UserBean ub1=am.ViewProfile_Manager(manager_id); 
		mv=new ModelAndView("Manager_profile");
			 mv.addObject("Profile",ub1);
	}
	
	return mv;
		}

//-------------------------Submit Manager Request -------------------------------------
	
	@RequestMapping("/submitManagerRequest") 
	public ModelAndView submitmanagerrequest(@ModelAttribute ("RequestBean")RequestBean rb)
	{
		
	
	int day, month, year;
	GregorianCalendar date = new GregorianCalendar();
	day = date.get(Calendar.DAY_OF_MONTH);
	month = date.get(Calendar.MONTH);
	year = date.get(Calendar.YEAR);
	String requestdate= (year+"-"+(month+1)+"-"+day);
	
	rb.setRequestdate(requestdate);
	
	System.out.println(rb.getManagerid());
	System.out.println(rb.getAssetname());
	System.out.println(rb.getRequestdate());
	
	System.out.println(rb.getSupportid());
	System.out.println(rb.getEmailid());

	ModelAndView mv=null;
	ManagerModel d=new ManagerModel();
	Object o=d.submitRequest(rb);
	
		if(o!=null)
		{
		mv=new ModelAndView("manager_create_request_page");
		mv.addObject("msg","request Created");

	}
		return mv;

	}


//----------------Create Request By Manager--------------------

	@RequestMapping("/managercreaterequestpage") 
	public String createUser()
	{
		
		return "manager_create_request_page";
		
	}
	
	
	
	
	
	
	//----------------manager change pwd--------------------

	@RequestMapping("/managerchangepwd") 
	public String changepwd()
	{
		return "manager_change_password";
		
	}
	
	@RequestMapping("/managerchangepwdsubmit")
	public ModelAndView manager_password_changed(HttpSession ss,@RequestParam String password)
	{
		int manager_id=(int) ss.getAttribute("user_session");

		
		System.out.println("Inside managerchangepwdsubmit");
		
		System.out.println("Inside managerchangepwdsubmit"+ manager_id);
		System.out.println("Inside managerchangepwdsubmit" +password);

		
		int y=new ManagerModel().changepwd(manager_id,password);
		if(y!=0)
		{
			mv=new ModelAndView("manager_change_password");
			mv.addObject("passwordchanged","password has been changed");
		}
		
		return mv;
	}
	
	

//-------------------------Manager Home btn-------------------------------------
	@RequestMapping("/BackbtnMangerhome") 
	public String back_to_Managerhome()
	{
		return "manager_home";	
	}

	//-------------------------View Asset Request By employee-------------------------------------

	@RequestMapping("/ViewassetRequestByEmp") 
	public ModelAndView view_assetRequestByEmp(HttpSession ss)
	{
		int manager_id=(int)ss.getAttribute("user_session");
		
		
			System.out.println("Managerid in ViewassetRequestByEmp"+manager_id);
		
			ManagerModel um=new ManagerModel();

			ArrayList<RequestBean> list=um.view_assetRequestByEmp(manager_id);
			mv=new ModelAndView("MangerPending_assetRequestByEmp");
			mv.addObject("Employee_request",list);
		
		return mv;
		}
	
	//-------------------------View Manager Request -------------------------------------
	//
	
	@RequestMapping("/ManagerviewMyrequest") 
	public ModelAndView managerViewReq(HttpSession ss)
	{
			
		int manager_id=(int) ss.getAttribute("user_session");
		
				ManagerModel um=new ManagerModel();

				System.out.println(manager_id);

			//System.out.println(ub.getManager_id());
				
				ArrayList<RequestBean> rb=um.Manager_viewMyrequest(manager_id);
			 mv=new ModelAndView("manager_viewMyRequest");
			 mv.addObject("Manager_request",rb);
		
		return mv;
		}
	
	
	
	
	
	//-------------------------View Manager Request -------------------------------------
	//
	
	@RequestMapping("/ManagerMyAsset") 
	public ModelAndView managermyasset(HttpSession ss)
	{
			
		int manager_id=(int) ss.getAttribute("user_session");
		
				ManagerModel um=new ManagerModel();

				System.out.println(manager_id);

			//System.out.println(ub.getManager_id());
				
				ArrayList<RequestBean> rb=um.Manager_viewMyAsset(manager_id);
			 mv=new ModelAndView("manager_viewMy_asset");
			 mv.addObject("Manager_request",rb);
		
		return mv;
		}
	
	
	
	

@RequestMapping("/aprooveEmprequest")
public ModelAndView active_employee(@RequestParam int employeeid,@RequestParam int requestid,HttpSession ss)
{

	int day, month, year;
	GregorianCalendar date = new GregorianCalendar();
	day = date.get(Calendar.DAY_OF_MONTH);
	month = date.get(Calendar.MONTH);
	year = date.get(Calendar.YEAR);
	String request_date= (year+"/"+(month+1)+"/"+day);
	
	int y=new ManagerModel().approve(employeeid,request_date,requestid);
	
	System.out.println("Into aprooveEmprequest");
	System.out.println("date"+request_date);
	System.out.println("Employeeid"+employeeid);
	
	
	int manager_id=(int) ss.getAttribute("user_session");

	if(y==1)
	{
		ArrayList<RequestBean> list=new ManagerModel().view_assetRequestByEmp(manager_id);
		 mv=new ModelAndView("MangerPending_assetRequestByEmp");
		 mv.addObject("Employee_request",list);
	}
	return mv;
}

@RequestMapping("/rejectEmprequest")
public ModelAndView deactive_employee(@RequestParam int employeeid,HttpSession ss,@RequestParam int requestid)
{
	
	int day, month, year;
	GregorianCalendar date = new GregorianCalendar();
	day = date.get(Calendar.DAY_OF_MONTH);
	month = date.get(Calendar.MONTH);
	year = date.get(Calendar.YEAR);
	String request_date= (year+"/"+(month+1)+"/"+day);
	
	int manager_id=(int) ss.getAttribute("user_session");

	int y=new ManagerModel().reject(employeeid,request_date,requestid);
	if(y==1)
	{
		ArrayList<RequestBean> list=new ManagerModel().view_assetRequestByEmp(manager_id);
		 mv=new ModelAndView("MangerPending_assetRequestByEmp");
		 mv.addObject("Employee_request",list);
		
	}
	return mv;
}



//-------------------------------------//--------------
@RequestMapping("/CheckOldpwd") 
public void getoldpassword(HttpServletResponse response,@RequestParam String oldpassword,HttpSession ss)
{
		
	int manager_id=420;
	
	//int manager_id=(Integer)ss.getAttribute("user_session");

			ManagerModel um=new ManagerModel();

			System.out.println("oldpassword inside Getoldpassword"+oldpassword);
			System.out.println("managerid inside Getoldpassword"+manager_id);
			
			
			

			int x=um.getMyOldPassword(oldpassword,manager_id);
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



//-----------------------------checkemailifexist Manager profile update Ajax code--------//--------------
@RequestMapping("/checkemailifexist") 
public void checkemailifexist(HttpServletResponse response,@RequestParam String emailid,@RequestParam int managerid)
{
		
//	int manager_id=(int) ss.getAttribute("user_session");
	
			ManagerModel mm=new ManagerModel();
//			System.out.println("managerid inside Getoldpassword"+manager_id);

			
			int x=mm.checkemailifexist(emailid,managerid);
			
			System.out.println("profile update krne pr email hai kya "+x);

			
			//mv=new ModelAndView("manager_profile_update");
		
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





//-----------------------------checkemailifexist Manager profile update Ajax code--------//--------------
@RequestMapping("/checkemobileifexist") 
public void checkemobileifexist(HttpServletResponse response,@RequestParam String mobile,@RequestParam int managerid)
{
		
//	int manager_id=(int) ss.getAttribute("user_session");
	
			ManagerModel mm=new ManagerModel();
//			System.out.println("managerid inside Getoldpassword"+manager_id);

			
			int x=mm.checkmobileifexist(mobile,managerid);
			
			System.out.println("profile update krne pr email hai kya "+x);

			
			//mv=new ModelAndView("manager_profile_update");
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 	out.println(x);	

	}





@RequestMapping("/assettransferRequest") 
public ModelAndView assetTransferReq(HttpSession ss)
{
		
	int manager_id=(int) ss.getAttribute("user_session");
	
			ManagerModel um=new ManagerModel();

			System.out.println(manager_id);

		//System.out.println(ub.getManager_id());
			
			ArrayList<AssetTransferBean> rb=um.manager_viewAssetTransferReq(manager_id);
		 mv=new ModelAndView("manager_asset_transfer_RequestByEmp");
		 mv.addObject("Manager_request",rb);
	
	return mv;
	}


}