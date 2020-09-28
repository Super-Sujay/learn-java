package com.learn.files;

import static org.apache.poi.ss.usermodel.CellType.STRING;
import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) {
		String excelData = readExcel("./src/main/resources/MMC KRAs - 2019.xlsx", "Testing - A13", 1, 2);
		System.out.println("The cell data is: " + excelData);
		writeExcel("./src/main/resources/MMC KRAs - 2019.xlsx", "Testing - A13", 8, 5, "Sujay");
		excelData = readExcel("./src/main/resources/MMC KRAs - 2019.xlsx", "Testing - A13", 1, 5);
		System.out.println("The cell data is: " + excelData);
	}
	
	private static String readExcel(String filePath, String sheetName, int row, int column) {
		try {
			FileInputStream in = new FileInputStream(filePath);
			XSSFWorkbook excelWorkBook = new XSSFWorkbook(in);
			in.close();
			String excelData = excelWorkBook.getSheet(sheetName).getRow(--row).getCell(--column, RETURN_BLANK_AS_NULL).getStringCellValue();
			excelWorkBook.close();
			return excelData;
		} catch (InvalidOperationException e) {
			return "File does not exists in the path " + filePath;
		} catch (IOException e) {
			return "File cannot be opened in the path " + filePath;
		} catch (NullPointerException e) {
			return "The sheet does not contain data at [" + ++row + ", " + ++column + "]";
		}
	}
	
	private static void writeExcel(String filePath, String sheetName, int row, int column, String value) {
		try {
			FileInputStream in = new FileInputStream(filePath);
			XSSFWorkbook excelWorkBook = new XSSFWorkbook(in);
			in.close();
			XSSFSheet excelSheet = excelWorkBook.getSheet(sheetName);
			XSSFRow excelRow = excelSheet.getRow(--row);
			XSSFCell excelCell = excelRow.getCell(--column, RETURN_BLANK_AS_NULL);
			if (excelCell == null) {
				excelCell = excelRow.createCell(column, STRING);
				excelCell.setCellValue(value);
			} else
				excelCell.setCellValue(value);
			FileOutputStream out = new FileOutputStream(filePath);
			excelWorkBook.write(out);
			out.flush();
			out.close();
			excelWorkBook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
