package com.asset_management.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.Id;

import org.hibernate.Criteria;
import org.hibernate.Query;
import javax.mail.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;
import com.asset_management.beans.AdminBean;
import com.asset_management.beans.UserBean;
import com.asset_management.mail.Email;



public class AdminModel {
	
	
	
	
	public int adminLoginCheck(AdminBean ab)
	{
		int x=0;
		
		
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		org.hibernate.Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
		

		
		System.out.println(ab.getEmailid());
		System.out.println(ab.getPassword());
		Criteria ct=ss.createCriteria(AdminBean.class);
		
		
		ct.add(Restrictions.eq("emailid",ab.getEmailid()));
		ct.add(Restrictions.eq("password",ab.getPassword()));
		
		
		List<AdminBean> list=ct.list();
		if(list.isEmpty())
		{
			
			System.out.println("Logion failllll");
		}
		else
			x=1;
		
		
		tx1.commit();
		ss.close();
		return x;
	}
	
	
	
	
	
	
	public Object insertUser(UserBean ub)
	{
		Integer x=0;
		
		Object o=null;
		
		UserBean ub1=null;
		String firstname=ub.getFirstname();
		String lastname=ub.getLastname();
		String emailid=ub.getEmailid();
		String password=ub.getPassword();
		int managerid=ub.getNewmanagerid();
		String designation=ub.getDesignation();
		int employeeid=ub.getNewemployeeid();
		String mobile=ub.getMobile();
		String dateofjoining=ub.getDateofjoining();
		int supportid=ub.getNewsupportid();
		
		int supportid1=ub.getSupportid();
		int managerid1=ub.getManagerid();
		System.out.println("Testing admminModel ------> insertuser()----->managerid="+ub.getManagerid());
		
		try
		{
		
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			org.hibernate.Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
			
			if(designation.equals("employee"))
			{

				ub1=new UserBean();
				
				ub1.setFirstname(firstname);
				ub1.setLastname(lastname);
				ub1.setEmailid(emailid);
				ub1.setPassword(password);
				ub1.setEmployeeid(employeeid);
				ub1.setDesignation(designation);
				ub1.setMobile(mobile);
				ub1.setManagerid(managerid1);
				System.out.println("managerid1 in Admin Model----->insertUser---->"+managerid1);
				ub1.setSupportid(0);
				ub1.setDateofjoining(dateofjoining);
				ub1.setStatus("A");
				ub1.setUserid(employeeid);
				System.out.println("employeeid ="+employeeid);
				
	
			}
			
				
				
			else if(designation.equals("manager"))
			{

				ub1=new UserBean();
			ub1.setFirstname(firstname);
			ub1.setLastname(lastname);
			ub1.setEmailid(emailid);
			ub1.setPassword(password);
			ub1.setSupportid(supportid1);
			ub1.setDesignation(designation);
			ub1.setMobile(mobile);
			ub1.setManagerid(managerid);
			ub1.setEmployeeid(0);
			ub1.setDateofjoining(dateofjoining);
			ub1.setStatus("A");
			ub1.setUserid(managerid);
			
			
			}
			
			
			else if(designation.equals("support"))
			{	

				ub1=new UserBean();
				ub1.setFirstname(firstname);
				ub1.setLastname(lastname);
				ub1.setEmailid(emailid);
				ub1.setPassword(password);
				ub1.setSupportid(supportid);
				ub1.setDesignation(designation);
				ub1.setMobile(mobile);		
				ub1.setDateofjoining(dateofjoining);
				ub1.setEmployeeid(0);
				ub1.setManagerid(0);				
				ub1.setStatus("A");
				ub1.setUserid(supportid);
	
			}
			
			
			
		
//			if(designation.equals("employee"))
	//			{
////					if(ub.getEmployeeid()==0)
////					{
////						ub1.setEmployeeid(ub.getEmployeeid());
////					}
////					else if(ab.getNewemployeeid()==0)
////					{
////						ps.setInt(5,ab.getEmployeeid());
////					}
////					ps.setString(6,ab.getDesignation());
////					ps.setString(7,ab.getMobile());
////					ps.setInt(8, ab.getManagerid());
////					ps.setString(9,ab.getDateofjoining());
////				}
////				else if(designation.equals("manager"))
////				{
////					if(ab.getManagerid()==0)
////					{
////						ps.setInt(5,ab.getNewmanagerid());
////					}
////					if(ab.getNewmanagerid()==0)
////					{
////						ps.setInt(5,ab.getManagerid());
////					}
////					ps.setString(6,ab.getDesignation());
////					ps.setString(7,ab.getMobile());
////					ps.setInt(8, ab.getSupportid());
////					ps.setString(9,ab.getDateofjoining());
////				}
////				else if(designation.equals("support"))
////					{
////					ps.setInt(5,ab.getNewsupportid());
////					ps.setString(6,ab.getDesignation());
////					ps.setString(7,ab.getMobile());
////					ps.setString(8,ab.getDateofjoining());
////					}
////				
////			
//			
////			x=ps.executeUpdate();
////			if(ab.getDesignation().equals("support"))
////				sendMail(ab.getEmailid(),ab.getPassword(),ab.getNewsupportid(),ab.getDesignation());
////			else if(ab.getDesignation().equals("employee"))
////				sendMail(ab.getEmailid(),ab.getPassword(),ab.getNewemployeeid(),ab.getDesignation());
////			else if(ab.getDesignation().equals("manager"))
////				sendMail(ab.getEmailid(),ab.getPassword(),ab.getNewmanagerid(),ab.getDesignation());
	
		
	
			
		
		o=ss.save(ub1);
		
		tx1.commit();
		ss.close();
		
		Email e=new Email();
		
		if(designation.equals("employee"))
		{
				int userid=	ub1.getEmployeeid();
				String 	Password=ub1.getPassword();
					String email=	ub1.getEmailid();
						designation="employee";
								
						
						System.out.println("inside Emplyee for mail"+userid);
						System.out.println("inside Emplyee for mail"+password);
						System.out.println("inside Emplyee for mail"+email);
						System.out.println("inside Emplyee for mail"+designation);


						
			e.sendMail(userid,Password,designation,email);
			
		}
		else if(designation.equals("manager"))
		{
			
			
			int userid=	ub1.getManagerid();
			String 	Password=ub1.getPassword();
				String email=	ub1.getEmailid();
					designation="manager";

					System.out.println("inside Emplyee for mail"+userid);
					System.out.println("inside Emplyee for mail"+password);
					System.out.println("inside Emplyee for mail"+email);
					System.out.println("inside Emplyee for mail"+designation);

		
			e.sendMail(userid,Password,designation,email);
		}
		
		
		else if(designation.equals("support"))
		{
			
			int userid=	ub1.getSupportid();
			String 	Password=ub1.getPassword();
				String email=	ub1.getEmailid();
					designation="manager";
									
		
					
					System.out.println("inside support");

					System.out.println("inside support" +userid);
					System.out.println("inside support"+Password);
					System.out.println("inside support"+designation);
					
			e.sendMail(userid,Password,designation,email);
			
		}
		
		
		}
		catch(Exception e)
		{e.printStackTrace();}
		
		return o;
	}
	
	
	

