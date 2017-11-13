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
import com.asset_management.beans.RequestBean;
import com.asset_management.beans.UserBean;



public class SupportModel {

	public ArrayList<RequestBean> retriveRequests(String usersession)
	{
		
		int x=0;
		RequestBean rb=null;
		ArrayList<RequestBean> al=new ArrayList<RequestBean>();
		try
		{		
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
		
			Criteria ct=ss.createCriteria(RequestBean.class);
//			ct.add(Restrictions.eq("usersession",usersession));
			
			List<RequestBean> list=ct.list();
			if(list.isEmpty())
			{}
			else
			{
				for(RequestBean rb1:list)
				{
					rb=new RequestBean();
					
					rb.setRequestid(rb1.getRequestid());
					rb.setEmployeeid(rb1.getEmployeeid());
					rb.setManagerid(rb1.getManagerid());
					rb.setManagerapproveddate(rb1.getManagerapproveddate());
					rb.setAssetname(rb1.getAssetname());
					rb.setRequestdate(rb1.getRequestdate());
					rb.setStatus(rb1.getStatus());	
					rb.setEmailid(rb1.getEmailid());
					rb.setDesignation(rb1.getDesignation());
					al.add(rb);
					
				}
				
			}
			tx1.commit();
			ss.close();	
		}
		catch(Exception e)
		{e.printStackTrace();}
		return al;
		
	}
	
	
	
	
	
