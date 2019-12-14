package com.InetBanking.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage 
{
     WebDriver driver;
	
	// Step 1: Click on add new customer
	By lnkAddNewCust = By.xpath("//a[contains(text(),'New Customer')]");
	
	// Step 2: Input the customer  name
	By txtCustName = By.name("name");
	
	// Step 3: click on the customer gender
	By rdGender = By.name("rad1");
			
	//Step 4: Input the customer date of birth
	By txtdob = By.id("dob");
	
	//Step 5: Input the customer address
	By txtAddress = By.name("addr");
	
	//Step 6 : Input the customer city
	By txtCity = By.name("city");
	
	// Step 7 : Input the customer state
	By txtState = By.name("state");
	
	// Step 8: Input the cutomer PIN
	By txtPinno= By.name("pinno");
		
	// Step 9: Input the customer phone number
    By txtPhone = By.name("telephoneno");
	
	//Step 10: Input the customer email Id
    By txtEmailId = By.name("emailid");
	
	//Step 11: Input the customer password
    By txtPassword = By.name("password");
	
	//Step 12: Click on submit button
	By btnSubmit = By.name("sub");
	
	//Pazametarized default constructor to initialize the webdriver 	
	    public AddCustomerPage (WebDriver driver)
		{	
			this.driver = driver;
		}
	
	// Create the method for performing the UI Webelement on Step 1
		public void ClickAddNewCustomer()
		{
			driver.findElement(lnkAddNewCust).click();
		}
	// Create the method for performing the UI Webelement on Step 2
		public void CustName(String Cname)
		{
			driver.findElement(txtCustName).sendKeys(Cname);
		}
	// Create the method for performing the UI Webelement on Step 3
		
		public void CustGender (String gendre)
		{
			driver.findElement(rdGender).sendKeys(gendre);
		}
	// Create the method for performing the UI Webelement on Step 4
		
		public void CustDoB (String mm, String dd, String yyyy)
		{
			driver.findElement(txtdob).sendKeys(mm);
			driver.findElement(txtdob).sendKeys(dd);
			driver.findElement(txtdob).sendKeys(yyyy);
		}
    // Create the method for performing the UI Webelement on Step 5
		
		public void CustAddress (String address)
		{
			driver.findElement(txtAddress).sendKeys(address);
		}
    // Create the method for performing the UI Webelement on Step 6
		
		public void CustCity(String city)
		{
			driver.findElement(txtCity).sendKeys(city);
		}
    // Create the method for performing the UI Webelement on Step 7
		
		public void CustState (String state)
		{
			driver.findElement(txtState).sendKeys(state);
		}
    // Create the method for performing the UI Webelement on Step 8
		
		public void CustPinno (String pin)
		{
			driver.findElement(txtPinno).sendKeys(String.valueOf(pin));
		}
    // Create the method for performing the UI Webelement on Step 9
		
		public void CustPhoneNum(String phone)
		{
			driver.findElement(txtPhone).sendKeys(phone);
		}
   // Create the method for performing the UI Webelement on Step 10
		
		public void CustEmailId (String cemailid)
		{
			driver.findElement(txtEmailId).sendKeys(cemailid);
		}
   // Create the method for performing the UI Webelement on Step 11
		
		public void CustPassword (String cpassword)
		{
			driver.findElement(txtPassword).sendKeys(cpassword);
		}
		
   // Create the method for performing the UI Webelement on Step 12
		
		public void Custsubmit()
		{
			driver.findElement(btnSubmit).click();
		}

}
   

