package com.vayneLove.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DealDate {

	public static String dateFomat(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM.dd 'at' HH:mm");
		
		String afterDate = sdf.format(date);
		
		return afterDate;
	}
	
}
