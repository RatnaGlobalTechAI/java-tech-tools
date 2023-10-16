package com.rgt.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtility {
	
	public static Date convertStringToDate(String date) {
		Date date1= null;
		try {
			 date1=new SimpleDateFormat("dd-MM-yyyy").parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date1;  
	}	
	
	public static Date getDateFromString(String dateObj){
		SimpleDateFormat dateFormat = new SimpleDateFormat( "DD/MM/YYYY hh:mm");

	    Date parsedTimeStamp = null;
		try {
			parsedTimeStamp = dateFormat.parse(dateObj);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	    return parsedTimeStamp;
	}
	
	public static String getTodayDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String todayDate = formatter.format(date);
		//System.out.println();
		return todayDate;
	}

}
