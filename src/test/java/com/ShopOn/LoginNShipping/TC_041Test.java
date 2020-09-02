package com.ShopOn.LoginNShipping;

import com.ShopOn.BaseTest.BaseTestAdmin;
import com.ShopOn.PageObjects.LoginProject;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

public class TC_041Test extends BaseTestAdmin {
	@BeforeClass
	public static void startTest() {
		BaseTestAdmin.startTest();
		test = report.startTest("TestCase41");
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
	public void LoginWithBlankData() throws InterruptedException {
		LoginProject objlogin = new LoginProject(super.driver);
		objlogin.setUserName("");
		objlogin.setPassword("");
		objlogin.clickRemember();
		objlogin.clickLogon();
		// assertTrue(driver.findElements(By.id("username_help")).size() == 0
		// && driver.findElements(By.id("password_help")).size() == 0);
	}

	@After
	public void takeSS() throws Exception {
		if (driver.findElements(By.id("username_help")).size() != 0
				&& driver.findElements(By.id("password_help")).size() != 0) {
			test.log(LogStatus.PASS, "Test Passed");
			assertTrue(true);

		}

		else {
			ScreenShot ss=new ScreenShot(super.driver,"LoginWithInvalidData1");
			ss.cleanFolder();
			ss.capture();
			
			System.out.println(ss.getScreenshotName("LoginWithInvalidData1").replace("/", "\\\\"));
			test.log(LogStatus.FAIL,test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn"+ss.getScreenshotName("LoginWithInvalidData1").replace("/", "\\\\"))+ "Test Failed");
			fail();
	}
	}

}
