package com.autodesk.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Muthumanickam
 * 
 * This POM class used to locate webelement present in Organization page
 *
 */
public class OrganizationPage {
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver , this);
	}
	
	@FindBy(css="img[title='Create Organization...']")
	private WebElement createOrg;	
	
	@FindBy(name="search_text")
	private WebElement searchTxtBox;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchOptionListBox;
	
	@FindBy(name="submit")
	private WebElement searchSubmmitBtn;
	
	@FindBy(css="input[value='Delete']")
	private WebElement deleteBtn;
	
	@FindBy(xpath="//span[contains(text(),'No Organization Found')]")
	private WebElement noOrgFoundMsg;
	
	public WebElement getNoOrgFoundMsg() {
		return noOrgFoundMsg;
	}

	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}

	public WebElement getSearchOptionListBox() {
		return searchOptionListBox;
	}

	public WebElement getSearchSubmmitBtn() {
		return searchSubmmitBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getCreateOrg() {
		return createOrg;
	}	
			
	public void navigateToCreateNewOrgPage() {
		getCreateOrg().click();
	}
	
	
}
