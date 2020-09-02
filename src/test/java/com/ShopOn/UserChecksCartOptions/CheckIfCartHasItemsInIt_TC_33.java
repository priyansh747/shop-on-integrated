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

public class CheckIfCartHasItemsInIt_TC_33 extends BaseTest3 {
	// WebDriver driver;

	@BeforeClass
	public static void startTest() {
		BaseTest3.startTest();
		test = report.startTest("CheckIfCartHasItemsInIt_TC_33");
	}

	@Test
	public void CheckingIfCartHasItems() throws Exception {
		ViewCart cart = new ViewCart(super.driver);

		cart.addToCart();
		cart.hoverCart(super.driver);
		checkIfCartHasItems();

		Thread.sleep(5000);

	}

	public boolean checkIfCartHasItems() throws Exception {
		WebElement actual = super.driver.findElement(By.xpath("//*[@id=\"miniCartDetails\"]/li[1]/div/ol/li/div[2]/div/button"));
		System.out.println("Cart Status: " + actual.isDisplayed());
		Assert.assertEquals(true, actual.isDisplayed());
		
		if (actual.isDisplayed()) {
			test.log(LogStatus.PASS, "Test Passed");
			return true;
		}
		else {
			takeSS();
			return false;
		}
		
	}
	
	public void takeSS() throws Exception {
		ScreenShot ss = new ScreenShot(super.driver, "checkIfCartHasItems");
		ss.cleanFolder();
		ss.capture();

		System.out.println(ss.getScreenshotName("checkIfCartHasItems").replace("/", "\\\\"));
		test.log(LogStatus.FAIL,
				test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn"
						+ ss.getScreenshotName("checkIfCartHasItems").replace("/", "\\\\"))
						+ "Test Failed");
		ss.capture();
		System.out.println(ss.getScreenshotName("checkIfCartHasItems").replace("/", "\\\\"));
		fail();
		
	}

}
