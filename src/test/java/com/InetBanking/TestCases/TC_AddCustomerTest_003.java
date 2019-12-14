package com.InetBanking.TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBanking.PageObjects.AddCustomerPage;
import com.InetBanking.PageObjects.LoginPage;


public class TC_AddCustomerTest_003 extends BaseClass 
{
	
	@Test
	public void addNewCustomer() throws Exception
	
	{
		// Login with customer credential
		LoginPage login = new LoginPage(driver);
		login.setUserName(username);
		login.setPassword(password);
		login.clickLogin();
		Thread.sleep(3000);
		
		// Adding new customer 
		AddCustomerPage addCust = new AddCustomerPage(driver);
		
		addCust.ClickAddNewCustomer();
		addCust.CustName("Gilles");
		addCust.CustGender("female");
		Thread.sleep(3000);
		addCust.CustDoB("10", "21", "1999");
		Thread.sleep(3000);
		addCust.CustAddress("10312 Trundle Pl");
		addCust.CustCity("Manassas");
		addCust.CustState("Virginia");
		addCust.CustPinno("500066");
		addCust.CustPhoneNum("5715358979");
		Thread.sleep(3000);
		
		String email = randomString()+"@gmail.com";
		addCust.CustEmailId(email);
		addCust.CustPassword("abcdhh255");
		
		addCust.Custsubmit();
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
		}
		else 
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
				
	}
		
}


