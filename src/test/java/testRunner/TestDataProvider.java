package testRunner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider
{
	@Test(dataProvider="getData")
public void m1(String URL)
{
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.manage().window().maximize();
}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[4][1];
		objArr[0][0] = "https://www.google.co.in/";
		
		objArr[1][0] = "https://selenium.dev/";
		
		objArr[2][0] = "http://automationtesting.in/";
		
		objArr[3][0] = "https://thememakker.com/templates/oreo/realestate/html/light/index.html";
		
		return objArr;
		
	}
}
