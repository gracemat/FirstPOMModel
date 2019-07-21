package com.qa.halfpricebooks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.halfpricebooks.base.BasePage;

public class HomePage extends BasePage {
	
	  //Page Objects
	  
	  @FindBy(linkText ="/stores")
	  WebElement storeLocator;
	  
	  @FindBy(xpath="//i[@class='icons-cart-white mll']")
	  WebElement shoppingCart;
	  
	  @FindBy(id = "welcome-back-name") 
	  WebElement loggedInName;
	  
	  @FindBy(xpath="//a[@class='logo icons-header-logo']")
	  WebElement HeaderLogo;
	  
	  @FindBy(css="body > div.page-wrap > div.secondary-header > div > div.small-7.large-6.columns > div > form > button")
	  WebElement searchBox;
	  
	  @FindBy(name="keywords")
	  WebElement searchQuerry;
	  
	  //Creating a constructor again same as LoginPAge
	  public HomePage(WebDriver driver)
	  {
		  this.driver = driver;
		  PageFactory.initElements(driver, this);
	  }
	  
	  //Page Actions
	   public void checkForStroreLocations()
	  {
		  
	  }
	 
}
