package com.autodesk.genericUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/**
 * 
 * @author Muthumanickam
 * 
 *         This class is act as Base class for all Test script
 *
 */
public class FoundationClass {
	public DatabaseLib dbLib = new DatabaseLib();
	public ExcelLib excelLib = new ExcelLib();
	public PropertyFileLib pfLib = new PropertyFileLib();
	public WebDriverUtils wLib = new WebDriverUtils();
	public WebDriver driver = null;

	@BeforeSuite
	public void configBS() {
		/* Connect to Database */
		dbLib.connectToDB();
	}

	@BeforeClass
	public void configBC() throws Throwable {
		String BROWSER = pfLib.getPropertyKeyValue("browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		} else {
			driver = new FirefoxDriver();
		}
	}

	/*
	 * @Parameters("browser")
	 * 
	 * @BeforeTest public void configBT(String BROWSER) throws Throwable{
	 * 
	 * if(BROWSER.equals("chrome")) { driver= new ChromeDriver(); } else
	 * if(BROWSER.equals("firefox")) { driver = new FirefoxDriver(); }else
	 * if(BROWSER.equals("ie")) { driver = new InternetExplorerDriver(); }else {
	 * driver = new FirefoxDriver(); }
	 * 
	 * }
	 */

	@BeforeMethod
	public void configBM() throws Throwable {
		/* Fetch data from Property File */
		String USERNAME = pfLib.getPropertyKeyValue("username");
		String PASSWORD = pfLib.getPropertyKeyValue("password");
		String URL = pfLib.getPropertyKeyValue("url");

		/* Launch to the Application */
		wLib.implicitWait(driver);
		driver.get(URL);

		/* Login to the Application */
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	}

	@AfterMethod
	public void configAm() {

		/* Logout from Application */

		WebElement wb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.moveMouseToElemnet(driver, wb);
		driver.findElement(By.linkText("Sign Out")).click();
	}

	@AfterClass
	public void configAC() {
		/* Close the Browser */
		driver.close();
	}

	@AfterSuite
	public void confiAs() {
		/* Disconnect from Database */
		dbLib.disConnectToDB();
	}
}
