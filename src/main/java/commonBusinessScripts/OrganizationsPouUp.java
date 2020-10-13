package commonBusinessScripts;

import org.openqa.selenium.By;
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
public class OrganizationsPouUp extends ConfigFiles
{
	@FindBy(id="search_txt")
	private WebElement SearchExistingOrg;
	
	@FindBy(name="search_field")
	private WebElement FilterOrgType;
	
	@FindBy(name="search")
	private WebElement SearchNowBtn;
	
	@FindBy(xpath="//table[@class='small']/tbody/tr[2]/td/a")
	private WebElement OrgToSelect;
	
	public void SelectOrgFromList()
	{
			OrgToSelect.click();
	}
	
	public void clickSearchNowBtn()
	{
		SearchNowBtn.click();
	}

	public void FilterOrgType(String SelectByValue)
	{
			d.SelectDropDownByValue(FilterOrgType, SelectByValue);
	}
	
	public void SearchExistOrgText(String enterSearchText)
	{
		SearchExistingOrg.sendKeys(enterSearchText);;
	}
	
	public WebElement getSearchExistingOrg() {
		return SearchExistingOrg;
	}
	
	public void SelectOrgFromListAndClick(String OrgName) throws Throwable
	{
		WebElement Organization = driver.findElement(By.xpath("//a[text()='"+OrgName+"']"));
		d.waitAndClickElement(driver, Organization);
	}
	public OrganizationsPouUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
