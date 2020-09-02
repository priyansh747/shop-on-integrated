package com.ShopOn.BaseTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest3 {

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
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
	
		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Open URL
		driver.get("http://15.207.109.183:8080/shop");
		driver.manage().window().maximize();
		driver.navigate().refresh();
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}
}
