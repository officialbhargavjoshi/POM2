package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class AddressPage  extends Testbase{
	
	
	@FindBy(xpath = "//button[@name='processAddress']")
	WebElement proceedToCheckOutAddressPage;
	
	public ShippingPage clickToProceedToCheckOutAddressPage() {
		proceedToCheckOutAddressPage.click();
		return new ShippingPage();
	}
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
