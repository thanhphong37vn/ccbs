package com.ncs.ccbs.util;
import java.io.*;
import org.apache.log4j.Logger;
import java.sql.*;
/**
 * Title : File Utility<br/>
 * Description : Support working with files <br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 11:45:35 AM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
public class FileUtil {
	/** file contain configuration information web services */
	private static File	     file	       =new File(
	                                         "D:\\CCBS\\config\\config.properties");
	/** connection object */
	public static Connection	connection	=null;
	private static Logger	   logger	     =Logger
	                                         .getLogger(FileUtil.class);
	/**
	 * this to test file utility
	 * 
	 * @param args
	 *          not used
	 */
	public static void main(String[] args) {
		PrintUtil.println(new FileUtil().readFile(FileUtil.file
		    .getPath()));
	}
	/**
	 * Return contents in file name
	 * 
	 * @param fileName
	 *          path file to read
	 * @return {@link String} content in file name
	 */
	public String readFile(String fileName) {
		BufferedReader reader;
		FileInputStream fis=null;
		file=new File(fileName);
		StringBuilder builder=null;
		if(file.exists()&&!file.isDirectory()) {
			try {
				fis=new FileInputStream(file);
				InputStreamReader isr=new InputStreamReader(fis);
				reader=new BufferedReader(isr);
				builder=new StringBuilder();
				String strLine;
				while((strLine=reader.readLine())!=null) {
					builder.append(strLine.trim()+"\n");
				}
			} catch(FileNotFoundException e) {
				logger.error("Khong tim thay file "+fileName);
			} catch(IOException e) {
				logger.error("Loi file cau hinh "+fileName);
			} finally {
				try {
					if(fis!=null) {
						fis.close();
					}
				} catch(IOException e) {
					logger.error("Loi dong file  "+fileName);
				}
			}
		} else {
			logger.error("File khong ton tai :   "+fileName);
		}
		return builder.toString();
	}
}
