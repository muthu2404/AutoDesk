package com.autodesk.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Muthumanickam
 * 
 * This POM class is used for accessing Web element present in Create New Organization Page
 *
 */
public class CreateNewOrganizationPage {
	
	WebDriver driver;
	
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}

	@FindBy(name="accountname")
	private WebElement orgNameTxtBox;
	
	public WebElement getOrgNameTxtBox() {
		return orgNameTxtBox;
	}
	
	@FindBy(name="website")
	private WebElement websiteTxtBox;
	
	public WebElement getWebsiteTxtBox() {
		return websiteTxtBox;
	}
	
	@FindBy(id="employees")
	private WebElement employeesTxtBox;
	
	public WebElement getEmployeesTxtBox() {
		return employeesTxtBox;
	}
	
	@FindBy(id="phone")
	private WebElement phoneTxtBox;
	
	public WebElement getPhoneTxtBox() {
		return phoneTxtBox;
	}
	
	@FindBy(xpath="//td[text()='Email ']/following-sibling::td/input")
	private WebElement emailTxtBox;
	
	public WebElement getEmailTxtBox() {
		return emailTxtBox;
	}
	
	@FindBy(name="industry")
	private WebElement industryListBox;
	
	public WebElement getIndustryListBox() {
		return industryListBox;
	}
	
	@FindBy(name="accounttype")
	private WebElement typeListBox;
	
	public WebElement getTypeListBox() {
		return typeListBox;
	}
	@FindBy(name="rating")
	private WebElement ratingListBox;
	
	public WebElement getRatingListBox() {
		return ratingListBox;
	}
	
	@FindBy(css="input[value='  Save  ']")
	private WebElement saveButton;
	
	public WebElement getSaveButton() {
		return saveButton;
	}
}
