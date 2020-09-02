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
import org.openqa.selenium.NoSuchElementException;
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

public class RemoveUsers extends BaseTest2 {

	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("Remove Users Testcase");
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
		
		driver.manage().window().maximize();
		ScreenShot ss=new ScreenShot(super.driver,"RemoveUsers");
		ss.cleanFolder();
		
		
		
		
		WebElement e1=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]"));
		e1.click();
		e1=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/ul/li[1]"));
		e1.click();
		
		e1=driver.findElement(By.id("users-link"));
		e1.click();
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
	driver.navigate().refresh();
	Thread.sleep(1000);
	Actions action = new Actions(driver);
	e1=driver.findElement(By.xpath("//*[@id='isc_Ntable']/tbody/tr[1]/td[6]"));
	Thread.sleep(3000);
	action.moveToElement(e1).click().perform();
	Thread.sleep(3000);
	

	
	Alert alertOK = driver.switchTo().alert();
	alertOK.accept();
	test.log(LogStatus.INFO, "Deleting User");
	////*[@id="isc_Ntable"]/tbody/tr[1]/td[6]
	Thread.sleep(5000);
	int ii=0;
	for(ii=1;true;ii++)
	{try {
		if(driver.findElement(By.xpath("//*[@id=\'isc_Ntable\']/tbody/tr["+ii+"]")).isDisplayed())
		System.out.println("User- "+ii+" Printed");
		test.log(LogStatus.INFO, "USER- "+ii+" PRINTED");
			
	}
	catch(NoSuchElementException e)
	{if(ii==1)
		{System.out.println("No Users Found!!");	
		assert(false);
		break;
		
		}	
	break;
	}
	}
	if(ii==i-1)
	{
		test.log(LogStatus.PASS, "User Deleted SUccessfully");	
		assert(true);
		
	}	
	else
	{
		test.log(LogStatus.FAIL,"User Deletion Failed");
		ss.capture();
		test.log(LogStatus.FAIL, test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn\\src\\test\\resources\\RemoveUsers\\RemoveUsers1.png"));
		assert(false);
	}
	
	
	
	
	
	}


	}
	
