package com.qa.halfpricebooks.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.halfpricebooks.base.BasePage;
import com.qa.halfpricebooks.constants.ConstantValues;
import com.qa.halfpricebooks.pages.HomePage;
import com.qa.halfpricebooks.pages.LoginPage;

public class HomePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basepg;
	LoginPage loginPg;
	HomePage homePg;
	
	@BeforeMethod
	public void setUp()
	{
		basepg = new BasePage();
		prop = basepg.properties_initialisation();
		driver = basepg.driver_initialisation(prop);
		loginPg = new LoginPage(driver);
		//getting home page object for the page chaining concept logic
		homePg = loginPg.login_With_credentials(prop.getProperty("username"),prop.getProperty("password"));
	}
	/**
	 * This method is to test Find a store Link page title
	 */
	@Test(priority = 3)
	public void verifyStoreLocations_Title_Test()
	{
		homePg.checkForStroreLocations();
		System.out.println("Find a Store page Title => "+driver.getTitle());
		String findAStoreTitle = driver.getTitle(); //It didnot work until I gave differnt variable
		Assert.assertEquals(findAStoreTitle,ConstantValues.STORE_LOCATIONS_PAGE_TITLE);
	}
	/**
	 * This method is to check the display of Shopping cart icon
	 */
	@Test(priority=4)
	public void verify_Shopping_cart_Icon()
	{
		System.out.println("Shopping cart icon isDisplayed TRUE/FALSE ==> " +homePg.shoppingCartIconDisplay());
		Assert.assertTrue(homePg.shoppingCartIconDisplay());
	}
	/**
	 * This method is to test Logged in user name
	 */
	@Test(priority=1)
	public void verify_UserName_Test()
	{
		System.out.println(homePg.getLoggedInUserName());
		Assert.assertEquals(homePg.getLoggedInUserName(),ConstantValues.LOGGED_USER_NAME);
	}
	/**
	 * This method is to test homepage header
	 */
	@Test(priority = 1)
	public void verify_Header_Logo_Test()
	{
		System.out.println("HOME Page header is => "+homePg.verifyHeaderLogo());
		Assert.assertEquals(homePg.verifyHeaderLogo(),ConstantValues.HEADER_LOGO);
	}
	/**
	 * 5. This method is to test search box enability
	 */
	@Test(priority=2)
	public void verify_Search_Box_Test()
	{
		System.out.println("Checking Search Box True/False ==> "+homePg.isSearchBoxEnabled());
		Assert.assertTrue(homePg.isSearchBoxEnabled());
	}
/**
 * 6.This method is used to test Searchquery text
 */
	@Test()
	public void verify_Search_Query_Text()
	{
		System.out.println("Search Querry is :: "+homePg.verifySearchQuerryText());
		//I want to get placeholder value here :-(
		//Assert.as
	}

	
	  @Test 
	  public void verify_Home_Page_title()
	  { 
		 System.out.println(homePg.getHomePageTitle());
		 Assert.assertEquals(homePg.getHomePageTitle(), ConstantValues.HOMEPAGE_TITLE);
		  }
	 
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
