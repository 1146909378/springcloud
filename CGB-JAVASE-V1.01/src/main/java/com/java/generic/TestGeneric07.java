package com.java.generic;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//List<?> list=new ArrayList<>();
public class TestGeneric07 {
	public static void main(String[] args)
	throws Exception{
		List<?> list=new ArrayList<>();
		Class<Date> c1=Date.class;//class本质就是一个泛型类
		//当泛型类型不确定时可以直接使用?替换
		Class<?> c2=Class.forName("java.util.Date");
		
		List<?> list1=new ArrayList<>();
	}
}
