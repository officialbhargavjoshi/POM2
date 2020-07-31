package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.AddressPage;
import com.crm.qa.pages.CreateAccountLinkPage;
import com.crm.qa.pages.CreateAccountPage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.MyAccountPage;
import com.crm.qa.pages.OrderConfirmationPage;
import com.crm.qa.pages.OrderHistoryPage;
import com.crm.qa.pages.PaymentConfirmationPage;
import com.crm.qa.pages.PaymentPage;
import com.crm.qa.pages.ShippingPage;
import com.crm.qa.pages.ShoppingCartSummaryPage;
import com.crm.qa.pages.WomenCategoryPage;
import com.crm.qa.util.TestUtil;

public class OrderConfirmationPageTest  extends Testbase
{
	

	LandingPage landingPage;
	//CreateAccountLinkPage createAccountLinkPage;
	CreateAccountLinkPage createAccountLinkPage2;
	CreateAccountPage createAccountPage;
	TestUtil testUtil;
	MyAccountPage accountPage;
	MyAccountPage accountPage2;
	
	WomenCategoryPage womenCategoryPage;
	ShoppingCartSummaryPage shoppingCartSummaryPage;
	
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	PaymentConfirmationPage paymentConfirmationPage;
	OrderConfirmationPage orderConfirmationPage;
	OrderHistoryPage orderHistoryPage;
	MyAccountPage accountPage3;
	
	
	String sheetName = "contacts";
	/*ContactsPage contactsPage;
	String sheetName = "contacts";
	*/
	
