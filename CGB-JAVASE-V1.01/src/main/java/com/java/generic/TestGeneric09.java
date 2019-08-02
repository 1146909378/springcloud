package com.java.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//homework
public class TestGeneric09 {
	public static void main(String[] args)throws Exception {
		List<String> list=new ArrayList<>();
		list.add("A");
		list.add("B");
		//list.add(100);//默认添加到最后
		//list.add(0, 100);//添加到指定位置
		//1.将100这个整数存储list集合(借助反射)  
		
		//1)获取类的字节码对象(此对象是应用反射的入口)
		Class<?> cls=list.getClass();
		
		//2)基于字节码对象获取add方法对象
		Method method=
		//cls.getDeclaredMethod("add",Object.class);//泛型类型擦除
		cls.getDeclaredMethod("add",int.class,Object.class);
		
		//3)执行list集合的add方法将100添加到集合
		method.invoke(list,0,100);
		//输出list集合内容
		System.out.println(list);//A,B,100
	}
}







