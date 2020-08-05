package com.autodesk.organiationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.autodesk.genericUtils.FoundationClass;
import com.autodesk.objectRepositoryLib.CreateNewOrganizationPage;
import com.autodesk.objectRepositoryLib.HomePage;
import com.autodesk.objectRepositoryLib.OrganizationInformationPage;
import com.autodesk.objectRepositoryLib.OrganizationPage;

/**
 * 
 * @author Muthu manickam
 * 
 *         This class is used for Delete An Organization from Organization page
 *
 */
public class DeleteOrganizationTest extends FoundationClass {
	/**
	 * This Method is used for Delete An Organization
	 * 
	 * @throws Throwable
	 */
	@Test
	public void deleteOrganization() throws Throwable {

		HomePage hpObj = new HomePage(driver);
		OrganizationPage orgObj = new OrganizationPage(driver);
		CreateNewOrganizationPage cnopObj = new CreateNewOrganizationPage(driver);
		OrganizationInformationPage oipObj = new OrganizationInformationPage(driver);
		
		/* Fetch Test Script specific data */
		String orgName = excelLib.getExcelData("org", 1, 2) + "_" + wLib.getRandomNumber();
		String org_Type = excelLib.getExcelData("org", 1, 3);
		String org_industry = excelLib.getExcelData("org", 1, 4);

		/* step 1 : Navigate to Organization page */
		hpObj.getOrganizationLink().click();;

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

		// Delete the Organization
		/* step 5 : Navigate to the Organization Page */
		hpObj.getOrganizationLink().click();

		/* step 6 : Search the Organization */
		orgObj.getSearchTxtBox().sendKeys(orgName);
		WebElement optionListBox = orgObj.getSearchOptionListBox();
		wLib.select(optionListBox, excelLib.getExcelData("org", 1, 6));
		orgObj.getSearchSubmmitBtn().click();

		/* step 7 : Select the Organization */
		driver.findElement(By.xpath("//tr[1]//a[text()='" + orgName + "']/..//preceding-sibling::td[2]")).click();

		/* step 8 : Delete the Organization */
		orgObj.getDeleteBtn().click();
		wLib.alertOk(driver);
		orgObj.getSearchSubmmitBtn().click();
		/* step 9 : Verify the Deletion of Organization */
		String actDelConformartion = orgObj.getNoOrgFoundMsg().getText();
		String expDelConformation = excelLib.getExcelData("org", 1, 5);
		boolean flag = actDelConformartion.contains(expDelConformation);
		Assert.assertTrue(flag);
	}
}
