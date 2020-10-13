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
public class CreatingNewOrganization extends ConfigFiles
{
	
	@FindBy(name="accountname")
	private WebElement accountname;
	
	@FindBy(name="industry")
	private WebElement industry;
	
	@FindBy(name="accounttype")
	private WebElement accounttype;
	
	@FindBy(css="input[title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	

	
	public WebElement getAccountname() 
	{
		return accountname;
	}
	
	public void ClickOnSaveBtn()
	{
		getSaveBtn().click();
	}
	
	public CreatingNewOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getIndustry()
	{
		return industry;
	}

	public WebElement getAccounttype() {
		return accounttype;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	





}
