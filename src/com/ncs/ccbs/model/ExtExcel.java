package com.ncs.ccbs.model;
import com.ncs.ccbs.dao.ExtExcelDao;
import com.ncs.ccbs.util.DateUtils;
/**
 * Title : Entity Layer : Extension Entity <br/>
 * Description : Extension Entity<br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 10:23:43 AM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
public class ExtExcel {
	/** MEG main - hot line: example : 84912400604 */
	private String	hotline;
	/** Employee_no : example 520 */
	private String	extNo;
	/** Employee phone : example: 914000520 */
	private String	phone;
	/** Employee name : example : NGuyen Van NAM */
	private String	name;
	/** Depart name : example : Phong ky thuat */
	private String	depart;
	/** 0: Employee : 1 Manager : 2 Chairman */
	private String	level;
	/** <CustID>668</CustID> */
	private String	custID;
	/**
	 * 1 : Register
	 * 2 : Change
	 * 3 : Change Mapping
	 * 3 : Edit
	 * 3 : ReActive
	 * 3 : Drop
	 * 3 : Change Mapp
	 */
	private String	extStatus	  ="1";
	/** Action type: default = 6 */
	private String	actionType	="6";
	/** Change info: default = 0 */
	private String	changeInfo	="0";
	/** Package type: default = E1 */
	private String	packageType	="E1";
	public String getPackageType() {
		return packageType;
	}
	public void setPackageType(String packageType) {
		this.packageType=packageType;
	}
	public String getHotline() {
		return hotline;
	}
	public void setHotline(String hotline) {
		this.hotline=hotline;
	}
	public String getExtNo() {
		return extNo;
	}
	public void setExtNo(String extNo) {
		this.extNo=extNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart=depart;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level=level;
	}
	@Override
	public String toString() {
		return "ExtExcel [hotline="+hotline+", extNo="+extNo
		    +", phone="+phone+", name="+name+", depart="+depart
		    +", level="+level+"]";
	}
	/**
	 * Get {@link ExtExcel} object to XML data, which data use to send the</br>
	 * message to server
	 * 
	 * @return XML data
	 */
	public String toStringXML() {
		StringBuilder builder=new StringBuilder();
		builder
		    .append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		builder.append("<root>");
		builder.append("<Header>");
		builder.append("<StreamingNo>")
		    .append(DateUtils.getDateTimeStampCurrent())
		    .append("</StreamingNo>");
		builder.append("<TimeStamp>")
		    .append(DateUtils.getDateTimeStampCurrent())
		    .append("</TimeStamp>");
		builder.append("<ActionType>").append(this.actionType)
		    .append("</ActionType>");
		builder.append("</Header>");
		builder.append("<Body>");
		builder.append("<CustomerInfo>");
		builder.append("<CustID>"+this.getCustID()+"</CustID>");
		builder.append("<CustTelNum>"+this.hotline
		    +"</CustTelNum>");
		builder.append("<ExtAttributes>");
		builder.append("<EmpName>"+this.name+"</EmpName>");
		builder.append("<EmpTelNum>"+this.phone+"</EmpTelNum>");
		builder.append("<ExtNumber>"+this.extNo+"</ExtNumber>");
		builder.append("<PackageType>"+this.packageType
		    +"</PackageType>");
		builder.append("<EmpPosition>"+this.level
		    +"</EmpPosition>");
		builder.append("<EmpDivision>"+this.depart
		    +"</EmpDivision>");
		builder.append("<ChangeInfo>"+this.changeInfo
		    +"</ChangeInfo>");
		builder.append("<ExtStatus>"+this.extStatus
		    +"</ExtStatus>");
		builder.append("</ExtAttributes>");
		builder.append("</CustomerInfo>");
		builder.append("</Body>");
		builder.append("</root>");
		return builder.toString();
	}
	public String getCustID() {
		if(this.hotline!=null) {
			this.custID=ExtExcelDao
			    .getECCompanyCode(this.hotline);
		}
		return custID;
	}
	public String getExtStatus() {
		return extStatus;
	}
	public void setExtStatus(String extStatus) {
		this.extStatus=extStatus;
	}
	public String getChangeInfo() {
		return changeInfo;
	}
	public void setChangeInfo(String changeInfo) {
		this.changeInfo=changeInfo;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType=actionType;
	}
}
