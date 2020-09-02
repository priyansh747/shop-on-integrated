package com.ShopOn.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ShopOn.BasePage.BasePage;

public class StoreHome extends BasePage{

public StoreHome(WebDriver driver) {
          super(driver);
  }

@FindBy(id="title0")
WebElement pagetitle;

@FindBy(xpath="//*[@id='storeLanding']/div[10]/div/button")
WebElement submit;

public void setPageTitle(String strPageTitle){
         pagetitle.sendKeys(strPageTitle);
}

	public void submit() {
		submit.click();
	}
	
	public boolean isTitleEnabledAndDisplayed() {
		return (pagetitle.isEnabled() & pagetitle.isDisplayed());
	}
}	
