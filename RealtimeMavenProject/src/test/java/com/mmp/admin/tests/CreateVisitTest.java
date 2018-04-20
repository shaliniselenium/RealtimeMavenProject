package com.mmp.admin.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mmp.admin.helper.AdminLoginPage;
import com.mmp.admin.pages.CreateVisit;
import com.mmp.admin.pages.SearchPatient;
import com.mmp.util.TestBaseClass;

public class CreateVisitTest extends TestBaseClass {
	
	
	
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
	
	
	/*String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[2]")).getText();
	System.out.println(sCellValue);
	
	// Here we are clicking on the link of first row and the last column
	driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[6]/a")).click();        
	System.out.println("Link has been clicked otherwise an exception would have thrown");
	driver.close();
	*/
	
}
 @Parameters({"doj","expTime","doctorName","symptoms"})
 @Test(priority=3)
 public void createpatientvisitTest(String doj, String expTime,String doctorName, String  symptoms) throws InterruptedException
 {	

	 
	 
CreateVisit visit=new CreateVisit(driver);
visit.clickpatient();
visit.createvisitEx(doctorName);
 visit.schedulevisit(doj, expTime,doctorName, symptoms);
 	
 }
 
 
 
}
