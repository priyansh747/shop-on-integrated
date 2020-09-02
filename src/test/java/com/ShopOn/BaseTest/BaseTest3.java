package com.ShopOn.BaseTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest3 {

	public WebDriver driver;
	protected static ExtentTest test;
	protected static ExtentReports report;

	//@BeforeClass
		public static  void startTest()
		{
		report = new ExtentReports("D:\\2019"+"\\ExtentReportResults.html",false);
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\drivers\\chromedriver.exe"); 
		//test = report.startTest("ExtentDemo");
		}


	@Before
	public void setUp() throws Exception {
		System.setProperty("Webdriver.chrome.driver", ".\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

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
