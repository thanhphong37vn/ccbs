package com.ncs.ccbs.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vn.meg.bossservice.vnp.CallWebService;
import com.ncs.ccbs.model.ExtExcel;
import com.ncs.ccbs.util.DBUtil;
import com.ncs.ccbs.util.ErrorUtil;
import org.apache.log4j.Logger;
/**
 * Title : DAO layer : ExtExcel DAO<br/>
 * Description : Support Business layer working with database<br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 12:03:23 PM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version Jul 14, 2015 12:03:23 PM
 */
public class ExtExcelDao {
	private static Logger	logger	=Logger
	                                 .getLogger(ExtExcelDao.class);
	/**
	 * Get EC_COMPANY_CODE value from USERS table in database similar <br/>
	 * by MEG main
	 * 
	 * @param hotline
	 *          MEG main number
	 * @return EC_COMPANY_CODE value by MEG main
	 */
	public static String getECCompanyCode(String hotline) {
		String ecCompanyCode="";
		ResultSet rs=null;
		PreparedStatement stmt=null;
		String query="select EC_COMPANY_CODE from USERS  where USERNAME =  ? and STATUS<>3  ORDER BY CREATETIME DESC";
		try {
			stmt=DBUtil.getConnection().prepareStatement(query);
			stmt.setString(1,hotline);
			rs=stmt.executeQuery();
			if(rs.next())
			  ecCompanyCode=rs.getString("EC_COMPANY_CODE");
		} catch(Exception e) {
			logger.info("khong lay duoc EC_COMPANY_CODE  : "
			    +hotline);
			logger.error(ErrorUtil.stackTrace2String(e));
		} finally {
			DBUtil.closeStatement(stmt);
		}
		return ecCompanyCode;
	}
	/**
	 * Add new extension
	 * 
	 * @param i
	 *          index
	 * @param extExcel
	 *          {@link ExtExcel} object
	 */
	public static void addExt(int i, ExtExcel extExcel) {
		send(i,extExcel);
	}
	/**
	 * Delete extension
	 * 
	 * @param i
	 *          index
	 * @param extExcel
	 *          {@link ExtExcel} object
	 */
	public static void delExt(int i, ExtExcel extExcel) {
		send(i,extExcel);
	}
	/**
	 * Change info extension
	 * 
	 * @param i
	 *          index
	 * @param extExcel
	 *          {@link ExtExcel} object
	 */
	public static void changeExt(int i, ExtExcel extExcel) {
		send(i,extExcel);
	}
	/**
	 * Edit info extension
	 * 
	 * @param i
	 *          index
	 * @param extExcel
	 *          {@link ExtExcel} object
	 */
	public static void editExt(int i, ExtExcel extExcel) {
		send(i,extExcel);
	}
	/**
	 * ReActive extension
	 * 
	 * @param i
	 *          index
	 * @param extExcel
	 *          {@link ExtExcel} object
	 */
	public static void reActiveExt(int i, ExtExcel extExcel) {
		send(i,extExcel);
	}
	/**
	 * Stop extension
	 * 
	 * @param i
	 *          index
	 * @param extExcel
	 *          {@link ExtExcel} object
	 */
	public static void stopExt(int i, ExtExcel extExcel) {
		send(i,extExcel);
	}
	/**
	 * Send message to server
	 * 
	 * @param i
	 *          index
	 * @param extExcel
	 *          {@link ExtExcel} object
	 * @see {@link CallWebService} : class support send request to server
	 */
	private static void send(int i, ExtExcel extExcel) {
		// Request message
		String req=extExcel.toStringXML();
		logger.info("Request : "+(i)+"\n");
		// Response message
		CallWebService.send(req);
	}
}
