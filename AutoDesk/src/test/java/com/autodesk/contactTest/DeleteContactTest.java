package com.autodesk.contactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodesk.genericUtils.FoundationClass;
import com.autodesk.objectRepositoryLib.ContactInformationPage;
import com.autodesk.objectRepositoryLib.ContactPage;
import com.autodesk.objectRepositoryLib.CreateNewContactPage;
import com.autodesk.objectRepositoryLib.CreateNewOrganizationPage;
import com.autodesk.objectRepositoryLib.HomePage;
import com.autodesk.objectRepositoryLib.OrganizationInformationPage;
import com.autodesk.objectRepositoryLib.OrganizationLookupPage;
import com.autodesk.objectRepositoryLib.OrganizationPage;

/**
 * 
 * @author Muthu manickam
 * 
 *         This class is used for Delete Contact from Contact Page
 *
 */
public class DeleteContactTest extends FoundationClass {
	/**
	 * This Method is used for Delete the Contact with Organization
	 * 
	 * @throws Throwable
	 */
	@Test
	public void deleteContactWithOrganization() throws Throwable {

		HomePage hpObj = new HomePage(driver);
		OrganizationPage orgObj = new OrganizationPage(driver);
		CreateNewOrganizationPage cnopObj = new CreateNewOrganizationPage(driver);
		OrganizationInformationPage oipObj = new OrganizationInformationPage(driver);
		OrganizationLookupPage olpObj = new OrganizationLookupPage(driver);
		ContactPage cpObj = new ContactPage(driver);
		CreateNewContactPage cncpObj = new CreateNewContactPage(driver);
		ContactInformationPage cipObj = new ContactInformationPage(driver);

		/* Fetch Test Script specific data */
		String orgName = excelLib.getExcelData("contact", 1, 2) + "_" + wLib.getRandomNumber();
		String org_Type = excelLib.getExcelData("contact", 1, 3);
		String org_industry = excelLib.getExcelData("contact", 1, 4);
		String contactName = excelLib.getExcelData("contact", 1, 5)+wLib.getRandomNumber();

		/* step 1 : Navigate to Organization page */
		hpObj.getOrganizationLink().click();
		;

		/* step 2 : Navigate to create new Organization */
		orgObj.navigateToCreateNewOrgPage();

		/* step 3 : Create Organization */
		cnopObj.getOrgNameTxtBox().sendKeys(orgName);

		WebElement swb1 = cnopObj.getTypeListBox();
		wLib.select(swb1, org_Type);

		WebElement swb2 = cnopObj.getIndustryListBox();
		wLib.select(swb2, org_industry);

		cnopObj.getSaveButton().click();

		/* step 4 : Verify the Organization */
		String actOrgName = oipObj.getOrgInfo().getText();

		Assert.assertTrue(actOrgName.contains(orgName));

		/* step 5 : Navigate to Contact page */
		hpObj.getContactsLink().click();

		/* step 6 : Navigate to create new Contact page */
		cpObj.getCreateContact().click();

		/* step 7 : Create new Contact */
		cncpObj.getLastNameTxtBox().sendKeys(contactName);
		cncpObj.getOrgNameLookup().click();

		// Goto new tab
		wLib.switchToNewTab(driver, "specific_contact_account_address");

		olpObj.getSearchTxtBox().sendKeys(orgName);
		olpObj.getSearchBtn().click();
		olpObj.getSelectOrg().click();

		// come back to parent Window
		wLib.switchToNewTab(driver, "Administrator - Contacts");

		cncpObj.getSaveButton().click();

		/* step 8: Verify the Contact Creation */
		String actconatct = cipObj.getContactInfo().getText();
		Assert.assertTrue(actconatct.contains(contactName));

		// Delete contact
		/* step 11 : Navigate to Contact Page */
		hpObj.getContactsLink().click();

		/* step 12 : Search for the Contact */
		orgObj.getSearchTxtBox().sendKeys(contactName);
		WebElement optionListBox = orgObj.getSearchOptionListBox();
		wLib.select(optionListBox, excelLib.getExcelData("org", 4, 5));
		orgObj.getSearchSubmmitBtn().click();

		boolean waitFlag1 = wLib.customWait(driver);

		/* step 13 : Delete the Contact */
		if (waitFlag1)
			driver.findElement(By.xpath("//a[text()='" + contactName + "']/..//preceding-sibling::td[3]")).click();
		orgObj.getDeleteBtn().click();
		wLib.alertOk(driver);

		/* step 14 : Verify the Deletion of Contact */
		String actConDelConformation = cpObj.getNoContactFoundMsg().getText();
		String expConDelConformation = excelLib.getExcelData("org", 4, 4);
		boolean Conflag = actConDelConformation.contains(expConDelConformation);
		Assert.assertTrue(Conflag);

		// Delete organization
		/* step 15 : Navigate to the Organization Page */
		hpObj.getOrganizationLink().click();

		/* step 16 : Search the Organization */
		orgObj.getSearchTxtBox().sendKeys(orgName);
		WebElement optionListBox1 = orgObj.getSearchOptionListBox();
		wLib.select(optionListBox1, excelLib.getExcelData("org", 1, 6));
		orgObj.getSearchSubmmitBtn().click();

		/* step 17 : Select the Organization */
		driver.findElement(By.xpath("//tr[1]//a[text()='" + orgName + "']/..//preceding-sibling::td[2]")).click();

		/* step 18 : Delete the Organization */
		orgObj.getDeleteBtn().click();
		wLib.alertOk(driver);
		orgObj.getSearchSubmmitBtn().click();
		/* step 19 : Verify the Deletion of Organization */
		String actDelConformartion = orgObj.getNoOrgFoundMsg().getText();
		String expDelConformation = excelLib.getExcelData("org", 1, 5);
		boolean flag = actDelConformartion.contains(expDelConformation);
		Assert.assertTrue(flag);
	}
}
