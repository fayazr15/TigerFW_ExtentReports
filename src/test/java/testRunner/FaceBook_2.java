package testRunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonLibraries.ConfigFiles;

public class FaceBook_2 extends ConfigFiles

{

	
	@Test
	public void getTitle1() //fail
	{
//		test = report.createTest("getTitle1");
		
		
		String title =	driver.getTitle();
		System.out.println(title);
		String exp ="Facebook – log in or sign";
		Assert.assertEquals(title, exp);
	}
}
