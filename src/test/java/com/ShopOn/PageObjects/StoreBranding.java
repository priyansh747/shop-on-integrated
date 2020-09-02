package com.ShopOn.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ShopOn.BasePage.BasePage;

public class StoreBranding extends BasePage{

	public StoreBranding(WebDriver driver) {
		super(driver);
	}

@FindBy(xpath="//*[@id='imageControlRemove']/a")
WebElement removeLogo;

@FindBy(xpath="//*[@id='command']/div[3]/div/button")
WebElement logoSubmit;

@FindBy(id="storeTemplate")
WebElement template;


public WebElement getTemplate() {
	return template;
}

public void setTemplate(WebElement template) {
	this.template = template;
}

@FindBy(xpath="//*[@id='store']/div[2]/div/button")
WebElement themeSubmit;	

public void Remove() {
   removeLogo.click();
}

public void clickLogoSubmit() {
   logoSubmit.click();
}

public void clickThemeSubmit() {
   themeSubmit.click();
}

}