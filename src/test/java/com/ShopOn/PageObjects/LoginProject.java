package com.ShopOn.PageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ShopOn.BasePage.BasePage;

public class LoginProject extends BasePage {

	public LoginProject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriverWait wait;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "formSubmitButton")
	WebElement logon;

	@FindBy(id = "remember")
	WebElement remember;

	@FindBy(xpath = "/html/body/div[1]/div[1]/div/div[2]/div/div/ul[1]/li/a")
	WebElement dropdown;

	@FindBy(xpath = "/html/body/div[1]/div[1]/div/div[2]/div/div/ul[1]/li/ul/li[3]/a")
	WebElement logout;

	public void setUserName(String strUserName) {
		username.sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}

	public void clickRemember() {
		remember.click();
	}

	public void clickLogon() throws InterruptedException {
		logon.click();
		Thread.sleep(5000);
	}

	public void clickDropdown() {
		// it = new WebDriverWait(super.driver, 10);
		// it.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/ul[1]/li/a")));
		dropdown.click();
	}

	public void clickLogout() throws InterruptedException {
		logout.click();
		Thread.sleep(5000);
		// wait = new WebDriverWait(super.driver, 10);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

	}

	public void takeSnapShot(WebDriver driver, String fileWithPath) {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

