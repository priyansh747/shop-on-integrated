package com.ShopOn.admin.profile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.BaseTest.BaseTest2;
import com.ShopOn.PageObjects.LoginPage;
import com.ShopOn.PageObjects.LoginPage1;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;

public class ViewUsers extends BaseTest2 {

	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("View Users Testcase");
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
		
		
		ScreenShot ss1=new ScreenShot(super.driver,"ViewUsers");
		ss1.cleanFolder();
		
		
		
		WebElement e1=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]"));
		e1.click();
		e1=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/ul/li[1]"));
		e1.click();
		
		e1=driver.findElement(By.id("users-link"));
		e1.click();
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'isc_W\']/table/tbody/tr/td/table/tbody/tr/td[1]")));
	for(int i=1;true;i++)
	{try {
		if(driver.findElement(By.xpath("//*[@id=\'isc_Ntable\']/tbody/tr["+i+"]")).isDisplayed())
		System.out.println("User- "+i+" Printed");
		test.log(LogStatus.PASS, "USER- "+i+" PRINTED");
			
	}
	catch(NoSuchElementException e)
	{if(i==1)
		{System.out.println("FAIL");
		test.log(LogStatus.FAIL, "USER LIST UNAVAILABLE");
		ss1.capture();
		test.log(LogStatus.FAIL, test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn\\src\\test\\resources\\ViewUsers\\ViewUsers1.png"));
		break;
		}
	if(i!=1)
	{System.out.println("TEST DONE");
	test.log(LogStatus.PASS, "ALL USERS DATA DISPLAYED");
	break;
	}	
		
	}
	
	}
	
	
	
	
	
	
	}


}
