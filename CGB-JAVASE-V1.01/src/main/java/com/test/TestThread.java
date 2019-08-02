package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestThread {
	static final String LAYOUT = "";
	static SimpleDateFormat  sdf = new SimpleDateFormat(LAYOUT);
	public static String format(Date date) {
		return sdf.format(date);
	}
	String character() {
		return null;
	}
}