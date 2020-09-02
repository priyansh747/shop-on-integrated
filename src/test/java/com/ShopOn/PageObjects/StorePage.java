package com.ShopOn.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ShopOn.BasePage.BasePage;

public class StorePage extends BasePage {
		
	public StorePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="storename")
	WebElement name;
	
	@FindBy(id="storephone")
	WebElement phone;
	
	@FindBy(id="storeEmailAddress")
	WebElement email;
	
	@FindBy(id="storecity")
	WebElement city;
	
	@FindBy(id="storeaddress")
	WebElement address;
	
	
	@FindBy(id="country.isoCode")
	WebElement countryDrop;
	
	@FindBy(id="storestateprovince")
	WebElement stateProvince;
	
	@FindBy(id="storepostalcode")
	WebElement postalCode;
	
	
	@FindBy(id="languages2")
	WebElement lang2;
	
	
	@FindBy(id="languages1")
	WebElement lang1;
	
	@FindBy(id="defaultLanguage.id")
	WebElement defaultlang;
	
	@FindBy(id="currency.id")
	WebElement currency;
	
	@FindBy(id="currencyFormatNational1")
	WebElement currencyformcheckbox;
	
	@FindBy(id="weightunitcode")
	WebElement weightunit;
	
	@FindBy(id="seizeunitcode")
	WebElement sizeunit;
	
	@FindBy(id="dateBusinessSince")
	WebElement dateSince;
	

	@FindBy(id="domainName")
	WebElement domain;
	
	@FindBy(xpath = "/html/body/div/div[3]/div/div[2]/div/form/div[20]/div/button")
	WebElement submit;
	
	@FindBy(id= "code")
	WebElement storecode;
	
	@FindBy(id="store.success")
	WebElement success;

	public WebElement getName() {
		return name;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCountryDrop() {
		return countryDrop;
	}

	public WebElement getStateProvince() {
		return stateProvince;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getLang2() {
		return lang2;
	}

	public WebElement getLang1() {
		return lang1;
	}

	public WebElement getDefaultlang() {
		return defaultlang;
	}

	public WebElement getCurrency() {
		return currency;
	}

	public WebElement getCurrencyformcheckbox() {
		return currencyformcheckbox;
	}

	public WebElement getWeightunit() {
		return weightunit;
	}

	public WebElement getSizeunit() {
		return sizeunit;
	}

	public WebElement getDateSince() {
		return dateSince;
	}

	public WebElement getDomain() {
		return domain;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getStorecode() {
		return storecode;
	}
	
	public String getmessage() {
		return success.getText();
	}
	
	
	
}
