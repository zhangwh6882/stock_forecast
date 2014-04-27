package org.stockforecast.common;

import java.util.Calendar;

public final class GetTime {
	public static Calendar _calendar=Calendar.getInstance();
	public static int getYear(){
		int year=_calendar.get(Calendar.YEAR);
		return year;
	}
	public static int getMonth(){
		int month=_calendar.get(Calendar.MONTH);
		return month+1;
	}
	
	public static int getDay(){
		int day=_calendar.get(Calendar.DATE);
		return day;
	}
	
	public static int getHour(){
		int hour=_calendar.get(Calendar.HOUR_OF_DAY);
		return hour;
	}
	public static int getMinute(){
		int minute=_calendar.get(Calendar.MINUTE);
		return minute;
	}
	
	public static int getSecond(){
		int second=_calendar.get(Calendar.SECOND);
		return second;
	}
}
