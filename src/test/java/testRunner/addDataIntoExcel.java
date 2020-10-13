package testRunner;

import org.testng.annotations.Test;

import commonLibraries.FileData;

public class addDataIntoExcel

{
	@Test
	public void testing() throws Throwable
	{
		FileData data = new FileData();
	data.AddDataIntoExcelFile("AddData", 3, 0, "Fayaz");
	}
}
