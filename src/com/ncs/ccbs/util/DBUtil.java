package com.ncs.ccbs.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Title : Database Utility <br/>
 * Description : Support working with database<br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 11:03:51 AM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
public class DBUtil {
	/** Database URL connect to the database */
	private static String	                 DB_JDBC_URL	="jdbc:oracle:thin:@192.168.254.41:1521:ora11g";
	/** Database user name */
	private static String	                 DB_USER	   ="vasoa";
	/** Database password */
	private static String	                 DB_PASSWORD	="vasoa";
	/** Driver class name */
	private static String	                 DB_DRIVER	 ="oracle.jdbc.driver.OracleDriver";
	/** configuration file to the database */
	private static File	                   file	       =new File(
	                                                       "D:\\CCBS\\config.properties");
	/** connection objects */
	public static Connection	             connection	 =null;
	private static org.apache.log4j.Logger	logger	   =org.apache.log4j.Logger
	                                                       .getLogger(DBUtil.class);
	static {
		FileInputStream fis=null;
		file=new File(
		    ConstantFile.getCONFIGURATION_FILE_DATABASE());
		if(file.exists()&&!file.isDirectory()) {
			try {
				logger.info("File cau hinh Database :   "
				    +ConstantFile.getCONFIGURATION_FILE_DATABASE());
				fis=new FileInputStream(file);
				InputStreamReader isr=new InputStreamReader(fis);
				@SuppressWarnings("resource")
				BufferedReader reader=new BufferedReader(isr);
				DB_JDBC_URL=reader.readLine().split("=")[1].trim();
				DB_USER=reader.readLine().split("=")[1].trim();
				DB_PASSWORD=reader.readLine().split("=")[1].trim();
				DB_DRIVER=reader.readLine().split("=")[1].trim();
				logger.info("Thong tin cau hinh database  :   ");
				logger.info("Driver :   "+DB_DRIVER);
				logger.info("Url :   "+DB_JDBC_URL);
				logger.info("User :   "+DB_USER);
				logger.info("Pass :   "+DB_PASSWORD);
				connection=getConnection();
				logger.info("Da dong connection chua ?  :   "
				    +connection.isClosed());
			} catch(FileNotFoundException e) {
				logger.error("Khong tim thay file "
				    +ConstantFile.getCONFIGURATION_FILE_DATABASE());
			} catch(IOException e) {
				logger.error("Loi file cau hinh "
				    +ConstantFile.getCONFIGURATION_FILE_DATABASE());
			} catch(SQLException e) {
				logger.error("Loi tao ket noi "
				    +ConstantFile.getCONFIGURATION_FILE_DATABASE());
			} catch(Exception e) {
				logger.info(ErrorUtil.stackTrace2String(e));
			} finally {
				try {
					if(fis!=null) {
						fis.close();
					}
				} catch(IOException e) {
					logger.error("Loi dong file  "
					    +ConstantFile
					        .getCONFIGURATION_FILE_DATABASE());
				}
			}
		} else {
			logger.error("File khong ton tai :   "
			    +ConstantFile.getCONFIGURATION_FILE_DATABASE());
		}
	}
	/**
	 * This method to create a {@link Connection} object
	 * 
	 * @return {@link Connection} object
	 */
	public static synchronized Connection getConnection() {
		if(connection==null) {
			try {
				Class.forName(DB_DRIVER);
				connection=DriverManager.getConnection(DB_JDBC_URL,
				    DB_USER,DB_PASSWORD);
			} catch(ClassNotFoundException e) {
				logger.error("Loi thong tin ket noi : "+DB_DRIVER);
			} catch(SQLException e) {
				logger.error("Khong ket noi duoc co so du lieu !");
			}
		}
		return connection;
	}
	/**
	 * Close the {@link Connection} object
	 * 
	 * @param conn
	 *          {@link Connection} object
	 */
	public static void closeConnection(Connection conn) {
		try {
			if(conn!=null&&!conn.isClosed()) {
				conn.close();
			}
		} catch(SQLException e) {
			logger.error(ErrorUtil.stackTrace2String(e));
		}
	}
	/**
	 * @param conn
	 *          {@link Connection} object
	 * @param prep
	 *          {@link PreparedStatement} object
	 * @param rs
	 *          {@link ResultSet} object
	 */
	public static void closeConnection(Connection conn,
	    PreparedStatement prep, ResultSet rs) {
		closeConnection(conn);
		closePreparedStatement(prep);
		closeResultSet(rs);
	}
	/**
	 * to close {@link Connection} object and more..
	 * 
	 * @param conn
	 *          {@link Connection} object
	 * @param stm
	 *          {@link Statement} object
	 * @param rs
	 *          {@link ResultSet} object
	 */
	public static void closeConnection(Connection conn,
	    Statement stm, ResultSet rs) {
		closeConnection(conn);
		closeStatement(stm);
		closeResultSet(rs);
	}
	/**
	 * to close {@link Statement} object
	 * 
	 * @param {@link Statement} object
	 */
	public static void closeStatement(Statement stm) {
		try {
			if(stm!=null&&!stm.isClosed()) stm.close();
		} catch(SQLException e) {
			logger.error(ErrorUtil.stackTrace2String(e));
		}
	}
	/**
	 * to close {@link PreparedStatement} object
	 * 
	 * @param {@link PreparedStatement} object
	 */
	public static void closePreparedStatement(
	    PreparedStatement prep) {
		try {
			if(prep!=null&&!prep.isClosed()) prep.close();
		} catch(SQLException e) {
			logger.error(ErrorUtil.stackTrace2String(e));
		}
	}
	/**
	 * This method to create a {@link ResultSet} object
	 * 
	 * @param rs
	 *          {@link ResultSet} object
	 */
	public static void closeResultSet(ResultSet rs) {
		try {
			if(rs!=null&&!rs.isClosed()) rs.close();
		} catch(SQLException e) {
			logger.error(ErrorUtil.stackTrace2String(e));
		}
	}
}
