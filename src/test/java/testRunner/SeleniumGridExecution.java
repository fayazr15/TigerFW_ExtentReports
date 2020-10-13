package testRunner;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridExecution 
{
	WebDriver driver;
	@Test(priority=1)
	void setup() throws Throwable
	{
		String nodeURL="http://172.20.10.2:43948/wd/hub";
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		driver =new RemoteWebDriver(new URL(nodeURL),cap);
	}
	@Test(priority=2)
	void login() throws Throwable
	{
//		username==baigbaigbaig234@gmail.com     pwd==baigbaigbaig@234
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Step 1
		driver.get("http://localhost:8888/");
		String LogTit = driver.getTitle();
		if (LogTit.contains("vtiger CRM")) {
			System.out.println("Login page displayed");
		} else {
			System.out.println("Login page not Displayed");
		}
		// Step 2
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		String HomeTit = driver.getTitle();
		if (HomeTit.contains("Administrator")) 
		{
			System.out.println("Home page displayed");
		} else {
			System.out.println("Home page not Displayed");
		}
			driver.quit();
		}
	}
