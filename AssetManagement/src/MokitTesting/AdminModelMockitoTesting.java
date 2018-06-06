package MokitTesting;

import org.junit.Before;
import static org.mockito.Mockito.mock;
import com.asset_management.beans.AdminBean;
import com.asset_management.beans.UserBean;
import com.asset_management.models.AdminModel;

import junit.framework.Assert;

public class AdminModelMockitoTesting {
	AdminModel am;
	AdminBean ab;
	UserBean ub;
	Object o;
	
	
	@Before
	public void setUp()
	{
		am=mock(AdminModel.class);
		ab=mock(AdminBean.class);
	}
	
	@org.junit.Test
	public void	adminLoginCheck()throws Exception
	{
		org.mockito.Mockito.when(am.adminLoginCheck(ab)).thenReturn(1);
		Assert.assertEquals(am.adminLoginCheck(ab),1);
	}
	
	
	@org.junit.Test
	public void	insertUser()throws Exception
	{
		org.mockito.Mockito.when(am.insertUser(ub)).thenReturn(o);
		Assert.assertEquals(am.insertUser(ub),o);
	}
	
	
	@org.junit.Test
	public void	retriveAllUsers()throws Exception
	{
		org.mockito.Mockito.when(am.retriveAllUsers()).thenReturn(new java.util.ArrayList());
		Assert.assertEquals(am.retriveAllUsers(),new java.util.ArrayList());
	}
	
	
	@org.junit.Test
	public void	retriveUser()throws Exception
	{
		org.mockito.Mockito.when(am.retriveUser("adarshbatham@gmail.com")).thenReturn(ub);
		Assert.assertEquals(am.retriveUser("adarshbatham@gmail.com"),ub);
	}
	
	
	@org.junit.Test
	public void	active()throws Exception
	{
		org.mockito.Mockito.when(am.active("adarshbatham@gmail.com")).thenReturn(1);
		Assert.assertEquals(am.active("adarshbatham@gmail.com"),1);
	}
	
	
	
	@org.junit.Test
	public void	deactive()throws Exception
	{
		org.mockito.Mockito.when(am.deactive("adarshbatham@gmail.com")).thenReturn(1);
		Assert.assertEquals(am.deactive("adarshbatham@gmail.com"),1);
	}
	
	
	@org.junit.Test
	public void	updateNewPassword()throws Exception
	{
		org.mockito.Mockito.when(am.updateNewPassword("adarshbatham@gmail.com","101")).thenReturn(1);
		Assert.assertEquals(am.updateNewPassword("adarshbatham@gmail.com","101"),1);
	}
	
	
	
	@org.junit.Test
	public void	retriveManagerIds()throws Exception
	{
		org.mockito.Mockito.when(am.retriveManagerIds()).thenReturn(new java.util.ArrayList());
		Assert.assertEquals(am.retriveManagerIds(),new java.util.ArrayList());
	}
	
	
	
	@org.junit.Test
	public void	retriveSupportIds()throws Exception
	{
		org.mockito.Mockito.when(am.retriveSupportIds()).thenReturn(new java.util.ArrayList());
		Assert.assertEquals(am.retriveSupportIds(),new java.util.ArrayList());
	}
	
	
	@org.junit.Test
	public void	promotionAndDemotion()throws Exception
	{
		org.mockito.Mockito.when(am.promotionAndDemotion(ub)).thenReturn(1);
		Assert.assertEquals(am.promotionAndDemotion(ub),1);
	}
	
}
