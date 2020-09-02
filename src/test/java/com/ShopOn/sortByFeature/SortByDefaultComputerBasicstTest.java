package com.ShopOn.sortByFeature;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ShopOn.BasePage.BasePage;
import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.BaseTest.BaseTest1;
import com.ShopOn.PageObjects.LoginPage;
import com.ShopOn.PageObjects.SortByDefaultComputerBasics;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;

import net.bytebuddy.implementation.bind.annotation.Super;




public class SortByDefaultComputerBasicstTest extends BaseTest1 {
	
	@BeforeClass
	public static void startTest() {
		BaseTest1.startTest();
		test = report.startTest("SortByDefaultComputerBasicstTest");
	}
	
	
	public void setUp() {

		super.setUp();
	
	}
	
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public static void endTest() {
		BaseTest.endTest();
	}
	
	
	@Test
	public void testSortbydefaultComputerBasics() throws Exception {
		
		SortByDefaultComputerBasics objsortby=new SortByDefaultComputerBasics(driver);
		//BasePage objBasePage=new BasePage(driver);
		
		driver.findElement(By.linkText("Products")).click();
	    driver.findElement(By.cssSelector(".dropdown:nth-child(3) > .dropdown-toggle > .fa-angle-down")).click();
	    driver.findElement(By.linkText("Computer Books")).click();
       try {
    	if(driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[3]/a/span")).isDisplayed())   
{
	test.log(LogStatus.PASS,"Product(Compute Basics) sorted by default");
	assert(true);
}
    	else
    		assert(false);
    		
    	}
       catch(Exception e) {
    	   test.log(LogStatus.FAIL, "test failed");
    	   assert(false);
       }
      //log(LogStatus.FAIL, test.addScreenCapture("C:\\Users\\iismaili\\Desktop\\screencapture"));
	}}
	
	