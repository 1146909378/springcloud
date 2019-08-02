package com.java.generic;

import java.util.Arrays;
//类上的泛型和接口上的泛型就决定了:方法上参数类型,和方法的返回值类型.

//容器接口,并指定泛型<T>
interface Container<T>{//Type
	 void add(T t);
	 T get(int i);
}
//基于数组的容器泛型类
class ArrayContainer<T> implements Container<T>{
	Object array[];					 //T array[]; 错误写法
	public ArrayContainer(int cap) { //初始化时,都不能用到泛型啦
		array=new Object[cap];		 //array=new T[cap]; 错误写法
	}
	@Override
	public void add(T t) {
		this.array[0]=t;
	}
	@Override
	public T get(int i) {
		return (T) this.array[i];
	}

	@Override
	public String toString() {
		return "ArrayContaine " + "+r [array=" + Arrays.toString(array) + "]";
	}
	
}
public class TestGeneric02 {
    public static void main(String[] args) {
		ArrayContainer<String> c1= new ArrayContainer<>(3);
		c1.add("ABC");
		System.out.println(c1);
		
		String a = c1.get(0);
		System.out.println(a);
		//c1.add(100);
	}
}








