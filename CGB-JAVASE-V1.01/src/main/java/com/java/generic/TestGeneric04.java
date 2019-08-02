package com.java.generic;
import java.util.ArrayList;
//编写简易版本的线程安全的arraylist集合
//泛型类					//这里的E决定了方法参数和返回值类型
class SynchronizedArrayList<E> extends ArrayList<E>{
	private static final long serialVersionUID = 3560328425097090494L;
	@Override
	public synchronized boolean add(E e) {
		return super.add(e);
	}
	@Override
	public synchronized E get(int index) {
		return super.get(index);
	}
	
}
public class TestGeneric04 {
    public static void main(String[] args) {
    													//可以省略<>()里面的数组
    	SynchronizedArrayList<String> list=new SynchronizedArrayList<>();// Object类型的数组
    	list.add("ABCD");
    	System.out.println(list);
    	
    	ArrayList arrayList = new ArrayList();
    	arrayList.add("ABCD");
    	System.out.println(arrayList);
	}
}
