package com.ShopOn.LoginNShipping;

import com.ShopOn.BaseTest.BaseTestAdmin;
import com.ShopOn.PageObjects.LoginProject;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class TC_036Test extends BaseTestAdmin {

	@BeforeClass
	public static void startTest() {
		BaseTestAdmin.startTest();
		test = report.startTest("TestCase36");
	}

	public void setUp() {
		super.setUp();
	}

	public void tearDown() throws Exception {
		super.tearDown();
	}

	public static void endTest() {
		BaseTestAdmin.endTest();
	}

	@Test
	public void LoginWithValidData() throws InterruptedException {
		LoginProject objlogin = new LoginProject(super.driver);
		objlogin.setUserName("admin@shopizer.com");
		objlogin.setPassword("password");
		objlogin.clickLogon();
		// assertTrue(driver.findElements(By.xpath("//*[@id=\"logon\"]/div[1]/div")).size()
		// == 0);
	}

	@After
	public void ss() throws Exception {
		if (driver.findElements(By.xpath("//*[@id=\"logon\"]/div[1]/div")).size() == 0) {
			System.out.println("Test case passed");
			test.log(LogStatus.PASS, "Logged in successfully");
		}
		else {
			ScreenShot ss=new ScreenShot(super.driver,"LoginWithValidData");
			ss.cleanFolder();
			ss.capture();
			
			System.out.println(ss.getScreenshotName("LoginWithValidData").replace("/", "\\\\"));
			test.log(LogStatus.FAIL,test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn"+ss.getScreenshotName("LoginWithValidData").replace("/", "\\\\"))+ "Test Failed");
			

		}
	}

}
