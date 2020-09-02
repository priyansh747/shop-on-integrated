package com.ShopOn.LoginNShipping;

import com.ShopOn.BaseTest.BaseTestAdmin;
import com.ShopOn.PageObjects.LoginProject;
import com.ShopOn.Utilities.ScreenShot;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import com.relevantcodes.extentreports.LogStatus;
public class TC_037Test extends BaseTestAdmin {

	@BeforeClass
	public static void startTest() {
		BaseTestAdmin.startTest();
		test = report.startTest("TestCase37");
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
	public void LoginWithInvalidData() throws InterruptedException {
		LoginProject objlogin = new LoginProject(driver);
		objlogin.setUserName("!@#123@shopizer.com");
		objlogin.setPassword("password");
		objlogin.clickLogon();
		Thread.sleep(5000);
		// assertTrue(driver.findElements(By.xpath("//*[@id=\"logon\"]/div[1]/div")).size()
		// == 0);
	}

	@After
	public void takeSS() throws Exception {
		if (driver.findElements(By.xpath("//*[@id=\"logon\"]/div[1]/div")).size() != 0) {
			test.log(LogStatus.PASS, "Test Passed");
			assertTrue(true);

		}

		else {
			ScreenShot ss=new ScreenShot(super.driver,"LoginWithInvalidData");
			ss.cleanFolder();
			ss.capture();
			
			System.out.println(ss.getScreenshotName("LoginWithInvalidData").replace("/", "\\\\"));
			test.log(LogStatus.FAIL,test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn"+ss.getScreenshotName("LoginWithInvalidData").replace("/", "\\\\"))+ "Test Failed");
			fail();

		}
	}
}
