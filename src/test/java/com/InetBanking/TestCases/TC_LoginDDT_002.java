package com.InetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.InetBanking.PageObjects.LoginPage;
import com.InetBanking.Utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	
    @Test(dataProvider = "LoginData")
    public void loginDDT (String user , String pwd) throws Exception
    {
    	LoginPage login = new LoginPage(driver);
    	login.setUserName(user);
    	logger.info("User name provided");
    	login.setPassword(pwd);
    	logger.info("Password entered");
    	login.clickLogin();;
    	Thread.sleep(3000);
    	
    	if(isAlertPresent()==true) // isAlertPresent method created in BaseClass
    	{
    		driver.switchTo().alert().accept();//close invalid credential alert 
    		driver.switchTo().defaultContent();
    		captureScreen(driver, "loginDDT");
    		Assert.assertTrue(false);
    		logger.info("Login failed");
    		Thread.sleep(3000);
    	}
    	else
    	{
    		Assert.assertTrue(true);
    		logger.info("Login passed");
    		login.clickLogout();
    		Thread.sleep(3000);
    		driver.switchTo().alert().accept();//close alert logout
    		driver.switchTo().defaultContent();  		
    	}   	
    }
    
    @DataProvider(name = "LoginData")
     String[][] getData() throws IOException
    {
    	String path = System.getProperty("user.dir")+"/src/test/java/com/InetBanking/TestData/LoginData.xls";
    	int rownum = XLUtils.getRowCount(path, "Sheet1");
    	int colnum = XLUtils.getCellCount(path, "Sheet1", 1);
    	
    	String logindata[][] = new String[rownum][colnum];
    	
    	for(int i=1; i<=rownum; i++)
    	{
    		for(int j =0; j<colnum; j++ )
    		{
    			logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j); //1 0
    		}
    	}
    	
    	return logindata;
    }
    
    }