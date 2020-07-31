package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class ShippingPage  extends Testbase {

	
	@FindBy(xpath = "//button[@name='processCarrier']")
	WebElement proceedToCheckOutShippingPage;
	
	
	@FindBy(xpath= "//input[@type='checkbox' and @id='cgv']")
	WebElement agreeToTermscheckBox;
	
	public PaymentPage clickToProceedToCheckOutShippingPage() {
		proceedToCheckOutShippingPage.click();
		return new PaymentPage();
		
	}
	
	public void clickToAgreeTerms() {
		agreeToTermscheckBox.click();
	}
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	
}
