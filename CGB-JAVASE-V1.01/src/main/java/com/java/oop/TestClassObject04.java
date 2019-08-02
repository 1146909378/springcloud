package com.java.oop;
/**
 * 类加载时一定会执行静态代码块吗,不一定,要看它的执行方式
 */
class ClassC{
	static int c=100;
	static {
		System.out.println("ClassC.static");
	}
}
class ClassD extends ClassC{
	static int d=200;
	static {
		System.out.println("ClassD.static");
	}
}
public class TestClassObject04 {
	public static void main(String[] args)throws Exception {
		ClassLoader loader=
		ClassLoader.getSystemClassLoader();
//		loader.loadClass("com.java.oop.ClassC");
//	    Class.forName("com.java.oop.ClassC");
//		Class.forName("com.java.oop.ClassC",
//				       true,//true表示要对类变量初始化,执行静态代码块
//				       loader);
		//如下输出,ClassD为被动加载,其内部静态代码块不会执行
		 System.out.println(ClassD.c);//(访问类的时候执行了静态代码块)方法ClassC属性
		//如下输出,ClassD为主动加载,其内部静态代码块会执行.
//		System.out.println(ClassD.d);//访问自身属性
	}
	
}




