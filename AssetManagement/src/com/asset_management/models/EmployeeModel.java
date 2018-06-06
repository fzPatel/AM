package com.asset_management.models;

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




public List<AllocatedAssetsBean> viewallEmpmyasset()
{
	
		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();

	

		Criteria ct = ss.createCriteria(AllocatedAssetsBean.class);	
		
	    List<AllocatedAssetsBean>list=ct.list();
	    if(!list.isEmpty())
	   {
		   System.out.println("not Empty");
	   }
	     
	    
	   ss.close();
		return list;
	
		
	}




public List<AssetTransferBean> viewOtherEmpassetRequest(int employeeid)
{
	
		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();

		 System.out.println(employeeid);

		Criteria ct = ss.createCriteria(AssetTransferBean.class);	
		ct.add(Restrictions.eq("toempid",employeeid));

		
		
	    List<AssetTransferBean>list=ct.list();
	    if(!list.isEmpty())
	   {
		   System.out.println("not Empty");
	   }
	     
	    
	   ss.close();
		return list;
	
		
	}




public ArrayList<AssetTransferBean> empviewAseetrequestByMe(int employee_id, int manager_id)
{
	ArrayList<AssetTransferBean> al=new ArrayList<AssetTransferBean>();
	try
	{		
		System.out.println(manager_id);
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
	
		Criteria ct=ss.createCriteria(AssetTransferBean.class);		
		ct.add(Restrictions.eq("toempid",employee_id));	
		ct.add(Restrictions.eq("fromempid",manager_id));	

		List<AssetTransferBean> list=ct.list();
		
		if(list.isEmpty())
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
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(e);
			}


return al;
	
}





public ArrayList<AssetTransferBean> empviewAseetrequestByOtherEmp(int employee_id)
{
	ArrayList<AssetTransferBean> al=new ArrayList<AssetTransferBean>();
	try
	{		
		
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
		
		Criteria ct=ss.createCriteria(AssetTransferBean.class);		
		ct.add(Restrictions.eq("toempid",employee_id));

		List<AssetTransferBean> list=ct.list();
		
		if(list.isEmpty())
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
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(e);
			}


return al;
	
}








public int requesttomanagerforapprove(int employee_id,int manager_id,int tranferid,int assetid)
{
	int x=0;

	try
	{
		
		
		System.out.println(employee_id+assetid+"managerid"+manager_id+tranferid);
		
		
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
			Query q=ss.createQuery("update AssetTransferBean set transferstatus=:a,managerid=:c where toempid=:b and assetid=:d and transferid=:e");
			q.setInteger("a",2);
			q.setInteger("c",manager_id);
			q.setInteger("b",employee_id);
			q.setInteger("d",tranferid);
			q.setInteger("e",assetid);
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



public int requestbymanagertoempforasset(int employee_id,int tranferid,int assetid,int transferstatus)
{
	int x=0;

	try
	{
		
		System.out.println("aaaaa gya re model me");
		System.out.println(employee_id+assetid+"managerid"+tranferid);
		
		
			SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
			Session ss=sf.openSession();
			Transaction tx1=ss.beginTransaction();
			Query q=ss.createQuery("update AssetTransferBean set transferstatus=:a, where toempid=:b and assetid=:c and transferid=:d");
			q.setInteger("a",2);
			q.setInteger("b",employee_id);
			
			q.setInteger("c",assetid);
			q.setInteger("d",tranferid);
	
			x=q.executeUpdate();
			System.out.println("modelpe=======>"+x);
			tx1.commit(); 
			ss.close();
				
		}
		catch(Exception e)
		{e.printStackTrace();
		
		
		}
		
		return x;
				
	}
public int approveAssetTransferRequest(int fromempid,String approve_date,int transferid,int manager_id,int statusinsert)
{
	
	int x=0;

	System.out.println("fromempid>>>>>>>>>>"+fromempid);
	System.out.println("approve_date>>>>>>>>>"+approve_date);
	System.out.println("transferid>>>>>>"+transferid);
	System.out.println("statusinsert>>>>>>>>>>>"+statusinsert);
	System.out.println("manager_id>>>>>>>>>>>"+manager_id);

	try
	{
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
		Query q=ss.createQuery("update AssetTransferBean set transferstatus=:a, transferdate=:b where fromempid=:c and transferid=:d and managerid=:e ");
		
		q.setInteger("a",6);
		q.setString("b",approve_date);
		q.setInteger("c",fromempid);
		q.setInteger("d",transferid);
		q.setInteger("e",manager_id);

		
		x=q.executeUpdate();
		tx1.commit();
		ss.close();
			
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return x;
			
}

public int updateintoallocatedasset(int employeeid,int fromempid,int assetid)
{		
	int x=0;

	
	System.out.println("employeeid"+employeeid+"fromempid"+fromempid+"assetid"+assetid);
	System.out.println(">>>>>>>>123<<<<<<<<<<"+employeeid+fromempid);
	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
	Session ss=sf.openSession();
	Transaction tx1=ss.beginTransaction();
		
		Query q=ss.createQuery("update AllocatedAssetsBean set userid=:a where userid=:b and assetid=:c");
		
		q.setInteger("a",fromempid);
		q.setInteger("b",employeeid);
		q.setInteger("c",assetid);
		///int result = query.executeUpdate();
		
		x=q.executeUpdate();
		System.out.println("model ke>>>andar "+x);
		
		tx1.commit();
		ss.close();
		

	return x;
}



public int deleteassetswhenapproved(int transferid)
{		
	int x=0;


	System.out.println(">>>>>>>>123<<<<<<<<<<"+transferid);
	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
	Session ss=sf.openSession();
	Transaction tx1=ss.beginTransaction();
//	 String hql = "delete from Product where name = :name";
		Query q=ss.createQuery("Delete from  AssetTransferBean where transferid=:a");
		
		q.setInteger("a",transferid);
		
		///int result = query.executeUpdate();
		
		x=q.executeUpdate();
		System.out.println("model ke>>>andar "+x);
		
		tx1.commit();
		ss.close();
		

	return x;
}
//------------------------Reject  by manager------------------
public int rejectAssetTransfer(int fromempid,String reject_date,int transferid,int manager_id)
{
int x=0;
	try
{
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction tx1=ss.beginTransaction();
		Query q=ss.createQuery("update AssetTransferBean set transferstatus=:a, transferdate=:b where fromempid=:c and transferid=:d and managerid=:e ");
		
		q.setString("a","7");
		q.setString("b",reject_date);
		q.setInteger("c",fromempid);
		
		q.setInteger("d",transferid);
		q.setInteger("e",manager_id);
	
		x=q.executeUpdate();
		tx1.commit();
		ss.close();
			
	}
	catch(Exception e)
	{e.printStackTrace();
	
	
	}
	return x;
			
}


}