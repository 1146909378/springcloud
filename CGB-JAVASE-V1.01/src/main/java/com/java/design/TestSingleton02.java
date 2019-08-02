package com.java.design;
/**如何对下面的类进行设计才能保证
 * 1)此类的实例每个线程只有一份(线程内部单例)
 * 2)在外界不允许构建此对象*/
class Looper{//迭代器(任意的一个对象)
	private Looper() {
		System.out.println("Looper()");
	}												//这里的Looper可以省略
	private static ThreadLocal<Looper> td=new ThreadLocal<>();
	public static Looper getLooper() {
		  //1.从当前线程获取looper对象
		  Looper looper=td.get();//key是谁?
		  //2.当前线程没有则创建looper并绑定到当前线程
		  if(looper==null) {
			looper=new Looper();
			td.set(looper);//key是谁?
		  }
		  //3.返回looper实例
		  return looper;
	}
}
public class TestSingleton02 {
    public static void main(String[] args) {
		for(int i=0;i<3;i++) {
    	 new Thread() {
			@Override
			public void run() {
				Looper.getLooper();
				Looper.getLooper();
				Looper.getLooper();
			}
		 }.start();
		}
	}
}







