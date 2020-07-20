package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class OrderHistoryPage extends Testbase 
{
	//td[@class= 'history_price']/span
	
	int totalAmountInOrderHistoryPage;	
	
	@FindBy(xpath ="//td[@class= 'history_price']/span")
	WebElement totalInOrderHistoryPageElement;
	
	public int totalAmountinOrderHistoryPage() {
		String totalAmountOrderHistoryPageVar= totalInOrderHistoryPageElement.getText();
		totalAmountOrderHistoryPageVar= totalAmountOrderHistoryPageVar.substring(1, 3);
		totalAmountInOrderHistoryPage = Integer.parseInt(totalAmountOrderHistoryPageVar);
			return 	totalAmountInOrderHistoryPage;
	}
	
	
	public OrderHistoryPage() {
		PageFactory.initElements(driver, this);
	}

}
