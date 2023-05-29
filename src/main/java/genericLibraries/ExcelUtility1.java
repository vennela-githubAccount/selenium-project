package genericLibraries;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility1 {
	/**
	 * this class contains reusable methods to perform operations on excel 
	 * @author j
	 */
	public class ExcelUtility {
		private Workbook workbook;
		
		/**
		 * this method is used to initialize excel file
		 * @param excelPath
		 */
		public void excelInit(String excelPath) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(excelPath);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
				
			}
			try {
				workbook = WorkbookFactory.create(fis);
			}catch(EncryptedDocumentException | IOException e) {
				e.printStackTrace();
			}
		}
		 
		/**
		 * this method is used to read single data from excel
		 * @param sheetname
		 * @param rownum
		 * @param cellnum
		 * @return
		 */
		public String getDataFromExcel(String sheetName, int rowNum, int cellNum) {
			DataFormatter df = new DataFormatter();
			String data = df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
			return data;
		}
		
		/**
		 * this method is used to fetch multiple data from the excel
		 * @param sheetname
		 * @return
		 */
		public Map<String, String> getDataFromExcel(String sheetName){
			DataFormatter df = new DataFormatter();
			Map<String, String> map = new HashMap<>();
			Sheet sheet = workbook.getSheet(sheetName);
			
			for(int i=0; i<=sheet.getLastRowNum(); i++) {
				String key = df.formatCellValue(sheet.getRow(i).getCell(0));
				String value = df.formatCellValue(sheet.getRow(i).getCell(i));
				map.put(key, value);
			}
			
			return map;
		}
		
		/**
		 * this is used to write data to excel
		 * @param sheetName
		 * @param rowNum
		 * @param cellNum
		 * @param excelPath
		 * @param data
		 */
		public void writeToExcel(String sheetName, int rowNum, int cellNum, String excelPath, String data ) {
			Cell cell = workbook.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
			cell.setCellValue(data);
			
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(excelPath);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				workbook.write(fos);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * this method is used to close excel
		 */
		public void closeExcel() {
			try {
				workbook.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}


	}
}
