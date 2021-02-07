package com.specflow.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.specflow.pages.LoginPage;
import com.specflow.utility.ExcelDataProvider;

public class Login  extends BaseClass
{
	LoginPage lp;
	
	@Test
	public void loginGmail()throws Exception
	{
		log=reports.createTest("logingmail");
		
		lp=PageFactory.initElements(driver,LoginPage.class);
		lp.signIn();
		log.info("gmail clicked");
		log.info("sign in clicked");
		switchActiveWindow(driver);
		lp.loginGmail(edp.getStringData("Login",1, 0),edp.getStringData("Login",1,1));
		Thread.sleep(3000);
		System.out.println("==========================");
		log.pass("login successful");
	}
	
	
	
	
	

}
