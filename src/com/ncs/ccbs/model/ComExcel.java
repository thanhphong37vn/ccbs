package com.ncs.ccbs.model;
import com.ncs.ccbs.dao.ExtExcelDao;
import com.ncs.ccbs.util.DateUtils;
/**
 * Title : Model Layer Entity : Company Entity <br/>
 * Description : company entity <br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 1:21:10 PM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
public class ComExcel {
	/** customer Id : get in */
	String	custId;
	/** MEG main : example : 0912400604 */
	String	hotline;
	/**
	 * action type
	 * 3 : Drop
	 * 5 : ReActive
	 * 4 : Stop
	 */
	String	actionType;
	/**
	 * @return custId by MEG main
	 */
	public String getCustId() {
		if(this.hotline!=null) {
			this.custId=ExtExcelDao
			    .getECCompanyCode(this.hotline);
		}
		return custId;
	}
	/**
	 * @return MEG main
	 */
	public String getHotline() {
		return hotline;
	}
	/**
	 * set property hotline of {@link ComExcel} entity
	 * 
	 * @param hotline
	 *          : MEG main
	 */
	public void setHotline(String hotline) {
		this.hotline=hotline;
	}
	/**
	 * get property actionType of {@link ComExcel} entity
	 * 
	 * @param actionType
	 *          action type</br>
	 *          3 : Drop</br>
	 *          5 : ReActive</br>
	 *          4 : Stop</br>
	 */
	public String getActionType() {
		return actionType;
	}
	/**
	 * set property actionType of {@link ComExcel} entity
	 * 
	 * @param actionType
	 *          : MEG main
	 */
	public void setActionType(String actionType) {
		this.actionType=actionType;
	}
	/**
	 * generated XML data format using this to send message script to server
	 * 
	 * @return XML data of {@link ComExcel} object
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
		builder.append("<CustID>").append(this.getCustId())
		    .append("</CustID>");
		builder.append("<CustTelNum>")
		    .append(this.getHotline()).append("</CustTelNum>");
		builder.append("</CustomerInfo>");
		builder.append("</Body>");
		builder.append("</root>");
		return builder.toString();
	}
	@Override
	public String toString() {
		return "ComExcel [custId="+this.getCustId()
		    +", hotline="+hotline+", actionType="+actionType
		    +"]";
	}
}
