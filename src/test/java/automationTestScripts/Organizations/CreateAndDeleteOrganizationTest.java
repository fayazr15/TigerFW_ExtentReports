package automationTestScripts.Organizations;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonBusinessScripts.CreatingNewOrganization;
import commonBusinessScripts.HomePage;
import commonBusinessScripts.OrganizationInformation;
import commonBusinessScripts.Organizations;
import commonLibraries.ConfigFiles;
public class CreateAndDeleteOrganizationTest extends ConfigFiles
{
	
	/**
	 * @author Fayaz
	 * @category Organizations
	 * @code This code is written to create Organization and Delete Organization based on parameters
	 * @param Organization Name
	 * @param Industry
	 * @param Type
	 */ 
	@Test
	public void validateOrgAfterDelete() throws Throwable
	{
		/*
		 * All POM Classes Objects Created
		 */
		HomePage HomePage = new HomePage(driver);
		Organizations Oganisations =new Organizations(driver);
		CreatingNewOrganization CreatingNewOrganization =new CreatingNewOrganization(driver);
		OrganizationInformation OrganizationInformation =new OrganizationInformation(driver);
		
		/* Step 1: Navigate to Organization link */
		HomePage.ClickOrganisationsLink();
		/* Step 2: Click on Create Organization Button */
		Oganisations.ClickCreateOrgBtn();
		/* Step 3: Enter AccountName in textBox*/
		CreatingNewOrganization.getAccountname().sendKeys(data.FetchDataFromExcelFile("Organizations", 5, 3),"_"+d.getRamDomNum());
		/* Step 4: Select Industry from DropDown */
		d.SelectDropDownByValue(CreatingNewOrganization.getIndustry(), data.FetchDataFromExcelFile("Organizations", 6, 3));
		/* Step 5: Select AccountType from DropDown */
		d.SelectDropDownByValue(CreatingNewOrganization.getAccounttype(), data.FetchDataFromExcelFile("Organizations", 7, 3));
		/* Step 6: Click on Save Button */
		CreatingNewOrganization.ClickOnSaveBtn();
		/* Step 7: Fetch created Organization name */
		String orgNameAfterCreate = OrganizationInformation.getOrgNameAfterCreate();
		/* Step 8: Validate Organization should be created */
		Assert.assertTrue(OrganizationInformation.getOrgSuccMsg().contains(orgNameAfterCreate));
		/* Step 9: wait until Visibility of Element  */
		d.waitForElemnetVsibility(driver, HomePage.getOrganisationsLink());
		/* Step 10: Click to Organization link */
		HomePage.ClickOrganisationsLink();
		/* Step 11: Search created Organization in search text box */
		Oganisations.SearchOrgText(orgNameAfterCreate);
		/* Step 12: Select Organization filter type to OrganizationName */
		Oganisations.FilterOrgDropDown(data.FetchDataFromExcelFile("Organizations", 9, 3));
		/* Step 13: Click on Search Now Button */
		Oganisations.ClickSearchBtn();
		/* Step 14: wait until Visibility of Element  */
		d.waitForElemnetVsibility(driver, Oganisations.getInventoryCount());
		/* Step 15: Select CheckBox of created Organization*/
		Oganisations.ClickcheckBox();
		/* Step 16: Click on Delete Button*/
		Oganisations.ClickDeleteBtn();
		/* Step 17: Handle Alert as Accept*/
		d.alertOk(driver);
		/* Step 18: Clear search text box */
		Oganisations.getSearchText().clear();
		/* Step 19: Search created Organization in search text box */
		Oganisations.SearchOrgText(orgNameAfterCreate);
		/* Step 20: Select Organization filter type to OrganizationName */
		Oganisations.FilterOrgDropDown(data.FetchDataFromExcelFile("Organizations", 10, 3));
		/* Step 21: Click on Search Now Button */
		Oganisations.ClickSearchBtn();
		/* Step 22: Validate created Organization should not be there in Organization list */
		Assert.assertTrue(Oganisations.ValidateOrg().contains(data.FetchDataFromExcelFile("Organizations", 11, 4)));
	}
}
