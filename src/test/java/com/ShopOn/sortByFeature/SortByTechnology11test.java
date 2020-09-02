package com.ShopOn.sortByFeature;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.BaseTest.BaseTest1;
import com.ShopOn.PageObjects.SortByDefaultTechnology;
import com.ShopOn.PageObjects.SortByDefaultWeb;
import com.relevantcodes.extentreports.LogStatus;

public class SortByTechnology11test extends BaseTest1 {
	
	@BeforeClass
	public static void startTest() {
		BaseTest1.startTest();
		test = report.startTest("SortByTechnologyTest");
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
	public void testSortbydefaultTechnology111() throws Exception {
		
		SortByDefaultWeb objsortby=new SortByDefaultWeb(driver);
		//BasePage objBasePage=new BasePage(driver);
		
		driver.findElement(By.linkText("Products")).click();
	    driver.findElement(By.cssSelector(".dropdown:nth-child(3) > .dropdown-toggle > .fa-angle-down")).click();
	    driver.findElement(By.linkText("Technology111")).click();
       try {
    	if(driver.findElement(By.xpath("//html/body/div[3]/div[2]/div/div/div[1]/div[1]/div/div/div/div[1]/div/select")).isDisplayed())   
{
	test.log(LogStatus.PASS,"Product(Technology111) sorted by default");
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
