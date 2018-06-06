package MokitTesting;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.Before;

import com.asset_management.beans.AdminBean;
import com.asset_management.beans.AllocatedAssetsBean;
import com.asset_management.beans.RequestBean;
import com.asset_management.beans.UserBean;
import com.asset_management.models.SupportModel;

import junit.framework.Assert;


public class SupportModelMockitoTesting {
	
	SupportModel sm;
	ArrayList<RequestBean> al;
	ArrayList<AllocatedAssetsBean> al1;
	@Before
	public void setUp()
	{
		sm=mock(SupportModel.class);		
	}
	
	
	@org.junit.Test
	public void	retriveRequests()throws Exception
	{
		org.mockito.Mockito.when(sm.retriveRequests("101")).thenReturn(new java.util.ArrayList());
		Assert.assertEquals(sm.retriveRequests("101"),new java.util.ArrayList());
	}
	
	
	@org.junit.Test
	public void	approve()throws Exception
	{
		org.mockito.Mockito.when(sm.approve(101,1)).thenReturn(1);
		Assert.assertEquals(sm.approve(101,1),1);
	}
	
	
	@org.junit.Test
	public void	insert()throws Exception
	{
		org.mockito.Mockito.when(sm.insert(101,"Mouse","01/10/2017",301,"adarshbatham@gmail.com")).thenReturn(1);
		Assert.assertEquals(sm.insert(101,"Mouse","01/10/2017",301,"adarshbatham@gmail.com"),1);
	}
	
	
	@org.junit.Test
	public void	cancelRequest()throws Exception
	{
		org.mockito.Mockito.when(sm.cancelRequest(301,201,1)).thenReturn(1);
		Assert.assertEquals(sm.cancelRequest(301,201,1),1);
	}
	
	
	
	@org.junit.Test
	public void	retriveReports()throws Exception
	{
		org.mockito.Mockito.when(sm.retriveReports()).thenReturn(al1);
		Assert.assertEquals(sm.retriveReports(),al1);
	}
	
	
	@org.junit.Test
	public void	updateNewPassword()throws Exception
	{
		org.mockito.Mockito.when(sm.updateNewPassword(301,"302","support")).thenReturn(1);
		Assert.assertEquals(sm.updateNewPassword(301,"302","support"),1);
	}
	
	
	
	@org.junit.Test
	public void	checkExistanceOfSupportPassword()throws Exception
	{
		String s="301";
		org.mockito.Mockito.when(sm.checkExistanceOfSupportPassword(301)).thenReturn("301");
		Assert.assertEquals(sm.checkExistanceOfSupportPassword(301),"301");
	}
	
	
	@org.junit.Test
	public void	retriveSupportDetails()throws Exception
	{	
		org.mockito.Mockito.when(sm.retriveSupportDetails(301)).thenReturn(new ArrayList<UserBean>());
		Assert.assertEquals(sm.retriveSupportDetails(301),new ArrayList<UserBean>());
	}
	
	
	@org.junit.Test
	public void	checkemailifexist()throws Exception
	{		
		org.mockito.Mockito.when(sm.checkemailifexist("adarshbatham@gmail.com",301)).thenReturn(1);
		Assert.assertEquals(sm.checkemailifexist("adarshbatham@gmail.com",301),1);
	}
	
	
	@org.junit.Test
	public void	checkmobileifexist()throws Exception
	{		
		org.mockito.Mockito.when(sm.checkmobileifexist("8517913075",301)).thenReturn(1);
		Assert.assertEquals(sm.checkmobileifexist("8517913075",301),1);
	}
	
	
	@org.junit.Test
	public void	updateSupportProfile()throws Exception
	{		
		org.mockito.Mockito.when(sm.updateSupportProfile(301,"Adarsh","Batham","adarshbatham@gmail.com","8517913075","301")).thenReturn(1);
		Assert.assertEquals(sm.updateSupportProfile(301,"Adarsh","Batham","adarshbatham@gmail.com","8517913075","301"),1);
	}
}
