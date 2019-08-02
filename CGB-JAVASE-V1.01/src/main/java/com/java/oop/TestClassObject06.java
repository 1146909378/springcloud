package com.java.oop;
import java.util.Date;
/**
 * 编写对象工厂,通过工厂基于类的字节码对象创建类的实例对象
 * @author 000
 *
 */
class ClassF{}
//构建一对象工厂对象,此工厂可以基于类的字节码对象
//构建类的实例对象.
class ObjectFactory{//对象工厂			
	public static Object newInstance
		(Class<?> cls) //这是形参或者说是变量
		throws Exception{
		//基于字节码对象创建类的实例 对象
		//字节码对象是构建类的实例对象的"模版对象"
		return cls.newInstance();
	}
	//<bean id="" class="pkg.ClassName"> 第二种构建实例方法
	public static Object newInstance //这个和第一个方法构成重载关系
		(String className)
		throws Exception{
		Class<?> cls=Class.forName(className);
		return cls.newInstance();//创建类的实例对象
	}
} 
public class TestClassObject06 {
    public static void main(String[] args) throws Exception{
    	//一个字节码对象,三个实例对象					      这是要传的对象
    	Date date=(Date)ObjectFactory.newInstance(Date.class);
    		//又让这个date变量指向了新的对象
    		 date=(Date)ObjectFactory.newInstance(Date.class); 
    	Date date2 = date=(Date)ObjectFactory.newInstance(Date.class);
	    System.out.println(date);
	    //用这个ObjectFactory这个工厂构建一个对象
	    ClassF cf = (ClassF)ObjectFactory.newInstance(ClassF.class);
	    //这是第二种构建实例 方式
	    date=(Date)ObjectFactory.newInstance("java.util.Date");
	    
    }
}
