package com.qa.halfpricebooks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.halfpricebooks.base.BasePage;

public class LoginPage extends BasePage {
	//Defining Locators with the help of PageFactory -- Page Objects or WebElements --- 1st step
	
	@FindBy(id="spree_user_email")
	WebElement emailAddress;
	
	@FindBy(id="spree_user_password")
	WebElement password;
	
	@FindBy(id="login_button")
	WebElement logIn;
	
	@FindBy(linkText="click here")
	WebElement returningGuest;
	
	//Create Constructor of this class and intialize page objects--2nd step
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // or PageFactory.initElements(driver, LoginPage.class);
	}
//3rd step -- Page Actions
	/**
	 * This method is to get LoginPage Title
	 * @return
	 */
	public String getLoginPageTitle() 
	   {
		return driver.getTitle();
		}
	/**
	 * This method is used to check for the below link
	 * @return
	 */
	public boolean verifyReturnGuestLink() 
		{
		return returningGuest.isEnabled();
		}
	/**
	 * This method is used to login with credentials
	 * @param userName
	 * @param pwd
	 */
	public void login_credentials(String userName,String pwd) {
		emailAddress.sendKeys(userName);
		password.sendKeys(pwd);
		logIn.click();
		}
}
