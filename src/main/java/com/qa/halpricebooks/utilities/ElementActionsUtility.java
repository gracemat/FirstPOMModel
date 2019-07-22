package com.qa.halpricebooks.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.halfpricebooks.base.BasePage;

public class ElementActionsUtility extends BasePage {
	
	//1.Creating a constructor and extend class to BasePage because we need object to call the methods
	public ElementActionsUtility(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement elementFromByLocator(By locator)
	{
	WebElement elem = driver.findElement(locator);
	return elem;
	}
	
	public void waitForElemMethod(By locator)
	{
		WebDriverWait waitForElem =new  WebDriverWait(driver,15);
		waitForElem.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
}
