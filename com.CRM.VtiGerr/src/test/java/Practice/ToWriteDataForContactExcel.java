package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToWriteDataForContactExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("./src/test/resources/Soumya.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		wb.createSheet("Sheet2").createRow(3).createCell(2).setCellValue("Soumya@Tcs");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Soumya.xlsx");
		wb.write(fos);
		System.out.println("Data Added");

	}

}
