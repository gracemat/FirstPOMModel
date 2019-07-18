package com.qa.halfpricebooks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.halfpricebooks.base.BasePage;

public class LoginPage extends BasePage {
	//Defining Locators with the help of PageFactory
	
	@FindBy(id="spree_user_email")
	WebElement emailAddress;
	
	@FindBy(id="spree_user_password")
	WebElement password;
	
	@FindBy(id="login_button")
	WebElement logIn;
	
	@FindBy(linkText="click here")
	WebElement returningGuest;
	
	

}
