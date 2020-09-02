package com.ShopOn.LoginNShipping;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ShopOn.BaseTest.BaseTestAdmin;
import com.ShopOn.PageObjects.ShippingConfiguration;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;

public class TC_046Test extends BaseTestAdmin {
	WebElement national;

	@BeforeClass
	public static void startTest() {
		BaseTestAdmin.startTest();
		test = report.startTest("TestCase46");
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
	public void test() throws InterruptedException {
		ShippingConfiguration objlogin = new ShippingConfiguration(driver);
		objlogin.setUserName("admin@shopizer.com");
		objlogin.setPassword("password");
		objlogin.clickLogon();
		objlogin.clickShipping();
		objlogin.clickNational();
		national = driver.findElement(
				By.xpath("//*[@id=\"shipType\"]"));
		// assertTrue(national.isSelected());

	}

	@After
	public void takeSS() throws Exception {
		if (driver
				.findElement(
						By.xpath("//*[@id=\"shipType\"]"))
				.isSelected()) {
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
