package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class ShoppingCartSummaryPage extends Testbase 
{
	int totalAmountInSummaryPage;
	
	@FindBy(xpath ="//*[@id='total_price']")
	WebElement totalInSummaryPage;
	
	public int totalAmountinSummaryPage() {
		String totalAmountSummaryPageVar= totalInSummaryPage.getText();
		totalAmountSummaryPageVar= totalAmountSummaryPageVar.substring(1, 3);
		totalAmountInSummaryPage = Integer.parseInt(totalAmountSummaryPageVar);
			return 	totalAmountInSummaryPage;
	}
	
	public ShoppingCartSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	

	//p/a[@title='Proceed to checkout']
	@FindBy(xpath = "//p/a[@title='Proceed to checkout']")
	WebElement proceedToCheckOutInSummaryPage;
	
	public AddressPage clickToProceedToCheckOut() {
		proceedToCheckOutInSummaryPage.click();
		return new AddressPage();
	}
	
	
}
