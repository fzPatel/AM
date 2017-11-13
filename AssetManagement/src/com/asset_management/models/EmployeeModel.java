package com.asset_management.models;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.asset_management.beans.AdminBean;
import com.asset_management.beans.AllocatedAssetsBean;
import com.asset_management.beans.AssetTransferBean;
import com.asset_management.beans.RequestBean;
import com.asset_management.beans.UserBean;
public class EmployeeModel 
{
	public int createrequest(RequestBean ub)
{
	int x=0;
	
		
		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
		
		Session ss=sf.openSession();
		
		 Transaction tt = ss.beginTransaction();
		 System.out.println(ub.toString());
		ss.save(ub);
		
			x=1;
	  tt.commit();
	  ss.close();
	
	  return x;
}
//PreparedStatement ps=con.prepareStatement("select * from ordertable where status=?");
public List<AllocatedAssetsBean> myasset(int employeeid,String emailid)
{
	int x=0;	
	//ArrayList <UserBean> list= new ArrayList<UserBean>();

		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();

		 System.out.println(employeeid);
	        System.out.println(emailid);

		Criteria ct = ss.createCriteria(AllocatedAssetsBean.class);
		
		ct.add(Restrictions.eq("userid",employeeid));
		ct.add(Restrictions.eq("emailid",emailid));
		
	    List<AllocatedAssetsBean>list=ct.list();
	    if(!list.isEmpty())
	   {
		   System.out.println("not Empty");
	   }
	     
	    
	   ss.close();
		return list;
	
		
	}
public List<UserBean> myassetofemp()
{
	int x=0;	
	//ArrayList <UserBean> list= new ArrayList<UserBean>();

		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();

		 

		Criteria ct = ss.createCriteria(UserBean.class);
		
		ct.add(Restrictions.eq("designation","employee"));
		
	    List<UserBean>list=ct.list();
	    if(!list.isEmpty())
	   {
		   System.out.println("not Empty");
	   }
	     
	    
	   ss.close();
		return list;
	
		
	}




public List<UserBean> viewprofile(int s)
{
	
	int x=0;
	 
	//ArrayList <UserBean> list= new ArrayList<UserBean>();

		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
		
		Session ss=sf.openSession();
		
		Criteria ct = ss.createCriteria(UserBean.class);
		ct.add(Restrictions.eq("employeeid", s ));
	    
	     List<UserBean>list=(List<UserBean>)ct.list();
	   
		ss.close();
		return list;
	
		
	}
public List<RequestBean> Viewrequest(int employeeid)
{
	
	int x=0;	
	 
	//ArrayList <UserBean> list= new ArrayList<UserBean>();

		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
		
		Session ss=sf.openSession();
		
		Criteria ct = ss.createCriteria(RequestBean.class);
		ct.add(Restrictions.eq("employeeid",  employeeid ));
		ct.add(Restrictions.eq("designation",  "employee" ));
		
	     List<RequestBean>list=(List<RequestBean>)ct.list();
	   
		ss.close();
		return list;
	
		
	}
      
	

public int update_profile(int id,String fname,String lname,String email,String mobile )

{
	int x=0;
	
	
	SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();	
	Session ss=sf.openSession();	
	 Transaction tt = ss.beginTransaction();
	Query q = ss.createQuery("update UserBean set firstname = :a,lastname=:b,emailid=:c,mobile=:d  where employeeid =:e");
	
	q.setString("a", fname);
	q.setString("b", lname);
	q.setString("c", email);
	q.setString("d", mobile);
	q.setInteger("e", id);
	int result = q.executeUpdate();
	
	
  tt.commit();
  ss.close();

  return result;
}
//PreparedStatement ps=con.prepareStatement("Update placeorder set password=? where email=? and password=?");
//ps.setString(1, New);
//ps.setString(2, s1);
//ps.setString(3, current);
public int changepwds(String current,String New,int s1)

{
	
	SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
	Session ss= sf.openSession();
	Transaction tt = ss.beginTransaction();
	Query q= ss.createQuery("update UserBean set password=:a where employeeid=:b and password=:c");
	q.setString("a", New);
	q.setInteger("b", s1);
	q.setString("c", current);
	int x= q.executeUpdate();
	tt.commit();
	ss.close();
	return x;
	
	
}
public int View_PerticularId(int employeeid,String designation)
{
	int x=0;			
	
	try
	{		
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
	
		Criteria ct=ss.createCriteria(UserBean.class);		
		
		ct.add(Restrictions.eq("employeeid",employeeid));
		ct.add(Restrictions.eq("designation",designation));
		List<UserBean> list=ct.list();
		if(list.isEmpty())
		{
			
			System.out.println("In View_PerticularId -No Manager id Found!!!!");
		}
		else
		{	
			for(UserBean u:list)
				{
					 x=u.getManagerid();
				}	
		}	
		
		System.out.println("manager id is "+ x);
		
			}
	catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(e);
			}
	return x;
	

	
}
public String get_Perticulardesignation(int employeeid,String designation)
{
			
	String xa=null;
	try
	{		
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
	
		Criteria ct=ss.createCriteria(UserBean.class);		
		
		ct.add(Restrictions.eq("employeeid",employeeid));
		ct.add(Restrictions.eq("designation",designation));
		List<UserBean> list=ct.list();
		if(list.isEmpty())
		{
			
			System.out.println("In View_PerticularId -No Manager id Found!!!!");
		}
		else
		{	
			for(UserBean u:list)
				{
					 xa=u.getEmailid();
				}	
		}	
		
		System.out.println("designation is "+xa );
		
			}
	catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(e);
			}
	return xa;

	

	
}
public List<AllocatedAssetsBean> Fetchassetdata(int userid)
{
	
	int x=0;	
	 
	ArrayList <AllocatedAssetsBean> list2= new ArrayList<>();
	
		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();		
		Session ss=sf.openSession();
		/*Transaction tx1=ss.beginTransaction();
		String hql = "FROM AllocatedAssetsBean where userid=:a ";
		
		Query query = ss.createQuery(hql);
		query.setInteger("a", userid);
		
		List list = query.list();
		Iterator it =list.iterator();*/
		
		Transaction tx1=ss.beginTransaction();
		
		Criteria ct=ss.createCriteria(AllocatedAssetsBean.class);		
		
		ct.add(Restrictions.eq("userid",userid));
		List<AllocatedAssetsBean> list=ct.list();
		
		
		/*while(it.hasNext()){
			AllocatedAssetsBean ab= new AllocatedAssetsBean();
			ab.setAssetname((String)(it.next()));
			list2.add(ab);
		}
		*/
		/*Criteria ct = ss.createCriteria(AllocatedAssetsBean.class);
		ct.add(Restrictions.eq("userid", userid ));
		System.out.println("employeemodel--->fetchassetdta--->uid"+userid);
	   ct.add(Restrictions.eq("assetname",  "assetname" ));*/
		/*List<AllocatedAssetsBean>list=(List<AllocatedAssetsBean>)query.list();*/
	  
		tx1.commit();
		ss.close();
		return list;
	
		
	}


