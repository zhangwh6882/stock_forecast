package org.stockforecast.common;

import java.util.Calendar;

public  class GetTime {
	private  Calendar _calendar=Calendar.getInstance();
	
	public  int getYear(){
		int year=_calendar.get(Calendar.YEAR);
		return year;
	}
	public  int getMonth(){
		int month=_calendar.get(Calendar.MONTH);
		return month+1;
	}
	
	public  int getDay(){
		int day=_calendar.get(Calendar.DATE);
		return day;
	}
	
	public  int getHour(){
		int hour=_calendar.get(Calendar.HOUR_OF_DAY);
		return hour;
	}
	public  int getMinute(){
		int minute=_calendar.get(Calendar.MINUTE);
		return minute;
	}
	
	public  int getSecond(){
		int second=_calendar.get(Calendar.SECOND);
		return second;
	}
	public int getWeekDay(){
		int weekDay=_calendar.get(Calendar.DAY_OF_WEEK);
		return weekDay;
	}
}
