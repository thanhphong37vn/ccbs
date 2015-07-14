package com.ncs.ccbs.util;
import java.sql.SQLException;
import vn.meg.bossservice.vnp.CallWebService;
import org.apache.log4j.Logger;
/**
 * Title : Configuration Utility<br/>
 * Description :using check configuration to the system and web services<br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 10:32:19 AM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
public class ConfigUtil {
	public static Logger	logger	=Logger
	                                 .getLogger(ConfigUtil.class);
	/**
	 * this method using to check configuration
	 * 
	 * @return status of configuration<br/>
	 *         {@link <code>true</code>}: Configuration successful<br/>
	 *         {@link <code>false</code>}:Configuration failed !
	 */
	public static boolean isReady() {
		boolean flag=false;
		try {
			if(!DBUtil.connection.isClosed()
			    &&CallWebService.isReady()) {
				flag=true;
				logger.info("Ket noi co so du lieu thanh cong !");
			} else {
				flag=false;
				logger
				    .info("Ket noi co so du lieu khong thanh cong !");
			}
			if(CallWebService.isReady()) {
				flag=true;
				logger.info("Webservice ket noi thanh cong !");
			} else {
				flag=false;
				logger
				    .info("Webservice ket noi khong thanh cong !");
			}
			if(flag) {
				logger.info("Cau hinh thanh cong !");
			} else {
				logger.info("Cau hinh khong thanh cong !");
			}
		} catch(SQLException e) {
			logger.info("Loi ket noi co so du lieu ");
		}
		return flag;
	}
}
