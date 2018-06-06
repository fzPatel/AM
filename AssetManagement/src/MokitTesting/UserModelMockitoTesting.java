package MokitTesting;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.asset_management.models.UserModel;

import junit.framework.Assert;

public class UserModelMockitoTesting {

	Object o;
	UserModel um;

	@Before
	public void setUp()
{
		
		um=mock(UserModel.class)	;
	}
	
	@Test
	public void user_login_check()
	{
		when(um.user_login_check(101,"123")).thenReturn(1);
	    Assert.assertEquals(um.user_login_check(101,"123"),1);
	}
	

	@Test
	public void fetchDesignation()
	{
		
		
		when(um.fetchDesignation(201)).thenReturn("");
	    Assert.assertEquals(um.fetchDesignation(201),"");
	}
	
	@Test
	public void checkExistanceOfUser()
	{

		when(um.checkMobileExistanceOfUser("9752165945")).thenReturn(1);
	    Assert.assertEquals(um.checkMobileExistanceOfUser("9752165945"),1);
	}
	
	
	
	@Test
	public void forgetPassword()
	{

		when(um.forgetPassword("firozpatel3210@gmail.com")).thenReturn(0);
	    Assert.assertEquals(um.forgetPassword("firozpatel3210@gmail.com"),0);
	}
	

}
