package com.ShopOn.sortByFeature;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.BaseTest.BaseTest1;
import com.ShopOn.PageObjects.SortByDefaultTechnology;
import com.relevantcodes.extentreports.LogStatus;

public class SortByDEfaultDefaultTechnologyTest extends BaseTest1 {
	
	@BeforeClass
	public static void startTest() {
		BaseTest1.startTest();
		test = report.startTest("SortByDefaultTechnology");
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
	public void testSortbydefaultTechnology() throws Exception {
		
		SortByDefaultTechnology objsortby=new SortByDefaultTechnology(driver);
		//BasePage objBasePage=new BasePage(driver);
		
		driver.findElement(By.linkText("Products")).click();
		System.out.println("1");
	    driver.findElement(By.cssSelector(".dropdown:nth-child(3) > .dropdown-toggle > .fa-angle-down")).click();
	    System.out.println("2");
	    driver.findElement(By.linkText("Technology")).click();
	    System.out.println("3");
	    driver.findElement(By.xpath("/html/body/div[1]/div/a")).click();
       try {
    	if(driver.findElement(By.xpath("//html/body/div[3]/div[2]/div/div/div[1]/div[1]/div/div/div/div[1]/div/select")).isDisplayed())   
{
	test.log(LogStatus.PASS,"Product(Technology) sorted by default");
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
	