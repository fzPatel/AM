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
import com.asset_management.models.SupportModel;
@SessionAttributes({"user_session","My_Request_To_Id&MyEmail"})
@Controller
public class ManagerController {//create ManagerController class
	
	//Initialise the ModelAndView
	ModelAndView mv=null;			
	
	//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
	@RequestMapping("/")				
	
	//Create a method  welcome and return ModelAndView object	
	public ModelAndView welcome()
{
	ModelAndView mv=new ModelAndView("index");
			return mv;			//Return Object of Model and view
}
	

	//---------------- Manager Profile By Firoz-------------------

	
	//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
	@RequestMapping("/managerprofile") 

	//Create a method  view and return ModelAndView object	
public ModelAndView view(HttpSession ss)

	{	
		//getting manager session//getting menager session
				int managerid=(int)ss.getAttribute("user_session");
				
				//Creating ManagerModel object
				ManagerModel am=new ManagerModel();
		
		UserBean ub=am.ViewProfile_Manager(managerid); 
		 mv=new ModelAndView("Manager_profile");
			 mv.addObject("Profile",ub);

			return mv;			//Return Object of Model and view
		}


@RequestMapping("/managerprofileUpdateGet") 

//Create a method  managerUpdateprofileGet and return ModelAndView object	
public ModelAndView managerUpdateprofileGet(HttpSession ss)

{	
	
	//getting manager session//getting menager session
			int managerid=(int)ss.getAttribute("user_session");
	
	
			//Creating ManagerModel object
		       ManagerModel am=new ManagerModel();
	

	UserBean ub=am.ViewProfile_Manager(managerid); 
 mv=new ModelAndView("manager_profile_update");
	 mv.addObject("Profile",ub);
	return mv;			//Return Object of Model and view
}


//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping("/managerprofileUpdate") 

//Create a method  managerUpdateprofileGet and return ModelAndView object	
public ModelAndView managerUpdateprofile(@ModelAttribute("UserBean") UserBean ub,HttpSession ss)

{	
	
	int managerid =(int) ss.getAttribute("user_session");//get usersession and assign into manager 
	
	
	//Creating ManagerModel object
	ManagerModel am=new ManagerModel();
	
	int x=am.UpdateProfile_Manager(ub,managerid); 
	 
	if(x!=0) {
		UserBean ub1=am.ViewProfile_Manager(managerid); 
		mv=new ModelAndView("Manager_profile");
		 mv.addObject("profileupdatemsg","Profile Updated");

			 mv.addObject("Profile",ub1);
	}
	
		return mv;			//Return Object of Model and view
		}

//-------------------------Submit Manager Request By Firoz -------------------------------------
	
//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
	@RequestMapping("/submitManagerRequest") 
	
	
	//Create a method  submitmanagerrequest and return ModelAndView object	
public ModelAndView submitmanagerrequest(@ModelAttribute ("RequestBean")RequestBean rb)
	{
		
	
		//variable declaring of day month year
				int day, month, year;
				
				//create object of  GregorianCalendar class
				GregorianCalendar date = new GregorianCalendar();
				
				//get day form GregorianCalendar class 
				day = date.get(Calendar.DAY_OF_MONTH);
				
				//get month form GregorianCalendar class
				month = date.get(Calendar.MONTH);
				
				//get year form GregorianCalendar class 
				year = date.get(Calendar.YEAR);
				
	String requestdate= (year+"-"+(month+1)+"-"+day);
	
	rb.setRequestdate(requestdate);
	

	ModelAndView mv=null;
	ManagerModel d=new ManagerModel();
	Object o=d.submitRequest(rb);
	
		if(o!=null)
		{
		mv=new ModelAndView("manager_create_request_page");
		mv.addObject("msg","Asset Request Created");

	}
			return mv;			//Return Object of Model and view

	}


//----------------Create Request By Manager--------------------

	//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
	@RequestMapping("/managercreaterequestpage") 
	public String createUser()
	{
		
		return "manager_create_request_page";//return page to manager_create_request_page
		
	}
	
	
	
	
	//----------------manager change pwd By Firoz--------------------

	//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
	@RequestMapping("/managerchangepwd") 

	//Create a method  changepwd and return String	
public String changepwd()
	{
		return "manager_change_password";//return page to manager_change_password
		
	}
	
	//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
	@RequestMapping("/managerchangepwdsubmit")
	
	
//Create a method  manager_password_changed and return ModelAndView object	
public ModelAndView manager_password_changed(HttpSession ss,@RequestParam String password)
	{
		//getting manager session//getting menager session
		int managerid=(int)ss.getAttribute("user_session");
		
		
		int y=new ManagerModel().changepwd(managerid,password);
		if(y!=0)
		{
			mv=new ModelAndView("manager_change_password");
			mv.addObject("passwordchanged","password has been changed");
		}
		
			return mv;			//Return Object of Model and view
	}
	
	

//-------------------------Manager Home btn-------------------------------------

