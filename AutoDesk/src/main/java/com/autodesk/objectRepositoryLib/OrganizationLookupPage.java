package com.autodesk.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Muthumanickam
 * 
 * This POM class is used for accessing Web element present in Organization Lookup Page
 *
 */
public class OrganizationLookupPage {

	WebDriver driver;

	public OrganizationLookupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_text")
	private WebElement searchTxtBox;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
		
	@FindBy(xpath = "//tr[2]/td/a") 
	private WebElement selectOrg;

	public WebElement getSelectOrg() {
		return selectOrg;
	}

	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
}
