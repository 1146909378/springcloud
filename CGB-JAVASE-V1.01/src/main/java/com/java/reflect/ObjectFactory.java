package com.java.reflect;
import java.lang.reflect.Constructor;
/**对象工厂*/
public class ObjectFactory {
    /**基于类的字节码对象创建类的实例*/
	@SuppressWarnings("unchecked")
	public static <T>T doCreateInstance(Class<?> t) throws Exception{
		//1.获取类中的无参构造方法对象
		Constructor<?> con=t.getDeclaredConstructor();//public,private,protected,..
		//2.设置构造方法可访问(假如是私有)
		con.setAccessible(true);
		//3.基于构造方法对象,构建类的实例
		return (T)con.newInstance();
	}
	/**基于类的字节码对象创建类的实例*/
	@SuppressWarnings("unchecked")
	public static <T>T doCreateInstance(Class<?> t,Class<?>[] parameterTypes,Object... args) throws Exception{
		//1.获取类中有参构造方法对象
		Constructor<?> con=t.getDeclaredConstructor(parameterTypes);//public,private,protected,..
		//2.设置构造方法可访问(假如是私有)
		con.setAccessible(true);
		//3.基于构造方法对象构建类的实例
		return (T)con.newInstance(args);
	}
}
