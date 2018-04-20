package com.mmp.admin.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mmp.admin.helper.AdminLoginPage;
import com.mmp.admin.pages.AddPrescription;
import com.mmp.admin.pages.CreateFeePage;
import com.mmp.admin.pages.CreateVisit;
import com.mmp.admin.pages.Reportspage;
import com.mmp.admin.pages.SearchPatient;
import com.mmp.util.TestBaseClass;

public class AdminModule extends TestBaseClass {
	
@Parameters({"adminusername","adminpassword"})
@Test(priority=1)
public void AdminLoginTest(String adminusername,String adminpassword) 
{    	
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
		
@Parameters({"doj","expTime","doctorName","symptoms"})
@Test(priority=3)
public void createpatientvisitTest(String doj, String expTime,String doctorName, String  symptoms) throws InterruptedException
{		 
CreateVisit visit=new CreateVisit(driver);
visit.clickpatient();
visit.createvisitEx(doctorName);
visit.schedulevisit(doj, expTime,doctorName, symptoms);
		 	
}
@Parameters({"prescriptionname", "presdescription","ssn"})
@Test(priority=4)
public void addPresdescriptionTest(String prescriptionname,String presdescription, String ssn) throws InterruptedException {
	SearchPatient search=new SearchPatient(driver);
	search.searchpatient(ssn);
	CreateVisit visit=new CreateVisit(driver);
	visit.clickpatient();
	
AddPrescription pres=new AddPrescription(driver);
String actual=pres.addPrescriptionMethod(prescriptionname, presdescription);
Assert.assertEquals("Prescription has been Added.", actual);
}
@Parameters({"ssn"})
@Test(priority=5)
public void createFeeMethodTest(String ssn) throws InterruptedException
{
	SearchPatient search=new SearchPatient(driver);
	search.searchpatient(ssn);
	CreateVisit visit=new CreateVisit(driver);
	visit.clickpatient();
	
	CreateFeePage fee=new CreateFeePage(driver);
	String actual=fee.createFeeMethod();
	Assert.assertEquals("Fee Successfully Entered. ",actual);
}
@Parameters({"ssn","Reportname","ReportDescription","Reportfile"})
@Test(priority=6)
public void reportstest(String ssn,String Reportname, String ReportDescription ,String Reportfile) {
	SearchPatient search=new SearchPatient(driver);
	search.searchpatient(ssn);
	CreateVisit visit=new CreateVisit(driver);
	visit.clickpatient();
	
	Reportspage report=new Reportspage(driver);
    report.reports(Reportname, ReportDescription, Reportfile );
}
}
