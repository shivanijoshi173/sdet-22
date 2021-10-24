package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility
{
	/*
	 * author @shivani
	 */
	
	/**
	 * THIS METHOD IS USED TO READ DATA FROM EXCEL BY SPECIFYING SHEETNAME, ROW NUMBER,AND CELL NUMBER
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	
	public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable
	{
		FileInputStream File=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook=WorkbookFactory.create(File);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
	
		return cell.getStringCellValue();
	}
	
	
	/**
	 * THIS METHOD RETURNS ALL THE DATA IN THE SHEET  
	 * here we will use data provider for running same script with multiple data
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public Object [][] getExcelData(String sheetName) throws Throwable, InvalidFormatException, IOException
	{
		FileInputStream File=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook=WorkbookFactory.create(File);
		Sheet sheet=workbook.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		int lastCell=sheet.getRow(0).getLastCellNum();
		// we are using OBJECT[][] here coz we dont know what kind of data is present in database
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

	/**
	 * THIS METHOD IS USED TO WRITE DATA INSIDE EXCEL SHEET
	 * @param sheetname
	 * @param rownum
	 * @param colnum
	 * @param value
	 * @throws Throwable
	 */
	public void writeExcelData(String sheetname,int rownum,int colnum,String value) throws Throwable
	{
		FileInputStream File=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook=WorkbookFactory.create(File);
		workbook.createSheet(sheetname).createRow(rownum).createCell(colnum).setCellValue(value);
		FileOutputStream writeFile=new FileOutputStream(IPathConstant.EXCELPATH);
		workbook.write(writeFile);
		
	}

}