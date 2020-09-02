package com.ShopOn.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.ShopOn.BasePage.BasePage;

public class ViewCart extends BasePage{
	public WebDriver driver;

	@FindBy(xpath = "/html/body/nav[1]/div/ul/li[3]")
	WebElement shoppingCart;

	@FindBy(xpath = "//*[@id=\"miniCartDetails\"]/li/div/ol/h5")
	WebElement noElements;
	
	@FindBy(xpath = "//*[@id=\"featuredItemsContainer\"]/div[1]/div[2]/div/div")
	WebElement addBook1;
	
	@FindBy(xpath = "//*[@id=\"featuredItemsContainer\"]/div[2]/div[2]/div/div")
	WebElement addBook2;
	
	@FindBy(xpath = "//*[@id=\"miniCartDetails\"]/li[1]/div/ol/li[1]/div[2]/span")
	WebElement priceBook1;
	
	@FindBy(xpath = "//*[@id=\"miniCartDetails\"]/li[1]/div/ol/li[2]/div[2]/span")
	WebElement priceBook2;
	
	@FindBy(xpath = "//*[@id=\"miniCxartDetails\"]/li[2]/div/a[1]")
	WebElement totalPriceOfCart;
	
	int book1Qty;
	int book2Qty;
	float total;
	
	public void enterQty(int q1, int q2) {
		book1Qty = q1;
		book2Qty = q2;
	}

	public ViewCart(WebDriver driver) {
		super(driver);
	}

	public void hoverCart(WebDriver driver) throws InterruptedException {
		Actions builder = new Actions(driver);
		shoppingCart.click();
		Action mouseOver = builder.moveToElement(shoppingCart).build();
		mouseOver.perform();
	}

	
	
	public void addToCart() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", addBook1);
		addBook1.click();
		js.executeScript("arguments[0].scrollIntoView();", shoppingCart);
	}
	
	public void addToCartBook2() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", addBook2);
		addBook2.click();
		js.executeScript("arguments[0].scrollIntoView();", shoppingCart);
	}
	
	public float returnTotal() {
		System.out.println(priceBook1.getText());
		System.out.println(priceBook2.getText());
		String b1 = priceBook1.getText().substring(3);
		String b2 = priceBook2.getText().substring(3);
		
		total = (Integer.parseInt(b1)*book1Qty)+(Integer.parseInt(b2)*book2Qty);
		System.out.println("Calculated Total = "+total);
		return total;
	}
	
	

}
