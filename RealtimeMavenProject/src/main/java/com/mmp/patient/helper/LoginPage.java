package com.mmp.patient.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage  {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	
	{
		this.driver=driver;
		}

	public void login(String username, String password) {
		
		driver.findElement(By.linkText("Patient Login")).click();
		
		WebElement webElement1 = driver.findElement(By.linkText("Login"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", webElement1);
		
		//driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		WebElement webElement = driver.findElement(By.name("submit"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", webElement);
		
		System.out.println(username);
		System.out.println("Login Successful");
	}
	
	
	public String validateUserName()
	{
	
		return driver.findElement(By.tagName("h3")).getText();
		
	}

}


