package com.java.oop;
/**
 * 类何时被加载?
 * 1)隐式加载
 * a)构建类的实例对象
 * b)访问类的静态成员(属性,方法)
 * 2)显式加载
 * a)Class.forName(....)
 * b)loader.load(....)
 */
class ClassA{
	static final Integer content=100;
	static void doMethod() {}
}
public class TestClassObject02 {
	public static void main(String[] args) throws Exception{
	ClassA a;//不会加载类
	//访问类中成员
	System.out.println(ClassA.content);
	ClassA.doMethod();
	//获取JVM中的一个类加载器
	ClassLoader classLoader = ClassLoader.getSystemClassLoader();
	classLoader.loadClass("com.java.oop.ClassA");
   }
}









