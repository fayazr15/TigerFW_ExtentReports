package commonLibraries;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonBusinessScripts.HomePage;
import commonBusinessScripts.LoginPage;
/**
 * @code This Class provides Standard Schedule of connect DB,launching browser,
 * 		 login,logout,close browser,DisConnect DB by Using TestNG Annotations
 * @author Fayaz
 *
 */
public class ConfigFiles {

	/**
	 * commonLibraries object creation
	 */
	public  static WebDriver driver ;

	public DriverScripts d = new DriverScripts();
	
//	public DataBaseLib db =new DataBaseLib();
 
	public FileData data = new FileData();
	
	static ExtentReports extent;


	
	
	public void ConnectDB() throws SQLException
	{
		
		/*Connect to DB*/
//		db.connectToDB();
	}
//	@Parameters("browser")
	@BeforeClass
	public void LaunchBroser() throws Throwable 
	{
	//To CrossBrowser execution unComment @Parameters and add argument as String browser & comment below line
		String browser = data.FetchDataFromPropertiesFile("browser");
		
//		Launch the browser
		if (browser.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		} 
		else if (browser.equals("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		
		// To perform Remote Execution (SELENIUM GRID)
		
			/*String nodeURL="http://172.20.10.2:19859/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			driver =new RemoteWebDriver(new URL(nodeURL),cap);*/
		
		driver.get(data.FetchDataFromPropertiesFile("url"));
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);// Before get();
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void loginApplication() throws Throwable 
	{
		/*Login to Application*/
		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.LoginToVtiger(data.FetchDataFromPropertiesFile("username"),data.FetchDataFromPropertiesFile("password"));
	}
	
	@BeforeTest
	public static  ExtentReports extentReportGenerator()
	{
//		ExtentReports , ExtentSparkReporter 2 classes required 
		
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		
//		ExtentSparkReporter
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Vtiger CRM Apllication");
		reporter.config().setDocumentTitle("Contacts & Organisation Test Results");
		
//		ExtentReports
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Fayaz Baig");
		
		return extent;
	}
	

	public void LogOutApplication() throws Throwable
	{
		/* Logout from Application*/
		HomePage HomePage=new HomePage(driver);
		HomePage.MoveToAdminstrator();
		HomePage.ClickOnSignOut();
	}
	
	
	@AfterClass
	public void CloseBrowser() throws Throwable
	{
		/*Close the browser*/
		driver.quit();
	}
	
	public void CloseDB() throws SQLException
	{
		/*DisConnect DB*/
//		db.DisconnectToDB();
	}

	

}
