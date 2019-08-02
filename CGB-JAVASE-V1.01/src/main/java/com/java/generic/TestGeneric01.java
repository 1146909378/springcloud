package com.java.generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 1.如下写法正确的是:
 * 1)List<Object> list=new ArrayList<Object>()
 * 2)List<int> list=new ArrayList<int>();
 * 3)List<Object> list=new ArrayList<String>();
 * 4)List<String> list=new ArrayList<Object>();
 * 
 * 2.将100这个整数添加到如下List集合?(通过反射)
 * List<String> list=new ArrayList<String>();
 * 
 * 3.检测如下类的编写是否正确.
 * class Container<T>{
 *     T[] a;
 *     public void add(T t){}
 *     static T get(T t){return null;}
 * }
 */

public class TestGeneric01 {
	public static void main(String[] args) {
		List<Object> list=new ArrayList<Object>();
		//List<int> list=new ArrayList<int>(); 错误
		//List<Object> list=new ArrayList<String>(); 错误
		//修改第三个:等号右边的是左边的子类
		List<? extends Object> list3=new ArrayList<String>();
		List<?> list33=new ArrayList<String>();
		//List<String> list=new ArrayList<Object>(); 错误
		//修改第四个:等号右边的是左边的父类
		List<? super String> list4=new ArrayList<Object>(); 
		List<?> list44=new ArrayList<Object>(); 
	}
	
	@Test
	public void test() {
		//泛型是编译阶段时有效,运行时无效
		
		
	}
}
 	 	

class Container2<T>{
    T[] a;
    public void add(T t){}
    T get(T t){return null;}
}

class Container1<T>{
	   // T[] a = new T[];
	    public void add(T t){}
	  //  static T get(T t){return null;}
}





