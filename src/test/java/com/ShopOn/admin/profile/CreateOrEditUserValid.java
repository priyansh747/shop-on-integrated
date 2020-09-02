package com.ShopOn.admin.profile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.BaseTest.BaseTest2;
import com.ShopOn.PageObjects.LoginPage;
import com.ShopOn.PageObjects.LoginPage1;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;

public class CreateOrEditUserValid extends BaseTest2 {

	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("Valid Details TestCase");
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
		
		
		ScreenShot ss=new ScreenShot(super.driver,"CreateOrEditUserValid");
		ss.cleanFolder();
		
		
		
		WebElement e=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]"));
		e.click();
		e=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/ul/li[1]"));
		e.click();
		e=driver.findElement(By.id("create-user-link"));
		e.click();
		e=driver.findElement(By.id("adminName"));
		e.sendKeys("Hello123");
		e=driver.findElement(By.id("adminEmail"));
		e.sendKeys("Hello");
		e=driver.findElement(By.id("adminPassword"));
		e.sendKeys("Helloa");
		e=driver.findElement(By.id("firstName"));
		e.sendKeys("Hello");
		e=driver.findElement(By.id("lastName"));
		e.sendKeys("Hello");
		driver.findElement(By.id("groups1")).click();
		driver.findElement(By.id("groups2")).click();
		driver.findElement(By.id("groups3")).click();
		driver.findElement(By.id("groups4")).click();
		driver.findElement(By.id("groups5")).click();
		driver.findElement(By.id("groups6")).click();
		driver.findElement(By.id("groups7")).click();
		Select select =new Select(driver.findElement(By.id("question1")));
		select.selectByIndex(0);
		e=driver.findElement(By.id("answer1"));
		e.sendKeys("hello");
		select =new Select(driver.findElement(By.id("question2")));
		select.selectByIndex(1);
		e=driver.findElement(By.id("answer2"));
		e.sendKeys("hello");
		select=new Select(driver.findElement(By.id("question3")));
		select.selectByIndex(2);
		e=driver.findElement(By.id("answer3"));
		e.sendKeys("hello");
		e=driver.findElement(By.xpath("//*[@id=\'user\']/div[14]/div/button"));
		e.click();
		Thread.sleep(2000);
		try {
		if(driver.findElement(By.id("store.success")).isDisplayed())
		{
			test.log(LogStatus.PASS, "VALID USER ADDED SUCCESSFULLY");
			assert(true);	
		
		}
		else {
		
		ss.capture();
		test.log(LogStatus.FAIL, test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn\\src\\test\\resources\\CreateOrEditUserValid\\CreateOrEditUserValid1.png"));
		assert(false);
		}
	}
	catch(Exception E)
		{
		test.log(LogStatus.FAIL, "Test Failed");
		ss.capture();
		test.log(LogStatus.FAIL, test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn\\src\\test\\resources\\CreateOrEditUserValid\\CreateOrEditUserValid1.png"));
		assert(false);
		}
	}


}
