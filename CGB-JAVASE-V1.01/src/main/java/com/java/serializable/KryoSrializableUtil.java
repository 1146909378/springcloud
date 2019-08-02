package com.java.serializable;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
//基于Kryo框架实现对象序列化和反序列化.
/**
 * kryo 对象是一个线程不安全对象,不循序多线程共享
 * 可以每个线程有一份,那如何保证每个线程此类的实例
 * 只有一份呢?可以借助ThreadLocal实现
 * 
 * ThreadLocal 提供一种线程绑定机制,可以基于此
 * 对象将某个对象绑定当前线程中,也可以冲当前线程获取
 * 某个对象.
 * 1)set() 绑定
 * 2)get() 获取
 */
public class KryoSrializableUtil {
	//static Kryo kryo = new Kryo();//线程共享
	static private final ThreadLocal<Kryo> kryos 
	= new ThreadLocal<Kryo>() {
	//获取当前线程中Kryo对象时,假如线程中没有此对象
	//此时会调用initialValue创建对象并通过set方
	//法绑定当前线程
	protected Kryo initialValue() {
	Kryo kryo = new Kryo();
	//将默认类的自动注册功能关闭
	kryo.setRegistrationRequired(false);
	// Configure the Kryo instance.
	return kryo;
	};
};
	//序列化
	public static <T extends Serializable>byte[] 
	serializable(T t){
		//1.构建kryo对象
//		Kryo k = new Kryo();
		//将默认类的自动注册功能关闭
//		k.setRegistrationRequired(false);
		//2.构建字节数组输出流(内置可扩容数据)
		ByteArrayOutputStream bos 
		= new ByteArrayOutputStream ();
		//3.构建处理流output对象
		Output output = new Output(bos);
		//4.将对象序列化
		kryos.get().writeObject(output, t);
		output.flush();
		byte[] array = bos.toByteArray();
		output.close();
		return array;
	}
	//反序列化
	public static<T>T 
		deserialization(byte[] array,Class<T> cls){
		//1.构建kryo对象
//		Kryo k = new Kryo();
		//2.构建input对象(负责读字节数据)
		Input input = new Input(array);
		//3.反序列化数据
		T t = (T)kryos.get().readObject(input, cls);
		input.close();
		return t;
	}
}
