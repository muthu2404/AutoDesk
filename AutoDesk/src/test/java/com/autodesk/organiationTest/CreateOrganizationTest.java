package com.autodesk.organiationTest;

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
 * This class is used to create organization
 *
 */
public class CreateOrganizationTest extends FoundationClass{
	/**
	 * This method is used to create new organization
	 * @throws Throwable
	 */
	@Test
	public void createOrgtest() throws Throwable {
		HomePage hpObj = new HomePage(driver);
		OrganizationPage orgObj = new OrganizationPage(driver);
		CreateNewOrganizationPage cnopObj = new CreateNewOrganizationPage(driver);
		OrganizationInformationPage oipObj = new OrganizationInformationPage(driver);
		/* Fetch test script specific data */
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
	}
}
