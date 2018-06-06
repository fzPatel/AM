package com.asset_management.controllers;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.asset_management.beans.AllocatedAssetsBean;
import com.asset_management.beans.AssetTransferBean;
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

		
	@RequestMapping("/Assettranfer")
	
public ModelAndView assettransfermethod(HttpSession session)
	{
		/*int userid=(int)ss.getAttribute("user_session");
		System.out.println("user id aaja re"+userid);
		
		
		EmployeeModel am = new EmployeeModel();
		List<AllocatedAssetsBean> list= (List<AllocatedAssetsBean>) am.Fetchassetdata(userid);
		
	     mv = new ModelAndView("assettransferfields");
	     mv.addObject("List",list);
	  
	     if(list.isEmpty())
	     {
	    	 System.out.println(list+"emptylist");
	     }
	     else
	    	 System.out.println(list);
	   System.out.println(list+"list me aa ja re");
	   
			return mv;*/
		
		
		System.out.println("Myasset");

		String emailid=(String)session.getAttribute("Emailid");

	
		int employeeid=(Integer)session.getAttribute("user_session");
       
		ModelAndView mv=null;
		EmployeeModel am=new EmployeeModel();
	
		List<AllocatedAssetsBean> list=am.myasset(employeeid,emailid);
		
		List<UserBean> list1=am.myassetofemp(); 
		
		
	 mv=new ModelAndView("assettransferfields");
		 mv.addObject("LIST",list);
		 mv.addObject("emplist",list1);
	return mv;
			
		
		
		
}


	
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
    	   
    	   
    	  mv.addObject("msg", "Request created successfully");
    	  
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

		String emailid=(String)session.getAttribute("Emailid");

	
		int employeeid=(Integer)session.getAttribute("user_session");
       
		ModelAndView mv=null;
		EmployeeModel am=new EmployeeModel();
	
		List<AllocatedAssetsBean> list=am.myasset(employeeid,emailid);
		
		List<UserBean> list1=am.myassetofemp(); 
		
		
		
		
	 mv=new ModelAndView("EmpMyasset");
		 mv.addObject("LIST",list);
		 mv.addObject("emplist",list1);
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
			mv.addObject("updated", "Updated Successfully");
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
		else if(y==0){
			mv=new ModelAndView("Employee_change_password");
		mv.addObject("passwordchanged", "password doesn't match");
		}
		
		return mv;
	}
	@RequestMapping("/Getoldpasswordemp") 
	public void getoldpassword(HttpSession ss,HttpServletResponse response)
	{
			PrintWriter out;
			try {
				 out = response.getWriter();
			
		int employee_id=(int) ss.getAttribute("user_session");
		
		EmployeeModel um=new EmployeeModel();

				System.out.println(employee_id);


				String oldpassword=um.EmpgetMyOldPassword(employee_id);
				System.out.println("Old Pass==>Controller Mai="+oldpassword);

				
			 mv=new ModelAndView("Employee_change_password");
		      mv.addObject("oldpassword",oldpassword);
		      out.println(oldpassword);
		
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		      
		}
	@RequestMapping("/Employeechangepwdsubmit")
	public ModelAndView manager_password_changed(HttpSession ss,@RequestParam String password)
	{
		int employee_id=(int) ss.getAttribute("user_session");

		
		System.out.println("Inside managerchangepwdsubmit");
		System.out.println("Inside managerchangepwdsubmit"+ employee_id);
		System.out.println("Inside managerchangepwdsubmit" +password);

		
		int y=new EmployeeModel().empchangepwd(employee_id,password);
		if(y!=0)
		{
			mv=new ModelAndView("Employee_change_password");
			mv.addObject("passwordchanged","password has been changed");
		}
		
		return mv;
	}
	
	@RequestMapping("/MobileCheckControllerAjax")
	public void mobilecheckajax(HttpSession ss, HttpServletResponse response ,@RequestParam String mobile)
	{
	
		int x=0;
		int employee_id=(int) ss.getAttribute("user_session");
		EmployeeModel um= new EmployeeModel();
		PrintWriter out;
		try {
			out = response.getWriter();
		
	 x=um.mobilecheckajax(employee_id, mobile);
		System.out.println  ("old mobile==>Controller Mai="+x);

			 out.println(x);
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
		@RequestMapping("/EmailCheckControllerAjax")
		public void emailcheckajax(HttpSession ss, HttpServletResponse response ,@RequestParam String email)
		{
		
			
			System.out.println("inside");
			
			
			int x=0;
			int employee_id=(int) ss.getAttribute("user_session");
			EmployeeModel um= new EmployeeModel();
			PrintWriter out;
			try {
				out = response.getWriter();
			
		 x=um.emailcheckajax(employee_id, email);
			System.out.println  ("old Email aaaa jjaaa re==>Controller Mai email="+email);

				 out.println(x);
				
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}

	
	}


@RequestMapping ("/Askforasset")
public ModelAndView trasferassetrequest(@ModelAttribute ("AssetTransferBean")AssetTransferBean ab,HttpSession session)
	
{
			
	 ModelAndView mv = null;
	 
	 
		int managerid=(int)session.getAttribute("My_Request_To_Id");    //request to my manager
		
		int user=(int)session.getAttribute("user_session");

		System.out.println("Data inside askforasset");
	
		
		System.out.println(ab.getAssetid());
		System.out.println(ab.getAssetname());
		System.out.println(ab.getTransferid());
		System.out.println(ab.getTransferstatus());
		System.out.println(ab.getToempid());
		System.out.println(ab.getManagerid());

 
	       EmployeeModel um = new EmployeeModel ();
	       
	   	int day, month, year;
	   	GregorianCalendar date = new GregorianCalendar();
	   	day = date.get(Calendar.DAY_OF_MONTH);
	   	month = date.get(Calendar.MONTH);
	   	year = date.get(Calendar.YEAR);
	   	String transferRequestdate=(year+"/"+(month+1)+"/"+day);
	   	
	   	ab.setTransferrequestdate(transferRequestdate);
	   	ab.setManagerid(managerid);
	   	ab.setFromempid(user);
	   	int status=-1;
	   	ab.setTransferstatus(status);
	   	
	   	
	   	System.out.println(ab.getManagerid());
	   	System.out.println(ab.getAssetname());
	   	System.out.println(transferRequestdate);
	       
	       
	       int y=um.trasferassetrequest(ab);
	       
	       
	       
		EmployeeModel am=new EmployeeModel();
	
		List<AllocatedAssetsBean> list=am.viewallEmpmyasset();


		mv=new ModelAndView("empViewAllAssets");
		 mv.addObject("LIST",list);
		 
		return mv;



		
		
		}






@RequestMapping ("/empViewAllAssets")
public ModelAndView viewallassets(HttpSession session)
{
	
ModelAndView mv = null;

   
EmployeeModel am=new EmployeeModel();

List<AllocatedAssetsBean> list=am.viewallEmpmyasset();


mv=new ModelAndView("empViewAllAssets");
 mv.addObject("LIST",list);
 
return mv;

}




@RequestMapping("/EmpviewAseetrequestByOtherEmp")
public ModelAndView EmpviewAseetrequestByOtherEmp(HttpSession ss)
{


	int employee_id=(int) ss.getAttribute("user_session");

	
	EmployeeModel um=new EmployeeModel();

	ArrayList<AssetTransferBean> rb=um.empviewAseetrequestByOtherEmp(employee_id);
		 mv=new ModelAndView("EmpviewAseetrequestByOtherEmp");
		 
		 mv.addObject("Employee_request",rb);
	
	return mv;
}



@RequestMapping("/EmpviewAseetrequestByMe")
public ModelAndView EmpviewAseetrequestByMe(HttpSession ss)
{
int employee_id=(int) ss.getAttribute("user_session");
int managerid=(int)ss.getAttribute("My_Request_To_Id");
EmployeeModel um=new EmployeeModel();
ArrayList<AssetTransferBean> rb=um.empviewAseetrequestByMe(employee_id,managerid);
		 mv=new ModelAndView("emp_Viewasset_transfer_RequestByMe");
		 mv.addObject("Employee_request",rb);
	return mv;
}






@RequestMapping("/RequesttoManagerForAppoveRequestedAsset")
public ModelAndView requesttomanager(HttpSession ss,@RequestParam int assetid,@RequestParam int transferid)
{
	
	
	System.out.println("inside RequesttoManagerForAppoveRequestedAsset "+assetid+transferid);
	
	
	
	
	int employee_id=(int) ss.getAttribute("user_session");

	int managerid=(int)ss.getAttribute("My_Request_To_Id");

	EmployeeModel um=new EmployeeModel();

	um.requesttomanagerforapprove(employee_id,managerid,assetid,transferid);
	
	
	

	List<AssetTransferBean> rb=um.viewOtherEmpassetRequest(employee_id);
		 mv=new ModelAndView("EmpviewAseetrequestByOtherEmp");
		 
		 mv.addObject("Employee_request",rb);
	
	return mv;
	
	
}



@RequestMapping("/RequestbyManager")
public ModelAndView Managerrequesttoemp(HttpSession ss)
{

	int employee_id=(int) ss.getAttribute("user_session");

	
	int managerid=(int)ss.getAttribute("My_Request_To_Id");

	EmployeeModel um=new EmployeeModel();

	ArrayList<AssetTransferBean> rb=um.empviewAseetrequestByMe(employee_id,managerid);
		 mv=new ModelAndView("RequestbyManagerToEmp");
		 
		 mv.addObject("Employee_request",rb);
	
	return mv;
}
// request approve of manager

@RequestMapping("/aprooveTransferrequestManagerrequest")
public ModelAndView aprooveAssetEmprequest(@RequestParam int fromempid,@RequestParam int assetid,@RequestParam int transferid,@RequestParam int transferstatus,HttpSession ss)
{
	
	int employee_id=(int) ss.getAttribute("user_session");
	int manager_id=(int) ss.getAttribute("My_Request_To_Id");

	int day, month, year;
	GregorianCalendar date = new GregorianCalendar();
	day = date.get(Calendar.DAY_OF_MONTH);
	month = date.get(Calendar.MONTH);
	year = date.get(Calendar.YEAR);
	String approve_date= (year+"/"+(month+1)+"/"+day);
		
	System.out.println("Into aprooveEmprequest");
	
	System.out.println("managerid"+manager_id);
	System.out.println("emp frmid"+fromempid);
	System.out.println("approve datennnnnnnnnnnnnnnnnnnnn"+approve_date);
	
	EmployeeModel um= new EmployeeModel();
	int x=um.approveAssetTransferRequest(fromempid, approve_date, transferid, manager_id, transferstatus);


	if(x==1)
	{
	//update method	userid
	um.updateintoallocatedasset(employee_id , fromempid, assetid);
		//deleted when approved
		//um.deleteassetswhenapproved(transferid);
		ArrayList<AssetTransferBean> rb=um.empviewAseetrequestByMe(employee_id, manager_id);
		 mv=new ModelAndView("RequestbyManagerToEmp");
		 mv.addObject("approved","Your request for asset has been approved");
		 mv.addObject("Employee_request",rb);
	}
	
	return mv;
}

// reject transfer request by employee
@RequestMapping("/rejectrequestofManagerbyemp")
public ModelAndView rejectAssetEmprequest(@RequestParam int fromempid,HttpSession ss,@RequestParam int transferid)
{
	
	int day, month, year;
	GregorianCalendar date = new GregorianCalendar();
	day = date.get(Calendar.DAY_OF_MONTH);
	month = date.get(Calendar.MONTH);
	year = date.get(Calendar.YEAR);
	String reject_date= (year+"/"+(month+1)+"/"+day);

	int employee_id=(int) ss.getAttribute("user_session");
	int manager_id=(int) ss.getAttribute("My_Request_To_Id");

EmployeeModel um=new EmployeeModel();
	
	int y=new EmployeeModel().rejectAssetTransfer(fromempid,reject_date,transferid,manager_id);
	if(y==1)
	{
	
		ArrayList<AssetTransferBean> rb=um.empviewAseetrequestByMe(employee_id, manager_id);
		 mv=new ModelAndView("RequestbyManagerToEmp");
		 mv.addObject("approved","Your request for asset has been rejected");
		 mv.addObject("Employee_request",rb);
	}
	return mv;
}




}