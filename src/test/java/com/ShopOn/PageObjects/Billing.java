package com.ShopOn.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

public class Billing {
	public WebDriver driver;
	
	@FindBy(id = "signin_userName")
	WebElement uName;
	
	@FindBy(id = "signin_password")
	WebElement pword;
	
	@FindBy(xpath = "/html/body/div[3]/div/div/div[1]/div[2]/form/button")
	WebElement submit;
	
	@FindBy (xpath="/html/body/div[3]/div/div/div[1]/div/ul/li[2]/a")
	WebElement billing;
	
	@FindBy (xpath="/html/body/div[3]/div/div[1]/div[1]/span/p/a")
	WebElement billingEdit;
	
	@FindBy (xpath="/html/body/div[3]/div/div[1]/div[2]/span/p/a")
	WebElement shippingEdit;
	
	@FindBy(id="firstName")
	WebElement firstName;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="address")
	WebElement address;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="customer_country")
	WebElement customer_country;
	
	@FindBy(id="hidden_zones")
	WebElement hidden_zones;
	
	@FindBy(id="billingPostalCode")
	WebElement billingPostalCode;
	
	@FindBy(id="phone")
	WebElement phone;
	
	@FindBy(id="submitAddress")
	WebElement submitAddress;
	
	
	public Billing(WebDriver driver) {
		this.driver = driver;	
		PageFactory.initElements(driver,this);
	}
	
	public void clickBilling() {
		billing.click();
	}
	
	public void clickBillingEdit() {
		billingEdit.click();
	}
	
	public void EnterEmail(String uname) {
		uName.sendKeys(uname);
	}
	
	public void EnterPassword(String password) {
		pword.sendKeys(password);
	}
	
	public void clickSignIn() {
		submit.click();
	}
	
	public void EnterFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}
	
	public void EnterLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	
	public void EnterAddress(String address) {
		this.address.clear();
		this.address.sendKeys(address);
	}
	
	public void EnterCity(String city) {
		this.city.clear();
		this.city.sendKeys(city);
	}
	
	public void SelectCountry() {
		Select value1 = new Select(customer_country);
		value1.selectByVisibleText("India");
	}
	
	public void EnterState(String state) {
		this.hidden_zones.clear();
		this.hidden_zones.sendKeys(state);
	}
	
	public void EnterPost(String billingPostalCode) {
		this.billingPostalCode.clear();
		this.billingPostalCode.sendKeys(billingPostalCode);
	}
	
	public void Company(String company) {
		this.company.clear();
		this.company.sendKeys(company);
	}
	
	public void EnterPhone(String phone) {
		this.phone.clear();
		this.phone.sendKeys(phone);
	}
	
	public void clickSubmitAddress() {
		submitAddress.click();
	}
	
	public void clickShippingEdit() {
		shippingEdit.click();
	}
	
	
	
	
	
	
	
	
	

}
