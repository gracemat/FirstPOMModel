package com.qa.halpricebooks.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.halfpricebooks.base.BasePage;

public class ElementActionsUtility extends BasePage {
	WebElement elem;
	//1.Creating a constructor and extend class to BasePage because we need object to call the methods
	public ElementActionsUtility(WebDriver driver)
	{
		this.driver = driver;
	}
	/**
	 * This method is used to get the Element
	 * @param locator
	 * @return
	 */
	
	public WebElement elementFromByLocator(By locator)
	{
		try {
	 elem = driver.findElement(locator);
		}
		catch (Exception e) {
		System.out.println("Element not found with this specific --"+locator +"LOCATOR");}
	return elem;
	}
	/**
	 * This method is for wait method to element to be displayed
	 * @param locator
	 */
	public void waitForElemMethod(By locator)
	{
		WebDriverWait waitForElem =new  WebDriverWait(driver,15);
		waitForElem.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public boolean elementIsDisplayed(By locator)
	{
		return elementFromByLocator(locator).isDisplayed();
	}
	
	public void clickOnWebElem(By locator)
	{
		elementFromByLocator(locator).click();
	}
	
	public void sendKeysForWebElem(By locator,String value) 
	{
	elementFromByLocator(locator).sendKeys(value);	
	}
}
