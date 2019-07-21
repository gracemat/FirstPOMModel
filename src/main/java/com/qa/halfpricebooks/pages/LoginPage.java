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
	
	//@FindBy(using ="Submit")-- here it is not allowing @FindBy
	@FindBy(className= "typeahead search-query")// The annotation @FindBy is disallowed for this location
	//@FindBy(id="keywords")
	WebElement search;
	
	@FindBy(xpath="//*[@id=\"user_login\"]/div[4]/div/label")
	WebElement keepMeLogged;
	
	@FindBy(css="body > div.page-wrap > div.sticky > div.header-navigation > div > ul > li:nth-child(7) > a")
	WebElement sale;
	
	@FindBy(xpath="//div[@class='alert-box error']")
	WebElement errorMsg;
	
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
	/**
	 * This method is to check the displayed msg when both  incorrect credentials are given
	 * @param userName
	 * @param pswd
	 * @param msg
	 * @return
	 */
	public boolean login_incorrect_credentials(String userName,String pswd,String msg)
	{
		emailAddress.sendKeys(userName);
		password.sendKeys(pswd);
		logIn.click();
		msg = errorMsg.getText();
		boolean flag = true;
		return flag;
	}
	 
	/**
	* This Method is used to check the current URL
	 * @return
	 */
	public String getURL()
	{
		return driver.getCurrentUrl();
	}
	/**
	 * This Method checks the Checkbox is selected or not
	 * @return
	 */
	public boolean verifyKeepMeLoggedInCheckBox() {
		return keepMeLogged.isSelected();
		
	}
	/**
	 * Making sure to learn about returning getclass
	 * @return
	 */
	public Class<? extends WebElement> verifySaleLink() {
		return sale.getClass();
		}
	/**
	 * This method is to click on Sale 
	 */
	public void saleLinkCheck()
	{
		sale.click();
		
	}
}
