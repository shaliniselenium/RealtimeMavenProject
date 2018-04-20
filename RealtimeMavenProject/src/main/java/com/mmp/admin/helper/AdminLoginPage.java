package com.mmp.admin.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLoginPage {

	WebDriver driver;
	

	By adminLogin      =  By.linkText("Office Login");
	By loginLink       =  By.xpath(".//*[@id='welcome']/div/div[2]/a[1]");
	By userName        =  By.id("username");
	By password        =  By.id("password");
	By submitButton    =  By.xpath("//input[@value='Sign In']");


	public AdminLoginPage(WebDriver driver)
	
	{
		this.driver=driver;
		}
	
public void adminnavigation() {
	//Click Office login
	driver.findElement(By.linkText("Office Login")).click();
	//Click Login
	WebElement webElement2 = driver.findElement(loginLink);
	JavascriptExecutor executor2 = (JavascriptExecutor) driver;
	executor2.executeScript("arguments[0].click();", webElement2);
	
	
	
 
}

public void adminlogin(String adminusername, String adminpassword) {
	

	driver.findElement(userName).clear();
	driver.findElement(userName).sendKeys(adminusername);
	driver.findElement(password ).clear();
	driver.findElement(password ).sendKeys(adminpassword);
	driver.findElement(submitButton).click();
	
	System.out.println(adminusername);
	System.out.println("Login Successful");
	
}

}
