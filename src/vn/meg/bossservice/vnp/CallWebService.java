package vn.meg.bossservice.vnp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.xml.ws.BindingProvider;
import com.ncs.ccbs.util.ConstantFile;
import com.ncs.ccbs.util.ErrorUtil;
import com.ncs.ccbs.util.URLUtil;
import org.apache.log4j.Logger;
/**
 * Title : Call Web services<br/>
 * Description : Call web services from client to send message<br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 12:17:51 PM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version Jul 14, 2015 12:17:51 PM
 */
public class CallWebService {
	/** file to contain configuration information web services */
	private static File	                    file	        =new File(
	                                                          "D:\\CCBS\\config.properties");
	/** URL information web services */
	private static String	                  WSDL_LOCATION	="http://192.168.254.30:10000/services/AppAcceptService?wsdl";
	private static Logger	                  logger	      =Logger
	                                                          .getLogger(CallWebService.class);
	private static AppAcceptService_Service	service;
	// public static void test() {
	static {
		FileInputStream fis=null;
		file=new File(ConstantFile.getSERVICES_PROPERTIES());
		if(file.exists()&&!file.isDirectory()) {
			BufferedReader reader;
			InputStreamReader isr;
			try {
				fis=new FileInputStream(file);
				isr=new InputStreamReader(fis);
				reader=new BufferedReader(isr);
				WSDL_LOCATION=reader.readLine().split("=")[1]
				    .trim();
				WSDL_LOCATION=URLUtil.isURLValidate(WSDL_LOCATION)?WSDL_LOCATION
				    :null;
			} catch(FileNotFoundException e) {
				logger.error("Khong tim thay file "
				    +ConstantFile.getSERVICES_PROPERTIES());
			} catch(IOException e) {
				logger.error("Loi file websevices "
				    +ConstantFile.getSERVICES_PROPERTIES());
			} finally {
				try {
					if(fis!=null) {
						fis.close();
					}
				} catch(IOException e) {
					logger.error("Loi dong file  "
					    +ConstantFile.getSERVICES_PROPERTIES());
				}
			}
		} else {
			logger.error("File khong ton tai :   "
			    +ConstantFile.getSERVICES_PROPERTIES());
		}
	}
	/**
	 * Send XML data message script to server
	 * 
	 * @param acceptReq
	 *          XML data message
	 * @return XML data message response
	 */
	public static synchronized String send(String acceptReq) {
		String ref=null;
		if(WSDL_LOCATION!=null) {
			service=new AppAcceptService_Service();
			AppAcceptService pm=service.getAppAcceptService();
			((BindingProvider) pm).getRequestContext().put(
			    BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
			    WSDL_LOCATION);
			logger.info("Request :\n"+acceptReq+"\n");
			ref=pm.accept(acceptReq);
			logger.info("Response :\n "+ref+"\n\n");
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {
				logger.error(ErrorUtil.stackTrace2String(e));
			}
		} else {
			logger.error("wsdl : "+WSDL_LOCATION);
		}
		return ref;
	}
	/**
	 * Check status of URL web service
	 * 
	 * @return status of URL web service<br/>
	 *         <code>true</code>: URL is
	 *         validated <br/>
	 *         <code>false</code>: URL is invalid
	 */
	public static boolean isReady() {
		return URLUtil.isURLValidate(WSDL_LOCATION);
	}
}
