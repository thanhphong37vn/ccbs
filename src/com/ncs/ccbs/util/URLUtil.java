package com.ncs.ccbs.util;
import java.io.IOException;
import org.apache.log4j.Logger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * Title : URL Utility <br/>
 * Description : Support work with URL<br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 11:53:17 AM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
public class URLUtil {
	private static Logger	logger	=Logger
	                                 .getLogger(URLUtil.class);
	/**
	 * check URL is validated?<br/>
	 * < 100 is undetermined. <br/>
	 * 1nn is informal (shouldn't happen on a GET/HEAD) <br/>
	 * 2nn is success <br/>
	 * 3nn is redirect <br/>
	 * 4nn is client error <br/>
	 * 5nn is server error
	 * 
	 * @param url
	 *          String value of URL
	 */
	public static boolean isURLValidate(String url) {
		// url = "http://192.168.254.30:10000/services/AppAcceptService?wsdl";
		HttpURLConnection connection;
		boolean flag=false;
		try {
			connection=(HttpURLConnection) new URL(url)
			    .openConnection();
			connection.setRequestMethod("HEAD");
			int responseCode=connection.getResponseCode();
			System.out.println(responseCode);
			if(responseCode<100) {
				flag=false;
				logger.info(url+" URL khong xac dinh!");
			} else if(responseCode>=100&&responseCode<=199) {
				flag=false;
				logger
				    .info(url
				        +" URL is informal (shouldn't happen on a GET/HEAD)!");
			} else if(responseCode>=200&&responseCode<=299) {
				flag=true;
				logger.info(url+" : URL hop le!");
			} else if(responseCode>=300&&responseCode<=399) {
				flag=false;
				logger.info(url+" URL is redirect");
			} else if(responseCode>=400&&responseCode<=499) {
				flag=false;
				logger.info(url+" Client error");
			} else if(responseCode>=500&&responseCode<=999) {
				flag=false;
				logger.info(url+" server error");
			}
		} catch(MalformedURLException e) {
			logger.info(ErrorUtil.stackTrace2String(e));
		} catch(IOException e) {
			logger.info(ErrorUtil.stackTrace2String(e));
		}
		return flag;
	}
}
