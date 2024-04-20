package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TowriteExceldata {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		//Open the document in java readable format
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Soumya.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		wb.createSheet("Sheet11").createRow(3).createCell(2).setCellValue("Soumya Ranjan");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Soumya.xlsx");
		wb.write(fos);
		System.out.println("Data Added");

	}

}
