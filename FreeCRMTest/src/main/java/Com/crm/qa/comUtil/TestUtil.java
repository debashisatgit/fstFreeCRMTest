package Com.crm.qa.comUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	
	                                                          //Step-2
	public static long PAGE_LOAD_TIMEOUT = 20;               //public global data
	public static long IMPLICET_WAIT = 10;                  //public global data
	
	public static String TESTDATA_SHEET_PATH ="C:\\Users\\THI1901459\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\Com\\crm\\qa\\testdata\\RedifmailTestData.xlsx"; //path of excelsheet
	
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public static Object[][] getTestData(String sheetName){
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i<sheet.getLastRowNum(); i++) {
			for(int k = 0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
		
	}
	
	
	

}
