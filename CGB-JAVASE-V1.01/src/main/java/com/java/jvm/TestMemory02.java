package com.java.jvm;
//java.lang.StackOverflowError (栈内存溢出)__类似递归
public class TestMemory02 {
	static void doMethod01() {
		doMethod01(); //往返调用
	}
	public static void main(String[] args) {
	     doMethod01();
	}
}
