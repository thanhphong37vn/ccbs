package com.ncs.ccbs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
