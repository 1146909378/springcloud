package com.java.generic;

import java.util.ArrayList;
import java.util.List;

//泛型方法语法: "<泛型>方法返回值类型"
class DefaultSqlSession{
	//泛型方法
	public <T>T getMapper(Class<T> cls){
		return null;
	}
}
interface BeanFactory{//泛型方法
	public <E>E getBean(Class<E> cls);
}
class CollectionUtil{//泛型方法
	//静态方法,不能使用类定义时使用的泛型
			//List<T>:方法返回值类型		//这里的T是等待被传入的类型
	static <T>List<T> convert(List<T> list){   
//	static <T>T convert(List<T> list){  第一种写法
		return null;
	}
	static <T>void print(List<T> list) {
		System.out.println(list);
	}
}
public class TestGeneric05 {
    public static void main(String[] args) {
    	List<Integer> list=new ArrayList<Integer>();
    	list.add(100);
    	list.add(200);
    	list.add(300);
    	list.add(300);
    	list.add(300);
    	CollectionUtil.print(list);
	}
}




