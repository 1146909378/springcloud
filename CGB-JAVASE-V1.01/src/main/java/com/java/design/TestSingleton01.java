package com.java.design;
/**
 * 对如下类进行单例设计?
 * 1)保证类的实例在一个JVM内部分只有一份(多线程共享)
 * 2)保证类的实例在一个线程内部只有一份(线程内部单例)
 * 解决方案(考虑线程安全/资源使用)
 * 1)确保类的外界最好不能直接构建对象
 * 2)将类的实例放在池中
 * 3)将对象绑定到当前线程
 * 饿汉式设计思想
 */
//方案1:(类加载时创建实例对象)
class Singleton01{//应用场景:小对象(内存占用较小的)
	//private byte[]array = new byte[1024*1024];
	//1.构造方法私有化
	private Singleton01() {}
	//2.类的内部构建对象
	private static Singleton01 instance = new Singleton01();
	//3.对外界提对象访问
	public static Singleton01 getInstance() {
		return instance;
	}
	public static void show() {}
	public void display() {}	
}
//方案2(类的实例何时需要何时创建)
class Singleton02{//应用场景:大对象(占用内存比较多),稀少用
	//private byte[]array = new byte[1024*1024];
	//1.构造方法私有化
	private Singleton02() {}
	//2.类的内部构建对象
	private static Singleton02 instance;
	//3.对外界提对象访问(资源使用,这里会存在阻塞)
	public	synchronized static Singleton02 getInstance() {
		if (instance==null) {
			System.out.println("create()");
			instance=new Singleton02();
		}
		return instance;
	}
	public static void show() {}
	public void display() {}		
}
//方案3(类的在方案2的基础上减少阻塞)
class Singleton03{//应用场景:大对象(占用内存比较多),稀少用
	//private byte[]array = new byte[1024*1024];
	//1.构造方法私有化
	private Singleton03() {}
	//2.类的内部构建对象
	//volatile的作用
	//1)保证多线程之间变量的可见性(一个线程修改了此变量的值,其它的立即可见)
	//2)禁止指令重排序(JVM内部对指令执行有优化)
	private static volatile Singleton03 instance;
	//3.对外界提对象访问(会有阻塞,但会少一些)
	//3.1多个线程并发访问此方法是否有线程不会被阻塞
	//3.2为什么synchronized内部还要有一次判断?(确保对象创建1次)
	public static Singleton03 getInstance() {
		if (instance==null) {
			synchronized(Singleton03.class) {
				if (instance==null) {
					System.out.println("create()");
					instance=new Singleton03();
				}	//对象创建过程(开辟内存,初始化属性,调用构造方法,为instance赋值)
			}
		}
		return instance;
	}
	public static void show() {}
	public void display() {}		
}
//方案4:(继续减少阻塞,同时优化资源使用)
class Singleton04{//大对象(延迟加载),频繁用
	//private byte[] array=new byte[1024*1024];
	private Singleton04() {}
	//Singleton04加载时不会加载Inner类 (自己发问?已经被加载了)
	private static class Inner{
		private static final Singleton04 instance=new Singleton04();
	}
	//可以频繁访问(没有阻塞)
	public static Singleton04 getInstance() {
		//基于内部类实现对象的延迟加载
		return Inner.instance;//返回的时内部类构建的实例
	}
	//public static void show() {}
	//public void display() {}
}
//方法5 (小对象,频繁用)
enum Singleton05{//Singleton05.class
	INSTANCE;//此对象可以延迟加载吗?不可以
	//private byte[] array=new byte[1024*1024];
	public static void show() {}
}

public class TestSingleton01 {
	/**
	 -XX:+TraceClassLoading
	  类加载时类属性和静态代码块不一定会执行.
	  但是当通过类名直接访问类中静态成员时,假
	  如类还加载则先加载类,然后类变量初始化,执
	  行静态代码块.
	 */
	static void doMethod01() {
		Singleton01.getInstance();
		Singleton01.getInstance();
		Singleton01.getInstance();
	}
	static void doMethod02() {
		Thread t1=new Thread() {
			@Override
			public void run() {
				Singleton02.getInstance();
				Singleton02.getInstance();
			}	
		};
		Thread t2=new Thread() {
			@Override
			public void run() {
				Singleton02.getInstance();
				Singleton02.getInstance();
			}	
		};
		t1.start();
		t2.start();

	}
	static void doMethod03() {
		for(int i=0;i<10;i++) {
			new Thread() {
				@Override
				public void run() {
					Singleton03.getInstance();
					Singleton03.getInstance();
				}	
			}.start();
		}
	}
	static void doMethod05() {
		Singleton05.INSTANCE.show();
	}
	public static void main(String[] args) {
		//打印create(),和加synchronized及与doMethod02位置相关
		//		Singleton02.getInstance();
		//		Singleton02.getInstance();
		doMethod05();
	}
}
