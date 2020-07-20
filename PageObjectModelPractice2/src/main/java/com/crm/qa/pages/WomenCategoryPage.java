package com.crm.qa.pages;



import org.apache.commons.collections4.Get;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;
import com.crm.qa.util.ActionsClassUtils;
import com.crm.qa.util.Constants;
import com.crm.qa.util.WaitUtility;
import com.crm.qa.util.WriteUtil;

public class WomenCategoryPage extends Testbase {
	
	//String iframe = "fancybox-frame1595152939505";
	String priceString = "a";
	
	//img[@title='Blouse']
	
	@FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?id_product=2&controller=product' and @title='Blouse']//child::img")
	WebElement itemSelected;
	
	
	@FindBy(xpath = "//a[@title='Blouse']/following-sibling::a[@class='quick-view']//child::span[text()='Quick view']")
	WebElement itemSelectedQuickView;
	
	
	
	//a[@title='Blouse']/following-sibling::a[@class='quick-view']
	//a[@href='http://automationpractice.com/index.php?id_product=2&controller=product' and @title='Blouse']//child::img
	//a[@title='Blouse']/following-sibling::a[@class='quick-view']
	
	//a[@title='Blouse']/following-sibling::a[@class='quick-view']//child::span[text()='Quick view']
	
public void clickItemSelected() {
		
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",itemSelected);
		ActionsClassUtils.moveToElement(driver,itemSelected);
		//javascriptExecutor.executeScript("arguments[0].click();",itemSelected);
		
		itemSelectedQuickView.click();
		//itemSelected.click();
		//WaitUtility.getFluentWait();
		driver.switchTo().frame(0);
		
		
		
}

/*public ShoppingCartSummaryPage addItemToCart() {
	
	clickItemSelected();
	writetoQuantityNeeded();
	clickOnAddToCart();
	return clickProceedToCheckOutButton();
	

	
}*/
		
	
	
	
	@FindBy(xpath = "//p[@class='our_price_display']/child::span")
	WebElement priceOfItemElement;
	
	public void getPriceOfItem() {
		priceString  = priceOfItemElement.getText();
		System.out.println(priceString);
		priceString = priceString.substring(1, 3);
		priceOfSingleItemInt = Integer.parseInt(priceString);
			
	}
	
	@FindBy(xpath = "//*[contains(text(),'Total products')]//following-sibling::span")
	WebElement priceOfTotalProducts;	
	public void getTotalPriceOfProducts() {
		WebElement priceOfTotalProducts2 = WaitUtility.explicitWaitforVisibilityOfElement(priceOfTotalProducts);
		String totalProductsPrice= priceOfTotalProducts2.getText();
		System.out.println(totalProductsPrice);
		
		totalProductsPrice= totalProductsPrice.substring(1, 3);
		priceOfTotalProductsInt = Integer.parseInt(totalProductsPrice);
				
	}
	
	@FindBy(xpath = "//*[contains(text(),'Total shipping')]/following-sibling::span")
	WebElement priceOfShippingProducts;	
	public void getPriceOfShipping() {
		String totalShippingPrice= priceOfShippingProducts.getText();
		totalShippingPrice= totalShippingPrice.substring(1, 2);
		priceOfShippingInt = Integer.parseInt(totalShippingPrice);
				
	}
	
	@FindBy(xpath = "//*[contains(text(),'Total shipping')]/parent::div//following-sibling::div[1]/span")
	WebElement totalAmountOfProducts;	
	public void getTotalAmountOfProducts() {
		String totalAmountVar= totalAmountOfProducts.getText();
		totalAmountVar= totalAmountVar.substring(1, 3);
		totalAmount = Integer.parseInt(totalAmountVar);
				
	}
	
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement proceedToCheckOutButton;
	public ShoppingCartSummaryPage clickProceedToCheckOutButton() {
		WebElement proceedButton = WaitUtility.explicitWaitforVisibilityOfElement(proceedToCheckOutButton);
		getTotalPriceOfProducts();
		getPriceOfShipping();
		getTotalAmountOfProducts();
		
		proceedButton.click();
		return new ShoppingCartSummaryPage();
	}
	
	
	
	//*[contains(text(),'Total shipping')]/following-sibling::span
	
	//*[contains(text(),'Total shipping')]/parent::div//following-sibling::div[1]/span
	
	
	@FindBy(xpath = "//input[@type='text' and @id='quantity_wanted']")
	WebElement quantityWantedField;
	
	public void writetoQuantityNeeded(String quantityWanted) {
	
		WriteUtil.writeTo(quantityWantedField, quantityWanted);
		getPriceOfItem();
	}
	
	@FindBy(xpath ="//button[@name='Submit']" )
	WebElement submitButtonIframe;
	
	
	public void clickOnAddToCart() {
		submitButtonIframe.click();
		driver.switchTo().defaultContent();
	}
	
	public WomenCategoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	}
	
	
	
	


