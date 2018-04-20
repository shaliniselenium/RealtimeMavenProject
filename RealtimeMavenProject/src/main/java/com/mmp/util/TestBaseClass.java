package com.mmp.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBaseClass {
	
	public WebDriver driver;
	public String url;

	@Parameters({"browser","url"})	
	@BeforeClass(alwaysRun=true)
    public void setup(String browser,String url) throws Exception{
		if (browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		//	capabilities.setCapability("marionette", false);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if (browser.equals("CH")) {
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		else {
			throw new Exception("Browser is not correct");
		}
		this.url=url;
		driver.get(url);

	}
		
	
	@AfterClass
	public void closeApp()
	{
      //  driver.close();
	}


	
	
	
	
}

	




