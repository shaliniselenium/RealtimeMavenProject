package com.mmp.patient.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mmp.util.TestBaseClass;

public class ScheduleAppoint extends TestBaseClass {
WebDriver driver;

public ScheduleAppoint(WebDriver driver) {
	
	this.driver=driver;
	
}
public void scheduleAppointment(String doj, String expTime, String doctorName,String  symptoms ) throws InterruptedException {

	driver.findElement(By.xpath("//span[contains(text(),'Schedule')]")).click();
	driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
	//driver.findElement(By.xpath("(//*[@id='opener'])[3]")).click();
	driver.findElement(By.xpath("//h4[contains(text(),'"+doctorName+"')]/ancestor::ul/following-sibling::button")).click();
	//to change frame:

		driver.switchTo().frame("myframe"); 
		 Thread.sleep(6000);  
		
		driver.findElement(By.id("datepicker")).click(); 
		
	//String doj;
	String dt,month,year;
	String []date = doj.split("/");//delimeter /
	
	month=date[0];
	dt = date[1];
	year = date[2];
	
	String calYear,calMonth;
	calYear = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/span[2]")).getText();
	System.out.println(calYear);
	System.out.println(year);
	while(!calYear.equals(year))
	{
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
		calYear= driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/span[2]"))
				.getText();
		System.out.println("While Loop printing year::"+ calYear);
	}
	 
	calMonth= driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/span[1]")).getText();
	System.out.println(calMonth);
	System.out.println(month);
	while(!calMonth.equals(month))
	{
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
		calMonth=driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]")).getText();
		System.out.println("While Month printing month::"+ calMonth);
	}
	
	List<WebElement> tdList = driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr/td/a"));
	System.out.println(tdList);
	
	for(int i=0;i<tdList.size();i++)
	{
		
		WebElement e = tdList.get(i);
		if(e.getText().equals(dt))
		{
			System.out.println("Date matching::"+  e.getText());
			e.click();
			break;
		}
	}
	
	 WebElement k = driver.findElement(By.id("time"));
	    Select sel = new Select(k);
	    //sel.selectByIndex(1);
       // String expTime="11Am";
	    List<WebElement> optionList = sel.getOptions();
	    System.out.println("List size::::::" + optionList.size());

	    for (int i = 0; i < optionList.size(); i++) {
	        if (optionList.get(i).getText().equalsIgnoreCase(expTime)) {
	            optionList.get(i).click();
	            System.out.println("Time Selected");
	            break;
	        }
	    }	
	    Thread.sleep(5000);
	    driver.findElement(By.id("ChangeHeatName")).click();

		driver.switchTo().defaultContent();
		driver.findElement(By.id("sym")).sendKeys(symptoms);
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[3]/input")).click();
		System.out.println("Appointment Scheduled");
}

public void verifyAppointment() {
	//click on profile
	driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
	//click view history
	//driver.findElement(By.xpath("//div[2]/a[1]/button")).click();
	
	//view history button
	driver.findElement(By.xpath("//html/body/div[1]/div/div[2]/div[2]/div/div/div[2]/a[1]/button")).click();
/*	WebDriverWait wait  = new WebDriverWait(driver,30);
	WebElement submitWE= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("View History")));
	submitWE.sendKeys(Keys.ENTER);*/
	
	driver.manage().window().maximize();
	//Click past appointments
	//driver.findElement(By.xpath(".//*[@id='wrapper']/p[2]/a/input")).click();
	driver.findElement(By.xpath("//input[@value='Past Appointments']")).click();
	//click on the table
	// return driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/table/tbody/tr/td[3]")).getText();
	// return driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/table/tbody/tr/td")).getText();
  

}


/*public String verifyAppointment() {
	//click on profile
	driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
	//click view history
	//driver.findElement(By.xpath("//div[2]/a[1]/button")).click();
	WebDriverWait wait  = new WebDriverWait(driver,30);
	WebElement submitWE= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("View History")));
	submitWE.sendKeys(Keys.ENTER);
	
	driver.manage().window().maximize();
	//Click past appointments
	//driver.findElement(By.xpath(".//*[@id='wrapper']/p[2]/a/input")).click();
	driver.findElement(By.xpath("//input[@value='Past Appointments']")).click();
	//click on the table
	// return driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/table/tbody/tr/td[3]")).getText();
	 return driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/table/tbody/tr/td")).getText();
  

}
*/


}
//input[@value='Past Appointments']


//html/body/div[1]/div[1]/div[2]/div[2]/div














