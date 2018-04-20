package com.mmp.patient.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mmp.patient.helper.LoginPage;
import com.mmp.util.TestBaseClass;

public class LoginPageTest extends TestBaseClass{
	LoginPage lp;
	@Parameters({"username","password"})
	@Test
	public void LoginTest(String username, String password)
	{
		
		lp=new LoginPage(driver);
			lp.login(username, password);
}
	
	
	@Parameters({"username"})
	@Test
	public void validateUserNameTest()
	{
		String user=lp.validateUserName();
		Assert.assertEquals(user, "ria1");
	}
	
}
