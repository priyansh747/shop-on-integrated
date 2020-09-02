package com.ShopOn.store;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.PageObjects.AdminLogin;
import com.ShopOn.PageObjects.StoreBranding;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;

public class StoreThemeTest extends BaseTest{
	
	
	@BeforeClass
	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("StoreThemeTest");
	}
	
	public void setUp() {

		super.setUp();
		driver.navigate().to("http://15.207.109.183:8080/admin/logon.html");
		AdminLogin login= new AdminLogin(driver);
		login.login();
		driver.navigate().to("http://15.207.109.183:8080/admin/store/storeBranding.html");
	
	}
	
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public static void endTest() {
		BaseTest.endTest();
	}
	
	@Test
	public void ifThemeListVisible() throws Exception {
		
		StoreBranding storeBranding = new StoreBranding(driver);
		
		
		Select options= new Select(storeBranding.getTemplate());
		System.out.println(options.getOptions().size());
		
		if(options.getOptions().size()>0) {
			test.log(LogStatus.PASS, "testpassed");
			assertTrue(true);
		}
		else {
			//test.log(LogStatus.FAIL, "testfailed");
		ScreenShot ss=new ScreenShot(super.driver,"ifThemeListVisible");
		ss.cleanFolder();
		ss.capture();
		
		System.out.println(ss.getScreenshotName("ifThemeListVisible").replace("/", "\\\\"));
		test.log(LogStatus.FAIL,test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn"+ss.getScreenshotName("ifThemeListVisible").replace("/", "\\\\"))+ "Test Failed");
		
			assertTrue(false);
		}
	}
	
	@Test
	public void themeSubmit1() throws InterruptedException {
		
		StoreBranding storeBranding = new StoreBranding(driver);
		
		
		Select options= new Select(storeBranding.getTemplate());
		options.selectByIndex(1);
		
		Thread.sleep(2000);
		storeBranding.clickThemeSubmit();
		
		Thread.sleep(2000);
		

	}
	
	@Test
	public void themeSubmit2() throws InterruptedException {
		
		StoreBranding storeBranding = new StoreBranding(driver);
		
		
		Select options= new Select(storeBranding.getTemplate());
		options.selectByIndex(3);
		
		Thread.sleep(2000);
		storeBranding.clickThemeSubmit();
		
		Thread.sleep(2000);
		

	}


	
}
