package com.mmp.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.Select;

public class Reportspage {
WebDriver driver;

By reports =By.xpath("//input[@value='Reports']");
By reportname= By.id("exampleInputcardnumber1");
By appointments =By.id("app_date");
By upload = By.id("file");
By description= By.xpath("//textarea[@name='report_desc']");
By submit = By.xpath("//input[@value='submit']");





public Reportspage (WebDriver driver) {
	
	this.driver=driver;
}

public void reports (String Reportname, String ReportDescription, String Reportfile) {
	//Click on Reports
	driver.findElement(reports).click();
	//input[@value='Reports']
	
	//Click on select appointments
	WebElement appt=driver.findElement(appointments);
	 Select apptdrop=new Select(appt);
	apptdrop.selectByIndex(2);
	
	
	//Click Reportname
	driver.findElement(reportname).clear();
	driver.findElement(reportname).sendKeys(Reportname);
	
	
 
	WebElement file=driver.findElement(upload);
	file.sendKeys(Reportfile);
	//C:\Users\Shalini\Desktop\report.txt

	//textarea[@name='report_desc']
	//Click Report Description
	driver.findElement(description).clear();
	driver.findElement(description).sendKeys(ReportDescription);
	
	//click submit
	driver.findElement(submit).click();
			
	
}
}
