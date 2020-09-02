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
import org.junit.Ignore;
import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.BaseTest.BaseTest2;
import com.ShopOn.PageObjects.LoginPage;
import com.ShopOn.PageObjects.LoginPage1;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;

public class EditUserFromUsersAllCheck extends BaseTest2 {

	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("Edit Users Testcase from Users page(Valid/Invalid/Blank)");
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
	
	@Ignore
	@Test
	public void Login() throws Exception {
		this.startTest();
		
		
		ScreenShot ss1=new ScreenShot(super.driver,"EditUserFromUsersAllCheck");
		ss1.cleanFolder();
		
		
		LoginPage1 objlogin = new LoginPage1(super.driver);
		objlogin.setUserName("admin@shopizer.com");
		objlogin.setPassword("password");
		objlogin.clickSubmit();
		
		WebElement e1=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]"));
		e1.click();
		e1=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/ul/li[1]"));
		e1.click();
		
		e1=driver.findElement(By.id("users-link"));
		e1.click();
		String ss=driver.getCurrentUrl();
		WebDriverWait wait=new WebDriverWait(driver, 5);
		int i=0;
		Thread.sleep(1000);
	for(i=1;true;i++)
	{try {
		if(driver.findElement(By.xpath("//*[@id=\'isc_Ntable\']/tbody/tr["+i+"]")).isDisplayed())
		System.out.println("User- "+i+" Printed");
		test.log(LogStatus.INFO, "USER- "+i+" PRINTED");
			
	}
	catch(NoSuchElementException e)
	{if(i==1)
		{System.out.println("No Users Found!! please add some");	
		break;
		}	
	break;
	}
	}
	Thread.sleep(1000);
	WebElement ee=driver.findElement(By.id("isc_17"));
	Actions mouse=new Actions(driver);
	mouse.moveToElement(ee).click().perform();
	Thread.sleep(2000);
	System.out.println(driver.getCurrentUrl());
	if(driver.getCurrentUrl().equals("http://15.207.109.183:8080/admin/users/displayStoreUser.html?id=50"))
		{System.out.println("Passed");
		test.log(LogStatus.PASS, "Successfully redirected to edit user page");
		assert(true);
		}
	else
	{ss1.capture();
	test.log(LogStatus.FAIL, test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn\\src\\test\\resources\\EditUserFromUsersAllCheck\\EditUserFromUsersAllCheck1.png"));
		test.log(LogStatus.FAIL, "Redirection to edit user page failed");
		assert(false);
	}

	
	}


	}
	
