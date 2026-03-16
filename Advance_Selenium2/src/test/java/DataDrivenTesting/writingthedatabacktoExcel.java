package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writingthedatabacktoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		FileInputStream fis= new FileInputStream("./src\\test\\resources\\sample.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet2");
		Row r= sh.getRow(0);
		Cell c=r.createCell(3);
		c.setCellValue("hello");
		FileOutputStream fos= new FileOutputStream("./src\\test\\resources\\sample.xlsx");
		wb.write(fos);
		wb.close();
	}

}
