package com.crm.qa.util;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.Testbase;

public class WaitUtility  extends Testbase
{
	
	
	
	public static WebElement explicitWaitforVisibilityOfElement(WebElement element) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
		
		WebElement element1 = getFluentWait().until(ExpectedConditions.visibilityOf(element));
		WebElement element2 = webDriverWait.until(ExpectedConditions.visibilityOf(element1));
		return element2;
	}

	
	/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(30, SECONDS)
		       .pollingEvery(5, SECONDS)
		       .ignoring(NoSuchElementException.class);

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.id("foo"));
		     }
		   });*/
	
	
	private static Integer fluentWaitInterval = 60;

    public static FluentWait<WebDriver> getFluentWait() 
    {
        FluentWait<WebDriver> fluentWait = 
        		new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(fluentWaitInterval))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return fluentWait;
    }

    public static WebElement waitUntilElementIsPresent(By by) {
         
        {
            return getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
        } 
        
    }


    public static WebElement waitUntilElementClickable(By by) {
        
            return getFluentWait().until(ExpectedConditions.elementToBeClickable(by));
        
     
    }

}
