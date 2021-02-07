package com.specflow.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SelectBrowser 
{
	
	public static WebDriver initiateBrowser(WebDriver ldriver,String browserName, String url)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			ldriver=new ChromeDriver();
			
		}
		
		else
		{
			System.setProperty("webdriver.firefox.driver","./drivers/geckodriver.exe");
			ldriver=new FirefoxDriver();
		}
		ldriver.get(url);
		ldriver.manage().timeouts().pageLoadTimeout(5000,TimeUnit.SECONDS);
		ldriver.manage().window().maximize();
		
		return ldriver;
	}
	
	
	public static  void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