	public OrderConfirmationPageTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@DataProvider(parallel =true)
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		
		//contactsPage = new ContactsPage();
		landingPage = new LandingPage();
		createAccountLinkPage2 = landingPage.clickOnCreateAccountPageLink();
		
		
		
		
	}
	
	
	
	
	
	@Test(priority = 1,dataProvider="getCRMTestData")
	public void verifyOrderPlacedSuccessfully(String fn, String ln,String email , String pwd , String day,String month, String year,String company,String add1, String add2, String city, String state, String pc,String mobileNumber,String quantity) throws InterruptedException 
	{
		
		
		
		//createAccountLinkPage2 = new CreateAccountLinkPage();
		createAccountLinkPage2.fillEmailAddressFieldSignIn(email);
		createAccountLinkPage2.fillPassowrdFieldSignIn(pwd);
		accountPage2 = createAccountLinkPage2.clickOnSubmitbutton();
		womenCategoryPage = accountPage2.clickOnWomenPageLink();
		womenCategoryPage.clickItemSelected();		
		womenCategoryPage.writetoQuantityNeeded(quantity);
		womenCategoryPage.clickOnAddToCart();
		shoppingCartSummaryPage  = womenCategoryPage.clickProceedToCheckOutButton();
		
		
		addressPage = shoppingCartSummaryPage.clickToProceedToCheckOut();
		shippingPage = addressPage.clickToProceedToCheckOutAddressPage();
		shippingPage.clickToAgreeTerms();
		paymentPage = shippingPage.clickToProceedToCheckOutShippingPage();
		
		
		
		
		paymentConfirmationPage = paymentPage.clickOnPayByBankButton();
		orderConfirmationPage = paymentConfirmationPage.clickonConfirmMyOrder();
		String orderConfirmText = orderConfirmationPage.getOrderConfirmationElementText();
		assertEquals(orderConfirmText, "ORDER CONFIRMATION");
		
		
		
		
	}
	
	
	@Test(priority = 1,dataProvider="getCRMTestData" , groups = "AmountVerification")
	public void verifyAmountCalculatedSuccessfully(String fn, String ln,String email , String pwd , String day,String month, String year,String company,String add1, String add2, String city, String state, String pc,String mobileNumber,String quantity) throws InterruptedException 
	{

		createAccountLinkPage2 = new CreateAccountLinkPage();
		createAccountLinkPage2.fillEmailAddressFieldSignIn(email);
		createAccountLinkPage2.fillPassowrdFieldSignIn(pwd);
		accountPage2 = createAccountLinkPage2.clickOnSubmitbutton();
		womenCategoryPage = accountPage2.clickOnWomenPageLink();
		womenCategoryPage.clickItemSelected();		
		womenCategoryPage.writetoQuantityNeeded(quantity);
		womenCategoryPage.clickOnAddToCart();
		shoppingCartSummaryPage  = womenCategoryPage.clickProceedToCheckOutButton();
		int var = priceOfSingleItemInt * Integer.parseInt(quantity);
		Assert.assertEquals(priceOfTotalProductsInt, var  );
		
		
		
	}
	
	/*@Test(priority = 1,dataProvider="getCRMTestData", groups = "AmountVerification")
	public void verifyTotalAmountCalculatedSuccessfully(String fn, String ln,String email , String pwd , String day,String month, String year,String company,String add1, String add2, String city, String state, String pc,String mobileNumber,String quantity) throws InterruptedException 
	{
		
		createAccountLinkPage2 = new CreateAccountLinkPage();
		createAccountLinkPage2.fillEmailAddressFieldSignIn(email);
		createAccountLinkPage2.fillPassowrdFieldSignIn(pwd);
		accountPage2 = createAccountLinkPage2.clickOnSubmitbutton();
		womenCategoryPage = accountPage2.clickOnWomenPageLink();
		womenCategoryPage.clickItemSelected();		
		womenCategoryPage.writetoQuantityNeeded(quantity);
		womenCategoryPage.clickOnAddToCart();
		shoppingCartSummaryPage  = womenCategoryPage.clickProceedToCheckOutButton();
		
		
		int var = priceOfTotalProductsInt + priceOfShippingInt;
		//Assert.assertEquals(priceOfTotalProductsInt, var  );
		
		Assert.assertEquals(totalAmount,  var ); 
		
		
	
		
	}*/
	/*@Test(priority = 1,dataProvider="getCRMTestData", groups = "AmountVerification")
	public void verifyTotalInShippingPageShownCorrectly(String fn, String ln,String email , String pwd , String day,String month, String year,String company,String add1, String add2, String city, String state, String pc,String mobileNumber,String quantity) throws InterruptedException 
	{
	
		createAccountLinkPage2 = new CreateAccountLinkPage();
		createAccountLinkPage2.fillEmailAddressFieldSignIn(email);
		createAccountLinkPage2.fillPassowrdFieldSignIn(pwd);
		accountPage2 = createAccountLinkPage2.clickOnSubmitbutton();
		womenCategoryPage = accountPage2.clickOnWomenPageLink();
		womenCategoryPage.clickItemSelected();		
		womenCategoryPage.writetoQuantityNeeded(quantity);
		womenCategoryPage.clickOnAddToCart();
		shoppingCartSummaryPage  = womenCategoryPage.clickProceedToCheckOutButton();
		
		
		Assert.assertEquals(totalAmount,  shoppingCartSummaryPage.totalAmountinSummaryPage()); 
		
		
	
		
		
	}
	@Test(priority = 1,dataProvider="getCRMTestData", groups = "AmountVerification")
	public void verifyTotalInPaymentPageShownCorrectly(String fn, String ln,String email , String pwd , String day,String month, String year,String company,String add1, String add2, String city, String state, String pc,String mobileNumber,String quantity) throws InterruptedException 
	{
	
		createAccountLinkPage2 = new CreateAccountLinkPage();
		createAccountLinkPage2.fillEmailAddressFieldSignIn(email);
		createAccountLinkPage2.fillPassowrdFieldSignIn(pwd);
		accountPage2 = createAccountLinkPage2.clickOnSubmitbutton();
		womenCategoryPage = accountPage2.clickOnWomenPageLink();
		womenCategoryPage.clickItemSelected();		
		womenCategoryPage.writetoQuantityNeeded(quantity);
		womenCategoryPage.clickOnAddToCart();
		shoppingCartSummaryPage  = womenCategoryPage.clickProceedToCheckOutButton();
				
		addressPage = shoppingCartSummaryPage.clickToProceedToCheckOut();
		shippingPage = addressPage.clickToProceedToCheckOutAddressPage();
		shippingPage.clickToAgreeTerms();
		paymentPage = shippingPage.clickToProceedToCheckOutShippingPage();
		
		Assert.assertEquals(totalAmount,  paymentPage.totalAmountinPaymentPage()); 
		
		
		
		
	}
	@Test(priority = 1,dataProvider="getCRMTestData", groups = "AmountVerification")
	public void verifyTotalInOrdersHistoryPageShownCorrectly(String fn, String ln,String email , String pwd , String day,String month, String year,String company,String add1, String add2, String city, String state, String pc,String mobileNumber,String quantity) throws InterruptedException 
	{
		
		createAccountLinkPage2 = new CreateAccountLinkPage();
		createAccountLinkPage2.fillEmailAddressFieldSignIn(email);
		createAccountLinkPage2.fillPassowrdFieldSignIn(pwd);
		accountPage2 = createAccountLinkPage2.clickOnSubmitbutton();
		womenCategoryPage = accountPage2.clickOnWomenPageLink();
		womenCategoryPage.clickItemSelected();		
		womenCategoryPage.writetoQuantityNeeded(quantity);
		womenCategoryPage.clickOnAddToCart();
		shoppingCartSummaryPage  = womenCategoryPage.clickProceedToCheckOutButton();
		
		
		
		addressPage = shoppingCartSummaryPage.clickToProceedToCheckOut();
		shippingPage = addressPage.clickToProceedToCheckOutAddressPage();
		shippingPage.clickToAgreeTerms();
		paymentPage = shippingPage.clickToProceedToCheckOutShippingPage();
		
		
		
		paymentConfirmationPage = paymentPage.clickOnPayByBankButton();
		orderConfirmationPage = paymentConfirmationPage.clickonConfirmMyOrder();
		
		
		
		accountPage3 = orderConfirmationPage.clickOnViewMyAccountLink();
		orderHistoryPage = accountPage3.clickOrdersLink();
		
		
		Assert.assertEquals(totalAmount,  orderHistoryPage.totalAmountinOrderHistoryPage()); 
		
		
	}
		
		@Test(dependsOnGroups = "AmountVerification")
		public void allAmountsVerifiedcorrectly() {
			
			int var = priceOfShippingInt +priceOfTotalProductsInt ;
			Assert.assertTrue(totalAmount == var);
			
		}
	
		*/
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
