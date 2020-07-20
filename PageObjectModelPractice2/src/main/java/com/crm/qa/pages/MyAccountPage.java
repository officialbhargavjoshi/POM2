package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAccountPage  extends Testbase
{
	//CreateAccountLinkPage createAccountLinkPage;
	
	
	@FindBy(xpath = "//a[@title='Return to Home']/following-sibling::span[2]")
	WebElement myAccountField;
	
	@FindBy(xpath = "//a[@title='Log me out']")
	WebElement logOutButton;
	
	
	@FindBy(xpath = "//a[@title='Women']")
	WebElement WomenPageLink;
	
	
	@FindBy(xpath = "//a[@title='Orders']")
	WebElement ordersLink;
	
	public OrderHistoryPage clickOrdersLink() {
		ordersLink.click();
		return new OrderHistoryPage();
		
	
	}
	
	
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String  getMyAccountFieldText() {
		return myAccountField.getText();
	}
	
	
	public CreateAccountLinkPage clickLogOut() {
		logOutButton.click();
		return new CreateAccountLinkPage();
		
	
	}
	
	
	public WomenCategoryPage clickOnWomenPageLink() {
		WomenPageLink.click();
		return new WomenCategoryPage();
	}
	/*public static void main(String[] args) {
		
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		driver.findElement(By.id("email")).sendKeys("bhargavjsh6@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Bjoshi06#");
		driver.findElement(By.id("SubmitLogin")).click();
		WebElement element = driver.findElement(By.xpath("//a[@title='Return to Home']/following-sibling::span[2]"));
		
		System.out.println(element.getText());
	}*/

}
