package com.mmp.patient.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mmp.patient.pages.ScheduleAppoint;
import com.mmp.util.TestBaseClass;

public class ScheduleAppointTest extends TestBaseClass{
	
	ScheduleAppoint sch;
	
	@Parameters({"doj","expTime","doctorName","symptoms"})
	@Test(priority=1)
	public void scheduleAppointmenttest(String doj, String expTime, String doctorName,String  symptoms) throws InterruptedException  {
		sch = new ScheduleAppoint(driver);
		sch.scheduleAppointment( doj,expTime,doctorName,symptoms);
	}
	
	/*@Parameters({"symptoms"})
	@Test(priority=2)
	public void verifyAppointmenttest(String  symptoms) {
		
		 sch.verifyAppointment();
		String str=sch.verifyAppointment();
		System.out.println("The text is  : "  +str);
		Assert.assertEquals(str, symptoms);
	}*/
	@Parameters({"doj","expTime","doctorName","symptoms"})
	@Test(priority=2)
	public void verifyAppointmenttest(String doj, String expTime, String doctorName,String  symptoms) {
		
		 sch.verifyAppointment();
		//String str=sch.verifyAppointment();
		 //	System.out.println("The text is  : "  +str);
		//Assert.assertEquals(str, symptoms);
		 
		 
		 WebElement e1=driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/table/tbody/tr[1]/td[1]"));
		 String s1=(String)e1.getText();
		 String Date;
		  
		  Date=s1.replace("April/20/2018","04/20/2018");
		  
		 System.out.println("Value of Date displayed is::"+ Date);
		// String tm=Date.f
		 
		 WebElement e2=driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/table/tbody/tr[1]/td[2]"));
		 String	Time=(String)e2.getText();
		 System.out.println("Value of Time displayed is::"+ Time);
		
		 
		 WebElement e3=driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/table/tbody/tr[1]/td[3]"));
		 String	Appointment=(String)e3.getText();
		 System.out.println("Value of Appointment displayed is::"+Appointment);
		 
		 WebElement e4=driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/table/tbody/tr[1]/td[4]"));
		 String	Doctor=(String)e4.getText();
		 String dr="Dr.".concat(Doctor);
		 System.out.println("Value of Doctor displayed is::"+ dr);
		 //String dr="Dr.".concat(Doctor);
		 
		 if((Date.equalsIgnoreCase(doj)) && (Time.equalsIgnoreCase(expTime)) && (Appointment.equalsIgnoreCase(symptoms)) && (dr.equalsIgnoreCase(doctorName)))
		 {
			 System.out.println("Scheduled Appointment Verified & TestCase Passed");
		 }
		 else
		 {
			 System.out.println("we didn't find the scheduled appointment and TestCase failed");
		 }
		 //Assert.assertEquals(Date, expected);
	}
	//(Date.equalsIgnoreCase(doj)) && 
	
}
