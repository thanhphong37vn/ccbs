package com.ncs.ccbs.run;
import vn.meg.bossservice.vnp.CallWebService;
/**
 * Title : Test Call Message<br/>
 * Description : Test Call Message <br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 12:51:40 PM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
public class Main02 {
	public static void main(String[] args) {
		// String
		// acceptReq="<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><Header><StreamingNo>20150625162600016</StreamingNo><TimeStamp>20150625162600016</TimeStamp><ActionType>6</ActionType></Header><Body><CustomerInfo><CustID>628</CustID><CustTelNum>0912400604</CustTelNum><ExtAttributes><EmpName>Nhanvien520</EmpName><EmpTelNum>91400052</EmpTelNum><ExtNumber>520</ExtNumber><PackageType>E1</PackageType><EmpPosition>2</EmpPosition><EmpDivision>KT01</EmpDivision><ChangeInfo>0</ChangeInfo><ExtStatus>1</ExtStatus></ExtAttributes></CustomerInfo></Body></root>";
		String acceptReq="<?xml version=\"1.0\" encoding=\"UTF-8\"?> <root> <Header> <StreamingNo>54410</StreamingNo> <TimeStamp>20150626151154</TimeStamp> <ActionType>6</ActionType> </Header> <Body> <CustomerInfo> <CustID>628</CustID> <CustTelNum>0912400604</CustTelNum> <ExtAttributes> <EmpName>Mobi Test</EmpName> <EmpTelNum>1656053785</EmpTelNum> <ExtNumber>155</ExtNumber> <PackageType>E1</PackageType> <EmpPosition>1</EmpPosition> <EmpDivision>Phongkythuat</EmpDivision> <ChangeInfo>0</ChangeInfo> <ExtStatus>3</ExtStatus> </ExtAttributes> </CustomerInfo> </Body> </root>";
		// String
		// acceptReq="<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><Header><StreamingNo>20150625162600016</StreamingNo><TimeStamp>20150625162600016</TimeStamp><ActionType>6</ActionType></Header><Body><CustomerInfo><CustID>668</CustID><CustTelNum>0912400604</CustTelNum><ExtAttributes><EmpName>Nguyen Thi Hong Thu</EmpName><EmpTelNum>919220466</EmpTelNum><ExtNumber>405</ExtNumber><PackageType>E1</PackageType><EmpPosition>0</EmpPosition><EmpDivision>BP Kinh Doanh</EmpDivision><ChangeInfo>2</ChangeInfo><ExtStatus>5</ExtStatus></ExtAttributes></CustomerInfo></Body></root>";
		// String
		// del="<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><Header><StreamingNo>20150626110958192</StreamingNo><TimeStamp>20150626110958192</TimeStamp><ActionType>6</ActionType></Header><Body><CustomerInfo><CustID>628</CustID><CustTelNum>0912400604</CustTelNum><ExtAttributes><EmpName>MEG229</EmpName><EmpTelNum>914000229</EmpTelNum><ExtNumber>229</ExtNumber><PackageType>E1</PackageType><EmpPosition>2</EmpPosition><EmpDivision>KT02</EmpDivision><ChangeInfo>0</ChangeInfo><ExtStatus>3</ExtStatus></ExtAttributes></CustomerInfo></Body></root>";
		String ref=CallWebService.send(acceptReq);
		System.out.println(ref);
		System.out.println("Completed !");
	}
}
