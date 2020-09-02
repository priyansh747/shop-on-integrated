package com.ShopOn.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ShopOn.BasePage.BasePage;

public class SortByDefaultTechnology11 extends BasePage {
	
	public SortByDefaultTechnology11(WebDriver driver) {
	super(driver);
}

	
	public WebDriver driver; 
		@FindBy(xpath="/html/body/nav[2]/div/div[2]/ul/li[3]/a")
		WebElement Productsdropdown;

	
	
}


