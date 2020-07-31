package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class PaymentConfirmationPage extends Testbase {
	
	@FindBy(xpath = "//*[text()='I confirm my order']//parent::button")
	WebElement confirmMyOrderButton;
	
	public OrderConfirmationPage clickonConfirmMyOrder() {
		confirmMyOrderButton.click();
		return new OrderConfirmationPage();
	}

	
	public PaymentConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
}
