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
 * 
 * @author HoanPV
 * @version Jun 18, 2015
 *
 */
public class DBUtil {

	private static String DB_JDBC_URL = "jdbc:oracle:thin:@192.168.254.41:1521:ora11g";
	private static String DB_USER = "vasoa";
	private static String DB_PASSWORD = "vasoa";
	private static String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static File file = new File("D:\\CCBS\\config.properties");
	public static Connection connection = null;
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(DBUtil.class);

	static {
		FileInputStream fis = null;
		file = new File(ConstantFile.getCONFIGURATION_FILE_DATABASE());
		try {
			fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(isr);
			DB_JDBC_URL = reader.readLine().split("=")[1].trim();
			DB_USER = reader.readLine().split("=")[1].trim();
			DB_PASSWORD = reader.readLine().split("=")[1].trim();
			DB_DRIVER = reader.readLine().split("=")[1].trim();
			connection = getConnection();
		} catch (FileNotFoundException e) {
			logger.error("Khong tim thay file "
					+ ConstantFile.getCONFIGURATION_FILE_DATABASE());
		} catch (IOException e) {
			logger.error("Loi file cau hinh "
					+ ConstantFile.getCONFIGURATION_FILE_DATABASE());
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				logger.error("Loi dong file  "
						+ ConstantFile.getCONFIGURATION_FILE_DATABASE());
			}

		}
	}

	/**
	 * Get Connnection
	 * 
	 * @return Connection : Ket noi toi Database
	 */
	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName(DB_DRIVER);
				connection = DriverManager.getConnection(DB_JDBC_URL, DB_USER,
						DB_PASSWORD);
			} catch (ClassNotFoundException e) {
				logger.error("Loi " + DB_DRIVER);
			} catch (SQLException e) {
				logger.error("Khong ket noi duoc co so du lieu !");
			}
		}
		return connection;

	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			logger.error("Khong dong duoc connection");
		}
	}

	public static void closeConnection(Connection conn, PreparedStatement prep,
			ResultSet rs) {
		closeConnection(conn);
		closePreparedStatement(prep);
		closeResultSet(rs);
	}

	public static void closeConnection(Connection conn, Statement stm,
			ResultSet rs) {
		closeConnection(conn);
		closeStatement(stm);
		closeResultSet(rs);
	}

	public static void closeStatement(Statement stm) {
		try {
			if (stm != null && !stm.isClosed()) {
				stm.close();
			}
		} catch (SQLException e) {
			logger.error("Khong dong duoc Statement");
		}
	}

	public static void closePreparedStatement(PreparedStatement prep) {
		try {
			if (prep != null && !prep.isClosed()) {
				prep.close();
			}
		} catch (SQLException e) {
			logger.error("Khong dong duoc Statement");
		}
	}

	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			logger.error("Khong dong duoc Statement");
		}
	}

	public static void main(String[] args) {
		try {
			Print.println(getConnection().isClosed() + "");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Print.println("System closed!");

	}
}
