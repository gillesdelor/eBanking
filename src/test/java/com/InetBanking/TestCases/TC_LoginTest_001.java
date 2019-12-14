package com.InetBanking.TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.InetBanking.PageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws Exception
	{
		
		
		logger.info("Url is opened");
		
		LoginPage login = new LoginPage(driver);
		login.setUserName(username);
		Thread.sleep(2000);
		logger.info("Username entered");
		
		login.setPassword(password);
		Thread.sleep(2000);
		logger.info("Password entered");
		
		login.clickLogin();;
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		// Assertion
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
		    Assert.assertTrue(true);
		    logger.info("Login test passed");
		}
		else 
		{  
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		    
	}
}
