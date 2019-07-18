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
	@Test
	public void verifyLoginPageTitleTest()
	{
		String loginTitle = loginPage.getLoginPageTitle();
		System.out.println("");
		//Assert.assertEquals(loginTitle, "Log in to Your Account,Create Account|Half Price Books");
		// To remove hardcodingfor expected value we created Constants class
		Assert.assertEquals(loginTitle, ConstantValues.LOGIN_PAGE_TITLE);
	}
	
	@Test
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
