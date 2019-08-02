package com.test;

import java.util.List;
import java.util.Set;

class PrintUtil{
	//这里的代码块为啥没有执行?
	static void doPrint(List<? extends CharSequence> list){
		System.out.println(list);
	}
	static void doPrint(Set<? super Integer> set){
		System.out.println(set);
	}
	static {
		System.out.println("你好");
	}
}


/**
 * 泛型通配符"?"的应用
 * 说明:"?"代表一种不确定的类型,
 * 当使用一个泛型类时假如其类型不确定可以使用"?"替代
 */
public class TestGeneric05 {
	public static void main(String[] args)throws Exception {
	     Class<Object> c1=Object.class;	//类对象
//	     Object c3 = Object.class;
//	     System.out.println(c3.toString());
	     System.out.println(c1.toString());
	     //"?"为泛型应用的一个通配符
	     //当泛型应用时,无法判定具体类型时,使用"?"替代
         //此案例在编译阶段根本无法确定字符串中代理的类型具体为何种类型.
	     Class<?> c2=Class.forName("java.lang.Object");
	     //Class<Log> c3=Class.forName("java.lang.Object"); 错误
	     System.out.println(c1==c2);
	     
	}
}
