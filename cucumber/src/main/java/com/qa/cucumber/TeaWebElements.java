package com.qa.cucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaWebElements {
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a")
	private WebElement menuItem;
	
	@FindBy(xpath = "//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a")
	private WebElement checkOutItem;
	
	@FindBy(className = "wsb-button customStyle ")
	private WebElement menuElement;
	
	@FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]")
	private WebElement checkOutForm;

	public WebElement getmenuItem() {
		return menuItem;
	}
	public WebElement getmenuElement() {
		return menuElement;
	}
	public WebElement getcheckOutForm() {
		return checkOutForm;
	}
	
	public void clickMenuItem() {
		menuItem.click();
	}
	public void clickCheckoutItem() {
		menuItem.click();
	}
}


