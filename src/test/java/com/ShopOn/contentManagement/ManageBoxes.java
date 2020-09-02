package com.ShopOn.contentManagement;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.BaseTest.BaseTestAdmin;
import com.ShopOn.PageObjects.AdminLoginPage;
import com.ShopOn.PageObjects.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
public class ManageBoxes extends BaseTestAdmin {
	@BeforeClass
	public static void startTest() {
		BaseTestAdmin.startTest();
		test = report.startTest("ManageBoxes");
	}


	@Before
	public void setUp() {
		super.setUp();
		AdminLogin();
		WebElement ManageContent = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[5]/a"));
		ManageContent.click();
	}

	public void AdminLogin() {
		AdminLoginPage objlogin = new AdminLoginPage(super.driver);
		objlogin.setUserName("admin@shopizer.com");
		objlogin.setPassword("password");
		objlogin.clickSubmit();
	}
	
	public void gotoManageBoxes() {
		WebElement manageBoxesdd = driver.findElement(By.xpath("/html/body/div/div[3]/div/div[2]/div/ul/li[2]/a"));
		manageBoxesdd.click();
		WebElement manageBox = driver.findElement(By.id("content-boxes-link"));
		manageBox.click();
	}

	public void gotoCreateBoxes() {
		WebElement manageBoxesdd = driver.findElement(By.xpath("/html/body/div/div[3]/div/div[2]/div/ul/li[2]/a"));
		manageBoxesdd.click();
		WebElement createBox = driver.findElement(By.id("content-boxes-create-link"));
		createBox.click();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	public static void endTest() {
		BaseTestAdmin.endTest();
	}
	
	
	@Test
	public void test_TC_Check_Duplicate_Code() {
		gotoCreateBoxes();
		WebElement code = driver.findElement(By.id("code"));
		code.click();
		code.clear();
		code.sendKeys("101");
		driver.findElement(By.xpath("//*[@id=\"order\"]")).click();
		if(driver.findElement(By.xpath("//*[@id=\"checkCodeStatus\"]/font")).getText().contentEquals("This code already exist")) {
			test.log(LogStatus.PASS, "Test Passed");
            assertTrue(true);
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
            assertTrue(false);
		}
		
		
		//assertTrue(driver.findElement(By.xpath("//*[@id=\"checkCodeStatus\"]/font")).getText().contentEquals("This code already exist"));
	}

	
	@Test
	public void test_Check_Invalid_order() throws InterruptedException {
		gotoCreateBoxes();
		WebElement Orders = driver.findElement(By.id("order"));
		Orders.clear();
		Orders.sendKeys("abc");
		driver.findElement(By.id("name0")).click();
		Thread.sleep(500);
		System.out.println(Orders.getAttribute("value"));
		if(Orders.getAttribute("value").length() == 0) {
			test.log(LogStatus.PASS, "Test Passed");
            assertTrue(true);
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
            assertTrue(false);
		}
		
		
		//assertTrue(Orders.getAttribute("value").length() == 0);
	}
	
}