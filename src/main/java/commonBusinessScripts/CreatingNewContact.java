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
public class CreatingNewContact extends ConfigFiles
{

	@FindBy(name="salutationtype")
	private WebElement salutationtype;
	
	@FindBy(name="firstname")
	private WebElement firstname;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(xpath="//tr[5]//td[2]//img[1]")
	private WebElement SelectOrg;
	
	@FindBy(css="input[title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public void clickSelectOrgBtn()
	{
		SelectOrg.click();
	}
	
	public void ClickOnSaveBtn()
	{
		getSaveBtn().click();
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void Getsalutationtype(String EnterElement)
	{
		d.SelectDropDownByValue(salutationtype, EnterElement);
	}
	
	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}
	
	public CreatingNewContact(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
