package com.ShopOn.admin.profile;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.BaseTest.BaseTest2;
import com.ShopOn.PageObjects.LoginPage;
import com.ShopOn.PageObjects.LoginPage1;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;

public class EditUserGroups extends BaseTest2 {

	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("EditUserGroups");
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
	public void Login() throws Exception {
		this.startTest();
		LoginPage1 objlogin = new LoginPage1(super.driver);
		objlogin.setUserName("admin@shopizer.com");
		objlogin.setPassword("password");
		objlogin.clickSubmit();
		
		
		ScreenShot ss1=new ScreenShot(super.driver,"EditUserGroups");
		ss1.cleanFolder();
		
		
		
		
		WebElement e1=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]"));
		e1.click();
		e1=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/ul/li[2]"));
		e1.click();
		
		e1=driver.findElement(By.id("security-groups-link"));
		e1.click();
		String ss=driver.getCurrentUrl();
		WebDriverWait wait=new WebDriverWait(driver, 5);
		int i=0;
		Thread.sleep(1000);
	for(i=1;true;i++)
	{try {
		if(driver.findElement(By.xpath("//*[@id=\'isc_Ntable\']/tbody/tr["+i+"]")).isDisplayed())
		System.out.println("UserGroup- "+i+" Printed");
		test.log(LogStatus.INFO, "USERGROUP- "+i+" VIEWABLE");
			
	}
	catch(NoSuchElementException e)
	{if(i==1)
		{System.out.println("No Users Found!! please add some");	
		break;
		}
	if(i!=1)
	{System.out.println("Groups Identified");
	//test.log(LogStatus.PASS, "ALL GROUP DATA VIEWABLE");
	break;
	}	
	
	}
	}
	Thread.sleep(1000);
	WebElement ee=driver.findElement(By.id("isc_15"));
	Actions mouse=new Actions(driver);
	mouse.moveToElement(ee).click().perform();
	Thread.sleep(2000);
	System.out.println(driver.getCurrentUrl());
	if(driver.getCurrentUrl().equals("http://15.207.109.183:8080/admin/groups/editGroup.html?id=1"))
		{System.out.println("Passed");
		test.log(LogStatus.PASS, "Successfully redirected to edit Group page");
		assert(true);
		}
	else
	{
		test.log(LogStatus.FAIL, "Redirection to edit Group page failed");
		ss1.capture();
		test.log(LogStatus.FAIL, test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn\\src\\test\\resources\\EditUserGroups\\EditUserGroups1.png"));
		assert(false);
	}
	
	}


	}
	
