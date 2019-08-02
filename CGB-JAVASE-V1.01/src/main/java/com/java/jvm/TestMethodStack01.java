package com.java.jvm;

public class TestMethodStack01 {

	static void doMethod02() {
		Thread thread=Thread.currentThread();
		//获取当前线程中的栈中元素
		StackTraceElement[] array = thread.getStackTrace();
		for(StackTraceElement st:array) {
			System.out.println(st.getMethodName());
		}		
	}
	static void doMethod01() {
		doMethod02();
	}
	public static void main(String[] args) {
		doMethod01();
	}
}
