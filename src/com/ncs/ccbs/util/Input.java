package com.ncs.ccbs.util;

import java.util.Scanner;
/**
 * 
 * @author HoanPV
 * @version Jun 18, 2015
 *
 */
public class Input {
	private static Scanner scanner = null;
	static {
		scanner = new Scanner(System.in);
		// scanner.useDelimiter("\n");
	}

	/**
	 * This method use to get number value input from console
	 * 
	 * @return number input
	 */
	public static int getNumberInput() {
		while (!scanner.hasNextInt())
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
