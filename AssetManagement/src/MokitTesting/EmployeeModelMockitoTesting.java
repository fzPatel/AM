package MokitTesting;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.asset_management.beans.AdminBean;
import com.asset_management.beans.AssetTransferBean;
import com.asset_management.beans.RequestBean;
import com.asset_management.beans.UserBean;
import com.asset_management.models.AdminModel;
import com.asset_management.models.EmployeeModel;

import junit.framework.Assert;
public class EmployeeModelMockitoTesting 

{
EmployeeModel em;

@Before
public void setUp()
{
	em=mock(EmployeeModel.class);
	em=mock(EmployeeModel.class);
}
@Test
public void createrequest()
{
	
	RequestBean rb=new RequestBean();
    rb.setEmployeeid(111);
	rb.setManagerid(201);
	rb.setAssetname("Laptop");
	rb.setRequestdate("08-12-2017");
	rb.setEmailid("firozpatel3210@gmail.com");
    rb.setDesignation("employee");
	
    when(em.createrequest(rb)).thenReturn(1);
    Assert.assertEquals(em.createrequest(rb),1);
}
@Test
public void myasset()
{
	when(em.myasset(201, "wkhan0419@gmail.com")).thenReturn(new java.util.ArrayList());
    Assert.assertEquals(em.myasset(201, "wkhan0419@gmail.com"),new java.util.ArrayList());
}
@Test
public void myassetofemp()
{
	when(em.myassetofemp()).thenReturn(new java.util.ArrayList());
    Assert.assertEquals(em.myassetofemp(),new java.util.ArrayList());
}
@Test
public void viewprofile()
{
	when(em.viewprofile(101)).thenReturn(new java.util.ArrayList());
    Assert.assertEquals(em.viewprofile(101),new java.util.ArrayList());
}
@Test
public void Viewrequest()
{
	when(em.Viewrequest(101)).thenReturn(new java.util.ArrayList());
    Assert.assertEquals(em.Viewrequest(101),new java.util.ArrayList());
}

@Test
public void update_profile()
{
	

	when(em.update_profile(101, "waqas", "khan", "wkhan0419@gmail.com", "9752172833")).thenReturn(1);
	  Assert.assertEquals(em.update_profile(101, "waqas", "khan", "wkhan0419@gmail.com", "9752172833"),1);
}
@Test
public void changepwds()
{
	

	when(em.changepwds("111", "111", 123)).thenReturn(1);
	  Assert.assertEquals(em.changepwds("111", "111", 123),1);
}
@Test
public void View_PerticularId()
{
	when(em.View_PerticularId(101, "employee")).thenReturn(1);
    Assert.assertEquals(em.View_PerticularId(101, "employee"),1);
}
@Test
public void get_Perticulardesignation()
{
	String s= "";
	when(em.get_Perticulardesignation(101, "employee")).thenReturn(s);
    Assert.assertEquals(em.get_Perticulardesignation(101, "employee"),s);
}
@Test
public void Fetchassetdata()
{
	when(em.Fetchassetdata(101)).thenReturn(new java.util.ArrayList());
    Assert.assertEquals(em.Fetchassetdata(101),new java.util.ArrayList());
}
@Test
public void FetchassetdataToTransfer()
{
	when(em.FetchassetdataToTransfer(101)).thenReturn(new java.util.ArrayList());
    Assert.assertEquals(em.FetchassetdataToTransfer(101),new java.util.ArrayList());
}
@Test
public void EmpgetMyOldPassword()
{
	String s= "";
	when(em.EmpgetMyOldPassword(101)).thenReturn(s);
    Assert.assertEquals(em.EmpgetMyOldPassword(101),s);
}
@Test
public void empchangepwd()
{
	when(em.empchangepwd(101, "123")).thenReturn(1);
    Assert.assertEquals(em.empchangepwd(101, "123"),1);
}
@Test
public void mobilecheckajax()
{
	when(em.mobilecheckajax(101, "8103331059")).thenReturn(1);
    Assert.assertEquals(em.mobilecheckajax(101, "8103331059"),1);
}
@Test
public void emailcheckajax()
{
	when(em.emailcheckajax(101, "wkhan0419@gmail.com")).thenReturn(1);
    Assert.assertEquals(em.emailcheckajax(101, "wkhan0419@gmail.com"),1);
}
@Test
public void trasferassetrequest()
{
	AssetTransferBean ub = new AssetTransferBean ();
	ub.setTransferid(1);
	ub.setToempid(102);
	ub.setManagerid(400);
	ub.setFromempid(101);
	
	ub.setAssetname("Laptop");
	ub.setTransferrequestdate("2017-11-02");
	ub.setTransferstatus(0);

	when(em.trasferassetrequest(ub)).thenReturn(1);
	  Assert.assertEquals(em.trasferassetrequest(ub),1);
}
@Test
public void viewallEmpmyasset()
{
	when(em.viewallEmpmyasset()).thenReturn(new java.util.ArrayList());
    Assert.assertEquals(em.viewallEmpmyasset(),new java.util.ArrayList());
}
@Test
public void viewOtherEmpassetRequest()
{
	when(em.viewOtherEmpassetRequest(101)).thenReturn(new java.util.ArrayList());
    Assert.assertEquals(em.viewOtherEmpassetRequest(101),new java.util.ArrayList());
}
@Test
public void empviewAseetrequestByMe()
{
	when(em.empviewAseetrequestByMe(101, 400)).thenReturn(new java.util.ArrayList());
    Assert.assertEquals(em.empviewAseetrequestByMe(101, 400),new java.util.ArrayList());
}
@Test
public void empviewAseetrequestByOtherEmp()
{
	when(em.empviewAseetrequestByOtherEmp(101)).thenReturn(new java.util.ArrayList());
    Assert.assertEquals(em.empviewAseetrequestByOtherEmp(101),new java.util.ArrayList());
}
@Test
public void requesttomanagerforapprove()
{
	when(em.requesttomanagerforapprove(101, 400, 1, 1)).thenReturn(1);
    Assert.assertEquals(em.requesttomanagerforapprove(101, 400, 1, 1),1);
}
@Test
public void requestbymanagertoempforasset()
{
	when(em.requestbymanagertoempforasset(101, 3, 1, 6)).thenReturn(1);
    Assert.assertEquals(em.requestbymanagertoempforasset(101, 3, 1, 6),1);
}
@Test
public void approveAssetTransferRequest()
{
	when(em.approveAssetTransferRequest(101, "2017-11-02", 3, 400, 6)).thenReturn(1);
    Assert.assertEquals(em.approveAssetTransferRequest(101, "2017-11-02", 3, 400, 6),1);
}
@Test
public void updateintoallocatedasset()
{

	when(em.updateintoallocatedasset(101, 102, 1)).thenReturn(1);
	  Assert.assertEquals(em.updateintoallocatedasset(101,102, 1),1);
}
@Test
public void deleteassetswhenapproved()
{
	

	when(em.deleteassetswhenapproved(3)).thenReturn(1);
	  Assert.assertEquals(em.deleteassetswhenapproved(3),1);
}
@Test
public void rejectAssetTransfer()
{
	

	when(em.rejectAssetTransfer(101, "2017-11-02", 3,400)).thenReturn(1);
	  Assert.assertEquals(em.rejectAssetTransfer(101, "2017-11-02",3, 400),1);
}
}
