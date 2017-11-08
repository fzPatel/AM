package com.asset_management.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import com.asset_management.beans.AdminBean;
import com.asset_management.beans.AssetTransferBean;
import com.asset_management.beans.RequestBean;
import com.asset_management.beans.UserBean;

public class ManagerModel {
	
///////////////View manager Profile/////////////////////////

	public UserBean ViewProfile_Manager(int manager_id)
	{
		UserBean ub=new UserBean();
		try
		{		
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
		
			Criteria ct=ss.createCriteria(UserBean.class);		
			
			ct.add(Restrictions.eq("managerid",manager_id));
			ct.add(Restrictions.eq("designation","manager"));
			

			List<UserBean> list=ct.list();
			if(list.isEmpty())
			{
				
				System.out.println("No Data Found!!!!");
			}
			else
			{
				
					for(UserBean u:list)
					{
						ub.setFirstname(u.getFirstname());
						ub.setLastname(u.getLastname());
//						System.out.println(u.getFirstname()+"   "+u.getLastname());
						ub.setEmailid(u.getEmailid());
						ub.setManagerid(u.getManagerid());
						ub.setDesignation(u.getDesignation());
						ub.setEmployeeid(u.getEmployeeid());
						ub.setMobile(u.getMobile());
						ub.setPassword(u.getPassword());
						ub.setDateofjoining(u.getDateofjoining());
						ub.setStatus(u.getStatus());
						ub.setSupportid(u.getSupportid());
						ub.setAuto(u.getAuto());
						
					}	
			}	
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		return ub;
		

	}
	public int UpdateProfile_Manager(UserBean ub,int manager_id)
	{
		
		int x=0;
		try
		{
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
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
			
			
			x=q.executeUpdate();
			System.out.println("xxxxxxxx=======>"+x);
			tx1.commit();
			ss.close();
				
		}
		catch(Exception e)
		{e.printStackTrace();}
		return x;
				
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
SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
Session ss=sf.openSession();
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
tx1.commit();
ss.close();

}
catch(Exception e)
{
	e.printStackTrace();
System.out.println(e);

}
return o;
}

//-------------------------Manager My Support Id-----------------------------//

		
public UserBean View_PerticularId(int manager_id,String designation)
	{
			int x=0;			
			
			UserBean ub=new UserBean();
		try
			{		
				SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
				Session ss=sf.openSession();
				Transaction tx1=ss.beginTransaction();
				Criteria ct=ss.createCriteria(UserBean.class);		
				ct.add(Restrictions.eq("managerid",manager_id));
				ct.add(Restrictions.eq("designation",designation));
				List<UserBean> list=ct.list();
				if(list.isEmpty())
				{
					System.out.println("In View_PerticularId -No Support id Found!!!!");
				}
				else
				{	
					for(UserBean u:list)
						{
							 ub.setSupportid(u.getSupportid());
							 ub.setEmailid(u.getEmailid());
						}	
				}	
				
				System.out.println("support id is "+ ub.getSupportid());
				System.out.println("emailid id is "+ub.getEmailid());
				
					}
			catch(Exception e)
					{
						e.printStackTrace();
						System.out.println(e);
					}
			return ub;
			

		}
		
	
//---------------------Manager Myrequest view--------------------------

public ArrayList<RequestBean> Manager_viewMyrequest(int manager_id)
		{
		ArrayList<RequestBean> al=new ArrayList<RequestBean>();
		try
		{		
			
			System.out.println(manager_id);
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
		
			Criteria ct=ss.createCriteria(RequestBean.class);		
			
			ct.add(Restrictions.eq("managerid",manager_id));
			ct.add(Restrictions.eq("designation","manager"));		
		


			List<RequestBean> list=ct.list();
			if(list.isEmpty())
			{
				
				System.out.println("No Data Found!!!!");
			}
			else
			{
				
					for(RequestBean u:list)
					{
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
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println(e);
				}
		return al;
		
}






//---------------------Manager My Asset view--------------------------

public ArrayList<RequestBean> Manager_viewMyAsset(int manager_id)
		{
		ArrayList<RequestBean> al=new ArrayList<RequestBean>();
		try
		{		
			
			System.out.println(manager_id);
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
		
			Criteria ct=ss.createCriteria(RequestBean.class);		
			
			ct.add(Restrictions.eq("managerid",manager_id));
			ct.add(Restrictions.eq("designation","manager"));
			ct.add(Restrictions.eq("status",4));

		
			List<RequestBean> list=ct.list();
			if(list.isEmpty())
			{
				
				System.out.println("No Data Found!!!!");
			}
			else
			{
				
					for(RequestBean u:list)
					{
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
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println(e);
				}
		return al;
		
}











//----------------------view_assetRequestByEmp////////////////////////////////////

public ArrayList<RequestBean> view_assetRequestByEmp(int manager_id)
{	
	ArrayList<RequestBean> al=new ArrayList<RequestBean>();
	try
	{		
		
		System.out.println(manager_id);
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
	
		Criteria ct=ss.createCriteria(RequestBean.class);		
		
		ct.add(Restrictions.eq("managerid",manager_id));
		ct.add(Restrictions.eq("designation","employee"));		

		List<RequestBean> list=ct.list();
		if(list.isEmpty())
		{
			
			System.out.println("No Data Found!!!!");
		}
		else
		{	
			for(RequestBean u:list)
				{
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
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(e);
			}
	return al;
	

}

//------------------------Aproove by manager------------------

public int approve(int employeeid,String request_date,int requestid)
{
	
	int x=0;
	try
	{
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
		Query q=ss.createQuery("update RequestBean set status=:a, managerapproveddate=:b where employeeid=:c and requestid=:d");
		q.setString("a","1");
		q.setString("b",request_date);
		q.setInteger("c",employeeid);
		
		q.setInteger("d",requestid);
		
		x=q.executeUpdate();
		tx1.commit();
		ss.close();
			
	}
	catch(Exception e)
	{e.printStackTrace();}
	return x;
			
}


//------------------------Reject  by manager------------------
public int reject(int employeeid,String request_date,int requestid)
{
int x=0;
	try
	{
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
		Query q=ss.createQuery("update RequestBean set status=:a, managerapproveddate=:b where employeeid=:c and requestid=:d");
		
		q.setString("a","2");
		q.setString("b",request_date);
		q.setInteger("c",employeeid);
		q.setInteger("d",requestid);
	
		x=q.executeUpdate();
		tx1.commit();
		ss.close();
			
	}
	catch(Exception e)
	{e.printStackTrace();
	
	
	}
	return x;
			
}




public int changepwd(int manager_id,String password)
{
	int x=0;

	try
	{
		
		
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
			Query q=ss.createQuery("update UserBean set password=:a where managerid=:b and designation=:c");
			q.setString("a",password);
			q.setInteger("b",manager_id);
			q.setString("c","manager");		
			x=q.executeUpdate();
			System.out.println("xxxxxxxx=======>"+x);
			tx1.commit();
			ss.close();
				
		}
		catch(Exception e)
		{e.printStackTrace();
		
		
		}
		
		return x;
				
	}


public String getMyOldPassword(int manager_id)
{	
		String password=null;
		try
		{
			System.out.println("Model mai Password checking chala.......");
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();				
			
			Criteria ct=ss.createCriteria(UserBean.class);		
			ct.add(Restrictions.eq("managerid",manager_id));
			List<UserBean> list=ct.list();
			
			if(list.isEmpty())
			{}
			else
			{
				for(UserBean u:list)
				{
					
					password=u.getPassword();

				}
			}
			tx1.commit();
			ss.close();
		}
		catch(Exception e)
		{e.printStackTrace();}
		
	return password;
	
	
}	
	// Asset Transer Request--------------//

public ArrayList<AssetTransferBean> manager_viewAssetTransferReq(int manager_id)
{
	ArrayList<AssetTransferBean> al=new ArrayList<AssetTransferBean>();
	try
	{		
		System.out.println(manager_id);
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
	
		Criteria ct=ss.createCriteria(AssetTransferBean.class);		
		
		ct.add(Restrictions.eq("managerid",manager_id));
		List<AssetTransferBean> list=ct.list();
		
		if(list.isEmpty())
		{
			
			System.out.println("No Data Found!!!!");
		}
		else
		{	
			for(AssetTransferBean u:list)
				{
				AssetTransferBean rrb=new AssetTransferBean();
					rrb.setTransferid(u.getTransferid());
					rrb.setFromempid(u.getFromempid());
					rrb.setManagerid(u.getManagerid());
					rrb.setAssetid(u.getAssetid());
					rrb.setAssetname(u.getAssetname());
					rrb.setToempid(u.getToempid());
					rrb.setTransferdate(u.getTransferdate());
					rrb.setTransferstatus(u.getTransferstatus());
					
					al.add(rrb);		
				}	
		}	
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(e);
			}


return al;
	
}

}