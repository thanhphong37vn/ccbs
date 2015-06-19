package com.ncs.ccbs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vn.meg.bossservice.vnp.CallWebService;

import com.ncs.ccbs.model.ExtExcel;
import com.ncs.ccbs.util.DBUtil;
import com.ncs.ccbs.util.Print;

/**
 * 
 * @author HoanPV
 * @version Jun 18, 2015
 *
 */
public class ExtExcelDao {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(ExtExcelDao.class);

	/**
	 * Ham nay tim kiem EC_COMPANY_CODE
	 * 
	 * @param hotline
	 *            Hotline cong ty
	 * @return tra va ma EC_COMPANY_CODE
	 */
	public static String getECCompanyCode(String hotline) {
		String ecCompanyCode = "";
		ResultSet rs = null;
		PreparedStatement stmt = null;
		String query = "select EC_COMPANY_CODE from USERS  where USERNAME =  ? and STATUS<>3  ORDER BY CREATETIME DESC";
		try {
			stmt = DBUtil.getConnection().prepareStatement(query);
			stmt.setString(1, hotline);
			rs = stmt.executeQuery();
			if (rs.next())
				ecCompanyCode = rs.getString("EC_COMPANY_CODE");

		} catch (Exception e) {
			logger.info("Khong lay duoc EC_COMPANY_CODE  : " + hotline);
			e.printStackTrace();

		} finally {
			DBUtil.closeStatement(stmt);
		}
		return ecCompanyCode;
	}

	/**
	 * Them may le
	 * 
	 * @param i
	 *            thu tu ban ghi can gui len server
	 * @param extExcel
	 *            : thong tin may le
	 */
	public static void addExt(int i, ExtExcel extExcel) {
		extExcel.setExtStatus("1");
		send(i, extExcel);
	}

	/**
	 * Xoa may le
	 * 
	 * @param i
	 *            thu tu ban ghi can gui len server
	 * @param extExcel
	 *            : thong tin may le
	 */
	public static void delExt(int i, ExtExcel extExcel) {
		extExcel.setExtStatus("3");
		send(i, extExcel);
	}

	/**
	 * Gui thong ban tin tin len server
	 * 
	 * @param i
	 *            thu tu ban ghi can gui len server
	 * @param extExcel
	 *            : thong tin may le
	 */
	private static void send(int i, ExtExcel extExcel) {
		// Request message
		String req = extExcel.toStringXML();
		logger.info("Request : " + (i) + "\n" + req + "\n");
		// Respone message
		String res = CallWebService.send(req);
		logger.info("Response : " + (i) + "\n" + res + "\n\n");
		logger.info("------------------------------------------------------");
	}

	public static void main(String[] args) {
		Print.println("getECCompanyCode " + getECCompanyCode("0912400604"));
		Print.println("Closed ..!");

		if (DBUtil.connection != null) {
			try {
				DBUtil.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
