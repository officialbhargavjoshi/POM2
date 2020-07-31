package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForTesting {
	public static void main(String[] args) {
	
	
		ChromeDriver driver;
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	//driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	
	driver.get("https://developer.salesforce.com/signup?d=70130000000td6N");
	
	//select[@id='country']//child::option[1]//following-sibling::option[1]
	
	/*List<WebElement> aList =  driver.findElements(By.xpath("//select[@id='country1']"));
	System.out.println(aList);
	System.out.println(aList.get(0));*/
	
	WebElement element1 = driver.findElement(By.xpath("//select[@id='country1']"));
	element1.click();
	
	
	//WebElement element = driver.findElement(By.xpath("//select[@id='country']//child::option[1]//following-sibling::option[1]"));
	/*driver.findElement(By.id("passwd")).sendKeys("Bjoshi06#");
	driver.findElement(By.id("SubmitLogin")).click();
	WebElement element = driver.findElement(By.xpath("//a[@title='Return to Home']/following-sibling::span[2]"));
	*/
	//System.out.println(element.getText());
	
	//driver.quit();
}

}
