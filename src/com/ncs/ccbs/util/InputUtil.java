package com.ncs.ccbs.util;
import java.util.Scanner;
/**
 * Title : Input Utility <br/>
 * Description : Support input from console<br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 11:48:15 AM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version Jul 14, 2015 11:48:15 AM
 */
public class InputUtil {
	private static final Scanner	scanner	=new Scanner(
	                                          System.in);
	/**
	 * This method use to get number value input from console
	 * 
	 * @return number input
	 */
	public static int getNumberInput() {
		while(!scanner.hasNextInt())
			scanner.next();
		return scanner.nextInt();
	}
	/**
	 * This method use to get string value input from console
	 * 
	 * @return string value
	 */
	public static String getStringInput() {
		return scanner.nextLine();
	}
}
