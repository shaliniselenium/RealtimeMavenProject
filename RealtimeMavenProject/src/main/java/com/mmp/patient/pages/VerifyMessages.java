package com.mmp.patient.pages;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyMessages {
WebDriver driver;

public VerifyMessages(WebDriver driver) {
	
	this.driver=driver;
}

public String verifymessages(String reason ,String subject) throws InterruptedException {
	//click message link on left
	driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/ul/li[8]/a")).click();
	//entering values-http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/sendmessage.php
	driver.findElement(By.id("subject")).clear();
	driver.findElement(By.id("subject")).sendKeys(reason);
	
	driver.findElement(By.id("message")).clear();
	driver.findElement(By.id("message")).sendKeys(subject);
	//click send
	driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div/div/form/div/table/tbody/tr[4]/td/input")).submit();
	
	 // Switching to Alert        
    Alert alert = driver.switchTo().alert();		
    		
    // Capturing alert message.    
    String alertMessage= driver.switchTo().alert().getText();		
    		
    // Displaying alert message		
    System.out.println("************alert message came after the message tab******************************************8:::"+alertMessage);	
    Thread.sleep(5000);
    		
    // Accepting alert		
    alert.accept();		
	
    return alertMessage;
	}
}

/*public void verifyadmin () {
	
	driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).click();
	driver.findElement(By.xpath("//td[2]")).
		
	}
	
	
}

}*/


