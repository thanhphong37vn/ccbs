package vn.meg.bossservice.vnp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.ws.BindingProvider;

import com.ncs.ccbs.util.ConstantFile;
import com.ncs.ccbs.util.URLUtil;

public class CallWebService {
	private static File file = new File("D:\\CCBS\\config.properties");
	private static String WSDL_LOCATION = "http://192.168.254.30:10000/services/AppAcceptService?wsdl";
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(CallWebService.class);
	private static AppAcceptService_Service service;

	static {
		FileInputStream fis = null;
		file = new File(ConstantFile.getSERVICES_PROPERTIES());
		if (file.exists() && !file.isDirectory()) {
			BufferedReader reader;
			InputStreamReader isr;
			try {
				fis = new FileInputStream(file);
				isr = new InputStreamReader(fis);
				reader = new BufferedReader(isr);

				WSDL_LOCATION = reader.readLine().split("=")[1].trim();
				WSDL_LOCATION = URLUtil.isURLValidate(WSDL_LOCATION) ? WSDL_LOCATION
						: null;
				logger.error("wsdl : " + WSDL_LOCATION);
			} catch (FileNotFoundException e) {
				logger.error("Khong tim thay file "
						+ ConstantFile.getSERVICES_PROPERTIES());
			} catch (IOException e) {
				logger.error("Loi file websevices "
						+ ConstantFile.getSERVICES_PROPERTIES());
			} finally {
				try {
					if (fis != null) {
						fis.close();
					}
				} catch (IOException e) {
					logger.error("Loi dong file  "
							+ ConstantFile.getSERVICES_PROPERTIES());
				}
			}
		} else {
			logger.error("File khong ton tai :   "
					+ ConstantFile.getSERVICES_PROPERTIES());
		}
	}

	/**
	 * Gui ban tin len Server
	 * 
	 * @param acceptReq
	 * @return
	 */
	public static String send(String acceptReq) {
		String ref = null;
		if (WSDL_LOCATION != null) {
			service = new AppAcceptService_Service();
			AppAcceptService pm = service.getAppAcceptService();
			// WSDL_LOCATION =
			// "http://192.168.254.30:10000/services/AppAcceptService?wsdl";
			((BindingProvider) pm).getRequestContext().put(
					BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WSDL_LOCATION);
			// Request message
			logger.info("Request :\n" + acceptReq + "\n");
			ref = pm.accept(acceptReq);
			// Respone message
			logger.info("Response :\n " + ref + "\n\n");
			logger.info("------------------------------------------------------");
		} else {
			logger.error("wsdl : " + WSDL_LOCATION);
		}
		return ref;
	}

	/**
	 * Kiem tra trang thai cua Webservice
	 * 
	 * @return true : duong dan service hop le<br/>
	 *         false : duong dan service loi<br/>
	 */
	public static boolean isReady() {
		return URLUtil.isURLValidate(WSDL_LOCATION);
	}
}
