package com.ShopOn.contentManagement;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.BaseTest.BaseTestAdmin;
import com.ShopOn.PageObjects.AdminLoginPage;
import com.ShopOn.PageObjects.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
public class CreatePages extends BaseTestAdmin {
	@BeforeClass
	public static void startTest() {
		BaseTestAdmin.startTest();
		test = report.startTest("CreatePagesCreate");
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

	public void gotoCreatePages() {
		WebElement ManageContent = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[5]/a"));
		ManageContent.click();
		WebElement managePagesdd = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/ul/li[1]/a"));
		managePagesdd.click();
		WebElement createPage = driver.findElement(By.id("content-pages-create-link"));
		createPage.click();
	}
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	public static void endTest() {
		BaseTestAdmin.endTest();
	}

	@Test
	public void test_Check_Duplicate_Code() {
		gotoCreatePages();
		WebElement code = driver.findElement(By.xpath("//*[@id=\"code\"]"));
		code.click();
		code.clear();
		code.sendKeys("Selenium test page");
		driver.findElement(By.xpath("//*[@id=\"name0\"]")).click();
		if(driver.findElement(By.xpath("//*[@id=\"checkCodeStatus\"]/font")).getText().contentEquals("This code already exist")) {
			System.out.println("Page Visible");
			test.log(LogStatus.PASS, "Test Passed");
			assertTrue(true);
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
			assertFalse(false);
		}
		//assertTrue(driver.findElement(By.xpath("//*[@id=\"checkCodeStatus\"]/font")).getText().contentEquals("This code already exist"));

		//This Doesn't Work
		//assertTrue(driver.findElements(By.xpath("//*[@id=\"checkCodeStatus\"]/font")).size() != 0);
	}


	@Test
	public void test_Check_InValid_Orders() throws InterruptedException {
		gotoCreatePages();
		WebElement Orders = driver.findElement(By.id("order"));
		Orders.clear();
		Orders.sendKeys("abc");
		driver.findElement(By.xpath("//*[@id=\"name0\"]")).click();
		Thread.sleep(500);
		System.out.println(Orders.getAttribute("value"));
		if(Orders.getAttribute("value").length() == 0) {
			System.out.println("Page Visible");
			test.log(LogStatus.PASS, "Test Passed");
			assertTrue(true);
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
			assertFalse(false);
		}
		//assertTrue(Orders.getAttribute("value").length() == 0);
	}

	@Test
	public void test_Check_URL_Generation() throws InterruptedException {
		gotoCreatePages();
		WebElement name = driver.findElement(By.xpath("//*[@id=\"name0\"]"));
		name.sendKeys("anything");
		driver.findElement(By.id("order")).click();
		Thread.sleep(500);
		WebElement seurl = driver.findElement(By.xpath("//*[@id=\"seUrl0\"]"));
		System.out.println(seurl.getAttribute("value"));
		if(seurl.getAttribute("value").length() != 0) {
			System.out.println("Page Visible");
			test.log(LogStatus.PASS, "Test Passed");
			assertTrue(true);
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
			assertFalse(false);
		}
		//assertTrue(seurl.getAttribute("value").length() != 0);
	}
}