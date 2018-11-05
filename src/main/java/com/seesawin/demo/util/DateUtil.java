package com.seesawin.demo.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil {
	/*
	 * String cast to java.sql.Date
	 */
	public static java.sql.Date getSqlDateFromString(String dateStr, String pattern) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		java.util.Date date = dateFormat.parse(dateStr);
		System.out.println(new java.sql.Date(date.getTime()));
		return new java.sql.Date(date.getTime());
	}
	
	/*
	 * String cast to java.util.Date
	 */
	public static java.util.Date getUtilDateFromString(String dateStr, String pattern) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		java.util.Date date = dateFormat.parse(dateStr);
		return date;
	}

	/*
	 * String cast to java.sql.Time
	 */
	public static Time getTimeFromString(String dateStr, String pattern) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		java.util.Date parsedDate = dateFormat.parse(dateStr);
		Time time = new java.sql.Time(parsedDate.getTime());
		return time;
	}

	/*
	 * String cast to java.sql.Timestamp
	 */
	public static Timestamp getTimestampFromString(String dateStr, String pattern) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		java.util.Date parsedDate = dateFormat.parse(dateStr);
		Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		return timestamp;
	}
}
