package com.ShopOn.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ShopOn.BasePage.BasePage;


public class AdminHome extends BasePage{

	public AdminHome(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"isc_0\"]")
	WebElement orderList;

	@FindBy(linkText = "Home")
	WebElement home;
	
	@FindBy(partialLinkText = "Details")
	WebElement orderItem1;
	
	@FindBy(id="isc_4")
	WebElement columnId;

	@FindBy(id="isc_6")
	WebElement columnName;
	
	@FindBy(id="isc_8")
	WebElement columnTotal;
	
	@FindBy(id="isc_A")
	WebElement columnDate;

	@FindBy(id="isc_C")
	WebElement columnStatus;
	
	@FindBy(id="isc_E")
	WebElement columnPayment;

	public WebElement getOrderList() {
		return orderList;
	}



	public void setOrderList(WebElement orderList) {
		this.orderList = orderList;
	}



	public WebElement getOrderItem1() {
		return orderItem1;
	}



	public void setOrderItem1(WebElement orderItem1) {
		this.orderItem1 = orderItem1;
	}
	
	public void sortByStatus() {
		columnStatus.click();
		
	}
	public void sortByPayment() {
		columnPayment.click();
		
	}
	
	public void sortByTotal() {
		columnTotal.click();
		
	}
	public void sortByDate() {
		columnDate.click();
		
	}
	public void sortByName() {
		columnName.click();
		
	}
	
	public void sortByID() {
		columnId.click();
		
	}
	



	public void clickFirstItem() {
		orderItem1.click();
	}

}
