package com.ncs.ccbs.util;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.InputSource;
import org.apache.log4j.Logger;
/**
 * Title : XML Utility<br/>
 * Description : Support work with XML data<br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 11:55:40 AM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
public class XMLUtil {
	private static Logger	logger	=Logger
	                                 .getLogger(XMLUtil.class);
	/**
	 * format string data to XML formatted
	 * 
	 * @param xml
	 *          String resources
	 * @return XML formatted
	 */
	public static String formatXml(String xml) {
		try {
			Transformer transformer=SAXTransformerFactory
			    .newInstance().newTransformer();
			transformer
			    .setOutputProperty(OutputKeys.INDENT,"yes");
			transformer.setOutputProperty(
			    "{http://xml.apache.org/xslt}indent-amount","2");
			Source source=new SAXSource(new InputSource(
			    new ByteArrayInputStream(xml.getBytes())));
			StreamResult result=new StreamResult(
			    new ByteArrayOutputStream());
			transformer.transform(source,result);
			return new String(
			    ((ByteArrayOutputStream) result.getOutputStream())
			        .toByteArray());
		} catch(TransformerConfigurationException e) {
			logger.error(ErrorUtil.stackTrace2String(e));
		} catch(TransformerFactoryConfigurationError e) {
			logger.error(e.getMessage());
		} catch(TransformerException e) {
			logger.error(ErrorUtil.stackTrace2String(e));
		}
		return xml;
	}
}
