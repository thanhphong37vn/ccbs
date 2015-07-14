package com.ncs.ccbs.run;
import com.ncs.ccbs.util.ConfigUtil;
import com.ncs.ccbs.util.ConstantFile;
import com.ncs.ccbs.util.DBUtil;
import com.ncs.ccbs.util.ExcelUtil;
import com.ncs.ccbs.util.InputUtil;
import com.ncs.ccbs.util.PrintUtil;
/**
 * Title : System Meg Register Extention Managerment<br/>
 * Description : Phan mem quan ly may le he thong MEG thuc hien cac chuc nang<br/>
 * ==========Menu==============<br/>
 * -------<br/>
 * 11.Customer Account Change<br/>
 * 12.Customer Account Open<br/>
 * -------<br/>
 * 21.Ext Add<br/>
 * 22.Ext Change Mapping<br/>
 * 23.Ext Drop<br/>
 * 24.Ext Edit<br/>
 * 25.Ext ReActive<br/>
 * 26.Ext Stop<br/>
 * -------<br/>
 * 31.Main MEG Drop<br/>
 * 32.Main MEG ReActive<br/>
 * 33.Main MEG Stop<br/>
 * -------<br/>
 * 0. Exit<br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 10:28:38 AM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
public class Main {
	private static org.apache.log4j.Logger	logger	=org.apache.log4j.Logger
	                                                   .getLogger(Main.class);
	/**
	 * Display menu list and return your choose
	 * 
	 * @return int : chose of user from screen
	 */
	public static int doMenu() {
		/** Print menu on standard output */
		PrintUtil.println("==========Menu==============");
		PrintUtil.println("-------");
		PrintUtil.println("11.Customer Account Change");
		PrintUtil.println("12.Customer Account Open");
		PrintUtil.println("-------");
		PrintUtil.println("21.Ext Add");
		PrintUtil.println("22.Ext Change Mapping");
		PrintUtil.println("23.Ext Drop");
		PrintUtil.println("24.Ext Edit");
		PrintUtil.println("25.Ext ReActive");
		PrintUtil.println("26.Ext Stop");
		PrintUtil.println("-------");
		PrintUtil.println("31.Main MEG Drop");
		PrintUtil.println("32.Main MEG ReActive");
		PrintUtil.println("33.Main MEG Stop");
		PrintUtil.println("-------");
		PrintUtil.println("0.	Exit");
		// get chose from console
		return InputUtil.getNumberInput();
	}
	/**
	 * This is method main which makes use of Main.
	 * 
	 * @return nothing
	 * @param args
	 *          Unused
	 */
	public static void main(String[] args)
	    throws InterruptedException {
		logger.info("Configuring ...");
		if(ConfigUtil.isReady()) {
			int chose=0;
			do {
				chose=doMenu();
				switch(chose){
					case 11:
						logger.info("11.Customer Account Change");
						break;
					case 12:
						logger.info("12.Customer Account Open");
						break;
					case 21:
						logger.info("21	Add Excel");
						logger.info(ConstantFile.getExt_Add());
						ExcelUtil.readExtFromExcel(ConstantFile
						    .getExt_Add());
						break;
					case 22:
						logger.info("22.Ext Change Mapping");
						logger.info(ConstantFile
						    .getExt_Change_Mapping());
						ExcelUtil.readExtFromExcel(ConstantFile
						    .getExt_Change_Mapping());
						break;
					case 23:
						logger.info("23.Ext Drop");
						logger.info(ConstantFile.getExt_Drop());
						ExcelUtil.readExtFromExcel(ConstantFile
						    .getExt_Drop());
						break;
					case 24:
						logger.info("24.Ext Edit");
						logger.info(ConstantFile.getExt_Edit());
						ExcelUtil.readExtFromExcel(ConstantFile
						    .getExt_Edit());
						break;
					case 25:
						logger.info("25.Ext ReActive");
						logger.info(ConstantFile.getExt_ReActive());
						ExcelUtil.readExtFromExcel(ConstantFile
						    .getExt_ReActive());
						break;
					case 26:
						logger.info("26.Ext Stop");
						logger.info(ConstantFile.getExt_Stop());
						ExcelUtil.readExtFromExcel(ConstantFile
						    .getExt_Stop());
						break;
					case 31:
						logger.info("31.Main MEG Drop");
						logger.info(ConstantFile.getMain_MEG_Drop());
						ExcelUtil.readComFromExcel(ConstantFile
						    .getMain_MEG_Drop());
						break;
					case 32:
						logger.info("32.Main MEG ReActive");
						logger
						    .info(ConstantFile.getMain_MEG_ReActive());
						ExcelUtil.readComFromExcel(ConstantFile
						    .getMain_MEG_ReActive());
						break;
					case 33:
						logger.info("33.Main MEG Stop");
						logger.info(ConstantFile.getMain_MEG_Stop());
						ExcelUtil.readComFromExcel(ConstantFile
						    .getMain_MEG_Stop());
						break;
					case 0:
						logger.info("System exited");
						System.exit(0);
						break;
					default:
						chose=doMenu();
						break;
				}
			} while(chose>0||chose<12);
		}
		DBUtil.closeConnection(DBUtil.connection);
		logger.info("System exiting ...");
		Thread.sleep(5000);
		logger.info("System exited");
		System.exit(0);
	}
}
