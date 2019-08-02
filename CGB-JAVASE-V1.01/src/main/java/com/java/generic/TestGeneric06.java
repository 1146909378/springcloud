package com.java.generic;
import java.util.Date;

//对象工厂
class ObjectFactory{
	//泛型方法   (传什么类型,就帮你构建什么类型对象)
	public static <T>T newInstance(Class<T > cls)
	throws Exception{
		return cls.newInstance();//newInstance是一个泛型方法
	}
}
public class TestGeneric06 {
    public static void main(String[] args)throws Exception {
    	//这里用了泛型后,就不用强转了
    	Date date=ObjectFactory.newInstance(Date.class);
    	System.out.println(date);
	}
}
/**
  *  总结练习:
 * interface LinkedContainer<M>{}
 * class FlashMap<V> extends HashMap<String,V>
 * class StringUtil{
 *      static <T>T connect(T t){}
 * }
 */