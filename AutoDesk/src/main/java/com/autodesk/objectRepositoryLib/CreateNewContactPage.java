package com.autodesk.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Muthumanickam
 * 
 * This POM class is used for accessing Web element present in Create New Contact page
 *
 */
public class CreateNewContactPage {

	WebDriver driver;

	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstname")
	private WebElement firstNameTxtBox;

	@FindBy(name = "lastname")
	private WebElement lastNameTxtBox;

	@FindBy(css = "input[value='  Save  ']")
	private WebElement saveButton;

	@FindBy(xpath = "//td[text()='Organization Name 			']/following-sibling::td//img")
	private WebElement orgNameLink;

	@FindBy(id = "phone")
	private WebElement phoneTxtBox;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgNameLookup;
	
	public WebElement getOrgNameLookup() {
		return orgNameLookup;
	}

	public WebElement getFirstNameTxtBox() {
		return firstNameTxtBox;
	}

	public WebElement getLastNameTxtBox() {
		return lastNameTxtBox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getOrgNameLink() {
		return orgNameLink;
	}

	public WebElement getPhoneTxtBox() {
		return phoneTxtBox;
	}
}
