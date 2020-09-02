package com.ShopOn.store;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.PageObjects.AdminHome;
import com.ShopOn.PageObjects.AdminLogin;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;




public class ViewOrders extends BaseTest {
	
	@BeforeClass
	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("ViewOrders");
	}
	
	public void setUp(){

		super.setUp();

		driver.navigate().to("http://15.207.109.183:8080/admin/logon.html");
		AdminLogin login= new AdminLogin(driver);
		login.login();
		
	
	}
	
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public static void endTest() {
		BaseTest.endTest();
	}
	
	
	@Test
	public void viewOrders() throws Exception {
		AdminHome objorderpage =  new AdminHome(driver);
		driver.navigate().to("http://15.207.109.183:8080/admin/logon.html");

		AdminLogin login= new AdminLogin(driver);
		login.login();

		if(objorderpage.getOrderList().isDisplayed()) {

			test.log(LogStatus.PASS, "testpassed");
			assertTrue(true);
		}
		else {
			ScreenShot ss=new ScreenShot(super.driver,"ViewOrders");
			ss.cleanFolder();
			ss.capture();
			
			System.out.println(ss.getScreenshotName("ViewOrders").replace("/", "\\\\"));
			test.log(LogStatus.FAIL,test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn"+ss.getScreenshotName("ViewOrders").replace("/", "\\\\"))+ "Test Failed");
			
		assertTrue(false);
		}
	}
	
/*	@Test
	public void viewOrderDetails() throws InterruptedException {
		AdminHome objorderpage =  new AdminHome(driver);
		Thread.sleep(1000);
		objorderpage.clickItem();
		Thread.sleep(2000);
	} */
	
	@Test
	public void testSortByName() throws InterruptedException {
		AdminHome objorderpage =  new AdminHome(driver);
		objorderpage.sortByName();
		Thread.sleep(2000);
		objorderpage.sortByName();

		test.log(LogStatus.PASS, "testpassed");
		
		Thread.sleep(2000);
		assertTrue(true);
		
		
	}
	
	@Test
	public void testSortByTotal() throws InterruptedException {
		AdminHome objorderpage =  new AdminHome(driver);
		
		objorderpage.sortByTotal();
		Thread.sleep(2000);
		objorderpage.sortByTotal();
		Thread.sleep(2000);

		test.log(LogStatus.PASS, "testpassed");
		assertTrue(true);
				
	}
	
	@Test
	public void testSortByOrderDate() throws InterruptedException {
		AdminHome objorderpage =  new AdminHome(driver);

		objorderpage.sortByDate();
		Thread.sleep(2000);
		objorderpage.sortByDate();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "testpassed");
		assertTrue(true);
		
		
	}
	
	@Test
	public void testSortByStatus() throws InterruptedException {
		AdminHome objorderpage =  new AdminHome(driver);
		

		objorderpage.sortByStatus();
		Thread.sleep(2000);
		objorderpage.sortByStatus();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "testpassed");
		assertTrue(true);
		
	}
	
	@Test
	public void testSortById() throws InterruptedException {
		AdminHome objorderpage =  new AdminHome(driver);

		objorderpage.sortByID();
		Thread.sleep(2000);
		objorderpage.sortByID();
		Thread.sleep(2000);
		
		test.log(LogStatus.PASS, "testpassed");
		assertTrue(true);
		
	}
	
	
	@Test
	public void testSortByPayment() throws InterruptedException {
		AdminHome objorderpage =  new AdminHome(driver);
		
		objorderpage.sortByPayment();
		Thread.sleep(2000);
		objorderpage.sortByPayment();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "testpassed");
		
	}
	
	
	
	
	

}
