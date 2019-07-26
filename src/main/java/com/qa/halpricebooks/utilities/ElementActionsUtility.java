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
		//driver.manage().deleteAllCookies();
	}
	/**
	 * This method is used to get the Element
	 * @param locator
	 * @return
	 */
	
	public WebElement elementFromByLocator(By locator)
	{
	//WebElement elem = driver.findElement(locator);
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
	/**
	 * This method is to wait for the title of the page to be displayed
	 * @param title
	 */
	public void waitForTitleUtil(String title)
	{ 
		WebDriverWait titleWait = new WebDriverWait(driver, 15);
		titleWait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * This method is wrapper method for .isDisplayed() method
	 * @param locator
	 * @return bollean value for IsDisplayed function
	 */
	public boolean elementIsDisplayed(By locator)
	{	
		waitForElemMethod(locator);
		return elementFromByLocator(locator).isDisplayed();
	}
	/**
	 * This method check for an Element if its enabled or not
	 * @param locator
	 * @return boolean value
	 */
	public boolean elementIsEnabled(By locator)
	{
	waitForElemMethod(locator);
	return elementFromByLocator(locator).isEnabled();
	}
	/**
	 * This method is Wrapper for .click()
	 * @param locator
	 */
	public void clickOnWebElem(By locator)
	{
		elementFromByLocator(locator).click();
	}
	/**
	 * This method is our creation of sendKeys Util method
	 * @param locator
	 * @param value
	 */
	public void sendKeysForWebElem(By locator,String value) 
	{
	elementFromByLocator(locator).sendKeys(value);	
	}
	/**
	 * This method returns title of the page also does error Handling which is very useful to give proper error msg ****interview question
	 * @return
	 */
	public String getTitleOfPage()
	{
		String pageTitle = null;
	try {
		 pageTitle =  driver.getTitle();
	}catch(Exception e) {
		System.out.println("Driver is not able to get title: "+pageTitle);
	}
		 return pageTitle;
	}

}
