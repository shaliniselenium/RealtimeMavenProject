package com.mmp.patient.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class VerifyPage {
	
	WebDriver driver;
	
	public VerifyPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public String gettitle() {
		driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/ul/li[8]/a/span")).click();
		String title=driver.getTitle();
		System.out.println("The title of the Page is :  " + title);
				return title;
		
	}
 public String firstlabel() {
	 
	 String t1=driver.findElement(By.xpath("(//label)[1]")).getText(); 
     return t1;
	 
	
 }
 
 
 public String secondlabel() {
	 System.out.println("This is in second label  ");
	return driver.findElement(By.xpath("(//label)[2]")).getText();
	 
	
 }

public String sendbutton() {
	System.out.println("This is in third label  "); 
	 return driver.findElement(By.xpath("//input[@value='Send']")).getAttribute("value");
	 
}





}