	public ArrayList<UserBean> retriveAllUsers()
	{
		ArrayList<UserBean> al=new ArrayList<UserBean>();		
		try
		{			
			
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			org.hibernate.Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
		
			Criteria ct=ss.createCriteria(UserBean.class);		
			
			List<UserBean> list=ct.list();
			if(list.isEmpty())
			{
				
				System.out.println("No Data Found!!!!");
			}
			else
			{
				
					for(UserBean u:list)
					{
						
						UserBean ub=new UserBean();
						ub.setFirstname(u.getFirstname());
						ub.setLastname(u.getLastname());
//						System.out.println(u.getFirstname()+"   "+u.getLastname());
						ub.setEmailid(u.getEmailid());
						ub.setManagerid(u.getManagerid());
						ub.setDesignation(u.getDesignation());
						ub.setEmployeeid(u.getEmployeeid());
						ub.setMobile(u.getMobile());				
						ub.setDateofjoining(u.getDateofjoining());
						ub.setStatus(u.getStatus());
						ub.setSupportid(u.getSupportid());
						ub.setAuto(u.getAuto());
						al.add(ub);
						
						
					}
					
					
			}	
				}
				catch(Exception e)
				{e.printStackTrace();}
		
		return al;

	}

	
	
	public UserBean retriveUser(String emailid)
	{
		UserBean ub=new UserBean();
		try
		{			
			
			
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			org.hibernate.Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
		
			Criteria ct=ss.createCriteria(UserBean.class);		
			
			ct.add(Restrictions.eq("emailid",emailid));

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

	
	
	

	
	public int update_single_user(UserBean ub)
	{
		
		int x=0;
		try
		{
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			org.hibernate.Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
			Query q=ss.createQuery("update UserBean set firstname=:a,lastname=:b,emailid=:c,managerid=:d,designation=:e,employeeid=:f,mobile=:g,dateofjoining=:h,status=:i,supportid=:j where emailid=:k");
			q.setString("a",ub.getFirstname() );
			q.setString("b",ub.getLastname());
			q.setString("c",ub.getEmailid());
			q.setInteger("d",ub.getManagerid());
			q.setString("e",ub.getDesignation());
			q.setInteger("f",ub.getEmployeeid());
			q.setString("g",ub.getMobile());
			q.setString("h",ub.getDateofjoining());
			q.setString("i",ub.getStatus().trim());
			q.setInteger("j",ub.getSupportid());
			q.setString("k",ub.getEmailid());
			
			x=q.executeUpdate();
			System.out.println("xxxxxxxx=======>"+x);
			tx1.commit();
			ss.close();
				
		}
		catch(Exception e)
		{e.printStackTrace();}
		return x;
				
	}
	
	
	
	
	
	
	
	
	
	
	public int active(String emailid)
	{
	
		int x=0;
		try
		{
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			org.hibernate.Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
			Query q=ss.createQuery("update UserBean set status=:a where emailid=:b");
			q.setString("a","A" );
			q.setString("b",emailid);
			x=q.executeUpdate();
			System.out.println("xxxxxxxx=======>"+x);
			tx1.commit();
			ss.close();
				
		}
		catch(Exception e)
		{e.printStackTrace();}
		return x;

	}
	
	
	
	
	public int deactive(String emailid)
	{
		int x=0;
		try
		{
			
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			org.hibernate.Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
			Query q=ss.createQuery("update UserBean set status=:a where emailid=:b");
			q.setString("a","D" );
			q.setString("b",emailid);			
			x=q.executeUpdate();	
			tx1.commit();
			ss.close();
		}
		catch(Exception e)
		{e.printStackTrace();}
		return x;

	}
	public int updateNewPassword(String emailid,String password)
	{
		int x=0;
	
		try
		{
						


			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			org.hibernate.Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
			Query q=ss.createQuery("update AdminBean set password=:a where emailid=:b");
			q.setString("a",password);
			q.setString("b",emailid);
			
			x=q.executeUpdate();	
			tx1.commit();
			ss.close();
	
		}
		catch(Exception e)
		{e.printStackTrace();}
		
		return x;
	}
	
	
	
	
//	------------------04/november/2017--------------
	
	
	
	public ArrayList<Integer> retriveManagerIds()
	{
		
		UserBean ab=null;
		ArrayList<Integer> al=new ArrayList<Integer>();
		try
		{
			
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			org.hibernate.Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
	
			Criteria ct=ss.createCriteria(UserBean.class);		
			ct.add(Restrictions.eq("designation","manager"));
			List<UserBean> list=ct.list();
			System.out.println("list.size()---->Manager ki list="+list.size());
			
			if(list.isEmpty())
			{}
			else
			{
				for(UserBean u:list)
				{
					al.add(u.getManagerid());
					System.out.println("Fetching Manager id"+u.getManagerid());


				}
			}	
		}
		catch(Exception e)
		{e.printStackTrace();}
		return al;
	}
	
	
	
	public ArrayList<Integer> retriveSupportIds()
	{

		AdminBean ab=null;
		ArrayList<Integer> al=new ArrayList<Integer>();
		try
		{
			
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			org.hibernate.Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
		
			 /*Query q = ss.createQuery("select distinct(supportid) from UserBean");	
			List<UserBean> list=q.list();*/
			
			
			Criteria ct=ss.createCriteria(UserBean.class);		
			ct.add(Restrictions.eq("designation","support"));
			List<UserBean> list=ct.list();
			System.out.println("list.size()---->Support ki list="+list.size());
			
			if(list.isEmpty())
			{}
			else
			{
				for(UserBean u:list)
				{
					al.add(u.getSupportid());
					System.out.println("Fetching support id"+u.getSupportid());


				}
			}	
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return al;
	}
	


	
	
	
	

public int getMyOldPassword(String oldpassword,String emailid)
{	
		int x=0;
		try
		{
			System.out.println("Model mai Password checking chala.......");
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			org.hibernate.Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();			
			
			Criteria ct=ss.createCriteria(AdminBean.class);
			ct.add(Restrictions.eq("password",oldpassword));
			ct.add(Restrictions.eq("emailid",emailid));

			List<UserBean> list=ct.list();
			
			if(list.isEmpty())
			{
				x=0;
				
			}
			else if(!list.isEmpty())
			{
				x=1;
			}
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
