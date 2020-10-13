package automationTestScripts.Contacts;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonBusinessScripts.ContactInformation;
import commonBusinessScripts.Contacts;
import commonBusinessScripts.CreatingNewContact;
import commonBusinessScripts.CreatingNewOrganization;
import commonBusinessScripts.HomePage;
import commonBusinessScripts.OrganizationInformation;
import commonBusinessScripts.Organizations;
import commonBusinessScripts.OrganizationsPouUp;
import commonLibraries.ConfigFiles;
/**
 * @author Fayaz
 * @category Organizations
 * @code This code is written to create Contact based on parameters
 * @param salutationtype
 * @param First Name
 * @param Last Name
 * @param Organization
 */
public class CreateContactWithOrganizationTest extends ConfigFiles

{
//	@Test(groups={"smoke"})
//	Comment below code line to start Group Execution
	@Test
	public void CreateNewContact() throws Throwable 
	{
		/*
		 * All POM Classes Objects Created
		 */
		HomePage HomePage =new HomePage(driver);
		Contacts Contacts =new Contacts(driver);
		CreatingNewOrganization CreatingNewOrganization =new CreatingNewOrganization(driver);
		Organizations Oganisations =new Organizations(driver);
		CreatingNewContact CreatingNewContact =new CreatingNewContact(driver);
		ContactInformation ContactInformation =new ContactInformation(driver);
		OrganizationsPouUp OrganizationsPouUp =new OrganizationsPouUp(driver);
		OrganizationInformation OrganizationInformation = new OrganizationInformation(driver);
		
		/* Step 1: Navigate to Organization link */
		HomePage.ClickOrganisationsLink();
		/* Step 2: Click on Create Organization Button */
		Oganisations.ClickCreateOrgBtn();
		/* Step 3: Enter AccountName in textBox*/
		CreatingNewOrganization.getAccountname().sendKeys(data.FetchDataFromExcelFile("Contacts", 1, 3),"_"+d.getRamDomNum());
		/* Step 4: Select Industry from DropDown */
		d.SelectDropDownByValue(CreatingNewOrganization.getIndustry(), data.FetchDataFromExcelFile("Contacts", 2, 3));
		/* Step 5: Select AccountType from DropDown */
		d.SelectDropDownByValue(CreatingNewOrganization.getAccounttype(), data.FetchDataFromExcelFile("Contacts", 3, 3));
		/* Step 6: Click on Save Button */
		CreatingNewOrganization.ClickOnSaveBtn();
		/* Step 7: Fetch Organization name after Created */
		String orgNameAfterCreate = OrganizationInformation.getOrgNameAfterCreate();
		/* Step 8: Validate Organization should be created */
		Assert.assertTrue(OrganizationInformation.getOrgSuccMsg().contains(data.FetchDataFromExcelFile("Contacts", 4, 4)));
		
		/* Step 1: Navigate to Contact link */
		HomePage.ClickContactLink();
		/* Step 2: Click on Create Contact Button */
		Contacts.clickCreateBtn();
		/* Step 3: Select SalutationType from DropDown */
		CreatingNewContact.Getsalutationtype(data.FetchDataFromExcelFile("Contacts", 5, 3));
		/* Step 4: Enter FirstName in textBox*/
		CreatingNewContact.getFirstname().sendKeys(data.FetchDataFromExcelFile("Contacts", 6, 3));
		/* Step 5: Enter LastName in textBox*/
		CreatingNewContact.getLastname().sendKeys(data.FetchDataFromExcelFile("Contacts", 7, 3)+d.getRamDomNum());
		/* Step 6: Click on Select Organization Button */
		CreatingNewContact.clickSelectOrgBtn();
		/* Step 7: Switch driver focus to Organizations window */
		d.SwitchToSpecificWindow(driver,data.FetchDataFromExcelFile("Contacts", 8, 3));
		/* Step 8: In Search provide Organization Name */
		OrganizationsPouUp.SearchExistOrgText(orgNameAfterCreate);
		/* Step 9: From Search drop down select Organization Name */
		OrganizationsPouUp.FilterOrgType(data.FetchDataFromExcelFile("Contacts", 9, 3));
		/* Step 10: Click on Search Now Button */
		OrganizationsPouUp.clickSearchNowBtn();
		/* Step 11: Select Existing Organization */
		OrganizationsPouUp.SelectOrgFromListAndClick(orgNameAfterCreate);
//		OrganizationsPouUp.SelectOrgFromList();
		/* Step 12: Switch back driver focus to Contacts window */
		d.SwitchToSpecificWindow(driver,data.FetchDataFromExcelFile("Contacts", 10, 3));
		/* Step 13: Click on Save Button */
//		CreatingNewOrganization.ClickOnSaveBtn();
		/* Step 14: Validate Contact should be created */
		Assert.assertTrue(ContactInformation.getContactSuccMsg().contains(data.FetchDataFromExcelFile("Contacts", 11, 4)));
		
	}
}
