package com.autodesk.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autodesk.genericUtils.WebDriverUtils;
/**
 * 
 * @author Muthu manickam
 * 
 * This POM class used to locate webelement present in Home page
 *
 */
public class HomePage extends WebDriverUtils  {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver , this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;	
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	
	public WebElement getContactsLink() {
		return contactsLink;
	}	

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void navigateToCampaignPage() {
		moveMouseToElemnet(driver, getCampaignLink());
	}
	
}
