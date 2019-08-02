package com.java.oop;

public class TestInteger01 {
    static int[] integerCache=new int[256];
    static {
    	
    }
	public static void main(String[] args) {
		Integer t1=100;//Integer.valueOf(100);
		Integer t2=100;//从池中取(-128~+127)
		Integer t3=200;
		Integer t4=200;
		System.out.println(t1==t2);//true
		System.out.println(t3==t4);//false
	}
}
