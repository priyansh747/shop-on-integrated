package com.ShopOn.PageObjects;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ShopOn.BasePage.BasePage;
import com.ShopOn.Utilities.ScreenShot;
import com.ShopOn.UserTriesToRegister.RegisterWithValidData_TC_14;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class RegisterUser extends BasePage {
	public WebDriver driver;

	@FindBy(id = "customerAccount")
	WebElement hover;

	@FindBy(xpath = "//*[@id=\"registerLink\"]")
	WebElement register;

	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "lastName")
	WebElement lastName;

	@FindBy(id = "registration_country")
	WebElement country;

	@FindBy(id = "hidden_zones")
	WebElement state;

	@FindBy(id = "emailAddress")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "passwordAgain")
	WebElement repeat;

	@FindBy(xpath = "//*[@id=\"registrationForm\"]/button")
	WebElement submit;

	public RegisterUser(WebDriver driver) {
		super(driver);
//		PageFactory.initElements(driver, this);
	}

	public void clickOnMyAccount(WebDriver driver) throws InterruptedException {
		Actions builder = new Actions(driver);
		hover.click();
		Action mouseOver = builder.moveToElement(hover).click(register).build();
		mouseOver.perform();
	}

	public void enterFirstName(WebDriver driver, String fname) throws InterruptedException {
		firstName.click();
		firstName.sendKeys(fname);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", lastName);
	}

	public void enterLastName(WebDriver driver, String lname) {
		lastName.clear();
		lastName.click();
		lastName.sendKeys(lname);
	}

	public void enterCountry(WebDriver driver, String c) {
		Select value1 = new Select(country);
		country.click();
		value1.selectByVisibleText(c);
	}

	public void enterState(WebDriver driver, String s) {
		state.click();
		state.sendKeys(s);
	}

	public void enterEmail(WebDriver driver, String e) {
		email.click();
		email.sendKeys(e);
	}

	public void enterPassword(WebDriver driver, String p) {
		password.click();
		password.sendKeys(p);
	}

	public void enterRepeatPassword(WebDriver driver, String pr) {
		repeat.click();
		repeat.sendKeys(pr);
	}

	public void clickSubmit() {
		submit.click();
	}

}