	//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
	@RequestMapping("/BackbtnMangerhome") 
	public String back_to_Managerhome()
	{
		return "manager_home";	
	}

	//-------------------------View Asset Request By employee By Firoz-------------------------------------

//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping("/ViewassetRequestByEmp") 

//Create a method  view_assetRequestByEmp and return ModelAndView object	
public ModelAndView view_assetRequestByEmp(HttpSession ss)
	{
		int managerid=(int)ss.getAttribute("user_session");//getting manager session
		
				
				ManagerModel um=new ManagerModel();//creating managermodel object//Creating ManagerModel object

			ArrayList<RequestBean> list=um.view_assetRequestByEmp(managerid);
			mv=new ModelAndView("MangerPending_assetRequestByEmp");
			mv.addObject("Employee_request",list);
		
			return mv;			//Return Object of Model and view
		}
	
	//-------------------------View Manager Request By Firoz-------------------------------------
	
	
//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping("/ManagerviewMyrequest") 
	
	
	//Create a method  managerViewReq and return ModelAndView object	
public ModelAndView managerViewReq(HttpSession ss)
	{
			
		//getting manager session//getting menager session
				int managerid=(int)ss.getAttribute("user_session");
				
			ManagerModel um=new ManagerModel();//creating managermodel object//Creating ManagerModel object

				
				ArrayList<RequestBean> rb=um.Manager_viewMyrequest(managerid);
			 mv=new ModelAndView("manager_viewMyRequest");
			 mv.addObject("Manager_request",rb);
		
			return mv;			//Return Object of Model and view
		}
	
	
	//-------------------------View Manager Request By Firoz-------------------------------------
	
	//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
	@RequestMapping("/ManagerMyAsset") 
	public ModelAndView managermyasset(HttpSession ss)
	{
			
			//getting manager session//getting menager session
			int managerid=(int)ss.getAttribute("user_session");
				
			ManagerModel um=new ManagerModel();//creating managermodel object//Creating ManagerModel object


				
				ArrayList<RequestBean> rb=um.Manager_viewMyAsset(managerid);
			 mv=new ModelAndView("manager_viewMy_asset");
			 mv.addObject("Manager_request",rb);
		
			return mv;			//Return Object of Model and view
		}
	
	
	
	

	//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping("/aprooveEmprequest")
public ModelAndView active_employee(@RequestParam int employeeid,@RequestParam int requestid,HttpSession ss)
{

	
	//variable declaring of day month year
	int day, month, year;
	
	//create object of  GregorianCalendar class
	GregorianCalendar date = new GregorianCalendar();
	
	//get day form GregorianCalendar class 
	day = date.get(Calendar.DAY_OF_MONTH);
	
	//get month form GregorianCalendar class
	month = date.get(Calendar.MONTH);
	
	//get year form GregorianCalendar class 
	year = date.get(Calendar.YEAR);
	
	//concat year month day in a string
	String request_date= (year+"/"+(month+1)+"/"+day);
	
	//calling approve method
	int y=new ManagerModel().approve(employeeid,request_date,requestid);
	
	
	
	int managerid=(int)ss.getAttribute("user_session");//getting manager session

	if(y==1)
	{
		ArrayList<RequestBean> list=new ManagerModel().view_assetRequestByEmp(managerid);
		 mv=new ModelAndView("MangerPending_assetRequestByEmp");
		 mv.addObject("Employee_request",list);
	}
		return mv;			//Return Object of Model and view
}

//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping("/rejectEmprequest")
public ModelAndView deactive_employee(@RequestParam int employeeid,HttpSession ss,@RequestParam int requestid)
{
	
	//variable declaring of day month year
		int day, month, year;
		
		//create object of  GregorianCalendar class
		GregorianCalendar date = new GregorianCalendar();
		
		//get day form GregorianCalendar class 
		day = date.get(Calendar.DAY_OF_MONTH);
		
		//get month form GregorianCalendar class
		month = date.get(Calendar.MONTH);
		
		//get year form GregorianCalendar class 
		year = date.get(Calendar.YEAR);
		
	String request_date= (year+"/"+(month+1)+"/"+day);
	
	int managerid=(int)ss.getAttribute("user_session");//getting manager session

	int y=new ManagerModel().reject(employeeid,request_date,requestid);
	if(y==1)
	{
		ArrayList<RequestBean> list=new ManagerModel().view_assetRequestByEmp(managerid);
		 mv=new ModelAndView("MangerPending_assetRequestByEmp");
		 mv.addObject("Employee_request",list);
		
	}
		return mv;			//Return Object of Model and view
}


//-------------------------------------//--------------
//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping("/Getoldpassword") 
public void getoldpassword(HttpServletResponse response,@RequestParam String oldpassword,HttpSession ss)
{
	
	//getting manager session//getting menager session
			int managerid=(int)ss.getAttribute("user_session");
			
				ManagerModel um=new ManagerModel();//creating managermodel object//Creating ManagerModel object


			int x=um.getMyOldPassword(oldpassword,managerid);//calling getMyOldPassword method

			
		
		PrintWriter out = null;//null pass in the object
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//printStackTrace will give line of error
		}
		 	out.println(x);	//msg is sending with PrintWriter objet to jsp	

	}

