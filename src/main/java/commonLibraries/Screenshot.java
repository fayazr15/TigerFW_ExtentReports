package commonLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot 
{
	public static String getSceenshotPath(String TestCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir") +"/reports/"+TestCaseName+".png";
			File file = new File(destPath);
			FileUtils.copyFile(source, file);
			return destPath;
	}
}
