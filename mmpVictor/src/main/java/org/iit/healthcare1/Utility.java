package org.iit.healthcare1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public class Utility {
	
public static String selectFutureDate(int days) {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM/d/YYYY");
		String date = sdf.format(d);
		return date;
	
	}

public static String getFutureDate(int days,String pattern)
{
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE, days);
	Date d = cal.getTime();
	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	String date = sdf.format(d);
	return date;
}
public static String randomString(int limit)
{
	
	String ranString = RandomStringUtils.randomAlphabetic(limit);
	return ranString;
	

}
}
