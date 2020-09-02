package com.ShopOn.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.ShopOn.BasePage.BasePage;

public class SortByDefaultComputerBasics extends BasePage {
	public SortByDefaultComputerBasics(WebDriver driver) {
		super(driver);
	}

	
	public WebDriver driver; 
		@FindBy(xpath="/html/body/nav[2]/div/div[2]/ul/li[3]/a")
		WebElement Productsdropdown;

	

}
