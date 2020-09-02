package com.ShopOn.admin.profile;


import static org.junit.Assert.*;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.BaseTest.BaseTest2;
import com.ShopOn.BaseTest.BaseTestAdmin;
import com.ShopOn.PageObjects.LoginPage;
import com.ShopOn.PageObjects.LoginPage1;
import com.ShopOn.Utilities.ReadExcel11;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class CreateOrEditUserBlank extends BaseTest2 {
	public int k;
	
	
	public static void startTest()
	{
	BaseTest.startTest();
	test = report.startTest("Blank Details TestCases");
	}
	

	
	public void setUp() {
		k=0;
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
		
		ScreenShot ss1=new ScreenShot(super.driver,"CreateOrEditUserBlank");
		ss1.cleanFolder();
		
		
		
		LoginPage1 objlogin = new LoginPage1(super.driver);
		objlogin.setUserName("admin@shopizer.com");
		objlogin.setPassword("password");
		objlogin.clickSubmit();
		ReadExcel11 e1=new ReadExcel11("./src/test/resources/ValidCases.xlsx","ValidCases");
		Sheet exampleSheet=e1.setExcelSheet();
		WebElement e=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]"));
		e.click();
		e=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/ul/li[1]"));
		e.click();
		e=driver.findElement(By.id("create-user-link"));
		e.click();
		String ss=driver.getCurrentUrl();
		int rowCount = exampleSheet.getLastRowNum()-exampleSheet.getFirstRowNum();
		//Create a loop over all the rows of excel file to read it
		String[] t;
		t=new String[8];
		k=0;
		for (int i = 0; i < rowCount+1; i++) {
			Row row = exampleSheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) 
				{t[j]=row.getCell(j).getStringCellValue();}
		
		
		 
		e=driver.findElement(By.id("adminName"));
		if(t[0].equals("BLANK"))
			e.sendKeys("");
		else
			e.sendKeys(t[0]+i);
		e=driver.findElement(By.id("adminEmail"));
		if(t[1].equals("BLANK"))
			e.sendKeys("");
		else
			e.sendKeys(t[1]);
		Thread.sleep(2000);
		
		e=driver.findElement(By.id("adminPassword"));
		if(t[2].equals("BLANK"))
			e.sendKeys("");
		else
			e.sendKeys(t[2]);
		
		e=driver.findElement(By.id("firstName"));
		if(t[3].equals("BLANK"))
			e.sendKeys("");
		else
			e.sendKeys(t[3]);
		
		e=driver.findElement(By.id("lastName"));
		if(t[4].equals("BLANK"))
			e.sendKeys("");
		else
			e.sendKeys(t[4]);
		
		
		Select select =new Select(driver.findElement(By.id("question1")));
		select.selectByIndex(0);
		e=driver.findElement(By.id("answer1"));
		if(t[5].equals("BLANK"))
			e.sendKeys("");
		else
			e.sendKeys(t[5]);
		select =new Select(driver.findElement(By.id("question2")));
		select.selectByIndex(1);
		e=driver.findElement(By.id("answer2"));
		if(t[6].equals("BLANK"))
			e.sendKeys("");
		else
			e.sendKeys(t[6]);
		select=new Select(driver.findElement(By.id("question3")));
		select.selectByIndex(2);
		e=driver.findElement(By.id("answer3"));
		if(t[7].equals("BLANK"))
			e.sendKeys("");
		else
			e.sendKeys(t[7]);
		
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		try {
		if(driver.findElement(By.xpath("//*[@id=\"user\"]/div[14]/div/button")).isEnabled())			
			{driver.findElement(By.xpath("//*[@id=\"user\"]/div[14]/div/button")).click();
			try{if(driver.findElement(By.id("user.errors")).isDisplayed())
				System.out.println("pass");}
			catch(Exception e4)
			{
			{wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("store.success")));
			if(driver.findElement(By.id("store.success")).isDisplayed())
				{System.out.println("fail");
				k+=1;
				ss1.capture();
				test.log(LogStatus.FAIL, test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn\\src\\test\\resources\\CreateOrEditUserBlank\\CreateOrEditUserBlank3.png"));
				break;
				}}}}
		}
		catch(Exception e2)
		{
			System.out.println("nfr");
			
		}
		
	
		try {	
		if(driver.findElement(By.xpath("//*[@id=\"user\"]/div[13]/div/button")).isEnabled())			
		{driver.findElement(By.xpath("//*[@id=\"user\"]/div[13]/div/button")).click();
		try{if(driver.findElement(By.id("user.errors")).isDisplayed())
			System.out.println("pass");}
		catch(Exception e4)
		{
		{wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("store.success")));
		if(driver.findElement(By.id("store.success")).isDisplayed())
			{System.out.println("fail");
			k+=1;
			ss1.capture();
			test.log(LogStatus.FAIL, test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn\\src\\test\\resources\\CreateOrEditUserBlank\\CreateOrEditUserBlank3.png"));
			break;
			}}}}
		}
		catch(Exception e2)
		{
			System.out.println("nfr");
			
		}
	try {	
	if(driver.findElement(By.xpath("//*[@id=\"user\"]/div[15]/div/button")).isEnabled())			
	{driver.findElement(By.xpath("//*[@id=\"user\"]/div[15]/div/button")).click();
	try{if(driver.findElement(By.id("user.errors")).isDisplayed())
		System.out.println("pass");}
	catch(Exception e4)
	{
	{wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("store.success")));
	if(driver.findElement(By.id("store.success")).isDisplayed())
		{System.out.println("fail");
		k+=1;
		ss1.capture();
		test.log(LogStatus.FAIL, test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn\\src\\test\\resources\\CreateOrEditUserBlank\\CreateOrEditUserBlank1.png"));
		break;
		}}}}
	else
		System.out.println("NotEnabled");
		}
		catch(Exception e2)
		{
			System.out.println("nfr");
			
		}
	
	
driver.navigate().to(ss);

	}
		System.out.println(k);
		
			
			if(k>=1)
				{
				test.log(LogStatus.FAIL, "Users With Blank Values Added");
				assert(false);
				
				}
			else
				{
				test.log(LogStatus.PASS, "Passed");
				assert(true);
				}
				}
		
}

