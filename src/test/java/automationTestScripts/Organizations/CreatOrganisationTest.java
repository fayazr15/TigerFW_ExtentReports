package automationTestScripts.Organizations;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonBusinessScripts.CreatingNewOrganization;
import commonBusinessScripts.HomePage;
import commonBusinessScripts.OrganizationInformation;
import commonBusinessScripts.Organizations;
import commonLibraries.ConfigFiles;

/**
 * @author Fayaz
 * @category Organizations
 * @code This code is written to create Organization based on parameters
 * @param Organization Name
 * @param Industry
 * @param Type
 */
public class CreatOrganisationTest extends ConfigFiles
{
	
	
//	@Test(groups={"regression"})
//	Comment below code line to start Group Execution
	@Test
	public void CreateOrganisation() throws Throwable
	{
		/*
		 * All POM Classes Objects Created
		 */
		HomePage HomePage = new HomePage(driver);
		Organizations Oganisations = new Organizations(driver);
		CreatingNewOrganization CreatingNewOrganization = new CreatingNewOrganization(driver);
		OrganizationInformation OrganizationInformation =new OrganizationInformation(driver);
		
		/* Step 1: Navigate to Organization link */
		HomePage.ClickOrganisationsLink();
		/* Step 2: Click on Create Organization Button */
		Oganisations.ClickCreateOrgBtn();
		/* Step 3: Enter AccountName in textBox*/
		CreatingNewOrganization.getAccountname().sendKeys(data.FetchDataFromExcelFile("Organizations", 1, 3),"_"+d.getRamDomNum());
		/* Step 4: Select Industry from DropDown */
		d.SelectDropDownByValue(CreatingNewOrganization.getIndustry(), data.FetchDataFromExcelFile("Organizations", 2, 3));
		/* Step 5: Select AccountType from DropDown */
//		d.SelectDropDownByValue(CreatingNewOrganization.getAccounttype(), data.FetchDataFromExcelFile("Organizations", 3, 3));
		/* Step 6: Click on Save Button */
		CreatingNewOrganization.ClickOnSaveBtn();
		/* Step 7: Validate Organization should be created */
		Assert.assertTrue(OrganizationInformation.getOrgSuccMsg().contains(data.FetchDataFromExcelFile("Organizations", 4, 4)));
	}
	
}
