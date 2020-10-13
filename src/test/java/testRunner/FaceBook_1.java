package testRunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonLibraries.ConfigFiles;

public class FaceBook_1 extends ConfigFiles
{
	@Test
	public void getTitle() //passing
	{
//		test = report.createTest("getTitle"); // Imp
		String title =	driver.getTitle();
		System.out.println(title);
		String exp ="Facebook – log in or sign";

		Assert.assertEquals(title, exp);
		

	}

}
