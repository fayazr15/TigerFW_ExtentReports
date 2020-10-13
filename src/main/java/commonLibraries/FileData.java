package commonLibraries;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @code This Class is used to Fetch and add the Data from external resources
 * @resource Properties File
 * @resource Excel File
 * @author Fayaz
 *
 */
public class FileData 
{
	
	/**
	 * Used to read data from Properties file based on parameter
	 * @param EnterKey
	 * @return value
	 * @throws Throwable
	 */
	public String FetchDataFromPropertiesFile(String EnterKey) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/GlobalVariables.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(EnterKey);
		return value;
	}
	
	/**
	 * Used to get data from Excel file based on parameter
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return value
	 * @throws EncryptedDocumentException
	 * @throws Throwable
	 */
	
	public String FetchDataFromExcelFile(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		book.close();
		return value;
	}
	
	/**
	 * Used to set data into excel file based on parameter
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	
	public void AddDataIntoExcelFile(String sheetName,int rowNum,int cellNum,String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.createRow(rowNum);       
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		book.write(fos);
		fos.flush();
		fos.close();
	}
	
	/**
	 *  used to get the excel row count
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return  i
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int i = sheet.getLastRowNum();
		return i;
	}
}
