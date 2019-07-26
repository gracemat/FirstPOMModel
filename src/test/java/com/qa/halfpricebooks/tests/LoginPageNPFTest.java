package com.qa.halfpricebooks.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.halfpricebooks.base.BasePage;
import com.qa.halfpricebooks.constants.ConstantValues;
import com.qa.halfpricebooks.pages.LoginPageNPF;

public class LoginPageNPFTest {
	WebDriver driver;
	Properties prop;
	BasePage basepg;
	LoginPageNPF loginNpf;
		
	@BeforeMethod
	public void setUp()
	{
		basepg = new BasePage();
		prop = basepg.properties_initialisation();
		driver = basepg.driver_initialisation(prop);
		loginNpf = new LoginPageNPF(driver);
	}
	/**
	 * This method is to verify Guest Link
	 */
	@Test
	public void verifyGuestLink_Test()
	{
		Assert.assertTrue(loginNpf.verifyGuestLinkNPF());
	}
	/**
	 * This method is used to test Login Page Title
	 */
	@Test
	public void getTitle_Test()
	{
		System.out.println(loginNpf.getTitlewithNPF());
		Assert.assertEquals(loginNpf.getTitlewithNPF(),ConstantValues.LOGIN_PAGE_TITLE);
	}
	/**
	 * 
	 */
	@Test
	public void clickOnLoginButtonTest()
	{
		loginNpf.clickOnLoginBtnNPF();
		//String title = loginNpf.clickOnLoginBtnNPF()
		//Assert.assertEquals(actual, );
	}
	@Test
	public void doLoginNPF_Test()
	{
		String afterLoggingTitle = loginNpf.doLoginNPF(prop.getProperty("username"),prop.getProperty("password") ).getHomePageTitle();//Here we are using two wrappers
		Assert.assertEquals(afterLoggingTitle, ConstantValues.HOMEPAGE_TITLE);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
