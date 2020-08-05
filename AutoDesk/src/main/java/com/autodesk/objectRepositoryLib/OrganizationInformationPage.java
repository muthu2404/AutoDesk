package com.autodesk.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Muthumanickam
 * 
 * This POM class is used for accessing Web element present in Organization Information Page
 *
 */
public class OrganizationInformationPage {

	WebDriver driver;

	public OrganizationInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement orgInfo;

	public WebElement getOrgInfo() {
		return orgInfo;
	}
		
	
}
