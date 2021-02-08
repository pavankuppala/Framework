package com.specflow.testcases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.specflow.utility.ConfigDataProvider;
import com.specflow.utility.ExcelDataProvider;
import com.specflow.utility.SelectBrowser;

public class BaseClass 
{
	public WebDriver driver;
	public ConfigDataProvider cdp;
	public ExcelDataProvider edp;
	public ExtentHtmlReporter htmlReport;
	public ExtentReports reports;
	public ExtentTest log;
	
	
	@BeforeSuite
	public void initialize()throws Exception
	{
		cdp=new ConfigDataProvider();
		edp=new ExcelDataProvider();
		htmlReport=new ExtentHtmlReporter("./reports/login.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		
		
	}
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser)throws Exception
	{
		//driver=SelectBrowser.initiateBrowser(driver,cdp.getBrowser(),cdp.getURL());
		driver=SelectBrowser.initiateBrowser(driver,browser,cdp.getURL());
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult itr)throws Exception
	{
		if(itr.getStatus()==ITestResult.SUCCESS)
		{
			String path=getScreenshot("test");
			log.pass("test passed",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			log.addScreenCaptureFromPath(path);
		}
		
		
		
		reports.flush();
	}
	{
		
	}
	
	@AfterClass
	public void tearDown()throws Exception
	{
		driver.quit(); 
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("done");
	}
	
	
	public void switchActiveWindow(WebDriver ldriver)
	{
		Set<String> window=ldriver.getWindowHandles();
		for(String s:window)
		{
			ldriver.switchTo().window(s);
		}
		
	}
	
	public  String  getScreenshot(String name)throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File f=ts.getScreenshotAs(OutputType.FILE);
		String dest1="./screenshots/"+name+".png";
		File dest=new File("./screenshots/"+name+".png");
		FileHandler.copy(f,dest);
		return dest1;
		
	}
	
	public String getDate()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date d=new Date();
		return dateFormat.format(d);
		
	}

	

}
