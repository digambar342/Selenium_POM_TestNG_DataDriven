package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import pages.ForgotPassword;

public class Utilities {

	public static String getPropertiesFileData(String key) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\DIGAMBAR\\workspace_Oxygen\\amazonDemo\\src\\main\\java\\config\\Config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

	public static String getDataFromExcelSheet(String sheetName, String columnName, String rowName) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\DIGAMBAR\\workspace_Oxygen\\amazonDemo\\src\\test\\java\\resources\\TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh;
		XSSFRow row;
		XSSFCell cell;
		int rowNum = 0;
		int columnNum = 0;
		String cellValue = null;
		Iterator<Sheet> si = wb.sheetIterator();
		while (si.hasNext()) {
			sh = (XSSFSheet) si.next();
			if (sh.getSheetName().equalsIgnoreCase(sheetName)) {
				Iterator<Row> ri = sh.rowIterator();
				while (ri.hasNext()) {
					row = (XSSFRow) ri.next();
					if (row.getCell(0).getStringCellValue().equalsIgnoreCase(rowName)) {
						System.out.println("Row Number to be searched " + row.getRowNum());
						rowNum = row.getRowNum();
						break;
					}
				}
			}
			Iterator<Cell> ci = sh.getRow(0).cellIterator();
			while (ci.hasNext()) {
				cell = (XSSFCell) ci.next();
				if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
					columnNum = cell.getColumnIndex();
					break;
				}
			}
			cellValue = sh.getRow(rowNum).getCell(columnNum).getStringCellValue();
			break;
		}
		return cellValue;
	}

	public static String returnNextWindows(WebDriver driver) {
		String newWindow=null;
		String currentWindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String eachWindow : allWindowHandles) {
			if (!(eachWindow.equals(currentWindow))) {
				newWindow = eachWindow;
				break;
			}
		}
		return newWindow;
	}

}
