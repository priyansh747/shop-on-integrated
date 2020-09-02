package com.ShopOn.contentManagement;

import com.ShopOn.Utilities.*;
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
import com.relevantcodes.extentreports.LogStatus;

public class ManageImagesUpload1 extends BaseTestAdmin {
	
	@BeforeClass
	public static void startTest() {
		BaseTestAdmin.startTest();
		test = report.startTest("ManageIMagesUpload1");
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
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	public static void endTest() {
		BaseTestAdmin.endTest();
	}
	
	@Test
	public void testSingleImage() throws InterruptedException {
		WebElement ManageImages = driver.findElement(By.id("content-images-link"));
		ManageImages.click();
		Thread.sleep(1000);
		List<WebElement> elements=driver.findElements(By.xpath("//*[contains(@id, 'isc_')]"));
		System.out.println(elements.size());
		WebElement chooseFiles = driver.findElement(By.id("file"));
		String path1 = "C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn\\src\\main\\resources\\";
		chooseFiles.sendKeys(path1 + "bk1.bmp");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement upload = driver.findElement(By.xpath("//*[@id=\"contentFiles\"]/div[3]/div/button"));
		upload.click();	
		Thread.sleep(1000);
		List<WebElement> elementsAfter=driver.findElements(By.xpath("//*[contains(@id, 'isc_')]"));
		System.out.println(elementsAfter.size());
		if(elements.size() != elementsAfter.size()) {
			test.log(LogStatus.PASS, "Test Passed");
            assertTrue(true);
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
            assertTrue(false);
		}
		//assertNotEquals(elements.size(), elementsAfter.size());
	}

	
	
	@Test
	public void testMultipleImages() throws InterruptedException {
		WebElement ManageImages = driver.findElement(By.id("content-images-link"));
		ManageImages.click();
		Thread.sleep(1000);
		List<WebElement> elements=driver.findElements(By.xpath("//*[contains(@id, 'isc_')]"));
		System.out.println(elements.size());
		WebElement chooseFiles = driver.findElement(By.id("file"));
		String path1 = "C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn\\src\\main\\resources\\";
		chooseFiles.sendKeys(path1 + "bk3.tiff" + "\n" + path1 + "bk5.jpg");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement upload = driver.findElement(By.xpath("//*[@id=\"contentFiles\"]/div[3]/div/button"));
		upload.click();	
		Thread.sleep(1000);
		List<WebElement> elementsAfter=driver.findElements(By.xpath("//*[contains(@id, 'isc_')]"));
		System.out.println(elementsAfter.size());
		if(elements.size() != elementsAfter.size()) {
			test.log(LogStatus.PASS, "Test Passed");
            assertTrue(true);
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
            assertTrue(false);
		}
		//assertNotEquals(elements.size(), elementsAfter.size());
	}
}