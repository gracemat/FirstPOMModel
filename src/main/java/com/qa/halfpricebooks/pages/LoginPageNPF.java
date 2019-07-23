package com.qa.halfpricebooks.pages;

import org.openqa.selenium.By;

import com.qa.halfpricebooks.base.BasePage;
import com.qa.halpricebooks.utilities.ElementActionsUtility;

public class LoginPageNPF extends BasePage {

	By emailAddress = By.id("spree_user_email");
	By pswd = By.id("spree_user_password");
	By loginBtn = By.id("login_button");
	By link = By.linkText("click here");
	ElementActionsUtility elemAct;
	public LoginPageNPF() {
		this.driver = driver;
	elemAct = new ElementActionsUtility(driver);
		
	}
	
	//Page Actions
	public String getTitlewithNPF()
	{
		return driver.getTitle();
	}
	
	public void verifyGuestLinkNPF(By locator)
	{
	elemAct.elementIsDisplayed(link);
	}
	
	public void clickOnLoginBtnNPF() 
	{
		elemAct.clickOnWebElem(loginBtn);
	}
	
	public HomePage doLoginNPF(String username,String password) {
		System.out.println("Credentials :"+username +" / "+password);
		elemAct.sendKeysForWebElem(emailAddress, username);
		elemAct.sendKeysForWebElem(pswd, password);
		elemAct.clickOnWebElem(loginBtn);
		
		return new HomePage(driver);
	}
}
