package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo2 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		File f = new File("C:\\Users\\AMEEN\\Documents\\HealthCare\\Demo\\Data\\test.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row r = sh.getRow(1);
		Cell c = r.getCell(1);
		String data = c.toString();
		
		DataFormatter d = new DataFormatter();
		String data1 = d.formatCellValue(c);
		System.out.println("data is " +data1);
		
		//in case we forget the single quotation, we gotta use class dataformatter to get the numerics
		
	}

}
