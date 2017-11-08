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
}
