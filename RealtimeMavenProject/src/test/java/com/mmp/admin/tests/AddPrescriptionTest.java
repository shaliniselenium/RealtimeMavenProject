package com.mmp.admin.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mmp.admin.helper.AdminLoginPage;
import com.mmp.admin.pages.AddPrescription;
import com.mmp.admin.pages.CreateVisit;
import com.mmp.admin.pages.SearchPatient;
import com.mmp.util.TestBaseClass;

public class AddPrescriptionTest extends TestBaseClass {

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
		 
		CreateVisit visit=new CreateVisit(driver);
		visit.clickpatient();
	}
@Parameters({"prescriptionname", "presdescription"})
@Test(priority=3)
public void addPresdescriptionTest(String prescriptionname,String presdescription) throws InterruptedException 

{
	
AddPrescription pres=new AddPrescription(driver);
String actual=pres.addPrescriptionMethod(prescriptionname, presdescription);
Assert.assertEquals("Prescription has been Added.", actual);
}

}
