package com.ShopOn.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ShopOn.BasePage.BasePage;

public class AdminLogin extends BasePage{

	public AdminLogin(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="formSubmitButton")
	WebElement submit;
	
	public void setUserName(String strUserName) {
		(username).sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
		(password).sendKeys(strPassword);
	}
	
	
	public void submit() {
		submit.click();
	}
	
	public void login() {
		setPassword("password");
		setUserName("admin@shopizer.com");
		submit();
	}
}
