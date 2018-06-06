package com.asset_management.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
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
import com.asset_management.beans.UserBean;
import com.asset_management.models.AdminModel;
import com.asset_management.models.ManagerModel;
import com.asset_management.models.SupportModel;

@Controller

public class SupportController {
ModelAndView mv=null;

	@ModelAttribute
	public void addCommonObject(Model m)
	{
		//-------------adding common object for each and every jsp---------------------
		m.addAttribute("oh","Asset Management");
	}
	
	@RequestMapping("/logout") 
	public ModelAndView Logout(HttpSession session)
	{	
		//------------------transferring control to the index page----------------------
		mv=new ModelAndView("index");	
		//------------------destroying every session-----------------------
		session.invalidate();
		return mv;
	}
	
	@RequestMapping("/supporthome") 
	public ModelAndView supporthome()
	{	
		//------------------transferring control to the support home page----------------------
		mv=new ModelAndView("support_home");		
		return mv;
	}
	
	@RequestMapping("/viewassetrequest")
	public ModelAndView viewassetrequest(HttpSession session)
	{
		//------------------fetching the support session ----------------------
		String usersession =(String)session.getAttribute("user_session");
		
		//------------------retriving the asset requests to the logged in support----------------------
		ArrayList<RequestBean> al=new SupportModel().retriveRequests(usersession);
		if(al.isEmpty())
		{		
			mv=new ModelAndView("show_requests");
			mv.addObject("requests_arraylist_empty", "No Data To Show!!!!");
		}
		else
		{
			/*transferring the control back to the show_requests.jsp*/
			mv=new ModelAndView("show_requests");
			/*fetching the request data because, show_request accepting the array list to view_reports.jsp*/
			mv.addObject("requests_arraylist", al);
			
		}
		return mv;
	}
	
	
	@RequestMapping("/viewreports")
	public ModelAndView viewreports()
	{
//		int usersession1=Integer.parseInt(usersession);
		/*retriving all the reports from AllocatedAssets*/
		ArrayList<AllocatedAssetsBean> al=new SupportModel().retriveReports();
		if(al!=null)
		{
			/*transferring the control back to the view_reports.jsp*/
			mv=new ModelAndView("view_reports");
			
			/*fetching the request data because, show_request accepting the array list to view_reports.jsp*/
			mv.addObject("reports_arraylist", al);
			
		}
		return mv;
	}
	
	@RequestMapping("/approveandinsert")
	/*fetching the values of hidden fields from show_requests*/
	public ModelAndView approveandinsert(@RequestParam String assetname,@RequestParam String dateofallocation,@RequestParam int supportid,@RequestParam String emailid,@RequestParam int employeeid,@RequestParam int requestid)
	{	
		System.out.println("inside supportcontroller---->approveandinsert()");
		
		/*approving the request in RequentBean POJO*/
		int y=new SupportModel().approve(employeeid,requestid);
		/*inserting into table of AllocatedAssetsBean POJO*/
		int w=new SupportModel().insert(employeeid,assetname,dateofallocation,supportid,emailid);
		if(w==1 && y==1)
		{
			/*transferring the control back to the show_requests*/
			mv=new ModelAndView("show_requests");
			String support_session1=supportid+"";
			/*fetching the request data because, show_request accepting the array list to show data*/
			ArrayList<RequestBean> al=new SupportModel().retriveRequests(support_session1);
			/*adding object*/
			mv.addObject("requests_arraylist", al);
			
		}
		return mv;
	}
	
	
	
	
	@RequestMapping("/cancelrequest")
	/*fetching the values of hidden fields from show_requests*/
	public ModelAndView cancelrequest(@RequestParam int supportid,@RequestParam int employeeid,@RequestParam int requestid,HttpSession ss)
	{		
		/*fetching the user id of support from the session*/
		int support_session=(Integer)ss.getAttribute("support_session");
		
		/*cancelling the request*/
		int y=new SupportModel().cancelRequest(supportid,employeeid,requestid);
		if(y==1)
		{
			/*transferring the control back to the show_requests*/
			mv=new ModelAndView("show_requests");
			String support_session1=supportid+"";
			/*fetching the request data because, show_request.jsp accepting the array list to show data*/
			ArrayList<RequestBean> al=new SupportModel().retriveRequests(support_session1);				
			
			mv.addObject("requests_arraylist", al);
			
		}
		return mv;
	}
	
	
	
	
	@RequestMapping("/changesupportpassword")
	public ModelAndView supportchangepassword()
	{
		/*forwarding the control to support_change_password*/
		mv=new ModelAndView("support_change_password");
		return mv;
	}
	
