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
public class Organizations extends ConfigFiles
{

	@FindBy(xpath="//td[@class='small']//td//td[1]//a[1]//img[1]")
	private WebElement CreateOrg;
	
	@FindBy(name="search_text")
	private WebElement SearchText; 
	
	@FindBy(name="search_field")
	private WebElement FilterOrg;
	
	@FindBy(name="submit")
	private WebElement SearchBtn;
	
	@FindBy(name="selected_id")
	private WebElement checkBox;
	
	@FindBy(xpath="//input[contains(@class,'delete')]")
	private WebElement DeleteBtn;
	
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement ValidateOrg;
	
	@FindBy(xpath="//td[contains(text(),'Showing Records 1 - 1 of 1')]")
	private WebElement InventoryCount;
	
	public String ValidateOrg()
	{
		String actText = ValidateOrg.getText();
		return actText;
	}
	
	public void ClickCreateOrgBtn()
	{
		CreateOrg.click();
	}
	public void ClickSearchBtn()
	{
		SearchBtn.click();
	}
	
	public void ClickcheckBox()
	{
		checkBox.click();
	}
	
	public void ClickDeleteBtn()
	{
		DeleteBtn.click();
	}
	public void SearchOrgText(String enterSearchText)
	{
		getSearchText().sendKeys(enterSearchText);;
	}
	
	
	public void FilterOrgDropDown(String EnterValue)
	{
		d.SelectDropDownByValue(FilterOrg, EnterValue);
	}
	public Organizations(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getDeleteBtn() {
		return DeleteBtn;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getSearchText() {
		return SearchText;
	}

	public WebElement getInventoryCount() {
		return InventoryCount;
	}

}
