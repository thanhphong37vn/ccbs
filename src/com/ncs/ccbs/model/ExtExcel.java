package com.ncs.ccbs.model;

import com.ncs.ccbs.dao.ExtExcelDao;
import com.ncs.ccbs.util.DateUtils;
import com.ncs.ccbs.util.ExcelUtil;

/**
 * 
 * @author HoanPV
 * @version Jun 18, 2015
 *
 */
public class ExtExcel {

	/** 84912400604 */
	private String hotline;
	/** 520 */
	private String extNo;
	/** 914000520 */
	private String phone;
	/** NGuyen Van Nam */
	private String name;
	/** Phong ky thuat */
	private String depart;
	/** 0:Nhan vien : 1 truong phong : 2 Lanh Dao */
	private String level;
	// <CustID>668</CustID>
	private String custID;
	@SuppressWarnings("unused")
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(ExcelUtil.class);

	public String getHotline() {
		return hotline;
	}

	public void setHotline(String hotline) {
		this.hotline = hotline;
	}

	public String getExtNo() {
		return extNo;
	}

	public void setExtNo(String extNo) {
		this.extNo = extNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "ExtExcel [hotline=" + hotline + ", extNo=" + extNo + ", phone="
				+ phone + ", name=" + name + ", depart=" + depart + ", level="
				+ level + "]";
	}

	public String toStringXML() {
		StringBuilder builder = new StringBuilder();
		builder.append("<?xmlversion=\"1.0\"encoding=\"UTF-8\"?>");
		builder.append("<root>");
		builder.append("<Header>");
		builder.append("<StreamingNo>" + DateUtils.getDateTimeStampCurrent()
				+ "</StreamingNo>");
		builder.append("<TimeStamp>" + DateUtils.getDateTimeStampCurrent()
				+ "</TimeStamp>");
		builder.append("<ActionType>6</ActionType>");
		builder.append("</Header>");
		builder.append("<Body>");
		builder.append("<CustomerInfo>");
		builder.append("<CustID>" + getCustID() + "</CustID>");
		builder.append("<CustTelNum>" + hotline + "</CustTelNum>");
		builder.append("<ExtAttributes>");
		builder.append("<EmpName>" + name + "</EmpName>");
		builder.append("<EmpTelNum>" + phone + "</EmpTelNum>");
		builder.append("<ExtNumber>" + extNo + "</ExtNumber>");
		builder.append("<PackageType>E1</PackageType>");
		builder.append("<EmpPosition>" + level + "</EmpPosition>");
		builder.append("<EmpDivision>" + depart + "</EmpDivision>");
		builder.append("<ChangeInfo>0</ChangeInfo>");
		builder.append("<ExtStatus>1</ExtStatus>");
		builder.append("</ExtAttributes>");
		builder.append("</CustomerInfo>");
		builder.append("</Body>");
		builder.append("</root>");
		return builder.toString();
	}

	public String getCustID() {
		if (this.hotline != null) {
			this.custID = ExtExcelDao.getECCompanyCode(this.hotline);
		}
		return custID;
	}

}
