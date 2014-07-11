package main.java;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetTime {
	
	private static final GetTime INSTANCE = new GetTime();
	
	private static Calendar calendar;
	private static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
	
	
	private GetTime(){
		
	}
	
	public static GetTime getInstance(){
		return INSTANCE;
	}
	
	public  String getTime(){
		calendar = Calendar.getInstance();
             
		return format.format(new java.sql.Timestamp(calendar.getTime().getTime()));
	}

}