//-----------------------------checkemailifexist Manager profile update Ajax code By Firoz--------//--------------

//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping("/checkemailifexist") 
public void checkemailifexist(HttpServletResponse response,@RequestParam String emailid,@RequestParam int managerid)
{
		
//	int managerid=(int) ss.getAttribute("user_session");
	
			ManagerModel mm=new ManagerModel();//Creating ManagerModel object

			
			int x=mm.checkemailifexist(emailid,managerid);//method calling
			

			
			//mv=new ModelAndView("manager_profile_update");
		
		PrintWriter out = null;//null pass in the object
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println(e);	
e.printStackTrace();//printStackTrace will give line of error//printStackTrace will give line of error
		}
		 	out.println(x);	//msg is sending with PrintWriter objet to jsp	
		 	System.out.println(x);	//msg is sending with PrintWriter objet to jsp

	}


//-----------------------------checkemailifexist Manager profile update Ajax code  By Firoz--------//--------------

//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping("/checkemobileifexist") 
public void checkemobileifexist(HttpServletResponse response,@RequestParam String mobile,@RequestParam int managerid)
{
			
			ManagerModel mm=new ManagerModel();//Creating ManagerModel object

			
			int x=mm.checkmobileifexist(mobile,managerid);
			
			System.out.println("profile update krne pr email hai kya "+x);

					
		PrintWriter out = null;//null pass in the object//null pass in the object
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//printStackTrace will give line of error
		}
		 	out.println(x);	//msg is sending with PrintWriter objet to jsp	//msg is sending with PrintWriter objet to jsp

	}



//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping("/assettransferRequest") 
public ModelAndView assetTransferReq(HttpSession ss)
{
		
	//getting manager session//getting menager session
		int managerid=(int)ss.getAttribute("user_session");
		
	ManagerModel um=new ManagerModel();//creating managermodel object//Creating ManagerModel object


			
		ArrayList<AssetTransferBean> rb=um.manager_viewAssetTransferReq(managerid);
		mv=new ModelAndView("manager_asset_transfer_RequestByEmp");
		 
		mv.addObject("Employee_request",rb);
	
		return mv;			//Return Object of Model and view			//Return Object of Model and view
	}



//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping("/aprooveAssetTransferEmprequest")
public ModelAndView aprooveAssetEmprequest(@RequestParam int fromempid,@RequestParam int transferid,HttpSession ss,@RequestParam int toempid,@RequestParam int assetid)
{

	//getting manager session//getting menager session
		int managerid=(int)ss.getAttribute("user_session");
		
	//variable declaring of day month year
		int day, month, year;
		
		//create object of  GregorianCalendar class
		GregorianCalendar date = new GregorianCalendar();
		
		//get day form GregorianCalendar class 
		day = date.get(Calendar.DAY_OF_MONTH);
		
		//get month form GregorianCalendar class
		month = date.get(Calendar.MONTH);
		
		//get year form GregorianCalendar class 
		year = date.get(Calendar.YEAR);
		
		String approve_date= (year+"/"+(month+1)+"/"+day);
	

	
	int status=new ManagerModel().getAssettransferRequest();
	
		ManagerModel um=new ManagerModel();//creating managermodel object

	

int y=0;
	
	
if(status==-1) {
		
	int statusinstert=0;

	
 y=new ManagerModel().approveAssetTransfer(fromempid,approve_date,transferid,managerid,statusinstert);
	
}

else if(status==2)
	{
		
		int statusinstert=3;

		
	 y=new ManagerModel().approveAssetTransfer(fromempid,approve_date,transferid,managerid,statusinstert);
		 
	um.updateIdafterTransfer(fromempid, toempid, transferid, managerid,assetid);
	
	um.deletetransferrequests(transferid);

}
else if(status==3)
{
	

	
ArrayList<AssetTransferBean> rb=um.manager_viewAssetTransferReq(managerid);
	
	
	
	 mv=new ModelAndView("manager_asset_transfer_RequestByEmp");
	 
	 mv.addObject("Employee_request",rb);
	 
	 
	 
	 
	 
}
	
	


	if(y==1)
	{
		ArrayList<AssetTransferBean> rb=um.manager_viewAssetTransferReq(managerid);
		 mv=new ModelAndView("manager_asset_transfer_RequestByEmp");
		 
		 mv.addObject("Employee_request",rb);
	}
	
		return mv;			//Return Object of Model and view
}






