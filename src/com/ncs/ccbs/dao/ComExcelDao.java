package com.ncs.ccbs.dao;
import vn.meg.bossservice.vnp.CallWebService;
import com.ncs.ccbs.model.ComExcel;
import org.apache.log4j.Logger;
/**
 * Title : DAO layer : ComExcel DAO<br/>
 * Description : Support Business layer working with database<br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 12:03:23 PM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
public class ComExcelDao {
	private static Logger	logger	=Logger
	                                 .getLogger(ComExcelDao.class);
	/**
	 * Drop company
	 * 
	 * @param i
	 *          index
	 * @param comExcel
	 *          {@link ComExcel} object
	 */
	public static void dropCom(int i, ComExcel comExcel) {
		send(i,comExcel);
	}
	/**
	 * ReActive company
	 * 
	 * @param i
	 *          index
	 * @param comExcel
	 *          {@link ComExcel} object
	 */
	public static void reActiveCom(int i, ComExcel comExcel) {
		send(i,comExcel);
	}
	/**
	 * Stop company
	 * 
	 * @param i
	 *          index
	 * @param comExcel
	 *          {@link ComExcel} object
	 */
	public static void stopCom(int i, ComExcel comExcel) {
		send(i,comExcel);
	}
	/**
	 * Send message to server
	 * 
	 * @param i
	 *          index
	 * @param comExcel
	 *          {@link ComExcel} object
	 * @see {@link CallWebService} : class support send request to server
	 */
	private static void send(int i, ComExcel comExcel) {
		// Request message
		String req=comExcel.toStringXML();
		logger.info("Request : "+(i)+"\n");
		// Response message
		CallWebService.send(req);
	}
}
