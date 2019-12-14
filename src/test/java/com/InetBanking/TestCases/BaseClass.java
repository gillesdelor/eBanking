package com.InetBanking.TestCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.InetBanking.Utilities.ReadConfig;

public class BaseClass
{
	ReadConfig readconfig = new ReadConfig();
	
	public String baseUrl = readconfig.getApplicationUrl();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browserType")
	
	@BeforeClass
	
	public void setUp(String browser) throws InterruptedException
	{
		//PropertyConfigurator is used to configure logger from Property configuration file
		logger = Logger.getLogger("InetBanking");
		PropertyConfigurator.configure("log4J.properties");
		
		//DOMConfigurator is used to configure logger from xml configuration file
        //DOMConfigurator.configure("log4J.xml");
 
		
		if(browser.equals("chrome"))
		{
	   //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "//Drivers//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver = new ChromeDriver();
		}
		
		if(browser.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath() );
		driver = new FirefoxDriver();
		}
		
		if(browser.equals("ie"))
		{
		System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
		driver = new InternetExplorerDriver();
		}	
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Lauching browser
		driver.get(baseUrl);
		
    }
	    
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	    
	 public static void captureScreen(WebDriver driver,String tname) throws Exception
	 {

		  //Convert web driver object to TakeScreenshot
	        TakesScreenshot scrShot =((TakesScreenshot)driver);

	      //Call getScreenshotAs method to create image file
	         File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	         
	     //Move image file to new destination
	          File DestFile=new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	              
	     //Copy file at destination
	          FileUtils.copyFile(SrcFile, DestFile);
	          
	          System.out.println("Screenshot has been taken");
	    }
	 
	 // User defined method created to check alert is present or not  
	    public boolean isAlertPresent() 
	    {
	    	try
	    	{
	    	driver.switchTo().alert();
	    	return true;
	    	}
	        
	    	catch (NoAlertPresentException e)
	    	{
	    	return false;
	    	}
	    }
	 // Generated Random alphabetic     
	    public String randomString()
		{
			String generatedString = RandomStringUtils.randomAlphabetic(8);
			return (generatedString);
		}
		
	// Generated Random Numeric  
		public String randomNum()
		{
			String generatedNum = RandomStringUtils.randomNumeric(4);
			return (generatedNum);
		}
}