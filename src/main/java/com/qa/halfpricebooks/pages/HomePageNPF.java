package com.qa.halfpricebooks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.halfpricebooks.base.BasePage;
import com.qa.halfpricebooks.constants.ConstantValues;
import com.qa.halpricebooks.utilities.ElementActionsUtility;

public class HomePageNPF extends BasePage {
	//By Locators 
	By findAStore = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/a");
	//By coupon = By.linkText("<a href=\"https://halfpricebooks.com/getink/\">SEE DETAILS</a>");
	By couponCode = By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/a");//Fix these after practicing Custom XPath *****
	By nameOfUser = By.id("welcome-back-name");
	By cartIcon = By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/div/a[2]/i");
	
	ElementActionsUtility actionUtil;
	
	//Constructor
	public HomePageNPF(WebDriver driver)
	{
		this.driver = driver;
		actionUtil = new ElementActionsUtility(driver);
	}
	
	//PageActions using Wrapper methods from ElementActionsUtility class
	/**
	 * This method return title of HomePage NPF style
	 */
	public String getHomePageTitle()
	{
		//actionUtil.waitForTitleUtil(ConstantValues.HOMEPAGE_TITLE);
		
		return actionUtil.getTitleOfPage();
	}
	/**
	 * This method is check for Cart Icon Enability
	 * @return 
	 */
	public boolean CartIconisEnabled()
		{
		return actionUtil.elementIsEnabled(cartIcon);
		}
	/**
	 * This method is used to click on Coupon details link
	 */
	public boolean couponCodeLink()
	{
		//actionUtil.clickOnWebElem(couponCode);
		return actionUtil.elementIsDisplayed(couponCode);
		//String couponPageTitle = driver.getTitle();
		//return couponPageTitle;
	}
	/**
	 * This method is used to get LoggedIn Users name
	 * @return 
	 */
	public String getLoggedUserName() {
		return actionUtil.elementFromByLocator(nameOfUser).getText();
	}
}