	@RequestMapping("/supportpasswordchanged")
	/*fetching the values of fields from support_change_password*/
	public ModelAndView supportpasswordchanged(HttpSession ss,@RequestParam String password,@RequestParam String user_designation)
	{
		/*retriving the user id of support from session_*/
		int support_session=(Integer)ss.getAttribute("support_session");
		
		/*method to update the password of support*/
		int y=new SupportModel().updateNewPassword(support_session,password,user_designation);
		if(y!=0)
		{
			/*forwarding the control to support_home*/
			mv=new ModelAndView("support_home");
			/*forwarding the message*/
			mv.addObject("passwordchanged","password has been changed");
		}
		
		return mv;
	}
	
	
	
	
	
	@RequestMapping("/SupportPasswordExistsOrNot")
	public ModelAndView SupportPasswordExistsOrNot(HttpSession ss)
	{
		
		
		int supportid=(Integer)ss.getAttribute("support_session");

		System.out.println("Controller mai Password checking chala.......");
		 
		 String password=new SupportModel().checkExistanceOfSupportPassword(supportid);
		 mv=new ModelAndView("support_change_password");
		 mv.addObject("see",password);
		return mv;
	}
	
	
	
	
	@RequestMapping("/retrivesupportdetails")
	/*getting the user id of support with session*/
	public ModelAndView supportProfileUpdate(HttpSession ss)
	{
		/*getting the user id of support with session*/
		int supportid=(Integer)ss.getAttribute("support_session");

		 /*retriving all the details of support corresponding to the user id of support*/
		 ArrayList<UserBean> al=new SupportModel().retriveSupportDetails(supportid);
		 
		 /*transferring the control to support_profile_update*/
		 mv=new ModelAndView("support_profile_update");
		 
		 /*setting the array list and sending to support_profile_update*/
		 mv.addObject("supportdetails",al);
		return mv;
	}
	

	
	
	//-----------------------------checkemailifexist Manager profile update Ajax code--------//--------------
	@RequestMapping("/checkemailifexistsupport") 
	public void checkemailifexist(HttpServletResponse response,@RequestParam String emailid,@RequestParam int supportid)
	{
			
//		int manager_id=(int) ss.getAttribute("user_session");
		
				SupportModel mm=new SupportModel();
//				System.out.println("managerid inside Getoldpassword"+manager_id);

				
				int x=mm.checkemailifexist(emailid,supportid);
				
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
	@RequestMapping("/checkemobileifexistsupport") 
	public void checkemobileifexist(HttpServletResponse response,@RequestParam String mobile,@RequestParam int supportid)
	{
			
//		int manager_id=(int) ss.getAttribute("user_session");
		
				SupportModel mm=new SupportModel();
//				System.out.println("managerid inside Getoldpassword"+manager_id);

				
				int x=mm.checkmobileifexist(mobile,supportid);
				
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


	
	
	@RequestMapping("/updatesupportprofile") 
	/*fetching the value of fields from support_profile_update.jsp*/
	public ModelAndView updateSupportProfile(HttpSession ss,@RequestParam String firstname,@RequestParam String lastname,@RequestParam String emailid,@RequestParam String mobile,@RequestParam String password)
	{	
		/*getting the user id of support from session*/
		int supportid=(Integer)ss.getAttribute("support_session");

		
		/*update the profile of support with*/
		int x=new SupportModel().updateSupportProfile(supportid,firstname,lastname,emailid,mobile,password); 
		 System.out.println("Support id="+supportid);
		if(x!=0)
		{
			
			/*retriving the details of support*/
			ArrayList<UserBean> al=new SupportModel().retriveSupportDetails(supportid);
			
			/*forwarding the control to support_profile_update.jsp*/
			 mv=new ModelAndView("support_profile_update");
			 /*forwarding the array list*/
			 mv.addObject("supportdetails",al);
			 /*forwarding the message*/
			 mv.addObject("supportdetailsupdated","Support profile Updated");
		}
		else
		{
			/*retriving the details of particular support corresponding to support id*/
			ArrayList<UserBean> al=new SupportModel().retriveSupportDetails(supportid);
			
			/*forwarding control to support_profile_update*/
			 mv=new ModelAndView("support_profile_update");
			 /*forwarding the array list*/
			 mv.addObject("supportdetails",al);
			 /*forwarding the message*/
			 mv.addObject("supportdetailsnotupdated","Failed to update support profile ");
		}
		
		return mv;
			}

	
}
