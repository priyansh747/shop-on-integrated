package com.ShopOn.test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Ignore;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ShopOn.BaseTest.BaseTest;
import com.ShopOn.PageObjects.Billing;
import com.ShopOn.Utilities.PropertyFile;
import com.ShopOn.Utilities.ReadExcel;
import com.ShopOn.Utilities.ReadExcel1;
import com.ShopOn.Utilities.ScreenShot;
import com.relevantcodes.extentreports.LogStatus;
@RunWith(Parameterized.class)
public class ShippingTest extends BaseTest {
	
	private String fname;
	private String lname;
	private String company;
	private String add;
	private String city;
	private String state;
	private String post;
	private String phone;
	
	public ShippingTest(String fname,String lname,String company,String add,String city,String state,String post,String phone) {
		this.fname = fname;
		this.lname = lname;
		this.company = company;
		this.add = add;
		this.city = city;
		this.state = state;
		this.post = post;
		this.phone = phone;
	}
	
	
	//public WebDriver driver;
	
	@BeforeClass
	public static void startTest() {
		BaseTest.startTest();
		test = report.startTest("ShippingTest");
	}
	
	@Before 
	public void setUp(){ 
		//Initiate the Browser 
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\drivers\\chromedriver.exe"); 
		driver = new ChromeDriver(); 
		//Open Admin Login 
		driver.get("http://15.207.109.183:8080/shop/customer/customLogon.html"); 
		
	} 
	@Ignore
	@Test
	public void Billing()throws InterruptedException,Exception{
		File file = new File("C://Users//athar//Downloads//testdata.xlsx");
		Billing objLogin = new Billing(super.driver);
		objLogin.EnterEmail("michaelscott@dunderm.com");
		objLogin.EnterPassword("123456");
		Thread.sleep(2000);
		WebElement cookie = driver.findElement(By.xpath("/html/body/div[1]/div/a"));
		cookie.click();
		objLogin.clickSignIn();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[1]/div/ul/li[2]/a")));
		objLogin.clickBilling();
		
		
		objLogin.clickShippingEdit();
		objLogin.EnterAddress(add);
		objLogin.EnterFirstName(fname);
		objLogin.EnterLastName(lname);
		objLogin.Company(company); 
		objLogin.EnterCity(city);
		objLogin.EnterState(state);
		objLogin.EnterPost(post);
		objLogin.EnterPhone(phone);
		objLogin.clickSubmitAddress();
		WebElement success = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div[1]"));
		boolean result  = success.isDisplayed();
		if(!result) {
			test.log(LogStatus.PASS, "Test Passed");
		}
		else {
			ScreenShot ss=new ScreenShot(super.driver,"EditBilling");
	
			ss.capture();
			
			System.out.println(ss.getScreenshotName("EditBilling").replace("/", "\\\\"));
			test.log(LogStatus.FAIL,test.addScreenCapture("C:\\Users\\Lenovo\\Automation Testing\\com.ShopOn"+ss.getScreenshotName("EditBilling").replace("/", "\\\\"))+ "Test Failed");
			ss.capture();
			System.out.println(ss.getScreenshotName("EditBilling").replace("/", "\\\\"));
			fail();
			
			
		}
				
		
	}
	@Parameterized.Parameters
	public static Collection testdata() throws IOException{ 
		  System.out.println("yo");
		  ReadExcel1 excel=new ReadExcel1(new PropertyFile().get("screenshotsFolderPath").replace("/", "\\\\")+"testdata.xlsx","Sheet1");
		  //excel.ReadSheet(excel.setExcelSheet());
		  int row=excel.getRowCount();
		  int lastcell=excel.lastCell();
		  Object [][] data=new Object[row][8];
	
		  for(int i=1;i<=row;i++) {
			  for(int j=1;j<lastcell;j++) {
				  data[i-1][j-1]=excel.readCellData(i, j);
				  //System.out.println(data[i-1][j-1]);
			  	}
		  }
		//  System.out.println(data.toString());
		
		  return Arrays.asList(data);
		  
	}
	
	//@Test
	/*public void Test() throws IOException {
		ReadExcel excel=new ReadExcel(new PropertyFile().get("screenshotsFolderPath").replace("/", "\\\\")+"testdata.xlsx","Sheet1");
		System.out.println(excel.readCellData(1, 1));
	}*/

}
