package com.ShopOn.UserTriesToRegister;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.PageObjects.RegisterUser;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class RegisterWithInvalidState_Province_TC_29 extends BaseTest{

	WebDriver driver;

	@BeforeClass
	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("Valid Details TestCase");
	}

	@Test
	public void RegisterWithInvalidState() throws Exception {
		RegisterUser reg = new RegisterUser(super.driver);

		reg.clickOnMyAccount(super.driver);
		reg.enterFirstName(super.driver,"Charles");
		reg.enterLastName(super.driver,"Boyle");
		reg.enterCountry(super.driver,"India");
		reg.enterState(super.driver,"@#@#@#***>>>");
		reg.enterEmail(super.driver,"charles920.boyle@gmail.com");
		reg.enterPassword(super.driver,"123");
		reg.enterRepeatPassword(super.driver,"123");
		
		reg.clickSubmit();
		Thread.sleep(5000);
		
		// Assert
		try {
		checkIfInvalidState( super.driver);
		}
		
		catch(Exception e) {
			takeSS();
			fail();
			
		}
		
	}
	
	public boolean checkIfInvalidState(WebDriver driver) throws Exception {
		WebElement actual = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/div/span/p"));
		Assert.assertEquals("Invalid State/Province Name", actual.getText());
		if ("Invalid State/Province Name".equalsIgnoreCase(actual.getText())) {
			test.log(LogStatus.PASS, "Test Passed");
			return true;
		}
		else {
			takeSS();
			return false;
		}

	}
	
	public void takeSS() throws Exception {
		ScreenShot ss = new ScreenShot(super.driver, "checkForInvalidStateData");
		ss.cleanFolder();
		ss.capture();

		System.out.println(ss.getScreenshotName("checkForInvalidStateData").replace("/", "\\\\"));
		test.log(LogStatus.FAIL,
				test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn"
						+ ss.getScreenshotName("checkForInvalidStateData").replace("/", "\\\\"))
						+ "Test Failed");
		ss.capture();
		System.out.println(ss.getScreenshotName("checkForInvalidStateData").replace("/", "\\\\"));
		fail();
		
	}

	

}
