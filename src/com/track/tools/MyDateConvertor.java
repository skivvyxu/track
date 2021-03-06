package com.track.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class MyDateConvertor extends StrutsTypeConverter {
	public Object convertFromString(Map context, String[] values, Class toClass) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = (Date) sdf.parse(values[0]);
			return new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			return values[0];
		}
	}

	public String convertToString(Map context, Object o) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(o);
	}
}