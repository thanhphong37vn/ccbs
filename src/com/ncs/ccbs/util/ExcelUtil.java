package com.ncs.ccbs.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import com.ncs.ccbs.dao.ExtExcelDao;
import org.apache.log4j.Logger;
import com.ncs.ccbs.model.ExtExcel;
/**
 * Title : Excel Utility<br/>
 * Description : Support working with excel data file<br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 11:25:06 AM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version Jul 14, 2015 11:25:06 AM
 */
public class ExcelUtil {
	public static Logger	logger	=Logger
	                                 .getLogger(ExcelUtil.class);
	/**
	 * Read data from Excel file
	 * 
	 * @param fileName
	 *          : excel file name
	 */
	public static void read(String fileName) {
		// default status of the exention
		String extStatus="1";
		String actionType="6";
		String changeInfo="0";
		String packageType="E1";
		if(fileName.toLowerCase().contains(
		    ConstantFile.Ext_Add.toLowerCase())) {
			// status to add the extension
			extStatus="1";
			actionType="6";
			changeInfo="0";
			packageType="E1";
		} else if(fileName.toLowerCase().contains(
		    ConstantFile.Ext_Change_Mapping.toLowerCase())) {
			// status to change mapping the extension
			extStatus="5";
			actionType="6";
			changeInfo="1";
			packageType="E1";
		} else if(fileName.toLowerCase().contains(
		    ConstantFile.Ext_Drop.toLowerCase())) {
			// status to drop the extension
			extStatus="3";
			actionType="6";
			changeInfo="0";
			packageType="E1";
		} else if(fileName.toLowerCase().contains(
		    ConstantFile.Ext_Edit.toLowerCase())) {
			// status to edit the extension
			extStatus="5";
			actionType="6";
			changeInfo="2";
			packageType="E1";
		} else if(fileName.toLowerCase().contains(
		    ConstantFile.Ext_ReActive.toLowerCase())) {
			// status to reactive the extension
			extStatus="4";
			actionType="6";
			changeInfo="0";
			packageType="E2";
		} else if(fileName.toLowerCase().contains(
		    ConstantFile.Ext_Stop.toLowerCase())) {
			// status to stop the extension
			extStatus="2";
			actionType="6";
			changeInfo="0";
			packageType="E2";
		}
		// update information of the extension
		try {
			FileInputStream file=new FileInputStream(new File(
			    fileName));
			HSSFWorkbook workbook=new HSSFWorkbook(file);
			HSSFSheet sheet=workbook.getSheetAt(0);
			Iterator<Row> rowIterator=sheet.iterator();
			int i=1;
			while(rowIterator.hasNext()) {
				// For each row, iterate through each columns
				ExtExcel extExcel=getExtExcelByIteratorCell(rowIterator
				    .next().cellIterator());
				extExcel.setExtStatus(extStatus);
				extExcel.setActionType(actionType);
				extExcel.setChangeInfo(changeInfo);
				extExcel.setPackageType(packageType);
				Thread.sleep(1000);
				// 1: Add
				if(extStatus.equals("1")) {
					ExtExcelDao.addExt(i,extExcel);
				}
				// 2: Stop
				else if(extStatus.equals("2")) {
					ExtExcelDao.stopExt(i,extExcel);
				}
				// 3: Delete
				else if(extStatus.equals("3")) {
					ExtExcelDao.delExt(i,extExcel);
				}
				// 4: ReActive
				else if(extStatus.equals("4")) {
					ExtExcelDao.reActiveExt(i,extExcel);
				}
				// 5: Update
				else if(extStatus.equals("5")) {
					// Change mapping
					if(changeInfo.equals("1"))
					  ExtExcelDao.changeExt(i,extExcel);
					// Edit
					if(changeInfo.equals("2"))
					  ExtExcelDao.editExt(i,extExcel);
				}
				i++;
			}
			file.close();
		} catch(FileNotFoundException e) {
			logger.error(ErrorUtil.stackTrace2String(e));
		} catch(IOException e) {
			logger.error(ErrorUtil.stackTrace2String(e));
		} catch(Exception e) {
			logger.error(ErrorUtil.stackTrace2String(e));
		}
	}
	/**
	 * Get {@link ExtExcel} object by iterator cell
	 * 
	 * @param cellIterator
	 *          danh sach cot trong 1 dong excel
	 * @return {@link ExtExcel} object
	 */
	private static ExtExcel getExtExcelByIteratorCell(
	    Iterator<Cell> cellIterator) {
		ExtExcel extExcel=new ExtExcel();
		String hotline=getCellValueString(
		    cellIterator.hasNext()?cellIterator.next():null)
		    .replace("E10","").replace(".","");
		extExcel.setHotline("0"
		    +hotline.substring(2,hotline.length()));
		extExcel.setExtNo(getCellValueString(
		    cellIterator.hasNext()?cellIterator.next():null)
		    .replace(".0",""));
		extExcel.setPhone(getCellValueString(
		    cellIterator.hasNext()?cellIterator.next():null)
		    .replace(".",""));
		// .replace("E8","").replace(".",""));
		extExcel.setName(getCellValueString(cellIterator
		    .hasNext()?cellIterator.next():null));
		extExcel.setDepart(getCellValueString(cellIterator
		    .hasNext()?cellIterator.next():null));
		extExcel.setLevel(getCellValueString(
		    cellIterator.hasNext()?cellIterator.next():null)
		    .replace(".0",""));
		return extExcel;
	}
	/**
	 * Get string value of {@link Cell} object
	 * 
	 * @param cell
	 *          {@link Cell} object
	 * @return String value of {@link Cell} object
	 */
	private static String getCellValueString(Cell cell) {
		String value=null;
		if(cell!=null) {
			switch(cell.getCellType()){
				case Cell.CELL_TYPE_BOOLEAN:
					value=String.valueOf(cell.getBooleanCellValue())
					    .trim();
					break;
				case Cell.CELL_TYPE_NUMERIC:
					value=BigDecimal.valueOf(
					    cell.getNumericCellValue()).toPlainString();
					// value=String.valueOf(cell.getNumericCellValue())
					// .trim();
					break;
				case Cell.CELL_TYPE_STRING:
					value=String.valueOf(cell.getStringCellValue())
					    .trim();
					break;
				case Cell.CELL_TYPE_BLANK:
					value="";
					break;
			}
		} else {
			logger.error("Cell khong co gia tri");;
		}
		return value;
	}
}
