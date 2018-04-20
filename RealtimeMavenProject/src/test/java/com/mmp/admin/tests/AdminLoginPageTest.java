package com.mmp.admin.tests;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mmp.admin.helper.AdminLoginPage;
import com.mmp.util.TestBaseClass;

public class AdminLoginPageTest extends TestBaseClass {
	
	
	
	
    @Parameters({"adminusername","adminpassword"})
	@Test
	public void AdminLoginTest(String adminusername,String adminpassword) {
    	
    	AdminLoginPage login=new AdminLoginPage(driver);
    	login.adminnavigation();
    	login.adminlogin(adminusername, adminpassword);
	
	}
}
