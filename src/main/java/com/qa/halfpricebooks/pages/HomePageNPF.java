package com.qa.halfpricebooks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.halfpricebooks.base.BasePage;
import com.qa.halfpricebooks.constants.ConstantValues;
import com.qa.halpricebooks.utilities.ElementActionsUtility;

public class HomePageNPF extends BasePage {
	//By Locators 
	By findAStore = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/a");
	By couponCode = By.xpath("//div[@class='offer']");
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
	public void getHomePageTitle()
	{
		actionUtil.waitForTitleUtil(ConstantValues.HOMEPAGE_TITLE);
		actionUtil.getTitleOfPage();
	}
	/**
	 * This method is check for Cart Icon Display
	 */
	public void CartIconisDisplayed()
		{
		actionUtil.elementIsDisplayed(cartIcon);
		}
	/**
	 * This method is used to click on Coupon details link
	 */
	public void couponCodeLink()
	{
		actionUtil.clickOnWebElem(couponCode);
	}
	/**
	 * This method is used to get LoggedIn Users name
	 */
	public void getLoggedUserName() {
		actionUtil.elementFromByLocator(nameOfUser).getText();
	}
}

