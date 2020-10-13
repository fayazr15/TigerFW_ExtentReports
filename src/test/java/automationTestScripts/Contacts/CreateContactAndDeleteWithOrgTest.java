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
 * @category Contacts
 * @code This code is written to create Contact and Select Organization and  Delete Created contact and Organization based on parameters
 * @param salutationtype
 * @param First Name
 * @param Last Name
 * @param Organization
 */ 

public class CreateContactAndDeleteWithOrgTest extends ConfigFiles
{
	@Test
	public void CreateContactWithOrgAndDeleteWithOrg() throws Throwable
	{
		/*
		 * All POM Classes Objects Created
		 */
		HomePage HomePage =new HomePage(driver);
		Contacts Contacts =new Contacts(driver);
		CreatingNewOrganization CreatingNewOrganization =new CreatingNewOrganization(driver);
		Organizations Oganisations = new Organizations(driver);
		CreatingNewContact CreatingNewContact = new CreatingNewContact(driver);
		ContactInformation ContactInformation =new ContactInformation(driver);
		OrganizationsPouUp OrganizationsPouUp =new OrganizationsPouUp(driver);
		OrganizationInformation OrganizationInformation = new OrganizationInformation(driver);
		
		
		/* Step 1: Navigate to Organization link */
		HomePage.ClickOrganisationsLink();
		/* Step 2: Click on Create Organization Button */
		Oganisations.ClickCreateOrgBtn();
		/* Step 3: Enter AccountName in textBox*/
		CreatingNewOrganization.getAccountname().sendKeys(data.FetchDataFromExcelFile("Contacts", 13, 3),"_"+d.getRamDomNum());
		/* Step 4: Select Industry from DropDown */
		d.SelectDropDownByValue(CreatingNewOrganization.getIndustry(), data.FetchDataFromExcelFile("Contacts", 14, 3));
		/* Step 5: Select AccountType from DropDown */
		d.SelectDropDownByValue(CreatingNewOrganization.getAccounttype(), data.FetchDataFromExcelFile("Contacts", 15, 3));
		/* Step 6: Click on Save Button */
		CreatingNewOrganization.ClickOnSaveBtn();
		/* Step 7: Fetch Organization name after Created */
		String orgNameAfterCreate = OrganizationInformation.getOrgNameAfterCreate();
		/* Step 8: Validate Organization should be created */
		Assert.assertTrue(OrganizationInformation.getOrgSuccMsg().contains(data.FetchDataFromExcelFile("Contacts", 16, 4)));
		
		/* Step 1: Navigate to Contact link */
		HomePage.ClickContactLink();
		/* Step 2: Click on Create Contact Button */
		Contacts.clickCreateBtn();
		/* Step 3: Select SalutationType from DropDown */
		CreatingNewContact.Getsalutationtype(data.FetchDataFromExcelFile("Contacts", 17, 3));
		/* Step 4: Enter FirstName in textBox*/
		CreatingNewContact.getFirstname().sendKeys(data.FetchDataFromExcelFile("Contacts", 18, 3));
		/* Step 5: Enter LastName in textBox*/
		CreatingNewContact.getLastname().sendKeys(data.FetchDataFromExcelFile("Contacts", 19, 3)+d.getRamDomNum());
		/* Step 6: Click on Select Organization Button */
		CreatingNewContact.clickSelectOrgBtn();
		/* Step 7: Switch driver focus to Organizations window */
		d.SwitchToSpecificWindow(driver,data.FetchDataFromExcelFile("Contacts", 20, 3));
		/* Step 8: In Search provide Organization Name */
		Contacts.SearchText(orgNameAfterCreate);
		/* Step 9: From Search drop down select Organization Name */
		OrganizationsPouUp.FilterOrgType(data.FetchDataFromExcelFile("Contacts", 21, 3));
		/* Step 10: Click on Search Now Button */
		OrganizationsPouUp.clickSearchNowBtn();
		/* Step 11: Select Existing Organization */
		OrganizationsPouUp.SelectOrgFromListAndClick(orgNameAfterCreate);
		/* Step 12: Switch back driver focus to Contacts window */
		d.SwitchToSpecificWindow(driver,data.FetchDataFromExcelFile("Contacts", 22, 3));
		/* Step 13: Click on Save Button */
		CreatingNewContact.ClickOnSaveBtn();
		/* Step 14: Fetch created contact name */
		String ContactAfterCreate = ContactInformation.getContactNameAfterCreate();
		/* Step 15: Validate Contact Created Successfully */
		Assert.assertTrue(ContactInformation.getContactSuccMsg().contains(data.FetchDataFromExcelFile("Contacts", 23, 4)));
		/* Step 16: wait until Contacts Link Visible*/
		d.waitForElemnetVsibility(driver, HomePage.getContactsLink());
		/* Step 17: Click on Contacts Link */
		HomePage.ClickContactLink();
		/* Step 18: Clear search text box */
		Contacts.getSearchText().clear();
		/* Step 19: Search created Contact in search text box */
		Contacts.SearchText(ContactAfterCreate);
		/* Step 20: From Search drop down select LatName */
		Contacts.FilterContactType(data.FetchDataFromExcelFile("Contacts", 24, 3));
		/* Step 21: Click on Search Now Button */
		Contacts.clickSearchNowBtn();
		/* Step 22: wait until Visibility of Element  */
		d.waitForElemnetVsibility(driver, Contacts.getInventoryCount());
		/* Step 23: Select CheckBox of created contact*/
		Contacts.ClickcheckBox();
		/* Step 24: Click on Delete Button*/
		Contacts.ClickDeleteBtn();
		/* Step 25: Handle Alert as Accept*/
		d.alertOk(driver);
		/* Step 26: Clear search text box */
		Contacts.getSearchText().clear();
		/* Step 27: Search created Contact in search text box */
		Contacts.SearchText(ContactAfterCreate);
		/* Step 28: From Search drop down select LatName */
		Contacts.FilterContactType(data.FetchDataFromExcelFile("Contacts", 25, 3));
		/* Step 29: Click on Search Now Button */
		Contacts.clickSearchNowBtn();
		/* Step 30: Validate created contact should not be there in contact list */
		Assert.assertTrue(Contacts.ValidateContact().contains(data.FetchDataFromExcelFile("Contacts", 26, 4)));
		/* Step 31: wait until Visibility of Element  */
		d.waitForElemnetVsibility(driver, HomePage.getOrganisationsLink());
		/* Step 32: Click on Organization link */
		HomePage.ClickOrganisationsLink();
		/* Step 33: Clear search text box */
		Oganisations.getSearchText().clear();
		/* Step 34: Search created Organization in search text box */
		Oganisations.SearchOrgText(orgNameAfterCreate);
		/* Step 35: Select Organization filter type to OrganizationName */
		Oganisations.FilterOrgDropDown(data.FetchDataFromExcelFile("Contacts", 27, 3));
		/* Step 36: Click on Search Now Button */
		Oganisations.ClickSearchBtn();
		/* Step 37: wait until Visibility of Element  */
		d.waitForElemnetVsibility(driver, Oganisations.getInventoryCount());
		/* Step 38: Select CheckBox of created Organization*/
		Oganisations.ClickcheckBox();
		/* Step 39: Click on Delete Button*/
		Oganisations.ClickDeleteBtn();
		/* Step 40: Handle Alert as Accept*/
		d.alertOk(driver);
		/* Step 41: Clear search text box */
		Oganisations.getSearchText().clear();
		/* Step 42: Search created Organization in search text box */
		Oganisations.SearchOrgText(orgNameAfterCreate);
		/* Step 43: Select Organization filter type to OrganizationName */
		Oganisations.FilterOrgDropDown(data.FetchDataFromExcelFile("Contacts", 28, 3));
		/* Step 44: Click on Search Now Button */
		Oganisations.ClickSearchBtn();
		/* Step 45: Validate created Organization should not be there in Organization list */
		Assert.assertTrue(Oganisations.ValidateOrg().contains(data.FetchDataFromExcelFile("Contacts", 29, 4)));
		
	}
}
