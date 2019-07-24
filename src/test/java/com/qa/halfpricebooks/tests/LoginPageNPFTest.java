package com.qa.halfpricebooks.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.halfpricebooks.base.BasePage;
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

	@Test
	public void verifyGuestLink()
	{
		Assert.assertTrue(loginNpf.verifyGuestLinkNPF());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
