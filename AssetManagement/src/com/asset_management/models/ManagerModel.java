package com.asset_management.models;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import com.asset_management.beans.AllocatedAssetsBean;
import com.asset_management.beans.AssetTransferBean;
import com.asset_management.beans.RequestBean;
import com.asset_management.beans.UserBean;

public class ManagerModel {
	
///////////////View manager Profile/////////////////////////

	public UserBean ViewProfile_Manager(int manager_id)
	{
		
		//creating object of UserBean//creating object of UserBean
				UserBean ub=new UserBean();	
				
				try
		{	  
					//creating session factory object//creating session factory object
					SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
					
					//creating session object//creating session object
						Session ss=sf.openSession();
						
					  
		
						//Criteria API helps us build criteria query objects dynamically
						Criteria ct=ss.createCriteria(UserBean.class);		
			
			//set Criteria in ct reference
			ct.add(Restrictions.eq("managerid",manager_id));
			ct.add(Restrictions.eq("designation","manager"));
			

			//get the list with data//get the list with data
			List<UserBean> list=ct.list();
						
		if(list.isEmpty())//check if list is empty
			{
				
				System.out.println("No Data Found!!!!");
			}
			else
			{
				
				//foreach loop to get data as iterator//foreach loop to get data as itirator
				for(UserBean u:list)	
					{
						//set Firstname in bean
						ub.setFirstname(u.getFirstname());
						
						//SetLastname in bean
						ub.setLastname(u.getLastname());

						// setEmailid in bean
						ub.setEmailid(u.getEmailid());
						
						// setManagerid in bean
						ub.setManagerid(u.getManagerid());
						
						// setDesignation in bean
						ub.setDesignation(u.getDesignation());

						// setEmployeeid in bean
						ub.setEmployeeid(u.getEmployeeid());
						
						// setMobile in bean
						ub.setMobile(u.getMobile());
						
						// setDateofjoining in bean
						ub.setDateofjoining(u.getDateofjoining());
						
						// setStatus in bean
						ub.setStatus(u.getStatus());
						
						// setSupportid in bean
						ub.setSupportid(u.getSupportid());
						// setAuto in bean
						ub.setAuto(u.getAuto());
						
					}	
			}	
				}
				catch(Exception e)//Exception reference is created
				{
									e.printStackTrace();//printStackTrace print line of error
				}
				return ub;				//return Userbean Object				//return Userbean Object

	}
	public int UpdateProfile_Manager(UserBean ub,int manager_id)
	{
		
		int x=0;
		try
		{
			
			//creating session factory object//creating session factory object
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
			
			//creating session object//creating session object
				Session ss=sf.openSession();
				
				//creating transaction object  
				Transaction tx1=ss.beginTransaction();	    
			
			Query q=ss.createQuery("update UserBean set firstname=:a,lastname=:b,emailid=:c,mobile=:d where managerid=:e and designation=:f");
			q.setString("a",ub.getFirstname() );
			q.setString("b",ub.getLastname());
			q.setString("c",ub.getEmailid());
		//	q.setInteger("d",ub.getManagerid());
		//	q.setString("e",ub.getDesignation());
		//	q.setInteger("f",ub.getEmployeeid());
			q.setString("d",ub.getMobile());
		//	q.setString("h",ub.getDateofjoining());
		//	q.setString("i",ub.getStatus().trim());
		//	q.setInteger("j",ub.getSupportid());
			q.setInteger("e",manager_id);
			q.setString("f","manager");
			
			
					x=q.executeUpdate();//executeUpdate will execute the update query
			System.out.println("xxxxxxxx=======>"+x);
				tx1.commit();//transaction is committed //transaction is committed 
			ss.close();//close session//close the session
				
		}
		catch(Exception e)//Exception reference is created
		{				e.printStackTrace();//printStackTrace print line of error}
		
		}
			return x;//Return 0 or 1 as integer in the x
				
	}

	
	
///////////////Submit Manager Request /////////////////////////

public Object submitRequest(RequestBean rb){

Object o=null;
RequestBean rb1=null;

int managerid=rb.getManagerid();
String assetname=rb.getAssetname();
String requestdate=rb.getRequestdate();
String emailid=rb.getEmailid();
int supportid=rb.getSupportid();
int status=3;
String designation="manager";


try
{
	//creating seession factory object//creating seession factory object
	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
	
	//creating session object//creating session object
		Session ss=sf.openSession();
		
		//creating transaction object  
		Transaction tx1=ss.beginTransaction();	    

	rb1=new RequestBean();
	
	rb1.setManagerid(managerid);
	rb1.setAssetname(assetname);
	rb1.setRequestdate(requestdate);
	rb1.setSupportid(supportid);
	rb1.setStatus(status);
	rb1.setEmailid(emailid);
	rb1.setDesignation(designation);
	
o=ss.save(rb1);	
	tx1.commit();//transaction is committed 
ss.close();//close session

}
catch(Exception e)//Exception reference is created//Exception reference is created
{
					e.printStackTrace();//printStackTrace print line of error
System.out.println(e);

}
return o;
}

//-------------------------Manager My Support Id-----------------------------//

		
public UserBean View_PerticularId(int manager_id,String designation)
	{
			int x=0;			
			
					UserBean ub=new UserBean();//creating object of UserBean
		try
			{		
			//creating session factory object//creating session factory object
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
			
			//creating session object//creating session object
				Session ss=sf.openSession();
				
				//creating transaction object  
				Transaction tx1=ss.beginTransaction();	    

				//Criteria API helps us build criteria query objects dynamically				
			
			Criteria ct=ss.createCriteria(UserBean.class);		
				ct.add(Restrictions.eq("managerid",manager_id));
				ct.add(Restrictions.eq("designation",designation));
							List<UserBean> list=ct.list();//get the list with data
				if(list.isEmpty())//check if list is empty
				{
					System.out.println("In View_PerticularId -No Support id Found!!!!");
				}
				else
				{	
					for(UserBean u:list)//foreach loop to get data as itirator
						{
							 ub.setSupportid(u.getSupportid());
							 ub.setEmailid(u.getEmailid());
						}	
				}	
				
				System.out.println("support id is "+ ub.getSupportid());
				System.out.println("emailid id is "+ub.getEmailid());
				
					}
			catch(Exception e)//Exception reference is created
					{
										e.printStackTrace();//printStackTrace print line of error
						System.out.println(e);
					}
					return ub;				//return Userbean Object
			

		}
		
	
//---------------------Manager Myrequest view--------------------------

public ArrayList<RequestBean> Manager_viewMyrequest(int manager_id)
		{
		ArrayList<RequestBean> al=new ArrayList<RequestBean>();
		try
		{		
			
			//creating session factory object//creating session factory object
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
			
			//creating session object//creating session object
			Session ss=sf.openSession();
				  

			//Criteria API helps us build criteria query objects dynamically
			Criteria ct=ss.createCriteria(RequestBean.class);		
			
			ct.add(Restrictions.eq("managerid",manager_id));
			ct.add(Restrictions.eq("designation","manager"));		
		
			List<RequestBean> list=ct.list();
			if(list.isEmpty())//check if list is empty
			{
				
				System.out.println("No Data Found!!!!");
			}
			else
			{
				
					for(RequestBean u:list)
					{
						//creating RequestBean Object
						RequestBean rrb=new RequestBean();
						rrb.setRequestid(u.getRequestid());
						rrb.setManagerid(u.getManagerid());
//						System.out.println(u.getFirstname()+"   "+u.getLastname());
						rrb.setAssetname(u.getAssetname());
						rrb.setRequestdate(u.getRequestdate());
						rrb.setStatus(u.getStatus());
						al.add(rrb);		
					}	
			}	
				}
				catch(Exception e)//Exception reference is created
				{
									e.printStackTrace();//printStackTrace print line of error
					System.out.println(e);
				}
				return al;    //return arraylist object    //return arraylist object
		
}






//---------------------Manager My Asset view--------------------------

public ArrayList<RequestBean> Manager_viewMyAsset(int manager_id)
		{
		ArrayList<RequestBean> al=new ArrayList<RequestBean>();
		try
		{		
			
			//creating session factory object//creating session factory object
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
			
			//creating session object//creating session object
				Session ss=sf.openSession();
				
				//Criteria API helps us build criteria query objects dynamically
				Criteria ct=ss.createCriteria(RequestBean.class);		
			
			ct.add(Restrictions.eq("managerid",manager_id));
			ct.add(Restrictions.eq("designation","manager"));
			ct.add(Restrictions.eq("status",4));

		
			List<RequestBean> list=ct.list();
			if(list.isEmpty())//check if list is empty
			{
				
				System.out.println("No Data Found!!!!");
			}
			else
			{
				
					for(RequestBean u:list)
					{
						
						//creating RequestBean Object
						RequestBean rrb=new RequestBean();
						rrb.setRequestid(u.getRequestid());
						rrb.setManagerid(u.getManagerid());
//						System.out.println(u.getFirstname()+"   "+u.getLastname());
						rrb.setAssetname(u.getAssetname());
						rrb.setRequestdate(u.getRequestdate());
						rrb.setStatus(u.getStatus());
						al.add(rrb);		
					}	
			}	
				}
				catch(Exception e)//Exception reference is created
				{
									e.printStackTrace();//printStackTrace print line of error
					System.out.println(e);
				}
				return al;    //return arraylist object
		
}











//----------------------view_assetRequestByEmp////////////////////////////////////

public ArrayList<RequestBean> view_assetRequestByEmp(int manager_id)
{	
	ArrayList<RequestBean> al=new ArrayList<RequestBean>();
	try
	{		
		
		//creating session factory object//creating session factory object
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
		
		//creating session object//creating session object
			Session ss=sf.openSession();
			
			    

			//Criteria API helps us build criteria query objects dynamically
		Criteria ct=ss.createCriteria(RequestBean.class);		
		
		ct.add(Restrictions.eq("managerid",manager_id));
		ct.add(Restrictions.eq("designation","employee"));		

		List<RequestBean> list=ct.list();
		if(list.isEmpty())//check if list is empty
		{
			
			System.out.println("No Data Found!!!!");
		}
		else
		{	
			for(RequestBean u:list)
				{
			
				//creating RequestBean Object
				RequestBean rrb=new RequestBean();
				
					rrb.setRequestid(u.getRequestid());
					rrb.setEmployeeid(u.getEmployeeid());
					rrb.setEmailid(u.getEmailid());
					rrb.setManagerid(u.getManagerid());
					rrb.setAssetname(u.getAssetname());
					rrb.setRequestdate(u.getRequestdate());
					rrb.setStatus(u.getStatus());
					al.add(rrb);		
				}	
		}	
			}
			catch(Exception e)//Exception reference is created
			{
								e.printStackTrace();//printStackTrace print line of error
				System.out.println(e);
			}
			return al;    //return arraylist object
	

}

//------------------------Aproove by manager------------------

public int approve(int employeeid,String request_date,int requestid)
{
	
	int x=0;
	try
	{
		//creating session factory object//creating session factory object
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
		
		//creating session object//creating session object
			Session ss=sf.openSession();
			
			//creating transaction object  
			Transaction tx1=ss.beginTransaction();	    

		//Criteria API helps us build criteria query objects dynamically			
		Query q=ss.createQuery("update RequestBean set status=:a, managerapproveddate=:b where employeeid=:c and requestid=:d");
		q.setString("a","1");
		q.setString("b",request_date);
		q.setInteger("c",employeeid);
		
		q.setInteger("d",requestid);
		
				x=q.executeUpdate();//executeUpdate will execute the update query
			tx1.commit();//transaction is committed //transaction is committed 
		ss.close();//close session
			
	}
	catch(Exception e)//Exception reference is created
	{				e.printStackTrace();//printStackTrace print line of error}
	
	}
		return x;//Return 0 or 1 as integer in the x
			
}


//------------------------Reject  by manager------------------
public int reject(int employeeid,String request_date,int requestid)
{
int x=0;
	try
	{
		//creating session factory object//creating session factory object
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
		
		//creating session object//creating session object
			Session ss=sf.openSession();
			
			//creating transaction object  
			Transaction tx1=ss.beginTransaction();	    

			Query q=ss.createQuery("update RequestBean set status=:a, managerapproveddate=:b where employeeid=:c and requestid=:d");
		
		q.setString("a","2");
		q.setString("b",request_date);
		q.setInteger("c",employeeid);
		q.setInteger("d",requestid);
	
				x=q.executeUpdate();//executeUpdate will execute the update query
			tx1.commit();//transaction is committed //transaction is committed 
		ss.close();//close session
			
	}
	catch(Exception e)//Exception reference is created
	{				e.printStackTrace();//printStackTrace print line of error
	
	
	}
		return x;//Return 0 or 1 as integer in the x
			
}




public int changepwd(int manager_id,String password)
{
	int x=0;

	try
	{
		
		
		//creating session factory object//creating session factory object
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
		
		//creating session object//creating session object
			Session ss=sf.openSession();
			
			//creating transaction object  
			Transaction tx1=ss.beginTransaction();	    

			Query q=ss.createQuery("update UserBean set password=:a where managerid=:b and designation=:c");
			q.setString("a",password);
			q.setInteger("b",manager_id);
			q.setString("c","manager");		
					x=q.executeUpdate();//executeUpdate will execute the update query
			System.out.println("xxxxxxxx=======>"+x);
				tx1.commit();//transaction is committed //transaction is committed 
			ss.close();//close session//close the session//close the session
				
		}
		catch(Exception e)//Exception reference is created
		{				e.printStackTrace();//printStackTrace print line of error
		
		
		}
		
			return x;//Return 0 or 1 as integer in the x
				
	}


public int getMyOldPassword(String oldpassword,int manager_id)
{	
		int x=0;
		try
		{
				
			//creating session factory object//creating session factory object
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
			
			//creating session object//creating session object
				Session ss=sf.openSession();
				
				//creating transaction object  
				Transaction tx1=ss.beginTransaction();	    

				//Criteria API helps us build criteria query objects dynamically	
			Criteria ct=ss.createCriteria(UserBean.class);
			ct.add(Restrictions.eq("password",oldpassword));
			ct.add(Restrictions.eq("managerid",manager_id));

						List<UserBean> list=ct.list();//get the list with data
			
			if(list.isEmpty())//check if list is empty
			{
				x=0;
				
			}
			else if(!list.isEmpty())
			{
				x=1;
			}
			
				tx1.commit();//transaction is committed //transaction is committed 
			ss.close();//close session//close the session
		}
		catch(Exception e)//Exception reference is created
		{				e.printStackTrace();//printStackTrace print line of error}
		
		}
		
		return x;//Return 0 or 1 as integer in the x//Return 0 or 1 as integer in the x
	
	
}	
	// Asset Transer Request--------------//

public ArrayList<AssetTransferBean> manager_viewAssetTransferReq(int manager_id)
{
	ArrayList<AssetTransferBean> al=new ArrayList<AssetTransferBean>();
	try
	{		
	
		//creating session factory object//creating session factory object
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
		
		//creating session object//creating session object
			Session ss=sf.openSession();
				    

			//Criteria API helps us build criteria query objects dynamically
			Criteria ct=ss.createCriteria(AssetTransferBean.class);	//	create Criteria		
		
		ct.add(Restrictions.eq("managerid",manager_id));
		
		List<AssetTransferBean> list=ct.list();
		
		if(list.isEmpty())//check if list is empty
		{
			
			System.out.println("No Data Found!!!!");
		}
		else
		{	
			
			System.out.println(" Data Found!!!!");

			for(AssetTransferBean u:list)
				{
				AssetTransferBean rrb=new AssetTransferBean();
					rrb.setTransferid(u.getTransferid());
					rrb.setFromempid(u.getFromempid());
					rrb.setManagerid(u.getManagerid());
					rrb.setAssetid(u.getAssetid());
					rrb.setAssetname(u.getAssetname());
					rrb.setToempid(u.getToempid());
					rrb.setTransferrequestdate(u.getTransferrequestdate());
					rrb.setTransferstatus(u.getTransferstatus());
					
					al.add(rrb);		
				}	
		}	
			
		ss.close();//close session//close the session
}
			catch(Exception e)//Exception reference is created
			{
								e.printStackTrace();//printStackTrace print line of error
				System.out.println(e);
			}


		return al;    //return arraylist object
	
}



//email alredy exixt hai k nahi by ajax--------------//

public int checkemailifexist(String emailid, int managerid)
{
		int x=0;
try
	{		
	//creating seession factory object//creating seession factory object
	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
	
	//creating session object//creating session object
		Session ss=sf.openSession();
		
		//Criteria API helps us build criteria query objects dynamically				
	
		Criteria ct=ss.createCriteria(UserBean.class);		
		ct.add(Restrictions.eq("emailid",emailid));
		/*ct.add(Restrictions.ne("managerid",managerid));*/
		/*ct.add(Restrictions.ne("designation","manager"));*/
					List<UserBean> list=ct.list();//get the list with data
		
		if(list.isEmpty())//check if list is empty
		{
			x=0;
			
		}
		else if (!list.isEmpty())
		{	
			for(UserBean ub:list)
			{
				if(ub.getDesignation().equals("manager")&& ub.getManagerid()==managerid)
						{
							x=0;
						}
				else
					x=1;
			
			}
			

		}	
		ss.close();//close session//close the session
}
			catch(Exception e)//Exception reference is created
			{
								e.printStackTrace();//printStackTrace print line of error
				System.out.println(e);
			}


	return x;//Return 0 or 1 as integer in the x
	
}

//email alredy exixt hai k nahi by ajax--------------//


public int checkmobileifexist(String mobile,int managerid)
{
		int x=0;
try
	{		
	//creating seession factory object//creating seession factory object
	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
	
	//creating session object//creating session object
		Session ss=sf.openSession();

		//Criteria API helps us build criteria query objects dynamically
		Criteria ct=ss.createCriteria(UserBean.class);		
	ct.add(Restrictions.eq("mobile",mobile));
	/*ct.add(Restrictions.ne("managerid",managerid));*/
	/*ct.add(Restrictions.ne("designation","manager"));*/
				List<UserBean> list=ct.list();//get the list with data
	
	if(list.isEmpty())//check if list is empty
	{
		x=0;
		
	}
	else if (!list.isEmpty())
	{	
		for(UserBean ub:list)
		{
			if(ub.getDesignation().equals("manager")&& ub.getManagerid()==managerid)
					{
						x=0;
					}
			else
				x=1;
		
		}
		

	}	
	ss.close();//close session//close the session
}
			catch(Exception e)//Exception reference is created
			{
								e.printStackTrace();//printStackTrace print line of error
				System.out.println(e);
			}


	return x;//Return 0 or 1 as integer in the x
	
}



//------------------------Aproove by manager------------------

public int approveAssetTransfer(int fromempid,String approve_date,int transferid,int manager_id,int statusinstert)
{
	
	int x=0;
	try
	{
		
		//creating session factory object//creating session factory object
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
		
		//creating session object//creating session object
			Session ss=sf.openSession();
			
			//creating transaction object  
			Transaction tx1=ss.beginTransaction();	    
		
		Query q=ss.createQuery("update AssetTransferBean set transferstatus=:a, transferdate=:b where fromempid=:c and transferid=:d and managerid=:e ");
		
		q.setInteger("a",statusinstert);
		q.setString("b",approve_date);
		q.setInteger("c",fromempid);
		
		q.setInteger("d",transferid);
		q.setInteger("e",manager_id);

		
				x=q.executeUpdate();//executeUpdate will execute the update query
			tx1.commit();//transaction is committed //transaction is committed 
		ss.close();//close session
			
	}
	
	catch(Exception e)//Exception reference is created
	{
						e.printStackTrace();//printStackTrace print line of error
	}
		return x;//Return 0 or 1 as integer in the x
			
}


//------------------------Reject  by manager------------------
public int rejectAssetTransfer(int fromempid,String reject_date,int transferid,int manager_id)
{
int x=0;
	try
{
		//creating session factory object//creating session factory object
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
		
		//creating session object//creating session object
			Session ss=sf.openSession();
			
			//creating transaction object  
			Transaction tx1=ss.beginTransaction();	    

			//Criteria API helps us build criteria query objects dynamically			
		
		Query q=ss.createQuery("update AssetTransferBean set transferstatus=:a, transferdate=:b where fromempid=:c and transferid=:d and managerid=:e ");
		
		q.setString("a","1");
		q.setString("b",reject_date);
		q.setInteger("c",fromempid);
		
		q.setInteger("d",transferid);
		q.setInteger("e",manager_id);
	
				x=q.executeUpdate();//executeUpdate will execute the update query
			tx1.commit();//transaction is committed //transaction is committed //transaction is committed 
		ss.close();//close session//close the session
			
	}
	catch(Exception e)//Exception reference is created
	{				e.printStackTrace();//printStackTrace print line of error
	
	
	}
		return x;//Return 0 or 1 as integer in the x
			
}

public List<AllocatedAssetsBean> viewallcatedasset()
{
	
	//creating seession factory object//creating seession factory object
	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
	
	//creating session object//creating session object
		Session ss=sf.openSession();
   

		//Criteria API helps us build criteria query objects dynamically
	
	Criteria ct = ss.createCriteria(AllocatedAssetsBean.class);	

	    List<AllocatedAssetsBean>list=ct.list();
	    if(!list.isEmpty())
	   {
		   System.out.println("not Empty");
	   }
	     
	    
	   ss.close();//close session
				return list;    //return arraylist object
	
		
	}




public int getAssettransferRequest()
{
		int status=0;
		int x=0;
try
	{		
    //creating seession factory object  
				SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();//creating seession factory object
	
    //creating session object  
				Session ss=sf.openSession();//creating session object

	//creating transaction object  
	Transaction tx1=ss.beginTransaction();

	Criteria ct=ss.createCriteria(AssetTransferBean.class);	//	create Criteria		
	List<AssetTransferBean> list=ct.list();
	
	if(list.isEmpty())//check if list is empty//check if list is empty
	{
		x=0;
		
	}
	else if (!list.isEmpty())
	{	
		for(AssetTransferBean ub:list)
		{
			status=ub.getTransferstatus();
		
		}
		

	}	
		}
			catch(Exception e)//Exception reference is created
			{
								e.printStackTrace();//printStackTrace print line of error
				System.out.println(e);
			}


return status;
	
}







//------------------------Update asset transfer id------------------

public int updateIdafterTransfer(int fromempid,int toempid,int transferid,int manager_id,int assetid)
{
	
	int x=0;
	try
	{
		
		//creating session factory object//creating session factory object
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
		
		//creating session object//creating session object
			Session ss=sf.openSession();
			
			//creating transaction object  
			Transaction tx1=ss.beginTransaction();	    

			Query q=ss.createQuery("update AllocatedAssetsBean set userid=:a where assetid=:b");
		
		q.setInteger("a",fromempid);
		q.setInteger("b",assetid);
		
				x=q.executeUpdate();//executeUpdate will execute the update query//executeUpdate will execute the update query
			tx1.commit();//transaction is committed //transaction is committed 
		ss.close();//close session
		
		
		
		System.out.println("transfer succes "+x);
			
	}
	
	catch(Exception e)//Exception reference is created
	{
						e.printStackTrace();//printStackTrace print line of error
	}
		return x;//Return 0 or 1 as integer in the x
			
}





public void deletetransferrequests(int transferid)
{
	int x=0;
	
	System.out.println("inside delete"+transferid);
try
	{		
	//creating session factory object//creating session factory object
	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
	
	//creating session object//creating session object
		Session ss=sf.openSession();
		
		//creating transaction object  
		Transaction tx1=ss.beginTransaction();	    

	Query q = ss.createQuery("delete from AssetTransferBean where transferid=:a");
	q.setInteger("a",transferid );
	
	q.executeUpdate();//executeUpdate will update the data
		tx1.commit();//transaction is committed //transaction is committed 
	
	ss.close();//close session
		
		}
			catch(Exception e)//Exception reference is created
			{
								e.printStackTrace();//printStackTrace print line of error//printStackTrace print line of error
				System.out.println(e);
			}


}

public int managertrasferassetrequest(AssetTransferBean ub)
{
	int x=0;
	
		
	//creating session factory object//creating session factory object
	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
	
	//creating session object//creating session object
		Session ss=sf.openSession();
		
		//creating transaction object  
		Transaction tx1=ss.beginTransaction();	    
		 
		 System.out.println(ub.toString());
		ss.save(ub);
		
			x=1;
	  tx1.commit();//transaction is committed
	  ss.close();//close session
	
	  	return x;//Return 0 or 1 as integer in the x
}




public ArrayList<AssetTransferBean> managerviewAseetrequestByMe(int manager_id)
{
	ArrayList<AssetTransferBean> al=new ArrayList<AssetTransferBean>();
	try
	{		
		//creating session factory object//creating session factory object
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();		
		
		//creating session object//creating session object
			Session ss=sf.openSession();
			
			
			//Criteria API helps us build criteria query objects dynamically

		Criteria ct=ss.createCriteria(AssetTransferBean.class);	//	create Criteria	//	create Criteria
		ct.add(Restrictions.eq("fromempid",manager_id));		
		List<AssetTransferBean> list=ct.list();
		
		if(list.isEmpty())//check if list is empty
		{
			
			System.out.println("No Data Found!!!!");
		}
		
		else
		{	
			
			System.out.println(" Data Found!!!!");

			for(AssetTransferBean u:list)
				{
				AssetTransferBean rrb=new AssetTransferBean();
					rrb.setTransferid(u.getTransferid());
					rrb.setFromempid(u.getFromempid());
					rrb.setManagerid(u.getManagerid());
					rrb.setAssetid(u.getAssetid());
					rrb.setAssetname(u.getAssetname());
					rrb.setToempid(u.getToempid());
					rrb.setTransferrequestdate(u.getTransferrequestdate());
					rrb.setTransferstatus(u.getTransferstatus());
					
					al.add(rrb);		
				}	
		}	
			}
			catch(Exception e)//Exception reference is created
			{
								e.printStackTrace();//printStackTrace print line of error
				System.out.println(e);
			}


		return al;    //return arraylist object
	
}



}