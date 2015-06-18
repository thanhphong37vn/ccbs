/**
 * 
 */
package com.ncs.ccbs.test;

import org.apache.log4j.FileAppender;
import com.ncs.ccbs.util.ConstantFile;

/**
 * @author HoanPV
 * @version Jun 18, 2015
 * 
 */
public class Main01 {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(Main01.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Logger.getRootLoggeCr().
		FileAppender fileAppender = new org.apache.log4j.FileAppender();
		fileAppender.setFile(ConstantFile.currentRootDirectoryPath()
				+ "log/ccbs.log");
		logger.info("Mesage");
		logger.info("Mesage");
		logger.info("Mesage");
		logger.info("Mesage");
		logger.info("Mesage");
		logger.info("Mesage");
		logger.info("Mesage");
	}
}
