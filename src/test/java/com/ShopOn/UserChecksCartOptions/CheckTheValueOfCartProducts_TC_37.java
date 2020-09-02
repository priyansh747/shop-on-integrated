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
import com.ShopOn.PageObjects.RegisterUser;
import com.ShopOn.PageObjects.ViewCart;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class CheckTheValueOfCartProducts_TC_37 extends BaseTest {
	WebDriver driver;

	@BeforeClass
	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("CheckTheValueOfCartProducts_TC_37 ");
	}

	@Test
	public void RegisterWithValidData() throws Exception {
		ViewCart cart = new ViewCart(super.driver);

		cart.addToCart();
		cart.addToCartBook2();
		cart.hoverCart(driver);
		cart.enterQty(2, 1);

		Thread.sleep(1000);

	}

	public boolean checkIfValueIsCorrect() throws Exception {
		ViewCart cart = new ViewCart(super.driver);
		float expected = cart.returnTotal();
		String expStr = Float.toString(expected);
		System.out.println("EXPECTED STRING: " + expStr);
		WebElement actualTotal = driver.findElement(By.xpath("//*[@id=\"miniCartDetails\"]/li[2]/div/a[1]"));
		System.out.println("Final Total: " + actualTotal.getText());
		Assert.assertEquals(expStr, actualTotal.getText());

		if (expStr.equalsIgnoreCase(actualTotal.getText())) {
			test.log(LogStatus.PASS, "Test Passed");
			return true;
		} else {
			takeSS();
			return false;
		}

	}

	public void takeSS() throws Exception {
		ScreenShot ss = new ScreenShot(super.driver, "checkIfCARTValueIsCorrect");
		ss.cleanFolder();
		ss.capture();

		System.out.println(ss.getScreenshotName("checkIfCARTValueIsCorrect").replace("/", "\\\\"));
		test.log(LogStatus.FAIL,
				test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn"
						+ ss.getScreenshotName("checkIfCARTValueIsCorrect").replace("/", "\\\\"))
						+ "Test Failed");
		ss.capture();
		System.out.println(ss.getScreenshotName("checkIfCARTValueIsCorrect").replace("/", "\\\\"));
		fail();

	}
}
