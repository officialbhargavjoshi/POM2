/*
Author : Bhargav Joshi
*/
package com.crm.qa.testcases;

import org.apache.poi.ss.formula.DataValidationEvaluator.ValidationEnum;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.MyAccountPage;
//import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateAccountLinkPage;
import com.crm.qa.pages.CreateAccountPage;
import com.crm.qa.pages.LandingPage;
//import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.ActionsClassUtils;;

public class MyAccountPageTest  extends Testbase

{
	
	
	LandingPage landingPage;
	CreateAccountLinkPage createAccountLinkPage;
	CreateAccountLinkPage createAccountLinkPage2;
	CreateAccountPage createAccountPage;
	TestUtil testUtil;
	MyAccountPage accountPage;
	MyAccountPage accountPage2;
	String sheetName = "contacts";
	/*ContactsPage contactsPage;
	String sheetName = "contacts";
	*/
	
	public MyAccountPageTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		
		//contactsPage = new ContactsPage();
		landingPage = new LandingPage();
		createAccountLinkPage = landingPage.clickOnCreateAccountPageLink();
		
		
		
		
		
	}
	
	
	
	
	
	@Test(priority = 1,dataProvider="getCRMTestData")
	public void verifyLogoutLoginSuccessfully(String fn, String ln,String email , String pwd , String day,String month, String year,String company,String add1, String add2, String city, String state, String pc,String mobileNumber,String qString) throws InterruptedException {
//		createAccountLinkPage.fillEmailAddressField(email);
//		createAccountPage = createAccountLinkPage.clickOnCreateAccountButton();		
//		accountPage = createAccountPage.fillFormData(fn,  ln,email, pwd ,  day, month,  year, company, add1,  add2,  city,  state,  pc, mobileNumber);
//		
		//accountPage = new MyAccountPage();
		//createAccountLinkPage2 = accountPage.clickLogOut();
		createAccountLinkPage2 = new CreateAccountLinkPage();
		
		createAccountLinkPage2.fillEmailAddressFieldSignIn(email);
		createAccountLinkPage2.fillPassowrdFieldSignIn(pwd);
		accountPage2 = createAccountLinkPage2.clickOnSubmitbutton();
		String string = accountPage2.getMyAccountFieldText();
		Assert.assertEquals(string, "My account");
		
		
	}
		
		
	
		
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
