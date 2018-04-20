package com.mmp.admin.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mmp.admin.helper.AdminLoginPage;
import com.mmp.admin.pages.SearchPatient;
import com.mmp.util.TestBaseClass;

public class SearchPatientTest extends TestBaseClass{

  @Parameters({"adminusername","adminpassword"})
		@Test(priority=1)
		public void AdminLoginTest(String adminusername,String adminpassword) {
	  AdminLoginPage login=new AdminLoginPage(driver);
  	login.adminnavigation();
  	login.adminlogin(adminusername, adminpassword);
	}
	  
	  
	 @Parameters({"ssn"})
	@Test(priority=2)
	public void searchPatientSSNTest(String ssn)
	{	
	
    	SearchPatient search=new SearchPatient(driver);
    	search.searchpatient(ssn);
    	
    	
}
	 
}