//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping("/rejectAssetTransferEmprequest")

//Create a method  rejectAssetEmprequest and return ModelAndView object
public ModelAndView rejectAssetEmprequest(@RequestParam int fromempid,HttpSession ss,@RequestParam int transferid)
{
	
	//variable declaring of day month year
		int day, month, year;
		
		//create object of  GregorianCalendar class
		GregorianCalendar date = new GregorianCalendar();
		
		//get day form GregorianCalendar class 
		day = date.get(Calendar.DAY_OF_MONTH);
		
		//get month form GregorianCalendar class
		month = date.get(Calendar.MONTH);
		
		//get year form GregorianCalendar class 
		year = date.get(Calendar.YEAR);
		
	String reject_date= (year+"/"+(month+1)+"/"+day);
	
	int managerid=(int)ss.getAttribute("user_session");//getting manager session

	
			ManagerModel um=new ManagerModel();//creating managermodel object//creating managermodel object//creating managermodel object
	
	int y=new ManagerModel().rejectAssetTransfer(fromempid,reject_date,transferid,managerid);
	if(y==1)
	{
	
		
		ArrayList<AssetTransferBean> rb=um.manager_viewAssetTransferReq(managerid);
		 mv=new ModelAndView("manager_asset_transfer_RequestByEmp");
		 
		 mv.addObject("Employee_request",rb);
		
	}
		return mv;			//Return Object of Model and view
}

//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping ("/viewallallocatedassets")

//Create a method  viewallassets and return ModelAndView object
public ModelAndView viewallassets(HttpSession session)
{
	
ModelAndView mv = null;

   
	       ManagerModel am=new ManagerModel();//creating managermodel object

List<AllocatedAssetsBean> list=am.viewallcatedasset();


mv=new ModelAndView("managerviewallallocated_assets");
 	        mv.addObject("LIST",list);//Addling data in the list with model 
 
	return mv;			//Return Object of Model and view

}



//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping ("/ManagerAskforasset")

//Create a method  trasferassetrequest and return ModelAndView object
public ModelAndView trasferassetrequest(@ModelAttribute ("AssetTransferBean")AssetTransferBean ab,HttpSession session)
	
{
			
	ModelAndView mv = null;
	 
	 
	//getting menager session//getting menager session
	int managerid=(int)session.getAttribute("user_session");
		
		//create managermodel object
		ManagerModel um = new ManagerModel ();
	       
		//variable declaring of day month year
		int day, month, year;
		
		//create object of  GregorianCalendar class
		GregorianCalendar date = new GregorianCalendar();
		
		//get day form GregorianCalendar class 
		day = date.get(Calendar.DAY_OF_MONTH);
		
		//get month form GregorianCalendar class
		month = date.get(Calendar.MONTH);
		
		//get year form GregorianCalendar class 
		year = date.get(Calendar.YEAR);
		
	   	String transferRequestdate=(year+"/"+(month+1)+"/"+day);
	   	
	   	ab.setTransferrequestdate(transferRequestdate);
	   	ab.setManagerid(managerid);
	  
	   	
	   	ab.setFromempid(managerid);//from empid by manager
	   	
	   	
	   	
	   	
	   	ab.setToempid(ab.getToempid());
	   	
	   	int status=-1;
	   	
	   	
	   	ab.setTransferstatus(status);
	   	
	   	
	   	
	       int y=um.managertrasferassetrequest(ab);
	       
	       
	       
	       
	       
	       	       ManagerModel am=new ManagerModel();//creating managermodel object

	       List<AllocatedAssetsBean> list=am.viewallcatedasset();


	       mv=new ModelAndView("managerviewallallocated_assets");
	        	        mv.addObject("LIST",list);//Addling data in the list with model //Addling data in the list with model 
	        
	       	return mv;			//Return Object of Model and view



		
		
		}


//@RequestMapping annotation maps HTTP requests to handler methods of MVC and REST controllers
@RequestMapping("/ManagerviewAseetrequestByMe")

//Create a method  EmpviewAseetrequestByMe and return ModelAndView object
public ModelAndView EmpviewAseetrequestByMe(HttpSession ss)
{

	//getting menager session//getting menager session
		int managerid=(int)ss.getAttribute("user_session");
		
			ManagerModel um=new ManagerModel();//creating managermodel object//creating managermodel object

	ArrayList<AssetTransferBean> rb=um.managerviewAseetrequestByMe(managerid);
		 mv=new ModelAndView("manager_Viewasset_transfer_RequestByMe");
		 
		 mv.addObject("Employee_request",rb);
	
		return mv;			//Return Object of Model and view
}


}