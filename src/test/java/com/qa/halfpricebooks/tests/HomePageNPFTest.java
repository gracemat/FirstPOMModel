package com.qa.halfpricebooks.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.halfpricebooks.base.BasePage;
import com.qa.halfpricebooks.constants.ConstantValues;
import com.qa.halfpricebooks.pages.HomePageNPF;
import com.qa.halfpricebooks.pages.LoginPageNPF;
import com.qa.halpricebooks.utilities.ElementActionsUtility;

public class HomePageNPFTest {
	BasePage bspg;
	Properties pro;
	WebDriver driv;
	LoginPageNPF lognpf;
	ElementActionsUtility eleAct;
	HomePageNPF homeNpf;
	
	
@BeforeMethod
public void setUp()
{
	bspg = new BasePage();
	pro = bspg.properties_initialisation();
	driv = bspg.driver_initialisation(pro);
	lognpf = new LoginPageNPF(driv);
	homeNpf = lognpf.doLoginNPF(pro.getProperty("username"), pro.getProperty("password"));
	//driv.manage().deleteAllCookies();
}
/**
 * This test verifies See Details Link is displayed or not?
 */
@Test(priority =2)
public void verifyCouponLinkTest()
{
System.out.println(homeNpf.couponCodeLink());//why will we get only if we pass into some variable?
	//String titleOfCouponPage = homeNpf.couponCodeLink();
	Assert.assertTrue(homeNpf.couponCodeLink());
}
/**
 * This method is used to verify Home Page title
 */
@Test(priority = 1)
public void verifyHomePageTitleTest()
{
	String hmpgtitle = homeNpf.getHomePageTitle();
	Assert.assertEquals(hmpgtitle,ConstantValues.HOMEPAGE_TITLE);
}
/**
 * This method is used to check Cart Icon is Enabled or not
 */
@Test(priority=2)
public void cartIconEnabililityTest()
{
	Assert.assertTrue(homeNpf.CartIconisEnabled());
}
/**
 * This method tests Logged In User Name
 */
@Test(priority=1)
public void loggedInUserNameTest()
{
	System.out.println("Logged In User name is :: "+homeNpf.getLoggedUserName());
	Assert.assertEquals(homeNpf.getLoggedUserName(),pro.getProperty("loggedInUserName"));
}
@AfterMethod
public void tearDown()
{
	driv.quit();
}
}
