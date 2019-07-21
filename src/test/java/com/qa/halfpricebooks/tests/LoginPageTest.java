package com.qa.halfpricebooks.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.halfpricebooks.base.BasePage;
import com.qa.halfpricebooks.constants.ConstantValues;
import com.qa.halfpricebooks.pages.LoginPage;

public class LoginPageTest {
	WebDriver driver;
	Properties property;
	BasePage basePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp()
	{
		basePage = new BasePage();
		property = basePage.properties_initialisation();//if it returns properties store in Properties :: Mapping
		driver = basePage.driver_initialisation(property);//using property variable to initialize driver method
		
		loginPage = new LoginPage(driver);
		
		}
	@Test(priority=1)
	public void verifyLoginPageTitleTest()
	{
		String loginTitle = loginPage.getLoginPageTitle();
		System.out.println("Login PAge title is : "+loginTitle);
		//Assert.assertEquals(loginTitle, "Log in to Your Account,Create Account|Half Price Books");
		// To remove hardcodingfor expected value we created Constants class
		Assert.assertEquals(loginTitle, ConstantValues.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verify_ReturnGuestLink_isEnabled_Test()
	{
		Assert.assertTrue(loginPage.verifyReturnGuestLink());
	}
	
	@Test(priority=3,enabled = true)
	public void verify_with_correct_Credentials_Test()
	{
		loginPage.login_credentials(property.getProperty("username"), property.getProperty("password"));
		//Assert.assertEquals(, property.getProperty("username"));
		
	}
	
	@Test(priority=4,enabled = true)
	public void verify_With_Incorrect_Credentials()
	{
		loginPage.login_credentials("grace@gmail.com","loginnow");
		//loginPage.login_incorrect_credentials("grace@gmail.com","loginnow","Invalid email or password.");
		Assert.assertTrue(loginPage.login_incorrect_credentials("grace@gmail.com", "loginnow", "Invalid email or password."));
		
	}
	
	@Test(priority=5)
	public void verifyCurrentUrlTest()
	{
		String currentUrl = loginPage.getURL();
		System.out.println("This URL is :: "+currentUrl);
		Assert.assertEquals(currentUrl, property.getProperty("url"));
	}
	
	@Test(priority=6)
	public void verifyCheckBoxTest()
	{
		System.out.println("Is checkbox selected? "+loginPage.verifyKeepMeLoggedInCheckBox());
	Assert.assertFalse(loginPage.verifyKeepMeLoggedInCheckBox());
	}
	
	@Test(priority = 7,enabled = false)
	public void sale_link_class_test()
	{
		System.out.println(loginPage.verifySaleLink());
	}
	@Test(priority = 8)
	public void Verify_Sale_Link_Test()
	{
		loginPage.saleLinkCheck();
		System.out.println("Sales Page URL is : "+driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(),ConstantValues.SALE_PAGE_URL);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
