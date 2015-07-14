package com.ncs.ccbs.util;
import java.io.File;
/**
 * Title : Constant files <br/>
 * Description : constant files to send message retrieve to server<br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 10:34:10 AM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version Jul 14, 2015 10:34:10 AM
 */
public class ConstantFile {
	/** file name use to change customer account */
	public static String	Customer_Account_Change	    ="Customer_Account_Change.xls";
	/** file name use to open customer account */
	public static String	Customer_Account_Open	      ="Customer_Account_Open.xls";
	/** file name use to add new extension */
	public static String	Ext_Add	                    ="Ext_Add.xls";
	/** file name use to change new extension */
	public static String	Ext_Change_Mapping	        ="Ext_Change_Mapping.xls";
	/** file name use to drop new extension */
	public static String	Ext_Drop	                  ="Ext_Drop.xls";
	/** file name use to edit extension */
	public static String	Ext_Edit	                  ="Ext_Edit.xls";
	/** file name use to reactive extension */
	public static String	Ext_ReActive	              ="Ext_ReActive.xls";
	/** file name use to stop extension */
	public static String	Ext_Stop	                  ="Ext_Stop.xls";
	/** file name use to drop MEG main */
	public static String	Main_MEG_Drop	              ="Main_MEG_Drop.xls";
	/** file name use to reactive MEG main */
	public static String	Main_MEG_ReActive	          ="Main_MEG_ReActive.xls";
	/** file name use to stop MEG main */
	public static String	Main_MEG_Stop	              ="Main_MEG_Stop";
	/** file configuration the information connect to the database */
	public static String	CONFIGURATION_FILE_DATABASE	="config.properties";
	/**
	 * file configuration the information link web services which support to send<br/>
	 * message script retrieve extension number and MEG main number
	 */
	public static String	SERVICES_PROPERTIES	        ="services.properties";
	/**
	 * Get current path file
	 * 
	 * @return current direction Path content Jar file run
	 */
	public static String currentRootDirectoryPath() {
		File currentJavaJarFile=new File(ConstantFile.class
		    .getProtectionDomain().getCodeSource()
		    .getLocation().getPath());
		String currentJavaJarFilePath=currentJavaJarFile
		    .getAbsolutePath();
		String currentRootDirectoryPath=currentJavaJarFilePath
		    .replace(currentJavaJarFile.getName(),"");
		return currentRootDirectoryPath;
	}
	/**
	 * get path file customer account change
	 * 
	 * @return get path file customer account change
	 */
	public static String getCustomer_Account_Change() {
		return currentRootDirectoryPath()
		    +Customer_Account_Change;
	}
	/**
	 * get path file customer account open
	 * 
	 * @return get path file customer account open
	 */
	public static String getCustomer_Account_Open() {
		return currentRootDirectoryPath()+Customer_Account_Open;
	}
	/**
	 * get path file using to add new extension
	 * 
	 * @return get path file using to add new extension
	 */
	public static String getExt_Add() {
		return currentRootDirectoryPath()+Ext_Add;
	}
	/**
	 * get path file using to change information extension
	 * 
	 * @return get path file using to change information extension
	 */
	public static String getExt_Change_Mapping() {
		return currentRootDirectoryPath()+Ext_Change_Mapping;
	}
	/**
	 * get path file using to drop extension
	 * 
	 * @return get path file using to drop extension
	 */
	public static String getExt_Drop() {
		return currentRootDirectoryPath()+Ext_Drop;
	}
	/**
	 * get path file using to edit information of the extension number
	 * 
	 * @return get path file using to edit information of the extension number
	 */
	public static String getExt_Edit() {
		return currentRootDirectoryPath()+Ext_Edit;
	}
	/**
	 * get path file using to reactive extension
	 * 
	 * @return get path file using to reactive extension
	 */
	public static String getExt_ReActive() {
		return currentRootDirectoryPath()+Ext_ReActive;
	}
	/**
	 * get path file using to stop extension
	 * 
	 * @return get path file using to stop extension
	 */
	public static String getExt_Stop() {
		return currentRootDirectoryPath()+Ext_Stop;
	}
	/**
	 * get path file using to drop MEG main
	 * 
	 * @return get path file using to drop MEG main
	 */
	public static String getMain_MEG_Drop() {
		return currentRootDirectoryPath()+Main_MEG_Drop;
	}
	/**
	 * get path file using to reactive MEG main
	 * 
	 * @return get path file using to reactive MEG main
	 */
	public static String getMain_MEG_ReActive() {
		return currentRootDirectoryPath()+Main_MEG_ReActive;
	}
	/**
	 * get path file using to stop MEG main
	 * 
	 * @return get path file using to stop MEG main
	 */
	public static String getMain_MEG_Stop() {
		return currentRootDirectoryPath()+Main_MEG_Stop;
	}
	/**
	 * get path file using to configuration the database
	 * 
	 * @return get path file using to read configuration to connect to the
	 *         database
	 */
	public static String getCONFIGURATION_FILE_DATABASE() {
		return currentRootDirectoryPath()
		    +CONFIGURATION_FILE_DATABASE;
	}
	/**
	 * get path file using to send message to server
	 * 
	 * @return get path file using to send message to server
	 */
	public static String getSERVICES_PROPERTIES() {
		return currentRootDirectoryPath()+SERVICES_PROPERTIES;
	}
}
