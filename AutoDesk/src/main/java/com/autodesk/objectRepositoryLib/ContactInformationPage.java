package com.autodesk.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Muthumanickam
 * 
 * This POM class is used for accessing Web element present in Contact information page
 *
 */
public class ContactInformationPage {

	WebDriver driver;

	public ContactInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement contactInfo;

	public WebElement getContactInfo() {
		return contactInfo;
	}	
}
