package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Flib {
	
		public String readExcelData(String ExcelPath,String excelSheet,int rowCount,int cellCount) throws EncryptedDocumentException, IOException {
			FileInputStream fl = new FileInputStream(ExcelPath);
			Workbook wb = WorkbookFactory.create(fl);
			Sheet sheet = wb.getSheet(excelSheet);
			Row row = sheet.getRow(rowCount);
			Cell cell = row.getCell(cellCount);
			String value = cell.getStringCellValue();
			return value;
		}
		public int getRowCount(String Excelpath,String excelSheet) throws EncryptedDocumentException, IOException {
			FileInputStream flv = new FileInputStream(Excelpath);
			Workbook wc = WorkbookFactory.create(flv);
			Sheet sheet = wc.getSheet(excelSheet);
			int rl = sheet.getLastRowNum();
			return rl;
		}
		public String readPropertyData(String propPath,String Key) throws IOException {
			FileInputStream fl = new FileInputStream(propPath);
			Properties prop = new Properties();
			prop.load(fl);
			String value = prop.getProperty(Key);
			return value;
		}
		public void WriteExcelData(String excelPath,String sheetName,int rowIndex,int cellCount,String data) throws EncryptedDocumentException, IOException {
			FileInputStream fl = new FileInputStream(excelPath);
			Workbook wr = WorkbookFactory.create(fl);
			Sheet sheet = wr.getSheet(sheetName);
			Row row = sheet.getRow(rowIndex);
			Cell cell = row.createCell(cellCount);
			cell.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(excelPath);
			wr.write(fos);

		}
	}

