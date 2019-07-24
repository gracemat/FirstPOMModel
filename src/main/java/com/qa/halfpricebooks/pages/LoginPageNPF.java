package com.qa.halfpricebooks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.halfpricebooks.base.BasePage;
import com.qa.halfpricebooks.constants.ConstantValues;
import com.qa.halpricebooks.utilities.ElementActionsUtility;

public class LoginPageNPF extends BasePage {
	//Creating By Locators as per Non Page Factory pattern
	By emailAddress = By.id("spree_user_email");
	By pswd = By.id("spree_user_password");
	By loginBtn = By.id("login_button");
	By link = By.linkText("click here");
	ElementActionsUtility elemAct;
	//Constructor to initialize ElementActionsUtility class and starting the driver
	public LoginPageNPF(WebDriver driver) {
		this.driver = driver;
	elemAct = new ElementActionsUtility(driver);
		
	}
	
	//Page Actions :::
	/**
	 * This method is used to get Login Page Title in NPF style with wrapper methods like methods created by us in ElementActionUtil class
	 * @return title of the page
	 */
	public String getTitlewithNPF()
	{
		elemAct.waitForTitleUtil(ConstantValues.LOGIN_PAGE_TITLE);
		return elemAct.getTitleOfPage();
	}
	/**
	 * This method is used to Check for the display of Guest link
	 * @return True/False according to Link displayed or not
	 */
	public boolean verifyGuestLinkNPF()
	{
	return elemAct.elementIsDisplayed(link);
	}
	/**
	 * This method is used to call click on Login Button method 
	 */
	public void clickOnLoginBtnNPF() 
	{
		elemAct.clickOnWebElem(loginBtn);
	}
	/**
	 * This method is used to call Login method in NPF pattern and retun obj of Homepage class
	 * @param username
	 * @param password
	 * @return new object of HomePage class after logging in 
	 */
	public HomePage doLoginNPF(String username,String password) {
		System.out.println("Credentials :"+username +" / "+password);
		elemAct.sendKeysForWebElem(emailAddress, username);
		elemAct.sendKeysForWebElem(pswd, password);
		elemAct.clickOnWebElem(loginBtn);
		
		return new HomePage(driver);
	}
}
