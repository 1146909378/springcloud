package com.java.oop;
	//外部类
class ClassAA{
	static Integer count1=100;
	//内部类//这里会生成一个独立的class文件
	static class InnerAA{
		//这里可以放一些再加载这个类的时,不需要       被访问的属性
		static Integer[] count2=new Integer[200];//调用方法时去加载:对象的延迟加载
		static Integer count3=300;;//调用方法时去加载:对象的延迟加载(需要时加载)
		static {
		Integer count2=00;
			System.out.println("InnerAA");
		}
	}
}
public class TestClassObject07 {
   public static void main(String[] args) {
	 System.out.println(ClassAA.count1);
	 System.out.println(ClassAA.InnerAA.count3);
   }
}
