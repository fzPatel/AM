package MokitTesting;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.asset_management.beans.AdminBean;
import com.asset_management.beans.RequestBean;
import com.asset_management.beans.UserBean;
import com.asset_management.models.AdminModel;
import com.asset_management.models.ManagerModel;
import junit.framework.Assert;

public class ManagerModelMockitoTesting {

	AdminModel am;
	ManagerModel m;
	AdminBean ab;
	UserBean ub;
	Object o;

	@Before
	public void setUp()
	{
		am=mock(AdminModel.class);
		ab=mock(AdminBean.class);
		m=mock(ManagerModel.class);
		ub=mock(UserBean.class);
	}
	
	@Test
	public void login()
	{
		UserBean ub=new UserBean();
		when(m.ViewProfile_Manager(101)).thenReturn(ub);
	    Assert.assertEquals(m.ViewProfile_Manager(101),ub);
	}
	

	@Test
	public void UpdateProfile_Manager()
	{
		
		UserBean ub=new UserBean();
		ub.setFirstname("ahad");
		ub.setLastname("patel");
		ub.setEmailid("abc@gmail.com");
		ub.setMobile("9827213352");
	
		when(m.UpdateProfile_Manager(ub,201)).thenReturn(1);
	    Assert.assertEquals(m.UpdateProfile_Manager(ub,201),1);
	}
	
	
	
	@Test
	public void submitRequest()
	{
		Object ob=new Object();
		RequestBean rb=new RequestBean();
		rb.setManagerid(201);
		rb.setAssetname("mobile");
		rb.setRequestdate("08-12-2017");
		rb.setEmailid("firozpatel3210@gmail.com");
		rb.setSupportid(201);
		int status=3;
		String designation="manager";
		rb.setStatus(status);
		rb.setDesignation(designation);

		when(m.submitRequest(rb)).thenReturn(ob);
	    Assert.assertEquals(m.submitRequest(rb),ob);
	}
	
	
	
	@Test
	public void View_PerticularId()
	{
		UserBean ub=new UserBean();
		when(m.View_PerticularId(201,"manager")).thenReturn(ub);
	    Assert.assertEquals(m.View_PerticularId(201,"manager"),ub);
	}
	
	
	@Test
	public void Manager_viewMyrequest()
	{
		when(m.Manager_viewMyrequest(201)).thenReturn(new java.util.ArrayList());
	    Assert.assertEquals(m.Manager_viewMyrequest(201),new java.util.ArrayList());
	}
	
	
	
	
	@Test
	public void Manager_viewMyAsset()
	{
		when(m.Manager_viewMyAsset(201)).thenReturn(new java.util.ArrayList());
	    Assert.assertEquals(m.Manager_viewMyrequest(201),new java.util.ArrayList());
	}
	
	
	
	@Test
	public void view_assetRequestByEmp()
	{
		when(m.view_assetRequestByEmp(201)).thenReturn(new java.util.ArrayList());
	    Assert.assertEquals(m.view_assetRequestByEmp(201),new java.util.ArrayList());
	}

	
	@Test
	public void approve()
	{
		
		when(m.approve(101,"08-12-2017",1)).thenReturn(1);
	    Assert.assertEquals(m.approve(101,"08-12-2017",1),1);
	}
	@Test
	public void reject()
	{
		
		when(m.reject(101,"08-12-2017",1)).thenReturn(1);
	    Assert.assertEquals(m.reject(101,"08-12-2017",1),1);
	}
	
	@Test
	public void changepwd()
	{
		
		when(m.changepwd(201,"123")).thenReturn(0);
	    Assert.assertEquals(m.changepwd(101,"123"),0);
	}
	
	
	
	@Test
	public void getMyOldPassword()
	{
		when(m.getMyOldPassword("123",201)).thenReturn(1);
	    Assert.assertEquals(m.getMyOldPassword("123",201),1);
	}
	
	

	@Test
	public void manager_viewAssetTransferReq()
	{
		when(m.manager_viewAssetTransferReq(201)).thenReturn(new java.util.ArrayList());
	    Assert.assertEquals(m.manager_viewAssetTransferReq(201),new java.util.ArrayList());
	}
	
	
	
	@Test
	public void checkemailifexist()
	{
		
		when(m.checkemailifexist("abc@gmail.com",201)).thenReturn(1);
	    Assert.assertEquals(m.checkemailifexist("abc@gmail.com",201),1);
	}
	
	@Test
	public void checkmobileifexist()
	{
		
		when(m.checkmobileifexist("9752165945",201)).thenReturn(1);
	    Assert.assertEquals(m.checkmobileifexist("9752165945",201),1);
	}
	
	
	
	@Test
	public void approveAssetTransfer()
	{
		
		when(m.approveAssetTransfer(101,"21-10-2017",102,201,1)).thenReturn(1);
	    Assert.assertEquals(m.approveAssetTransfer(101,"21-10-2017",102,201,1),1);
	}
	
	
	@Test
	public void rejectAssetTransfer()
	{
		
		when(m.rejectAssetTransfer(101,"21-10-2017",102,201)).thenReturn(1);
	    Assert.assertEquals(m.rejectAssetTransfer(101,"21-10-2017",102,1),1);
	}
	
	
	
	@Test
	public void viewallcatedasset()
	{
		when(m.viewallcatedasset()).thenReturn(new java.util.ArrayList());
	    Assert.assertEquals(m.viewallcatedasset(),new java.util.ArrayList());
	}
	
	
	
	@Test
	public void getAssettransferRequest()
	{
		when(m.getAssettransferRequest()).thenReturn(1);
	    Assert.assertEquals(m.getAssettransferRequest(),1);
	}
	
	
	
	@Test
	public void updateIdafterTransfer()
	{
		
		when(m.updateIdafterTransfer(101,102,1,201,11)).thenReturn(1);
	    Assert.assertEquals(m.updateIdafterTransfer(101,102,1,201,11),1);
	}
	
	
	
}
