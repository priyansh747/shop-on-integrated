package com.ShopOn.UserChecksCartOptions;

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
import com.ShopOn.PageObjects.ViewCart;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class CheckIfCartIsEmpty extends BaseTest3 {
	// WebDriver driver;
	@BeforeClass
	public static void startTest() {
		BaseTest3.startTest();
		test = report.startTest("CheckIfCartIsEmpty");
	}

	@Test
	public void CheckingIfCartIsEmpty() throws Exception {
		ViewCart cart = new ViewCart(super.driver);
		cart.hoverCart(super.driver);
		checkIfCartIsEmpty(super.driver);
		Thread.sleep(5000);
	}

	public boolean checkIfCartIsEmpty(WebDriver driver) throws Exception {
		WebElement actual = driver.findElement(By.xpath("//*[@id=\"miniCartDetails\"]/li/div/ol/h5"));
		Assert.assertEquals("No items in your shopping cart", actual.getText());
		System.out.println("Cart Status: " + actual.getText());
		
		if ("No items in your shopping cart".equalsIgnoreCase(actual.getText())) {
			test.log(LogStatus.PASS, "Test Passed");
			return true;
		} else {
			takeSS();
			return false;
		}
	}
	
	public void takeSS() throws Exception {
		ScreenShot ss = new ScreenShot(super.driver, "checkIfCartIsEmpty");
		ss.cleanFolder();
		ss.capture();

		System.out.println(ss.getScreenshotName("checkIfCartIsEmpty").replace("/", "\\\\"));
		test.log(LogStatus.FAIL,
				test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn"
						+ ss.getScreenshotName("checkIfCartIsEmpty").replace("/", "\\\\"))
						+ "Test Failed");
		ss.capture();
		System.out.println(ss.getScreenshotName("checkIfCartIsEmpty").replace("/", "\\\\"));
		fail();
		
	}

}
