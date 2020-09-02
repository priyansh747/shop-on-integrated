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
import com.ShopOn.BaseTest.BaseTest3;
import com.ShopOn.PageObjects.RegisterUser;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class RegisterWithInvalidLastName_TC_26 extends BaseTest3 {

	WebDriver driver;

	@BeforeClass
	public static void startTest() {
		BaseTest3.startTest();
		test = report.startTest("RegisterWithInvalidLastName_TC_26");
	}

	@Test
	public void RegisterWithInvalidLastName() throws Exception {
		RegisterUser reg = new RegisterUser(super.driver);

		reg.clickOnMyAccount(super.driver);
		reg.enterFirstName(super.driver, "Charles");
		reg.enterLastName(super.driver, "@132322****/");
		reg.enterCountry(super.driver, "India");
		reg.enterState(super.driver, "Bihar");
		reg.enterEmail(super.driver, "charles225.boyle@gmail.com");
		reg.enterPassword(super.driver, "123");
		reg.enterRepeatPassword(super.driver, "123");

		reg.clickSubmit();
		Thread.sleep(5000);

		// Assert
		try {
		checkIfInvalidLastName();
		}
		catch(Exception e) {
			takeSS();
			fail();
			
		}
	}

	public boolean checkIfInvalidLastName() throws Exception {
		WebElement actual = super.driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/div/span/p"));
		Assert.assertEquals("Invalid Last Name", actual.getText());
		if ("Invalid Last Name".equalsIgnoreCase(actual.getText())) {
			test.log(LogStatus.PASS, "Test Passed");
			return true;
		} else {
			takeSS();
			return false;
		}
	}

	public void takeSS() throws Exception {
		ScreenShot ss = new ScreenShot(super.driver, "CheckIfUserIsAbleToRegisterWithValidData");
		ss.cleanFolder();
		ss.capture();

		System.out.println(ss.getScreenshotName("checkForInvalidLastName").replace("/", "\\\\"));
		test.log(
				LogStatus.FAIL, test
						.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn"
								+ ss.getScreenshotName("checkForInvalidLastName").replace("/", "\\\\"))
						+ "Test Failed");
		ss.capture();
		System.out.println(ss.getScreenshotName("checkForInvalidLastName").replace("/", "\\\\"));
		fail();

	}

}
