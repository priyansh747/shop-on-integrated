package com.ShopOn.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingConfiguration {
	public WebDriver driver;
	WebDriverWait wait;

	public ShippingConfiguration(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "formSubmitButton")
	WebElement logon;

	@FindBy(className = "icon-plane")
	WebElement shipping;

	@FindBy(xpath = "//*[@id=\"shipType\"]")
	WebElement international;

	@FindBy(xpath = "//*[@id=\"shipType\"]")
	WebElement national;

	public void setUserName(String strUserName) {
		username.sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}

	public void clickLogon() throws InterruptedException {
		logon.click();
		Thread.sleep(5000);

	}

	public void clickShipping() throws InterruptedException {
		shipping.click();
		Thread.sleep(5000);
	}

	public void clickInternational() {
		international.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickNational() throws InterruptedException {
		national.click();
		Thread.sleep(5000);
	}

}
