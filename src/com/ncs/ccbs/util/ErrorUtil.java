package com.ncs.ccbs.util;
import java.io.PrintWriter;
import java.io.StringWriter;
/**
 * Title : Error Utility <br/>
 * Description : Support working with {@link Exception} object<br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 11:19:39 AM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
public class ErrorUtil {
	private static final StringWriter	errors	=new StringWriter();
	/**
	 * This method to get string values of exception stack trace
	 * 
	 * @param e
	 *          {@link Exception} object
	 * @return {@link String} values of exception
	 */
	public static String stackTrace2String(Exception e) {
		e.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}
}
