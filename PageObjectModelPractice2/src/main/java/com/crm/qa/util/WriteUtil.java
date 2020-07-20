package com.crm.qa.util;

import org.openqa.selenium.WebElement;

import com.crm.qa.base.Testbase;

public class WriteUtil  extends Testbase {
	
	public static void  writeTo(WebElement element , String emailAddress)
	{
		//element.click();
		element.clear();
		element.sendKeys(emailAddress);
	}
	


}
