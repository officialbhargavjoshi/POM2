package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;
import com.crm.qa.util.Constants;
import com.crm.qa.util.WaitUtility;
import com.crm.qa.util.WriteUtil;

public class CreateAccountLinkPage  extends Testbase  {
	
	@FindBy(id = "email_create")
	@CacheLookup
	WebElement emailField;
	
	@FindBy(id = "SubmitCreate")
	WebElement submitButton;
	
	public CreateAccountLinkPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void fillEmailAddressField(String email) 
	{
		//WaitUtility.explicitWaitforVisibilityOfElement(emailField);
		WriteUtil.writeTo(WaitUtility.explicitWaitforVisibilityOfElement(emailField), email);
		
	}
	
	public CreateAccountPage clickOnCreateAccountButton() 
	{
		WaitUtility.explicitWaitforVisibilityOfElement(submitButton).click();
		//submitButton.click();
		return new CreateAccountPage();
		
	}
	
	
	@FindBy(id = "email")
	WebElement signInEmailField;
	
	
	@FindBy(id = "passwd")
	WebElement signInPasswordField;
	
	
	@FindBy(id = "SubmitLogin")
	WebElement submitLoginButton;
	
	
	public void fillEmailAddressFieldSignIn(String email) 
	{
		WebElement sElement = WaitUtility.explicitWaitforVisibilityOfElement(signInEmailField);
		WriteUtil.writeTo(sElement, email);
		
	}
	public void fillPassowrdFieldSignIn(String pwd) 
	{
		WriteUtil.writeTo(signInPasswordField, pwd);
		
	}
	
	public MyAccountPage clickOnSubmitbutton() 
	{
		submitLoginButton.click();
		return new MyAccountPage();
		
	}
	
	
	
	
	
	

}
