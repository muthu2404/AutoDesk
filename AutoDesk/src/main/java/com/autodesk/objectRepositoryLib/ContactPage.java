package com.autodesk.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Muthumanickam
 * 
 * This POM class used to locate webelement present in Contact page
 *
 */
public class ContactPage {

	WebDriver driver;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="img[title='Create Contact...']")
	private WebElement createContact;
	
	@FindBy(xpath="//span[contains(text(),'No Contact Found')]")
	private WebElement noContactFoundMsg;
	
	public WebElement getNoContactFoundMsg() {
		return noContactFoundMsg;
	}

	public WebElement getCreateContact() {
		return createContact;
	}		
}
