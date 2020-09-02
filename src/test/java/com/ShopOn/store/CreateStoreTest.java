package com.ShopOn.store;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.PageObjects.AdminLogin;
import com.ShopOn.PageObjects.StorePage;
import static org.junit.Test.*;

import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class CreateStoreTest extends BaseTest{
	
	
	
	@BeforeClass
	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("CreateStoreTest");
	}
	
	public void setUp() {

		super.setUp();
		driver.navigate().to("http://15.207.109.183:8080/admin/logon.html");
		AdminLogin login= new AdminLogin(driver);
		login.login();
		driver.navigate().to("http://15.207.109.183:8080/admin/store/storeCreate.html");
	
	}
	
	
	public void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	public static void endTest() {
		BaseTest.endTest();
	}
	@Ignore
	@Test
	public void ValidDataTest() throws InterruptedException {
		StorePage create = new StorePage(driver);
		create.getName().sendKeys("BookWorld1");
		create.getStorecode().sendKeys("newst22ore");
		create.getPhone().sendKeys("991122334433");
		create.getAddress().sendKeys("#27,kakal33a");
		create.getEmail().sendKeys("myemail@my.c33om");
		create.getCity().sendKeys("patn33a");
		create.getPostalCode().sendKeys("133312233");
		
		create.getSubmit().click();
		Thread.sleep(2000);
		System.out.println(create.getmessage());

		assertEquals(create.getmessage(), "Request completed with success");
		
		
	}
	
}
