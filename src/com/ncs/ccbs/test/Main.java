package com.ncs.ccbs.test;

import com.ncs.ccbs.util.ConstantFile;
import com.ncs.ccbs.util.DBUtil;
import com.ncs.ccbs.util.ExcelUtil;
import com.ncs.ccbs.util.Input;
import com.ncs.ccbs.util.Print;

/**
 * <h1>System City Management</h1> <br/>
 * <br/>
 * The System City Management program implements an application that<br/>
 * 
 * 1. Input information for n countries of Asia<br/>
 * 2. Display information<br/>
 * 3. Sort descending by area and display result<br/>
 * 4. Sort ascending by area and display result<br/>
 * 5. Find information by countryName<br/>
 * 6. Exit<br/>
 * 
 * 
 * @author Admin
 * @version v.05.30
 * @since 2015-05-30
 * 
 */
/**
 * 
 * @author HoanPV
 * @version Jun 18, 2015
 *
 */
public class Main {
	/**
	 * Display menu list and return your choose
	 * 
	 * @return int : chose of user from screen
	 */
	public static int doMenu() {

		/** Print menu on standard output */
		Print.println("==========Menu==============");
		Print.println("1	Customer Account Change");
		Print.println("2	Customer Account Open ");
		Print.println("3	DROP Main MEG ");
		Print.println("4	Ext Add ");
		Print.println("5	Ext Change Mapping ");
		Print.println("6	Ext Drop ");
		Print.println("7	Ext Edit ");
		Print.println("8	Ext ReActive ");
		Print.println("9	Ext Stop ");
		Print.println("10	ReActive Main MEG ");
		Print.println("11	Stop Main MEG ");
		Print.println("12	Add Excel");
		Print.println("-------");
		Print.println("0	Exit");

		// get chose from console
		return Input.getNumberInput();

	}

	/**
	 * This is method main which makes use of Main.
	 * 
	 * @return nothing
	 * 
	 * @param args
	 *            Unused
	 * @exception No
	 *                Exception
	 * @see Exeption
	 * 
	 */
	public static void main(String[] args) {
		int chose = 0;

		do {
			chose = doMenu();
			switch (chose) {
			case 1:
				Print.println("1	Customer Account Change "); // arrACs =
				break;
			case 2:
				Print.println("2	Customer Account Open ");
				break;
			case 3:
				Print.println("3	DROP Main MEG ");
				break;
			case 4:
				Print.println("4	Ext Add ");
				break;
			case 5:
				Print.println("5	Ext Change Mapping ");
				break;
			case 6:
				Print.println("6	Ext Drop ");
				break;
			case 7:
				Print.println("7	Ext Edit ");
				break;
			case 8:
				Print.println("8	Ext ReActive ");
				break;
			case 9:
				Print.println("9	Ext Stop ");
				break;
			case 10:
				Print.println("10	ReActive Main MEG ");
				break;
			case 11:
				Print.println("11	Stop Main MEG ");
				break;
			case 12:

				// String banTin =
				// "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><Header><StreamingNo>67567</StreamingNo><TimeStamp>20150121113645</TimeStamp><ActionType>6</ActionType></Header><Body><CustomerInfo><CustID>668</CustID><CustTelNum>0914726006</CustTelNum><ExtAttributes><EmpName>nguyen thi hong thu</EmpName><EmpTelNum>919220466</EmpTelNum><ExtNumber>405</ExtNumber><PackageType>E1</PackageType><EmpPosition>0</EmpPosition><EmpDivision>kinh doanh</EmpDivision><ChangeInfo>0</ChangeInfo><ExtStatus>1</ExtStatus></ExtAttributes></CustomerInfo></Body></root>";
				// String banTin =
				// "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <root> <Header> <StreamingNo>16062015100839</StreamingNo> <TimeStamp>16/06/2015 10:08:39</TimeStamp> <ActionType>6</ActionType> </Header> <Body> <CustomerInfo> <CustID>10368</CustID> <CustTelNum>0945867722</CustTelNum> <ExtAttributes> <EmpName>Huỳnh Văn Quang</EmpName> <EmpTelNum>911500224</EmpTelNum> <ExtNumber>2451</ExtNumber> <PackageType>E1</PackageType> <EmpPosition>1</EmpPosition> <EmpDivision>BTS TT Long Bình An Phú AG</EmpDivision> <ChangeInfo>1</ChangeInfo> <ExtStatus>1</ExtStatus> </ExtAttributes> </CustomerInfo> </Body> </root>";
				// String accept = CallWebService.send(banTin);
				// System.out.println("Ket qua 1   : " +
				// CallWebService.send(banTin));YYMMDD
				Print.println("12	Add Excel");
				Print.println("Duong dan : " + ConstantFile.getADD_EXCEL());
				ExcelUtil.read(ConstantFile.getADD_EXCEL());

				break;
			case 0:
				Print.println("System exited");
				System.exit(0);
				break;
			default:
				chose = doMenu();
				break;
			}
		} while (chose > 0 || chose < 12);

		DBUtil.closeConnection(DBUtil.connection);
	}

}
