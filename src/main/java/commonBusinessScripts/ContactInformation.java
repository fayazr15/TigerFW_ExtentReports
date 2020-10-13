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

public class ContactInformation extends ConfigFiles
{
	@FindBy(className="dvHeaderText")
	private WebElement SuccMsg;
	
	public String getContactSuccMsg()
	{
		String Msg = SuccMsg.getText();
		return Msg;
	}
	
	public String getContactNameAfterCreate()
	{
		String Msg = SuccMsg.getText();
		String[] splitMsg = Msg.split(" ");
		String actText = splitMsg[3];
		return actText;
	}
	
	public ContactInformation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
