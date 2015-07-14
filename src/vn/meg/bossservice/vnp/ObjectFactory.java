package vn.meg.bossservice.vnp;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the cn.bnet.v3 package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * </p>
 * Title : <br/>
 * Description : <br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 12:53:16 PM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
@XmlRegistry
public class ObjectFactory {
	private final static QName	_UserSyncReq_QNAME	            =new QName(
	                                                                "http://www.bnet.cn/v3.0/",
	                                                                "userSyncReq");
	private final static QName	_UserSyncResp_QNAME	            =new QName(
	                                                                "http://www.bnet.cn/v3.0/",
	                                                                "userSyncResp");
	private final static QName	_AcceptReq_QNAME	              =new QName(
	                                                                "http://www.bnet.cn/v3.0/",
	                                                                "acceptReq");
	private final static QName	_ProductUseAuthReq_QNAME	      =new QName(
	                                                                "http://www.bnet.cn/v3.0/",
	                                                                "productUseAuthReq");
	private final static QName	_AcceptCompleteNotifyReq_QNAME	=new QName(
	                                                                "http://www.bnet.cn/v3.0/",
	                                                                "acceptCompleteNotifyReq");
	private final static QName	_ProductUseAuthResp_QNAME	      =new QName(
	                                                                "http://www.bnet.cn/v3.0/",
	                                                                "productUseAuthResp");
	private final static QName	_AcceptCompleteNotifyResp_QNAME	=new QName(
	                                                                "http://www.bnet.cn/v3.0/",
	                                                                "acceptCompleteNotifyResp");
	private final static QName	_AcceptResp_QNAME	              =new QName(
	                                                                "http://www.bnet.cn/v3.0/",
	                                                                "acceptResp");
	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: cn.bnet.v3
	 */
	public ObjectFactory() {}
	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 */
	@XmlElementDecl(namespace="http://www.bnet.cn/v3.0/", name="userSyncReq")
	public JAXBElement<String> createUserSyncReq(String value) {
		return new JAXBElement<String>(_UserSyncReq_QNAME,
		    String.class,null,value);
	}
	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 */
	@XmlElementDecl(namespace="http://www.bnet.cn/v3.0/", name="userSyncResp")
	public JAXBElement<String> createUserSyncResp(String value) {
		return new JAXBElement<String>(_UserSyncResp_QNAME,
		    String.class,null,value);
	}
	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 */
	@XmlElementDecl(namespace="http://www.bnet.cn/v3.0/", name="acceptReq")
	public JAXBElement<String> createAcceptReq(String value) {
		return new JAXBElement<String>(_AcceptReq_QNAME,
		    String.class,null,value);
	}
	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 */
	@XmlElementDecl(namespace="http://www.bnet.cn/v3.0/", name="productUseAuthReq")
	public JAXBElement<String> createProductUseAuthReq(
	    String value) {
		return new JAXBElement<String>(
		    _ProductUseAuthReq_QNAME,String.class,null,value);
	}
	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 */
	@XmlElementDecl(namespace="http://www.bnet.cn/v3.0/", name="acceptCompleteNotifyReq")
	public JAXBElement<String> createAcceptCompleteNotifyReq(
	    String value) {
		return new JAXBElement<String>(
		    _AcceptCompleteNotifyReq_QNAME,String.class,null,
		    value);
	}
	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 */
	@XmlElementDecl(namespace="http://www.bnet.cn/v3.0/", name="productUseAuthResp")
	public JAXBElement<String> createProductUseAuthResp(
	    String value) {
		return new JAXBElement<String>(
		    _ProductUseAuthResp_QNAME,String.class,null,value);
	}
	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 */
	@XmlElementDecl(namespace="http://www.bnet.cn/v3.0/", name="acceptCompleteNotifyResp")
	public JAXBElement<String> createAcceptCompleteNotifyResp(
	    String value) {
		return new JAXBElement<String>(
		    _AcceptCompleteNotifyResp_QNAME,String.class,null,
		    value);
	}
	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 */
	@XmlElementDecl(namespace="http://www.bnet.cn/v3.0/", name="acceptResp")
	public JAXBElement<String> createAcceptResp(String value) {
		return new JAXBElement<String>(_AcceptResp_QNAME,
		    String.class,null,value);
	}
}
