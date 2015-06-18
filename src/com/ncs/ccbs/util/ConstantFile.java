package com.ncs.ccbs.util;

import java.io.File;

/**
 * 
 * @author HoanPV
 * @version Jun 18, 2015
 *
 */
public class ConstantFile {
	private static String CUSTOMER_ACCOUNT_CHANGE = "Customer_Account_Change.txt";
	private static String CUSTOMER_ACCOUNT_OPEN = "Customer_Account_Open.txt";
	private static String DROP_MAIN_MEG = "DROP_Main_MEG.txt";
	private static String EXT_ADD = "Ext_Add.txt";
	private static String EXT_CHANGE_MAPPING = "Ext_Change_Mapping.txt";
	private static String EXT_DROP = "Ext_Drop.txt";
	private static String EXT_EDIT = "Ext_Edit.txt";
	private static String EXT_REACTIVE = "Ext_ReActive.txt";
	private static String EXT_STOP = "Ext_Stop.txt";
	private static String REACTIVE_MAIN_MEG = "ReActive_Main_MEG.txt";
	private static String STOP_MAIN_MEG = "Stop_Main_MEG.txt";
	private static String ADD_EXCEL = "Upload.xls";
	private static String CONFIGURATION_FILE_DATABASE = "config.properties";
	private static String SERVICES_PROPERTIES = "services.properties";

	public static String getCONFIGURATION_FILE_DATABASE() {
		return currentRootDirectoryPath() + CONFIGURATION_FILE_DATABASE;
	}

	public static String currentRootDirectoryPath() {
		File currentJavaJarFile = new File(ConstantFile.class
				.getProtectionDomain().getCodeSource().getLocation().getPath());
		String currentJavaJarFilePath = currentJavaJarFile.getAbsolutePath();
		String currentRootDirectoryPath = currentJavaJarFilePath.replace(
				currentJavaJarFile.getName(), "");
		return currentRootDirectoryPath;
	}

	public static String getCUSTOMER_ACCOUNT_CHANGE() {
		return currentRootDirectoryPath() + CUSTOMER_ACCOUNT_CHANGE;
	}

	public static String getCUSTOMER_ACCOUNT_OPEN() {
		return currentRootDirectoryPath() + CUSTOMER_ACCOUNT_OPEN;
	}

	public static String getDROP_MAIN_MEG() {
		return currentRootDirectoryPath() + DROP_MAIN_MEG;
	}

	public static String getEXT_ADD() {
		return currentRootDirectoryPath() + EXT_ADD;
	}

	public static String getEXT_CHANGE_MAPPING() {
		return currentRootDirectoryPath() + EXT_CHANGE_MAPPING;
	}

	public static String getEXT_DROP() {
		return currentRootDirectoryPath() + EXT_DROP;
	}

	public static String getEXT_EDIT() {
		return currentRootDirectoryPath() + EXT_EDIT;
	}

	public static String getEXT_REACTIVE() {
		return currentRootDirectoryPath() + EXT_REACTIVE;
	}

	public static String getEXT_STOP() {
		return currentRootDirectoryPath() + EXT_STOP;
	}

	public static String getREACTIVE_MAIN_MEG() {
		return currentRootDirectoryPath() + REACTIVE_MAIN_MEG;
	}

	public static String getSTOP_MAIN_MEG() {
		return currentRootDirectoryPath() + STOP_MAIN_MEG;
	}

	public static String getADD_EXCEL() {
		return currentRootDirectoryPath() + ADD_EXCEL;
	}

	public static String getSERVICES_PROPERTIES() {
		return currentRootDirectoryPath() + SERVICES_PROPERTIES;
	}

}
