package com.autodesk.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.genericUtils.PropertyFileLib;


/**
 * 
 * @author Muthumanickam
 * 
 * This POM class used to locate webelement present in Login page
 *
 */
public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, LoginPage.class);
	}
	
	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	public WebElement getUsername() {
		return username;
	}
	
	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}
	public void login(String username,String password) throws Throwable {
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getSubmitButton().click();
	}
	
	public void login() throws Throwable {
		PropertyFileLib pfLib = new PropertyFileLib();
		getUsername().sendKeys(pfLib.getPropertyKeyValue("username"));
		getPassword().sendKeys(pfLib.getPropertyKeyValue("password"));
		getSubmitButton().click();
	}
}
