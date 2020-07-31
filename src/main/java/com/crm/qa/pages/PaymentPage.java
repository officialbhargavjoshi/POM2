package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class PaymentPage  extends Testbase
{
	
	int totalAmountInPaymentPage;	
	
	
	@FindBy(xpath ="//*[@id='total_price']")
	WebElement totalInPaymentPage;

	
	public int totalAmountinPaymentPage() {
		String totalAmountPaymentPageVar= totalInPaymentPage.getText();
		totalAmountPaymentPageVar= totalAmountPaymentPageVar.substring(1, 3);
		totalAmountInPaymentPage = Integer.parseInt(totalAmountPaymentPageVar);
			return 	totalAmountInPaymentPage;
	}
	
	
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement payByBankButton;
	
	
	public PaymentConfirmationPage clickOnPayByBankButton() {
		payByBankButton.click();
		return new PaymentConfirmationPage();
	}
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
}
