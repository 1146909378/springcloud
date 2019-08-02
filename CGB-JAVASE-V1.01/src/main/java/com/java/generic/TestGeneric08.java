package com.java.generic;
import java.util.ArrayList;
import java.util.List;
//泛型的上下界问题 (参考java中的Collections类)
public class TestGeneric08 {
	
	//指定泛型上界				//限定了其传入的一定是一个Number类型
	static void doPrint(List<? extends Number> list) {
		Number t=list.get(0);
		System.out.println(t);
	}
	//指定泛型上界   (向优秀的人学习:看Collections工具类里面怎么定义的方法)
    public static <T extends CharSequence> void doDisplay(List<T> list) {
    }
    
     
	public static void main(String[] args) {
	 List<Integer> list=new ArrayList<Integer>();//编译时看等号左边
	 list.add(100);
	 doPrint(list);
	 List<String> lst1=new ArrayList<String>();
	 doDisplay(lst1);
	}
}



