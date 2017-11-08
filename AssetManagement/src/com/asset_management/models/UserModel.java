package com.asset_management.models;

import java.util.Iterator;
import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import com.asset_management.beans.AdminBean;
import com.asset_management.beans.UserBean;
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
	
	
	
	
	
}
