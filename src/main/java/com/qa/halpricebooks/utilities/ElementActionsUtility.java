package com.qa.halpricebooks.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.halfpricebooks.base.BasePage;

public class ElementActionsUtility extends BasePage {
<<<<<<< HEAD
	
=======
	WebElement elem;
>>>>>>> ee78c7e0db19f85ccabd4e3d2c9abc1fb14810ce
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
<<<<<<< HEAD
	WebElement elem = driver.findElement(locator);
	return elem;
	}
	
=======
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
>>>>>>> ee78c7e0db19f85ccabd4e3d2c9abc1fb14810ce
	public void waitForElemMethod(By locator)
	{
		WebDriverWait waitForElem =new  WebDriverWait(driver,15);
		waitForElem.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
<<<<<<< HEAD
=======
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
>>>>>>> ee78c7e0db19f85ccabd4e3d2c9abc1fb14810ce
}
