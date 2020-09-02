package com.ShopOn.store;

import static org.junit.Test.*;

import org.junit.BeforeClass;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.PageObjects.AdminLogin;
import com.ShopOn.PageObjects.StoreHome;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;

public class StoreTitleTest extends BaseTest{
	
	
	@BeforeClass
	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("StoreTitleTest");
	}
	
	public void setUp() {

		super.setUp();
		driver.navigate().to("http://15.207.109.183:8080/admin/logon.html");
		AdminLogin login= new AdminLogin(driver);
		login.login();
		driver.navigate().to("http://15.207.109.183:8080/admin/store/storeLanding.html");
	
	}
	
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public static void endTest() {
		BaseTest.endTest();
	}
	
	@Test
	public void ifTitleEnabled() throws Exception {
		StoreHome landing = new StoreHome(driver);
		if(landing.isTitleEnabledAndDisplayed()) {
			test.log(LogStatus.PASS, "testpassed");
			assertTrue(true);
		}
		else {
			ScreenShot ss=new ScreenShot(super.driver,"StoreTitleTest");
		ss.cleanFolder();
		ss.capture();
		
		System.out.println(ss.getScreenshotName("ifThemeListVisible").replace("/", "\\\\"));
		test.log(LogStatus.FAIL,test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn"+ss.getScreenshotName("ifThemeListVisible").replace("/", "\\\\"))+ "Test Failed");
		
		assertTrue(false);
		}
	}
	
	@Test
	public void titleTest1() {
		StoreHome landing = new StoreHome(driver);
		landing.setPageTitle("title1");
		landing.submit();
		test.log(LogStatus.PASS, "testpassed");
		
	}
	
	
	
}
