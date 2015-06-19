/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ncs.ccbs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import vn.meg.bossservice.vnp.CallWebService;

import com.ncs.ccbs.dao.ExtExcelDao;
import com.ncs.ccbs.model.ExtExcel;

/**
 * 
 * @author HoanPV
 * @version Jun 18, 2015
 *
 */
public class ExcelUtil {

	public static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(ExcelUtil.class);

	/**
	 * Read data from Excel
	 * 
	 * @param fileName
	 *            : excel file chua du lieu
	 */
	public static void read(String fileName) {
		String extStatus = "1";
		if (fileName.toLowerCase().contains("ext_add.xls")) {
			extStatus = "1";
		} else if (fileName.toLowerCase().contains("ext_del.xls")) {
			extStatus = "3";
		}

		try {

			FileInputStream file = new FileInputStream(new File(fileName));

			// Get the workbook instance for XLS file
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 1;
			while (rowIterator.hasNext()) {
				// For each row, iterate through each columns
				ExtExcel extExcel = getExtExcelByIteratorCell(rowIterator
						.next().cellIterator());
				extExcel.setExtStatus(extStatus);
				ExtExcelDao.addExt(i, extExcel);
				i++;

			}
			file.close();

		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * Lay thong tin may le
	 * 
	 * @param cellIterator
	 *            danh sach cot trong 1 dong excel
	 * @return ExtExcel thoong tin may le
	 */
	private static ExtExcel getExtExcelByIteratorCell(
			Iterator<Cell> cellIterator) {
		ExtExcel extExcel = new ExtExcel();
		String hotline = getCellValueString(
				cellIterator.hasNext() ? cellIterator.next() : null).replace(
				"E10", "").replace(".", "");
		extExcel.setHotline("0" + hotline.substring(2, hotline.length()));
		extExcel.setExtNo(getCellValueString(
				cellIterator.hasNext() ? cellIterator.next() : null).replace(
				".0", ""));
		extExcel.setPhone(getCellValueString(
				cellIterator.hasNext() ? cellIterator.next() : null).replace(
				"E8", "").replace(".", ""));
		extExcel.setName(getCellValueString(cellIterator.hasNext() ? cellIterator
				.next() : null));
		extExcel.setDepart(getCellValueString(cellIterator.hasNext() ? cellIterator
				.next() : null));
		extExcel.setLevel(getCellValueString(
				cellIterator.hasNext() ? cellIterator.next() : null).replace(
				".0", ""));
		return extExcel;
	}

	/**
	 * Lay gia tri
	 * 
	 * @param cell
	 *            ten cot
	 * @return gia tri cot
	 */
	private static String getCellValueString(Cell cell) {
		String value = null;

		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_BOOLEAN:
				value = String.valueOf(cell.getBooleanCellValue()).trim();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				value = String.valueOf(cell.getNumericCellValue()).trim();
				break;
			case Cell.CELL_TYPE_STRING:
				value = String.valueOf(cell.getStringCellValue()).trim();
				break;
			case Cell.CELL_TYPE_BLANK:
				value = "";
				break;
			}
		} else {
			logger.error("Cell khong co gia tri");
			;
		}
		return value;
	}
}
