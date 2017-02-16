package com.ibm.tealeaf.utils;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;

public class ExcelUtil {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String filePath, String sheetName)
			throws Exception {

		try {

			// Open the Excel file

			FileInputStream excelFile = new FileInputStream(filePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(excelFile);

			ExcelWSheet = ExcelWBook.getSheet(sheetName);

		} catch (Exception e) {
			e.printStackTrace();

			throw (e);

		}

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	public static String getCellData(int rowNum, int colNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(rowNum).getCell(colNum);

			String cellData = Cell.getStringCellValue();

			return cellData;

		} catch (Exception e) {
			e.printStackTrace();

			return "";

		}

	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters

	public static void setCellData(String filePath,String result, int rowNum, int colNum)
			throws Exception {

		try {

			Row = ExcelWSheet.getRow(rowNum);

			Cell = Row.getCell(colNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(colNum);

				Cell.setCellValue(result);

			} else {

				Cell.setCellValue(result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(filePath);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();

			throw (e);

		}

	}

}