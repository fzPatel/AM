package com.asset_management.models;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import com.asset_management.beans.UserBean;
import com.asset_management.mail.Email;
public class UserModel {

	public int user_login_check(int userid,String password)
	{
		int x=0;
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
		
		Criteria ct=ss.createCriteria(UserBean.class);
		
		org.hibernate.Query q=null;
		try
		{
			ct.add(Restrictions.eq("userid",userid));
			ct.add(Restrictions.eq("password",password));
			ct.add(Restrictions.eq("status","A"));
			/*if(designation.equals("employee"))
			{
		
				ct.add(Restrictions.eq("employee",id));
				ct.add(Restrictions.eq("password",password));
				ct.add(Restrictions.eq("designation",designation));
			}
			else if(designation.equals("manager"))
			{

				ct.add(Restrictions.eq("managerid",id));
				ct.add(Restrictions.eq("password",password));
				ct.add(Restrictions.eq("designation",designation));
			}
			else if(designation.equals("support"))
			{
			
				ct.add(Restrictions.eq("supportid",id));
				ct.add(Restrictions.eq("password",password));
				ct.add(Restrictions.eq("designation",designation));
			}
			*/
			
			
			List<UserBean> list=ct.list();
			
			if(list.isEmpty())
			{}
			else
				x=1;			
			
		}
		catch(Exception e)
		{System.out.println(e);}
		
		tx1.commit();
		ss.close();
		return x;
	}
	
	
	//--------------------04 Novmber 2017 Single login page ------------------	
	
	
	public String fetchDesignation(int userid)
	{
		UserBean ub=null;
		String designation=null;
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
		
		Criteria ct=ss.createCriteria(UserBean.class);		
		ct.add(Restrictions.eq("userid",userid));
		
		List<UserBean> list=ct.list();
//		System.out.println("list.size()---->"+list.size());
		
		if(list.isEmpty())
		{}
		else
		{
			for(UserBean u:list)
			{
				designation =u.getDesignation();
//				System.out.println("designation->"+designation);
			}
		}
		return designation;
	}
	
	
	

	
	public int checkExistanceOfUser(String emailid)
	{
		int x=0;
			try
			{
				
				SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
				Session ss=sf.openSession();
				Transaction tx1=ss.beginTransaction();
				
				Criteria ct=ss.createCriteria(UserBean.class);				
					ct.add(Restrictions.eq("emailid",emailid));
				
					
					List<UserBean> list=ct.list();
				
					if(list.isEmpty())
					{
						x=0;
					}
					else if(!list.isEmpty())
					{
						x=1;
						System.out.println("MOdel mai......emailid mili");
					}
				
			}
			catch(Exception e)
			{e.printStackTrace();}
		return x;
	}
	

	
	
	public int checkMobileExistanceOfUser(String mobile)
	{
		int x=0;
			try
			{
				
				SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
				Session ss=sf.openSession();
				Transaction tx1=ss.beginTransaction();
				
				Criteria ct=ss.createCriteria(UserBean.class);				
					ct.add(Restrictions.eq("mobile",mobile));
				
					
					List<UserBean> list=ct.list();
				
					if(list.isEmpty())
					{
						x=0;
					}
					else if(!list.isEmpty())
					{
						x=1;
						System.out.println("MOdel mai......mobile mila");
					}
				
			}
			catch(Exception e)
			{e.printStackTrace();}
		return x;
	}
	
	
	
	public int forgetPassword(String emailid)
	{
		int x=0;
		String pass = null;
		int userid = 0;
		
			try
			{
				
				SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
				Session ss=sf.openSession();
				Transaction tx1=ss.beginTransaction();
				
				Criteria ct=ss.createCriteria(UserBean.class);				
					ct.add(Restrictions.eq("emailid",emailid));
				
					
					List<UserBean> list=ct.list();
				
					if(list.isEmpty())
					{
						x=0;
					}
					else if(!list.isEmpty())
					{
						x=1;
						System.out.println("MOdel mai......mobile mila");
						
						
						

						for(UserBean u:list)
						{
							pass =u.getPassword();
							userid=u.getUserid();
						}
						
						
						if(x==1)
						
						{
							
							Email e=new Email();
							e.forgetpassword(userid,pass,emailid);
							
						}
						
						
						
						
					}
				
			}
			catch(Exception e)
			{e.printStackTrace();}
		return x;
	}
	
	
	
	
	
}
