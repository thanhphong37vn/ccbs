package com.ncs.ccbs.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;
import com.ncs.ccbs.util.DBUtil;
import com.ncs.ccbs.util.ErrorUtil;
/**
 * Title : <br/>
 * Description : <br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 3:00:18 PM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
public class BaseDao {
	private static Logger	logger	=Logger
	                                 .getLogger(BaseDao.class);
	/**
	 * Get EC_COMPANY_CODE value from USERS table in database similar <br/>
	 * by MEG main
	 * 
	 * @param hotline
	 *          MEG main number
	 * @return EC_COMPANY_CODE value by MEG main
	 */
	public static String string(String hotline) {
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
}
