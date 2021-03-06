package com.ShopOn.admin.profile;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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

public class RemoveUserGroups extends BaseTest2 {

	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("ViewUserGroups");
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
		LoginPage1 objlogin = new LoginPage1(super.driver);
		objlogin.setUserName("admin@shopizer.com");
		objlogin.setPassword("password");
		objlogin.clickSubmit();
		driver.manage().window().maximize();
		
		ScreenShot ss1=new ScreenShot(super.driver,"RemoveUserGroups");
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
		//test.log(LogStatus.INFO, "USERGROUP- "+i+" VIEWABLE");
			
	}
	catch(NoSuchElementException e)
	{if(i==1)
		{System.out.println("No Users Found!! please add some");	
		break;
		}
	if(i!=1)
	{System.out.println("TEST DONE");
	//test.log(LogStatus.PASS, "ALL GROUP DATA VIEWABLE");
	break;
	}	
	
	}
	}
	driver.navigate().refresh();
	Thread.sleep(1000);
	driver.navigate().refresh();
	Thread.sleep(1000);
	
	
	
	e1=driver.findElement(By.xpath("//*[@id=\'isc_Ntable\']/tbody/tr[9]/td[6]"));
	e1.click();
	Thread.sleep(2000);
	e1.click();
	Thread.sleep(2000);
	Alert alertOK = driver.switchTo().alert();
	Thread.sleep(2000);
	//String s1=alertOK.getText();
	//Thread.sleep(2000);
	alertOK.accept();
	
	Alert alertOK1 = driver.switchTo().alert();
	Thread.sleep(2000);
	//String s1=alertOK.getText();
	//Thread.sleep(2000);
	alertOK1.accept();
	test.log(LogStatus.INFO, "Deleting User");
	////*[@id="isc_Ntable"]/tbody/tr[1]/td[6]
	Thread.sleep(5000);
	int k=i;
	for(i=1;true;i++)
	{try {
		if(driver.findElement(By.xpath("//*[@id=\'isc_Ntable\']/tbody/tr["+i+"]")).isDisplayed())
		System.out.println("UserGroup- "+i+" Printed");
		//test.log(LogStatus.INFO, "USERGROUP- "+i+" VIEWABLE");
			
	}
	catch(NoSuchElementException e)
	{if(i==1)
		{System.out.println("No Users Found!! please add some");	
		break;
		}
	if(i!=1)
	{System.out.println("TEST DONE");
	//test.log(LogStatus.PASS, "ALL GROUP DATA VIEWABLE");
	break;
	}	
	
	}
	}
	
	if(k==i+1)
		{System.out.println("TEST DONE");
		test.log(LogStatus.PASS, "User Removed Successfully");
		assert(true);
		}
	else
		{
		System.out.println("Fail test");
		ss1.capture();
		test.log(LogStatus.FAIL, test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn\\src\\test\\resources\\RemoveUserGroups\\RemoveUserGroups1.png"));
		test.log(LogStatus.FAIL,"User Removal Failed");
		assert(false);
		
		}
	
	
	}


	}
	
