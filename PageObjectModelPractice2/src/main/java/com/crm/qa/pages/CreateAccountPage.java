package com.crm.qa.pages;

import org.apache.log4j.varia.StringMatchFilter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Testbase;
import com.crm.qa.util.Constants;
import com.crm.qa.util.WriteUtil;

public class CreateAccountPage  extends Testbase
{
	
	
	
	@FindBy(id = "id_gender1")
	WebElement titleMale;
	
	
	
	@FindBy(id = "id_gender2")
	WebElement titleFemale;
	
	public CreateAccountPage() {
		PageFactory.initElements(driver, this);
	}

	
	public void clickOnTitle()
	{
		titleMale.click();
		
	}
	
	@FindBy(id = "customer_firstname")
	WebElement customerFirstName;
	
	
	public void writeCustomerFirstName(String firstName) 
	{
		WriteUtil.writeTo(customerFirstName, firstName);
	}
	
	
	@FindBy(id = "customer_lastname")
	WebElement customerLastName;
	
	public void writeCustomerLastName(String lastName) 
	{
		WriteUtil.writeTo(customerLastName, lastName);
	}
	
	
	
	@FindBy(id = "email")
	WebElement emailElement;
	
	public void writeEmail(String email) 
	{
		WriteUtil.writeTo(emailElement, email);
	}
	
	@FindBy(id = "passwd")
	WebElement passwordElement;
	
	public void writePassword(String password) 
	{
		WriteUtil.writeTo(passwordElement, password);
	}
	
	
	@FindBy(id = "days")
	WebElement dateOfBirthDaySelect;
	
	public void clickOnDateOfBirthDay(String day) throws InterruptedException 
	{
		Select daySelect = new Select(dateOfBirthDaySelect);
		daySelect.selectByValue(day);
		Thread.sleep(5000);
	}
	
	
	
	@FindBy(id = "months")
	WebElement dateOfBirthMonthSelect;
	public void clickOnMonthOfBirthDay(String month) 
	{
		
		Select monthSelect = new Select(dateOfBirthMonthSelect);
		monthSelect.selectByIndex(Integer.parseInt(month));
	}
	
	
	
	@FindBy(id = "years")
	WebElement dateOfBirthYearSelect;
	public void clickOnYearOfBirthDay(String year) 
	{
		Select yearSelect = new Select(dateOfBirthYearSelect);
		yearSelect.selectByValue(year);
	}
	
	
	
	@FindBy(id = "company")
	WebElement companyElement;
	
	public void writeCompanyName(String company) 
	{
		WriteUtil.writeTo(companyElement, company);
	}
	
	@FindBy(id = "firstname")
	WebElement firstNameAddElement;
	
	public void writefirstNameAdd(String firstNameAdd ) 
	{
		WriteUtil.writeTo(firstNameAddElement, firstNameAdd);
	}
	
	
	@FindBy(id = "lastname")
	WebElement lastNameAddElement;
	public void writeLastNameAdd(String writeLastName) 
	{
		WriteUtil.writeTo(lastNameAddElement, writeLastName);
	}

	
	@FindBy(id = "address1")
	WebElement addresLine1;
	public void writeAddress1(String addressLineOne) 
	{
		WriteUtil.writeTo(addresLine1, addressLineOne);
	}
	
	@FindBy(id = "address2")
	WebElement addresLine2;
	public void writeAddress2(String addressLineTwo) 
	{
		WriteUtil.writeTo(addresLine2,addressLineTwo);
	}
	
	
	@FindBy(id = "city")
	WebElement cityElement;
	public void writeCity(String city) 
	{
		WriteUtil.writeTo(cityElement, city);
	}
	
	
	@FindBy(id = "id_state")
	WebElement stateDropdownElement;
	
	public void clickOnState(String state) 
	{
		//Select yearSelect = new Select(dateOfBirthYearSelect);
		Select stateSelect = new Select(stateDropdownElement);
		stateSelect.selectByIndex(Integer.parseInt(state));
	}
	
	
	@FindBy(id = "postcode")
	WebElement postcodeElement;
	public void writePostalCode(String postcode) 
	{
		WriteUtil.writeTo(postcodeElement, postcode);
	}
	
	@FindBy(id = "phone_mobile")
	WebElement mobilePhoneNumberElement;	
	public void writeMobilePhoneNumber(String mobileNumber) 
	{
		WriteUtil.writeTo(mobilePhoneNumberElement, mobileNumber);
	}
	
	@FindBy(id = "submitAccount")
	WebElement submitButton;
	public void clickOnSubmit()
	{
		submitButton.click();
		
	}
	
	public MyAccountPage fillFormData(String fn, String ln,String email,String pwd , String day,String month, String year,String company,String add1, String add2, String city, String state, String pc,String mobileNumber ) throws InterruptedException 
	{
		clickOnTitle();
		writeCustomerFirstName(fn );
		writeCustomerLastName(ln);
		writeEmail(email);
		writePassword(pwd);
		clickOnDateOfBirthDay(day);
		clickOnMonthOfBirthDay(month);
		clickOnYearOfBirthDay(year);
		writeCompanyName(company);
		writefirstNameAdd(fn);
		writeLastNameAdd(ln);
		writeAddress1(add1);
		writeAddress2(add2);
		writeCity(city);
		clickOnState(state);
		writePostalCode(pc);
		writeMobilePhoneNumber(mobileNumber);
		clickOnSubmit();
		
		return new MyAccountPage();
		
		
	}
	
	
	

}
