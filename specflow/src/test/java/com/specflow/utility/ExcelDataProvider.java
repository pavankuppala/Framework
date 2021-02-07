package com.specflow.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider
{
	XSSFWorkbook wb;
	public ExcelDataProvider()throws Exception
	{
		FileInputStream fis;
		
			fis = new FileInputStream(new File("./TestData/TestData.xlsx"));
			wb=new XSSFWorkbook(fis);
	}
	
	public String getStringData(String sheetName, int row, int col)
	{
		return wb.getSheet("Login").getRow(row).getCell(col).getStringCellValue();
	}
	
	public double getNumericData(String sheetName, int row, int col)
	{
		return wb.getSheet("Login").getRow(row).getCell(col).getNumericCellValue();
	}

}
