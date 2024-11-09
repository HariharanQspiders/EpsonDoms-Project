package com.Epsondoms.ExceLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.Epsondoms.GenericLibrary.FrameworkConstant;

/**
 * This Class Provides the Resuable Method To Read The Data To Excel File
 * 
 * 
 * @author Harry
 */
public class ReadExcelFile implements FrameworkConstant {

	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public Workbook wb = null;

	public String readSingleData(String Sheetname, int row, int cell) {
		// 1.Convert The Physical File into Java Readable File
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Create The Workbook Using WorkBookFactory
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		// 3.Using Workbook Get The Sheet Control
		// 4.Using Sheet Get the Row Control
		// 5.Using Row Get The Column Control
		// 6.Using Column Get The Cell-Data
		String data = wb.getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}

	public void readMultipleData(String Sheetname) {
		// 1.Convert The Physical File into Java Readable File
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Create The Workbook Using WorkBookFactory
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		// 3.Using Workbook Get The Sheet Control
		// 4.Using Sheet Get the Row Control
		// 5.Using Row Get The Column Control
		// 6.Using Column Get The Cell-Datalefuuyllti

		int rowcount = wb.getSheet(Sheetname).getLastRowNum();
		for (int i = 1; i < rowcount; i++) {

			String data1 = wb.getSheet(Sheetname).getRow(i).getCell(1).getStringCellValue();
			String data2 = wb.getSheet(Sheetname).getRow(i).getCell(2).getStringCellValue();

		}

	}

	public void writeData(String sheetname, int row, int cell, String data) {
		// 1.Convert The Physical File into Java Readable File
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2.Create The Workbook Using WorkBookFactory
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

		// 3.Using Workbook Get The Sheet Control
		// 4.Using Sheet Get the Row Control
		// 5.Using Row Create Column
		// 6.Using Column Set the Cell-Data
		wb.getSheet(sheetname).getRow(row).createCell(cell).setCellValue("Data We Will Pass");

		// 7.Convert Java Readable File Into Physical File
		try {
			fos = new FileOutputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 8.Write The data
		try {
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 9.Close The WorkBook
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
