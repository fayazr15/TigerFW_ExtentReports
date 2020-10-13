package commonLibraries;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @code This class provides all re-usable Scenarios of WebDriver
 * @author Fayaz
 *
 */
public class DriverScripts
{
	
	/**1
	 * To get Random Integer Values
	 * @return i
	 */
	public int getRamDomNum()
	{
		Random r = new Random();
		int i = r.nextInt(1000);
		return i;
	}
	
	/**2
	 * wait for all element to load in DOM document
	 * @param driver
	 */
	public void waitForPagetoLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	/**3
	 * wait for  visibility of specific element in GUI
	 * @param driver
	 * @param expEelement
	 */
	public void waitForElemnetVsibility(WebDriver driver,WebElement expEelement)
	{
		WebDriverWait wait =new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(expEelement));
	}
	/**4
	 * wait for  page title to be available
	 * @param driver
	 * @param pageTitle
	 */
	public void  waitForPageTitleVisibility(WebDriver driver,String pageTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(pageTitle));
	}
	
	/**5
	 * wait for  any element
	 * @param driver
	 * @param element
	 * @return 
	 * @throws Throwable
	 */
	public boolean waitForAnyElement(WebDriver driver,WebElement element) throws Throwable
	{
			boolean flag =false;
			int count =0;
								while (count<30) 
								{
						try
						{
								element.isDisplayed();
								flag=true;
								break;
						}
						catch (Throwable  t) 
						{
								count++;
								Thread.sleep(1000);
						}
								}
		return flag;
	}
	/**6
	 * Use to wait and click an element
	 * @param driver
	 * @param element
	 * @return flag
	 * @throws Throwable
	 */
	public boolean waitAndClickElement(WebDriver driver,WebElement element) throws Throwable
	{
		boolean flag =false;
		int count =0;
							while (count<30) 
							{
					try
					{
							element.click();
							flag=true;
							break;
					}
					catch (Throwable  t) 
					{
							count++;
							Thread.sleep(1000);
					}
							}
	return flag;
	}
	
	
	/**7
	 * Used to Select value from Drop Down based on Parameter
	 * @param WebElement
	 * @param EnterElement
	 */
	public void SelectDropDownByValue(WebElement WebElement,String EnterElement)
	{
		Select s = new Select(WebElement);
		s.selectByValue(EnterElement);
	}
	
	/**8
	 * Used to Select value from Drop Down based on Parameter
	 * @param WebElement
	 * @param Index
	 */
	public void SelectDropDownByIndex(WebElement WebElement,int Index)
	{
		Select s = new Select(WebElement);
		s.selectByIndex(Index);
	}
	/**9
	 * Used to Switch to new window based on Parameter
	 * @param driver
	 * @param pageTitle
	 */
	public void SwitchToSpecificWindow(WebDriver driver,String pageTitle)
	{
		Set<String> set  = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) 
		{
			String winID = it.next();
			driver.switchTo().window(winID);
			 String currentPageTitle =driver.getTitle();
		      if(currentPageTitle.contains(pageTitle)) 
		      {
		    	  break;
		      }
		}
	}
	
	/**10
	 * Used to Accept Alert Message
	 * @param driver
	 */
	public void alertOk(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
	
	/**11
	 * Used to Cancel Alert Message
	 * @param driver
	 */
	public void alertCancel(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**12
	 * Used to move cursor to specific element(Mouse Over) based on Parameter
	 * @param driver
	 * @param element
	 */
	public void moveMouseToElement(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**13
	 * Used to double click element based on Parameter
	 * @param driver
	 * @param element
	 */
	public void doubleClcik(WebDriver driver , WebElement element) 
	{
		Actions act = new Actions(driver);
		 act.doubleClick().perform();
	}
	
	/**14
	 * Used to Right click element based on Parameter
	 * @param driver
	 * @param element
	 */
	public void rightClcik(WebDriver driver , WebElement element) 
	{
		Actions act= new Actions(driver);
    	 act.contextClick(element).perform();
	}
	
	/**15
	 * Used to Switch one Frame to another Frame based on parameter
	 * @param drver
	 * @param attribute
	 */
	public void switchToFrame(WebDriver drver , String attribute) 
	{
        drver.switchTo().frame(attribute);
	}
	
	/**16
	 * Used to Switch one Frame to another Frame based on parameter
	 * @param drver
	 * @param index
	 */
	public void switchToFrame(WebDriver drver , int index) 
	{
      drver.switchTo().frame(index);
	}
	
	/**17
	 * Used to Switch one Frame to another Frame based on parameter
	 * @param drver
	 * @param elemnent
	 */
	public void switchToFrame(WebDriver drver , WebElement elemnent) 
	{
      drver.switchTo().frame(elemnent);
	}
	
	/**18
	 * Used to Perform all JavascriptExecutor Actions based on parameter
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver  , String javaScript) 
	{
   	 JavascriptExecutor js = (JavascriptExecutor)driver;
   	 js.executeScript(javaScript);
    }
	
}