package com.ncs.ccbs.run;

import com.ncs.ccbs.util.ConfigUtil;
import com.ncs.ccbs.util.ConstantFile;
import com.ncs.ccbs.util.DBUtil;
import com.ncs.ccbs.util.ExcelUtil;
import com.ncs.ccbs.util.Input;
import com.ncs.ccbs.util.Print;

/**
 * <h1>System City Management</h1> <br/>
 * <br/>
 * The System City Management program implements an application that<br/>
 * 
 * 1. Input information for n countries of Asia<br/>
 * 2. Display information<br/>
 * 3. Sort descending by area and display result<br/>
 * 4. Sort ascending by area and display result<br/>
 * 5. Find information by countryName<br/>
 * 6. Exit<br/>
 * 
 * 
 * @author Admin
 * @version v.05.30
 * @since 2015-05-30
 * 
 */
/**
 * 
 * @author HoanPV
 * @version Jun 18, 2015
 *
 */
public class Main {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(Main.class);

	/**
	 * Display menu list and return your choose
	 * 
	 * @return int : chose of user from screen
	 */
	public static int doMenu() {

		/** Print menu on standard output */
		Print.println("==========Menu==============");
		Print.println("1	Customer Account Change");
		Print.println("2	Customer Account Open ");
		Print.println("3	DROP Main MEG ");
		Print.println("4	Ext Add ");
		Print.println("5	Ext Change Mapping ");
		Print.println("6	Ext Drop ");
		Print.println("7	Ext Edit ");
		Print.println("8	Ext ReActive ");
		Print.println("9	Ext Stop ");
		Print.println("10	ReActive Main MEG ");
		Print.println("11	Stop Main MEG ");
		Print.println("12	Add Ext Excel");
		Print.println("13	Del Ext Excel");
		Print.println("-------");
		Print.println("0	Exit");

		// get chose from console
		return Input.getNumberInput();

	}

	/**
	 * This is method main which makes use of Main.
	 * 
	 * @return nothing
	 * 
	 * @param args
	 *            Unused
	 * @throws InterruptedException
	 * @exception No
	 *                Exception
	 * @see Exeption
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		logger.info("Configuring ...");
		if (ConfigUtil.isReady()) {
			int chose = 0;
			do {
				chose = doMenu();
				switch (chose) {
				case 1:
					logger.info("1	Customer Account Change ");
					break;
				case 2:
					logger.info("2	Customer Account Open ");
					break;
				case 3:
					logger.info("3	DROP Main MEG ");
					break;
				case 4:
					logger.info("4	Ext Add ");
					break;
				case 5:
					logger.info("5	Ext Change Mapping ");
					break;
				case 6:
					logger.info("6	Ext Drop ");
					break;
				case 7:
					logger.info("7	Ext Edit ");
					break;
				case 8:
					logger.info("8	Ext ReActive ");
					break;
				case 9:
					logger.info("9	Ext Stop ");
					break;
				case 10:
					logger.info("10	ReActive Main MEG ");
					break;
				case 11:
					logger.info("11	Stop Main MEG ");
					break;
				case 12:
					logger.info("12	Add Excel");
					logger.info("Duong dan add Excel: "
							+ ConstantFile.getEXT_ADD_EXCEL());
					ExcelUtil.read(ConstantFile.getEXT_ADD_EXCEL());
					break;
				case 13:
					logger.info("13	Del Excel");
					logger.info("Duong dan del Excel: "
							+ ConstantFile.getEXT_DEL_EXCEL());
					ExcelUtil.read(ConstantFile.getEXT_DEL_EXCEL());
					break;
				case 0:
					logger.info("System exited");
					System.exit(0);
					break;
				default:
					chose = doMenu();
					break;
				}
			} while (chose > 0 || chose < 12);
		}
		DBUtil.closeConnection(DBUtil.connection);
		logger.info("System exiting ...");
		Thread.sleep(3000);
		logger.info("System exited");
		System.exit(0);
	}

}
