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
public class ManagePages1 extends BaseTestAdmin {
	@BeforeClass
	public static void startTest() {
		BaseTestAdmin.startTest();
		test = report.startTest("ManagePages");
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

	public void gotoManagePages() {
		WebElement ManageContent = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[5]/a"));
		ManageContent.click();
		WebElement managePagesdd = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/ul/li[1]/a"));
		managePagesdd.click();
		WebElement managePage = driver.findElement(By.id("content-pages-link"));
		managePage.click();
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
	public void test_If_Visible_Works() throws InterruptedException {
		gotoManagePages();
		driver.findElement(By.xpath("//*[@id=\"isc_17\"]/table/tbody/tr/td")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//*[@id=\"visible1\"]")).isSelected()) {
			System.out.println("Selected");
		}
		else {
			System.out.println("Selecting");
			driver.findElement(By.xpath("//*[@id=\"visible1\"]")).click();
			driver.findElement(By.id("name0")).sendKeys("Test page");
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[20]/div/button")).click();
		}
		Set <String> windowHandles = driver.getWindowHandles();
		//System.out.println(windowHandles.size());
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.get("http://15.207.109.183:8080/shop/");
		WebElement dd = driver.findElement(By.xpath("/html/body/nav[2]/div/div[2]/ul/li[4]/a"));
		Actions builder = new Actions(driver);
		builder.moveToElement(dd).perform();
		if(driver.findElements(By.partialLinkText("Test page")).size() !=0 ) {
			System.out.println("Page Visible");
			test.log(LogStatus.PASS, "Test Passed");
			assertTrue(true);
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
			assertFalse(false);
		}
			
	}
	
	
	@Test
	public void test_If_ShowInMainMenu_Works() throws InterruptedException {
		gotoManagePages();
		driver.findElement(By.xpath("//*[@id=\"isc_1B\"]/table/tbody/tr/td")).click();
		Thread.sleep(1000);
		if(driver.findElement(By.id("linkToMenu1")).isSelected()) {
			System.out.println("Selected");
		}
		else {
			System.out.println("Selecting");
			driver.findElement(By.id("linkToMenu1")).click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			driver.findElement(By.id("name0")).sendKeys("Selenium test page");
			//js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.partialLinkText("Save"))); 
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[20]/div/button")).click();
		}
		Set <String> windowHandles = driver.getWindowHandles();
		//System.out.println(windowHandles.size());
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		driver.get("http://15.207.109.183:8080/shop/");
		if(driver.findElements(By.partialLinkText("Selenium test page")).size() !=0 ) {
			System.out.println("Page Visible");
			test.log(LogStatus.PASS, "Test Passed");
			assertTrue(true);
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
			assertFalse(false);
		}
			
	}
}
