package com.java.reflect;

import java.lang.reflect.Field;

class DefaultCache{
	private int size;
	private DefaultCache() {}
	private DefaultCache(int size) {
		this.size=size;
	}
	@Override
	public String toString() {
		return "DefaultCache [size=" + size + "]";
	}
	
}
public class TestReflect01 {
   public static void main(String[] args)throws Exception{
	 // Class<DefaultCache> cls=DefaultCache.class;
	  //1.获取字节码对象
	  Class<?> cls=Class.forName("com.java.reflect.DefaultCache");
	  //2.获取无参的构造函数,并构建类的实例
	  DefaultCache cache01=ObjectFactory.doCreateInstance(cls);
	  System.out.println(cache01);
	  //3.获取带参的构造函数,并构建类的实例
	  DefaultCache cache02=ObjectFactory.doCreateInstance(cls,new Class[]{int.class},10);
	  System.out.println(cache02);
	  //4.通过反射修改对象实例size属性的值
	  //4.1获取属性对象
	  Field f=cls.getDeclaredField("size");
	  //4.2设置属性可访问
	  f.setAccessible(true);
	  //4.3为cache02对象的f属性赋值20
	  f.set(cache02, 20);
	  System.out.println(cache02);
   }
}








