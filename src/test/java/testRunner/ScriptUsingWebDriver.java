package testRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScriptUsingWebDriver 
{

	
	/*WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	WebDriverManagesr.edgedriver().setup();
	WebDriverManager.operadriver().setup();
	WebDriverManager.phantomjs().setup();
	WebDriverManager.iedriver().setup();
	WebDriverManager.chromiumdriver().setup();*/
	

		
		private static WebDriver driver;

	    @BeforeClass
	    public static void setupClass() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	    }


	    @Test
	    public void test() {
	 driver.get("https://www.google.co.in/");
	    }
	
}
