package com.mmp.patient.tests;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
//import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.mmp.admin.helper.AdminLoginPage;
import com.mmp.patient.helper.LoginPage;
import com.mmp.patient.pages.VerifyMessages;
import com.mmp.util.TestBaseClass;

@Test
public class VerifyMessagetest extends TestBaseClass{
	
	@Parameters({"username","password"})
	@Test(priority=1)
	public void LoginTest(String username, String password)
	{
		
		LoginPage lp=new LoginPage(driver);
			lp.login(username, password);
}
	
	@Parameters({"reason", "subject"})
	@Test(priority=2)
	public void verifymessagestest(String reason,String subject) throws InterruptedException {
		
		VerifyMessages vm=new VerifyMessages(driver);
		
		String actual=vm.verifymessages(reason, subject);
		Assert.assertEquals("Messages Successfully sent.", actual);
		
	}


	@Parameters({"adminusername","adminpassword","adminurl"})
	@Test(priority=3)
	public void AdminLoginTest(String adminusername,String adminpassword, String adminurl) {
    	driver.navigate().to(adminurl);
    	AdminLoginPage login=new AdminLoginPage(driver);
    	login.adminlogin(adminusername, adminpassword);
    	System.out.println("*********************Admin login is completed***************" );
	}
	
	
	
	

}
