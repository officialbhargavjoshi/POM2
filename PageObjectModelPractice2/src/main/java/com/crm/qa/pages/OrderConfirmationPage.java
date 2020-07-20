package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class OrderConfirmationPage  extends Testbase{
	
	
	@FindBy(xpath = "//a[@title = 'View my customer account']")
	WebElement viewMyAccount;
	
	
	@FindBy(xpath = "//h1[contains(text(),'Order confirmation')]")
	WebElement orderConfirmationElement;
	
	public String  getOrderConfirmationElementText() {
		return orderConfirmationElement.getText();
	}
	
	public MyAccountPage clickOnViewMyAccountLink() {
		viewMyAccount.click();
		return new MyAccountPage();
	}
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	

}