	public int approve(int employeeid,int requestid)
//	public int approveAndInsert(String assetname,String dateofallocation,int supportid,String emailid,int employeeid,int requestid)
	{
	
		int x=0;
	
		
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
			
			Query q=ss.createQuery("update RequestBean set status=:a where employeeid=:b and requestid=:c");
									
			q.setParameter("a",4);
			q.setParameter("b", employeeid);
			q.setParameter("c", requestid);			
			x=q.executeUpdate();			
			tx1.commit();
			ss.close();
		return x;
	}
	
	
	public int insert(int employeeid,String assetname,String dateofallocation,int supportid,String emailid)
	{
		int y=0;
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
		
		AllocatedAssetsBean aab = new AllocatedAssetsBean();			
		aab.setUserid(employeeid);
		aab.setAssetname(assetname);
		aab.setDateofallocation(dateofallocation);
        aab.setEmailid(emailid);
       Transaction tx2=ss.beginTransaction();
        ss.save(aab);
        	y=1;		
		tx2.commit();
		
		return y;
	}
	
	
	
	
	
	
	public int cancelRequest(int supportid,int employeeid,int requestid)
	{		
		int x=0;
		int z=0;
		
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
			
			Query q=ss.createQuery("update RequestBean set status=:a where employeeid=:b and requestid=:c and supportid=:d");
			q.setInteger("a",5);
			q.setInteger("b", employeeid);
			q.setInteger("c", requestid);
			q.setInteger("d", supportid);
			
			x=q.executeUpdate();
			tx1.commit();
			ss.close();
			

		return x;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//==========================================================================================	
	public ArrayList<AllocatedAssetsBean> retriveReports()
	{
		AllocatedAssetsBean aab=null;
		ArrayList<AllocatedAssetsBean> al=new ArrayList<AllocatedAssetsBean>();
		try
		{
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
		
			Criteria ct=ss.createCriteria(AllocatedAssetsBean.class);		
			List<AllocatedAssetsBean> list=ct.list();
			if(list.isEmpty())
			{}
			else
			{
				
				for(AllocatedAssetsBean aab1:list)
				{
					aab=new AllocatedAssetsBean();
					aab.setAssetid(aab1.getAssetid());
					aab.setUserid(aab1.getUserid());
					aab.setAssetname(aab1.getAssetname());
					aab.setDateofallocation(aab1.getDateofallocation());
					aab.setEmailid(aab1.getEmailid());
				
					al.add(aab);
					
				}
				
			}
			tx1.commit();
			ss.close();
			
		}
		catch(Exception e)
		{e.printStackTrace();}
		return al;

	}
	
	
	
	
	
	
	
	
	
//	============================================Method to change Support Password================================================
	
	public int updateNewPassword(int support_session,String password,String user_designation)
	{
		int x=0;
	
		try
		{
						


			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
			
			Query q=ss.createQuery("update UserBean set password=:a where supportid=:b and designation=:c");
			q.setString("a",password);
			q.setInteger("b", support_session);
			q.setString("c", user_designation);
			
			x=q.executeUpdate();

			tx1.commit();
			ss.close();
	
		}
		catch(Exception e)
		{e.printStackTrace();}
		
		return x;
	}
	
	
	
	
	
	
//-------------checking the password of support , if it exists or not----------------
	
	public String checkExistanceOfSupportPassword(int supportid)
	{
		String password=null;
			try
			{
				System.out.println("Model mai Password checking chala.......");
				SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
				Session ss=sf.openSession();
				Transaction tx1=ss.beginTransaction();				
				
				Criteria ct=ss.createCriteria(UserBean.class);		
				ct.add(Restrictions.eq("supportid",supportid));
				List<UserBean> list=ct.list();
				System.out.println("SupportModel mai------>list.size()---->Supportid  ki list="+list.size());
				
				if(list.isEmpty())
				{}
				else
				{
					for(UserBean u:list)
					{
						
						System.out.println("SupportModel---->Fetching support password"+u.getPassword());
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
	
	
	
	
	
	public ArrayList<UserBean> retriveSupportDetails(int supportid)
	{
		UserBean ub=null;
		ArrayList<UserBean> al=new ArrayList<UserBean>();
		try
		{
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
		
			Criteria ct=ss.createCriteria(UserBean.class);	
			ct.add(Restrictions.eq("supportid",supportid));
			ct.add(Restrictions.eq("designation","support"));
			List<UserBean> list=ct.list();
			if(list.isEmpty())
			{}
			else
			{
				
				for(UserBean ub1:list)
				{
					ub=new UserBean();

					ub.setFirstname(ub1.getFirstname());
					ub.setLastname(ub1.getLastname());
					ub.setMobile(ub1.getMobile());
					ub.setEmailid(ub1.getEmailid());
					ub.setPassword(ub1.getPassword());
					ub.setDesignation(ub1.getDesignation());
					ub.setDateofjoining(ub1.getDateofjoining());
					al.add(ub1);
					
				}
				
			}
			tx1.commit();
			ss.close();
			
		}
		catch(Exception e)
		{e.printStackTrace();}
		return al;

	}
	
	
	
	//email alredy exixt hai k nahi by ajax--------------//

	public int checkemailifexist(String emailid, int supportid)
	{
			int x=0;
	try
		{		
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
		
			Criteria ct=ss.createCriteria(UserBean.class);		
			ct.add(Restrictions.eq("emailid",emailid));
			/*ct.add(Restrictions.ne("managerid",managerid));*/
			/*ct.add(Restrictions.ne("designation","manager"));*/
			List<UserBean> list=ct.list();
			
			if(list.isEmpty())
			{
				x=0;
				
			}
			else if (!list.isEmpty())
			{	
				for(UserBean ub:list)
				{
					if(ub.getDesignation().equals("support")&& ub.getSupportid()==supportid)
							{
								x=0;
							}
					else
						x=1;
				
				}
				

			}	
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println(e);
				}


	return x;
		
	}




	//email alredy exixt hai k nahi by ajax--------------//

	public int checkmobileifexist(String mobile,int supportid)
	{
			int x=0;
	try
		{		
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();

		Criteria ct=ss.createCriteria(UserBean.class);		
		ct.add(Restrictions.eq("mobile",mobile));
		/*ct.add(Restrictions.ne("managerid",managerid));*/
		/*ct.add(Restrictions.ne("designation","manager"));*/
		List<UserBean> list=ct.list();
		
		if(list.isEmpty())
		{
			x=0;
			
		}
		else if (!list.isEmpty())
		{	
			for(UserBean ub:list)
			{
				if(ub.getDesignation().equals("support")&& ub.getSupportid()==supportid)
						{
							x=0;
						}
				else
					x=1;
			
			}
			

		}	
			}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println(e);
				}


	return x;
		
	}

	
	
	
	
	
//------updating support profile-------
	public int updateSupportProfile(int supportid,String firstname,String lastname,String emailid,String mobile,String password)
	{
		int x=0;
		try
		{
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			
			Transaction tx1=ss.beginTransaction();
			Query query=ss.createQuery("update UserBean set firstname=:a,lastname=:b,emailid=:c,password=:d,mobile=:e where supportid=:f and designation=:g");
			query.setString("a",firstname);
			query.setString("b",lastname);
			query.setString("c",emailid);
			query.setString("d",password);
			query.setString("e",mobile);
			query.setInteger("f",supportid);
			query.setString("g","support");
			
			x=query.executeUpdate();
			tx1.commit();
			ss.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}

		return x;
	}
	
	
}
