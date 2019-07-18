package com.qa.halfpricebooks.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.halpricebooks.utilities.UtilityOfTime;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Greeshma
 *
 */
public class BasePage {
	
	public WebDriver driver;//these are global variables used through out the framework
	public Properties prop;
	
	/**
	 * This method is to Initialize the driver
	 * @param prop
	 * @return driver
	 */
	
	public WebDriver driver_initialisation(Properties prop)
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("FireFox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Please enter a valid Browser Name as mentioned in properties file \n"+browserName +"is not VALID");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.get(prop.getProperty("url"));
		
		//Thread.sleep(5000);//to make it look good create a wrapper for Thread.sleep method in Utility package
		UtilityOfTime.Medium_Time_Wait();//our own utility Method
		
		return driver;
	}
	/**
	 * This method is to Initialize the Properties 
	 * @return prop
	 */
	public Properties properties_initialisation()
	{
		prop = new Properties();
		try {
			FileInputStream fip = new FileInputStream("C:\\Users\\prave\\eclipse-workspace\\FirstPOMProject\\src\\main\\java\\com\\qa\\halfpricebooks\\configuration\\qa_config.properties");
			try {
				prop.load(fip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
}
