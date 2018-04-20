package com.mmp.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPatient {
WebDriver driver;

public SearchPatient(WebDriver driver){
	this.driver=driver;
	
}

public void searchpatient(String ssn) {
	
	driver.findElement(By.xpath("//span[contains(text(),'Patients')]")).click();
	driver.findElement(By.id("search")).clear();
	driver.findElement(By.id("search")).sendKeys(ssn);
	driver.findElement(By.xpath("//input[@value='search']")).click();
	
	
}



}
