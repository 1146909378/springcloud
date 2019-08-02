package com.java.oop;

import java.util.Date;

/**
 * 字节码对象应用分析
 * JVM参数配置:跟踪类的加载过程(开发过程:自己使用)
 * -XX:+TraceClassLoading 
 */
public class TestClassObject01 {
   public static void main(String[] args)
   throws Exception{
	   //1.获取类的字节码对象方式1
	   Class<Date> d1=Date.class;
	   Class<Integer> d11=Integer.class;
	   //2.获取类的字节码对象方式2,编译阶段不知道泛型对象的类型(不知道什么类型)
	   Class<?> d2=Class.forName("java.util.Date");
	   //3.获取类的字节码对象方式3
	   Class<?> d3=new Date().getClass();
	   System.out.println(d1==d2);
	   System.out.println(d2==d3);
   }
}




