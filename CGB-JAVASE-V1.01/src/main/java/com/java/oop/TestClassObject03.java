package com.java.oop;
//class AppClassLoader{//关联方式
//	 ExtClassLoader loader;
//}
//class ExtClassLoader{
//	BootstrapClassLoader loader;
//}

public class TestClassObject03 {
	public static void main(String[] args) {
		//获取AppClassLoader(自己写的类通过这个加载)
		//user class(用户类)
		ClassLoader loader01=ClassLoader.getSystemClassLoader();
		System.out.println(loader01);
		//获取 ExtClassLoader 
		//路径:jre\lib\ext\*.jar
		ClassLoader loader02=loader01.getParent();
		System.out.println(loader02);
		//根类加载器(启动类加载器) BootstrapClassLoader (底层使用c完成)
		//路径:jre\lib\rt.jar
		ClassLoader loader03=loader02.getParent();
		System.out.println(loader03);
		//查一查类的双亲委派模型?
		/*
		 * 当一个类加载器接收到类加载的任务时，会首先交给其父类加载器去加载，
		 * 只有当父类加载器无法加载是其才会自己加载
		 */
	}
}



