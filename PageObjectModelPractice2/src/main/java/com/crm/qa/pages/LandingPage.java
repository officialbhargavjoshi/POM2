
package com.crm.qa.pages;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.ActionsClassUtils;


public class LandingPage extends Testbase {
	
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signInLink;
	
	
	
	public LandingPage()
	{
		PageFactory.initElements(driver, this);
	}
		
	
	
	
	public CreateAccountLinkPage clickOnCreateAccountPageLink() 
	{
		//ActionsClassUtils.clickByElement(driver,signInLink );
		
		signInLink.click();
		return new CreateAccountLinkPage();
	}	
	
	

	

	

	
}
