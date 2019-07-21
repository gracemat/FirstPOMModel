package com.qa.halpricebooks.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.halfpricebooks.base.BasePage;

public class ElementActionsUtility extends BasePage {
	
	public ElementActionsUtility(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By emailAddress = By.id("spree_user_email");
	By pswd = By.id("spree_user_password");
	

}
