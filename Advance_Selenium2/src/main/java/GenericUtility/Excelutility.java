package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {
	public String toReadDataFromExcelFile(String sheetname, int Rownum, int cellNum) throws EncryptedDocumentException, IOException { 
	FileInputStream fis = new 
	FileInputStream("./src\\test\\resources\\sample.xlsx"); 
	Workbook wb = WorkbookFactory.create(fis); 
	String data = wb.getSheet(sheetname).getRow(Rownum).getCell(cellNum).getStringCellValue(); 
	wb.close(); 
	return data;
	
}

	public int togetLastRowNum(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\sample.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rownum = wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rownum;
	}

}
