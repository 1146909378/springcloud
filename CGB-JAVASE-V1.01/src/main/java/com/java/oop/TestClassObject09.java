package com.java.oop;
import java.util.Date;
//-XX:+TraceClassLoading
//访问类中的static final 成员时
//一定会执行类加载吗?不一定
//java中JVM会在编译阶段对类可以执行编译优化
//当类中有static final修饰的基本数据类型
//和字符串类型时,就会在编译阶段执行初始化
class ClassDD{
	public static final int count=100;//
	public static final String LOCK="LOCK";//类ClassD没有被加载
    public static final Date date=new Date();//导致类被加载了
    public static String LOCKP="LOCKP";//一定会导致类加载
	static {
		System.out.println("static{}");
	}
}
public class TestClassObject09 {
    public static void main(String[] args) {
		//System.out.println(ClassDD.count);
		System.out.println(ClassDD.LOCK);
		//System.out.println(ClassDD.date);
	}
}
