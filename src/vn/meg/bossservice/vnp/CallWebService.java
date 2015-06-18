package vn.meg.bossservice.vnp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.ws.BindingProvider;

import com.ncs.ccbs.util.ConstantFile;
import com.ncs.ccbs.util.ExcelUtil;

public class CallWebService {
	private static File file = new File("D:\\CCBS\\config.properties");
	private static String WSDL_LOCATION = "http://192.168.254.30:10000/services/AppAcceptService?wsdl";
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(CallWebService.class);
	static AppAcceptService_Service service;
	{
		FileInputStream fis = null;
		file = new File(ConstantFile.getSERVICES_PROPERTIES());
		try {
			fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader reader = new BufferedReader(isr);
			WSDL_LOCATION = reader.readLine().split("=")[1].trim();
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
	}

	public static String send(String acceptReq) {
		service = new AppAcceptService_Service();
		AppAcceptService pm = service.getAppAcceptService();
		// WSDL_LOCATION =
		// "http://192.168.254.30:10000/services/AppAcceptService?wsdl";
		((BindingProvider) pm).getRequestContext().put(
				BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WSDL_LOCATION);
		String ref = null;
		ref = pm.accept(acceptReq);
		return ref;
	}
}
