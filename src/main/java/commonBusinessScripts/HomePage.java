package commonBusinessScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibraries.ConfigFiles;
/**
 * 
 * @author Fayaz
 *
 */
public class HomePage extends ConfigFiles
{
	@FindBy(xpath="//td[@class='small']//td[2]//img[1]")
	private WebElement Administrator;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOut;
	
	@FindBy(linkText="Organizations")
	private WebElement OrganisationsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	public void MoveToAdminstrator() 
	{
		 d.moveMouseToElement(driver,Administrator);
	}
	
	public void ClickOnSignOut()
	{
		SignOut.click();
	}
	
	public void ClickContactLink()
	{
		getContactsLink().click();
	}
	
	public void ClickOrganisationsLink()
	{
		getOrganisationsLink().click();
	}
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganisationsLink() {
		return OrganisationsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}


	
}
