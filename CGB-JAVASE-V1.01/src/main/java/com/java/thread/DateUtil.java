package com.java.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 	借助此工具类:
 * 	1)将指定给出的字符串转换为日期对象
 * 	2)将日期转换为指定给事的字符串
 *
 *  ThreadLocal 提供一种线程绑定机制,可以基于此
 *	 对象将某个对象绑定当前线程中,也可以冲当前线程获取
 *	某个对象.
 *  1)set() 绑定
 *  2)get() 获取
 */

public class DateUtil {
	static final String PATTERN = "yyyy/MM/dd HH:mm:ss";
	//此对象线程不安全
	static SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
	public static  String format(Date date) {
		return sdf.format(date);
		//解决线程不安全第一种方法:加上synchronized
//	public static synchronized String format(Date date) {
		//解决线程不安全二种解决线程不安全的方法,把sdf写入方法内
//		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
	}
	//第三种解决线程不安全的方法
	//ThreadMap<key,value>:key指对象,value指实际传入的值
	private static ThreadLocal<SimpleDateFormat> td 
			= new ThreadLocal<SimpleDateFormat>() {//普通泛型
			protected SimpleDateFormat initialValue() {
				System.out.println("initialValue()");
				return new SimpleDateFormat(PATTERN);
			};
	};
	public static Date parse(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO: handle exception
			//e.printStackTrace();
			//return null;
			throw new IllegalArgumentException(e);
		}
	}
	public static void main(String[] args) {
		//run线程
		new Thread() {
			public void run() {
				Date d1 = parse("2019/06/03 09:12:13");
				Date d2 = parse("2019/06/03 09:12:13");
			};
		}.start();
		//main线程
		Date d3 = parse("2019/06/03 09:12:13");
		Date d4 = parse("2019/06/03 09:12:13");		
		
	}
}
