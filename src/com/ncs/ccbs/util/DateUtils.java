package com.ncs.ccbs.util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Title : Support working with date time<br/>
 * Description : Support working with date time<br/>
 * Copyright : Copyright (c) 2015<br/>
 * Company : NCS <br/>
 * Create on Jul 14, 2015 11:01:35 AM<br/>
 * 
 * @author <a href="mailto:hoanpmp@gmail.com">HoanPham</a>
 * @version 2015.1.0.1
 */
public class DateUtils {
	private static final SimpleDateFormat	datetimeFormat	     =new SimpleDateFormat(
	                                                               "yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat	datetimeFormat2	     =new SimpleDateFormat(
	                                                               "yyyy-MM-dd HH:mm");
	private static final SimpleDateFormat	yyyyMMdd	           =new SimpleDateFormat(
	                                                               "yyyy-MM-dd");
	private static final SimpleDateFormat	HHmmss	             =new SimpleDateFormat(
	                                                               "HH:mm:ss");
	private static final SimpleDateFormat	HHmm	               =new SimpleDateFormat(
	                                                               "HH:mm");
	private static final SimpleDateFormat	yyyyMMddHHmmssSSS	   =new SimpleDateFormat(
	                                                               "yyyyMMddHHmmssSSS");
	private static final SimpleDateFormat	simpleDateTimeFormat	=new SimpleDateFormat(
	                                                               "MM-dd HH:mm");
	private static final SimpleDateFormat	monthDateFormat	     =new SimpleDateFormat(
	                                                               "MM-dd");
	private static final SimpleDateFormat	monthDateFormat2	   =new SimpleDateFormat(
	                                                               "M\u6708d\u65E5");
	private static final SimpleDateFormat	simpleDateFormat	   =new SimpleDateFormat(
	                                                               "HH:mm");
	private static final SimpleDateFormat	dateTimeNumber2	     =new SimpleDateFormat(
	                                                               "yyyyMMddHHmmssSSSZ");
	private static final SimpleDateFormat	timeLimitFormat	     =new SimpleDateFormat(
	                                                               "yyyy\u5E74MM\u6708dd\u65E5");
	private static final SimpleDateFormat	timeLimitFormat1	   =new SimpleDateFormat(
	                                                               "yyyy\u5E74MM\u6708");
	private static final SimpleDateFormat	timeLimitFormat2	   =new SimpleDateFormat(
	                                                               "yyyy-MM");
	private static SimpleDateFormat	      dateFormat2	         =new SimpleDateFormat(
	                                                               "yyyy/MM/dd");
	public static String formatDateNumber(Date date) {
		String str=simpleDateFormat.format(date);
		return str;
	}
	public static String formatDateTimeStamp(Date date) {
		String str=yyyyMMddHHmmssSSS.format(date);
		return str;
	}
	public static String getDateTimeStampCurrent() {
		String str=yyyyMMddHHmmssSSS.format(Calendar
		    .getInstance().getTime());
		return str;
	}
	public static String formatDateNumber(long datetime) {
		String str=simpleDateFormat.format(new Date(datetime));
		return str;
	}
	public static String formatDateTimeNumber(long datetime) {
		String str=yyyyMMddHHmmssSSS.format(new Date(datetime));
		return str;
	}
	public static String formatDateTimeNumber2(long datetime) {
		String str=dateTimeNumber2.format(new Date(datetime));
		return str.contains("-")?(str=str.replace("-","+")):str;
	}
	public static String formatDateTime2(Date datetime) {
		String str=datetimeFormat2.format(datetime);
		return str;
	}
	public static String getCurrentDateTime() {
		Date now=new Date();
		return formatDateTime(now);
	}
	public static String getCurrentDate() {
		Date now=new Date();
		return formatDate(now);
	}
	public static Date parseDateTime(String str) {
		Date date=null;
		try {
			date=datetimeFormat.parse(str);
		} catch(ParseException ex) {
			// SystemLogger.getInstance().error(ex);
		}
		return date;
	}
	public static Date parseDateTime2(String str) {
		Date date=null;
		try {
			date=datetimeFormat2.parse(str);
		} catch(ParseException ex) {
			// SystemLogger.getInstance().error(ex);
		}
		return date;
	}
	public static Date parseDate(String str) {
		Date date=null;
		if((str==null)||("".equals(str))) return null;
		try {
			date=yyyyMMdd.parse(str);
		} catch(ParseException e) {
			// SystemLogger.getInstance().error(e);
		}
		return date;
	}
	public static Date parseDateTimeWithOutSS(String str) {
		Date date=null;
		try {
			date=HHmm.parse(str);
		} catch(ParseException e) {
			// SystemLogger.getInstance().error(e);
		}
		return date;
	}
	public static String formatDateTimeWithOutSS(long lngTime) {
		String str=HHmm.format(new Date(lngTime));
		return str;
	}
	public static String formatMonthDate(long lngTime) {
		String str=monthDateFormat.format(new Date(lngTime));
		return str;
	}
	public static String formatMonthDate2(long lngTime) {
		String str=monthDateFormat2.format(new Date(lngTime));
		return str;
	}
	public static String formatMonthDate2(Date datetime) {
		String str=monthDateFormat2.format(datetime);
		return str;
	}
	public static String formatDateTime(Date datetime) {
		String str=datetimeFormat.format(datetime);
		return str;
	}
	public static String formatSimpleDateTime(Date datetime) {
		String str=simpleDateTimeFormat.format(datetime);
		return str;
	}
	public static String formatDateTime(long datetime) {
		String str=datetimeFormat.format(new Date(datetime));
		return str;
	}
	public static String formatDate(long date) {
		String str=yyyyMMdd.format(new Date(date));
		return str;
	}
	public static String formatDate(Date date) {
		if(date==null) { return ""; }
		String str=yyyyMMdd.format(date);
		return str;
	}
	public static String formatTime(Date date) {
		String str=HHmmss.format(date);
		return str;
	}
	public static Date stringToDate(String str) {
		Date date=null;
		try {
			date=yyyyMMdd.parse(str);
		} catch(ParseException e) {
			// //SystemLogger.getInstance().error(e);
		}
		return date;
	}
	public static Date stringToDateTime(String str) {
		Date date=null;
		try {
			date=datetimeFormat.parse(str);
		} catch(ParseException e) {
			// //SystemLogger.getInstance().error(e);
		}
		return date;
	}
	/** @deprecated */
	public static Date StringToDate(String str) {
		Date date=null;
		try {
			date=datetimeFormat.parse(str);
		} catch(ParseException e) {
			// //SystemLogger.getInstance().error(e);
		}
		return date;
	}
	/** @deprecated */
	public static String DateToString(Date date) {
		String str=datetimeFormat.format(date);
		return str;
	}
	/** @deprecated */
	public static String getFormattedNowDate() {
		DateFormat df=DateFormat.getDateTimeInstance();
		Date date=new Date();
		return df.format(date);
	}
	public static int getDayCount(int year, int month, int day) {
		int count=0;
		switch(month){
			case 12:
				count+=30;
			case 11:
				count+=31;
			case 10:
				count+=30;
			case 9:
				count+=31;
			case 8:
				count+=30;
			case 7:
				count+=31;
			case 6:
				count+=31;
			case 5:
				count+=30;
			case 4:
				count+=31;
			case 3:
				count+=28;
			case 2:
				count+=31;
			case 1:
				count+=0;
		}
		count=count+day;
		if((year%4==0)&&(year%100!=0)&&(month>=3)) {
			count++;
		}
		return count;
	}
	public static int getWeek(int year, int month, int day) {
		int week=1;
		int c=20;
		year=Integer
		    .parseInt(String.valueOf(year).substring(2));
		if(month<3) {
			year--;
			month+=12;
		}
		week=c/4-2*c+year+year/4+13*(month+1)/5+day-1;
		if((week>0)&&(week<7))
			week%=7;
		else if(week==7)
			week=7;
		else if(week>7)
			week%=7;
		else if(week<0) {
			week=(week+700)%7;
		}
		if(week==0) {
			week=7;
		}
		return week;
	}
	public static String getWeekStr(int year, int month,
	    int day) {
		int week=1;
		String weekstr="\u661F\u671F\u4E00";
		int c=20;
		year=Integer
		    .parseInt(String.valueOf(year).substring(2));
		if(month<3) {
			year--;
			month+=12;
		}
		week=c/4-2*c+year+year/4+13*(month+1)/5+day-1;
		if(week==0)
			week=7;
		else if((week>0)&&(week<7))
			week%=7;
		else if(week==7)
			week=7;
		else if(week>7)
			week%=7;
		else if(week<0) {
			week=(week+700)%7;
		}
		switch(week){
			case 1:
				weekstr="\u661F\u671F\u4E00";
				break;
			case 2:
				weekstr="\u661F\u671F\u4E8C";
				break;
			case 3:
				weekstr="\u661F\u671F\u4E09";
				break;
			case 4:
				weekstr="\u661F\u671F\u56DB";
				break;
			case 5:
				weekstr="\u661F\u671F\u4E94";
				break;
			case 6:
				weekstr="\u661F\u671F\u516D";
				break;
			case 7:
				weekstr="\u661F\u671F\u65E5";
		}
		return weekstr;
	}
	public static boolean overdueDate(long date, int type)
	    throws ParseException {
		boolean flag=false;
		DateFormat df=new SimpleDateFormat(
		    "yyyy-MM-dd HH:mm:ss");
		Date now=df.parse(df.format(Long.valueOf(System
		    .currentTimeMillis())));
		Date pass=df.parse(df.format(Long.valueOf(date)));
		long elapse=now.getTime()-pass.getTime();
		long days=elapse/86400000L;
		if(type==1) {
			if(days>=7L)
				flag=true;
			else flag=false;
		} else if(type==2) {
			if(days>=30L)
				flag=true;
			else flag=false;
		} else if(type==3) {
			if(days>=365L)
				flag=true;
			else {
				flag=false;
			}
		}
		return flag;
	}
	@SuppressWarnings({"deprecation"})
	public static String getWeekStart(Date date) {
		Calendar weekstart=Calendar.getInstance();
		weekstart.setTime(date);
		if(date.getDay()==0) {
			weekstart.add(5,-7);
		}
		weekstart.set(7,2);
		String sStartDate=new SimpleDateFormat("yyyy-MM-dd")
		    .format(weekstart.getTime());
		return sStartDate;
	}
	@SuppressWarnings("deprecation")
	public static String getWeekEnd(Date date) {
		Calendar weekEnd=Calendar.getInstance();
		weekEnd.setTime(date);
		if(date.getDay()!=0) {
			weekEnd.add(5,6);
		}
		weekEnd.set(7,1);
		String sStartDate=new SimpleDateFormat("yyyy-MM-dd")
		    .format(weekEnd.getTime());
		return sStartDate;
	}
	public static String getTimeLimit(Date date) {
		if(date==null) { return ""; }
		String str=timeLimitFormat.format(date);
		return str;
	}
	public static String getTimeLimit1(Date date) {
		if(date==null) { return ""; }
		String str=timeLimitFormat1.format(date);
		return str;
	}
	public static String formatDate1(Date date) {
		if(date==null) { return ""; }
		String str=timeLimitFormat2.format(date);
		return str;
	}
	public static Date getDateByStrToYMD(String str) {
		Date date=null;
		if((str!=null)&&(str.trim().length()>0)) {
			DateFormat dFormat=new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss");
			try {
				date=dFormat.parse(str);
			} catch(ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}
	public static SimpleDateFormat getDateFormat2() {
		return dateFormat2;
	}
	public static void setDateFormat2(
	    SimpleDateFormat dateFormat2) {
		DateUtils.dateFormat2=dateFormat2;
	}
}