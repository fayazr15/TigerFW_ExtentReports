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
public class Contacts extends ConfigFiles
{
	@FindBy(xpath="//td[@class='small']//td//td[1]//a[1]//img[1]")
	private WebElement createContactBtn;
	
	@FindBy(name="search_text")
	private WebElement SearchText;
	
	@FindBy(name="search_field")
	private WebElement FilterOrg;
	
	@FindBy(name="submit")
	private WebElement SearchNowBtn;
	
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement ValidateContact;
	
	@FindBy(name="selected_id")
	private WebElement checkBox;
	
	@FindBy(xpath="//input[contains(@class,'delete')]")
	private WebElement DeleteBtn;
	
	@FindBy(xpath="//td[contains(text(),'Showing Records 1 - 1 of 1')]")
	private WebElement InventoryCount;
	
	
	public void ClickcheckBox()
	{
		checkBox.click();
	}
	
	public void ClickDeleteBtn()
	{
		DeleteBtn.click();
	}
	
	public String ValidateContact()
	{
		String actText = ValidateContact.getText();
		return actText;
	}
	public void SearchText(String EnterContactTxt)
	{
		getSearchText().sendKeys(EnterContactTxt);
	}
	
	public void FilterContactType(String SelectByValue)
	{
			d.SelectDropDownByValue(FilterOrg, SelectByValue);
	}
	
	public void clickSearchNowBtn()
	{
		SearchNowBtn.click();
	}
	
	public void clickCreateBtn()
	{
		createContactBtn.click();
	}
	
	public Contacts(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchText() {
		return SearchText;
	}
	
	public WebElement getDeleteBtn() {
		return DeleteBtn;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}
	
	public WebElement getInventoryCount() {
		return InventoryCount;
	}
	
	
	
}
