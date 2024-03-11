package week5.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static String[][] getExcelData(String fileName) throws IOException {
		
		XSSFWorkbook workBook = new XSSFWorkbook("./data/"+fileName+".xlsx");
		
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		int rowCountWithoutHeader = sheet.getLastRowNum();
		
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowCountWithoutHeader][columnCount];
		
		for(int i = 1; i <= rowCountWithoutHeader; i++) {
			for(int j = 0; j <columnCount; j++) {
				String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j] = cellValue;
			}
		}
		
		workBook.close();
		
		return data;

	}

}
