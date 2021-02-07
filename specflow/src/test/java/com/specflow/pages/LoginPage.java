package com.specflow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.specflow.testcases.BaseClass;

public class LoginPage extends BaseClass
{

	@FindBy(linkText="Gmail")public WebElement lnkGmail;
	@FindBy(linkText="Sign in")public WebElement lnkSignIn;
	@FindBy(xpath="//*[@name='identifier']")public WebElement tbxUname;
	@FindBy(xpath="//*[@name='password']")public WebElement tbxPassword;
	@FindBy(xpath="//*[@id='identifierNext']/div/button")public WebElement btnNext;
	
	public void signIn()throws Exception
	{
		lnkGmail.click();
		lnkSignIn.click();
		Thread.sleep(4000);
	}
	
	
	public void loginGmail(String uname, String pwd)throws Exception
	{
		tbxUname.sendKeys(uname);
		Thread.sleep(4000);
		btnNext.click();
		//Thread.sleep(4000);
		//tbxPassword.sendKeys(pwd);
		}
	
	
	
}