public List<AllocatedAssetsBean> FetchassetdataToTransfer(int userid)
{
	
	int x=0;	
	 
	ArrayList <AllocatedAssetsBean> list2= new ArrayList<>();
	
		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();		
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
		String hql = "select assetid FROM AllocatedAssetsBean where userid=:a ";
		
		Query query = ss.createQuery(hql);
		query.setInteger("a", userid);
		List list = query.list();
		Iterator it =list.iterator();
		while(it.hasNext()){
			AllocatedAssetsBean ab= new AllocatedAssetsBean();
			ab.setAssetname((String)(it.next()));
			list2.add(ab);
		}
		
		/*Criteria ct = ss.createCriteria(AllocatedAssetsBean.class);
		ct.add(Restrictions.eq("userid", userid ));
		System.out.println("employeemodel--->fetchassetdta--->uid"+userid);
	   ct.add(Restrictions.eq("assetname",  "assetname" ));*/
		/*List<AllocatedAssetsBean>list=(List<AllocatedAssetsBean>)query.list();*/
	  
		tx1.commit();
		ss.close();
		return list2;
	
		
	}

public String EmpgetMyOldPassword(int employee_id)
{	
		String password=null;
		try
		{
			System.out.println("Model mai Password checking chala.......");
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();				
			
			Criteria ct=ss.createCriteria(UserBean.class);		
			ct.add(Restrictions.eq("employeeid",employee_id));
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



public int empchangepwd(int employee_id,String password)
{
	int x=0;

	try
	{
		
		
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
			Query q=ss.createQuery("update UserBean set password=:a where employeeid=:b and designation=:c");
			q.setString("a",password);
			q.setInteger("b",employee_id);
			q.setString("c","employee");		
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

public int mobilecheckajax(int employee_id, String mobile)
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
			else if (!list.isEmpty())
			{	
				for(UserBean ub:list)
				{
					if(ub.getDesignation().equals("employee")&& ub.getEmployeeid()== employee_id)
							{
								x=0;
							}
					
					else
						x=1;
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>"+mobile);
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


public int emailcheckajax(int employee_id, String email)
{	
int x=0;
		try
		{
			
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();				
			
			Criteria ct=ss.createCriteria(UserBean.class);		
			ct.add(Restrictions.eq("emailid",email));
			
			List<UserBean> list=ct.list();
			
			System.out.println("model me email a raha hai"+email);
			System.out.println(">>>>>>>>>>>"+list);
			if(list.isEmpty())
			{
				x=0;
				
			}
			else if (!list.isEmpty())
			{	
				for(UserBean ub:list)
				{
					if(ub.getDesignation().equals("employee")&& ub.getEmployeeid()== employee_id)
							{
								x=0;
							}
					
					else
						x=1;
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@"+email);
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




public int trasferassetrequest(AssetTransferBean ub)
{
	int x=0;
	
		
		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
		
		Session ss=sf.openSession();
		
		 Transaction tt = ss.beginTransaction();
		 
		 System.out.println(ub.toString());
		ss.save(ub);
		
			x=1;
	  tt.commit();
	  ss.close();
	
	  return x;
}


}

