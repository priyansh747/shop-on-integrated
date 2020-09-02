package com.ShopOn.BaseTest;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest1 {

	public WebDriver driver; 
	protected static ExtentTest test;
	protected static ExtentReports report;

	
	//@BeforeClass
	public static  void startTest()
	{
	report = new ExtentReports("./ExtentReportResults1.html",false);
	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	//test = report.startTest("ExtentDemo");
	}


	
	@Before 

	public void setUp(){ 

	//Initiate the Browser 





	driver = new ChromeDriver();
	 

	//Open login page

	driver.get("http://15.207.109.183:8080/shop");

	driver.manage().window().maximize();
	driver.navigate().refresh();

	} 
	
	
	
	@After
	public void tearDown() throws Exception {
		//TestResult result=new TestResult(driver);
		//System.out.println("after class");
		driver.close();
	}

	
	@AfterClass
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
}
