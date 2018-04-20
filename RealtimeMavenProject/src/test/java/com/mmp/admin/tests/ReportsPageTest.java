package com.mmp.admin.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mmp.admin.helper.AdminLoginPage;
import com.mmp.admin.pages.CreateVisit;
import com.mmp.admin.pages.Reportspage;
import com.mmp.admin.pages.SearchPatient;
import com.mmp.util.TestBaseClass;

public class ReportsPageTest extends TestBaseClass {
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
@Parameters({"Reportname","ReportDescription","Reportfile"})
@Test(priority=3)
public void reportstest(String Reportname, String ReportDescription ,String Reportfile) {

	Reportspage report=new Reportspage(driver);
    report.reports(Reportname, ReportDescription, Reportfile );
}
}