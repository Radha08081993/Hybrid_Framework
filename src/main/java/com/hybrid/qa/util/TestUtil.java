package com.hybrid.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil 
{
	public static long PAGE_LOAD_TIMEPUT=20;
	public static long IMPLICIT_WAIT=10;
	static Workbook book;
	static Sheet sheet;
	public static String Test_data_sheet_path="C:\\Users\\Radha.Gade\\Documents\\Hybrid_Datadriven.xlsx";
	
	public static Object[][] getTestData(String sheetName) {

	    try {
	        FileInputStream file = new FileInputStream(Test_data_sheet_path);
	        book = WorkbookFactory.create(file);
	        sheet = book.getSheet(sheetName);

	        if (sheet == null) {
	            throw new RuntimeException("Sheet not found: " + sheetName);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    int totalRows = sheet.getLastRowNum();
	    int totalCols = sheet.getRow(0).getLastCellNum();

	    Object[][] data = new Object[totalRows][totalCols];

	    for (int i = 0; i < totalRows; i++) {
	        for (int j = 0; j < totalCols; j++) {
	            data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
	        }
	    }

	    return data;
	}
	}


