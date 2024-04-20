package com.CRM.VtiGerr.GeneralUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class Excelfileutility {


	public void WriteDataintoExcel(String sheetname,int rowNumber,int cellno,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ipathConstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).createRow(rowNumber).createCell(cellno).setCellValue(value);
		FileOutputStream fos=new FileOutputStream(ipathConstant.excelfilepath);
		wb.write(fos);
	}
	
	public String  getDataFromExcel(String sheetname,int rowNumber,int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ipathConstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(rowNumber).getCell(cellno).getStringCellValue();
		return value;
		
	}
	@DataProvider
	public void getMultiplecellDate() throws Exception
	{
		FileInputStream fis=new FileInputStream(ipathConstant.excelfilepath);
		Sheet sh = WorkbookFactory.create(fis).getSheet("Sheet2");
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		Object[][]data=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				data[i][j]=sh.getRow(i)	.getCell(j).getStringCellValue();
			}
		}
		
	}
	
}
