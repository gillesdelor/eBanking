package com.InetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
	WebDriver driver;
	
	public LoginPage (WebDriver driver)
	{	
		PageFactory.initElements(driver, this);	
	}
	
	// Sign in WebElement	
	@FindBy (name = "uid")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy (name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy (name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy (xpath = "//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement btnLogout;
	
	// Creating the methods for the action
	
		public void setUserName (String uname)
		{
			txtUsername.sendKeys(uname);
		}
		
		public void setPassword(String pwd)
		{
			txtPassword.sendKeys(pwd);
		}
		
		public void clickLogin()
		{
			btnLogin.click();
		}	
		
		public void clickLogout()
		{
			btnLogout.click();
		}	
}

    