package com.java.serializable;

import java.io.ByteArrayOutputStream;
import java.util.Date;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class TestSerializable06 {
	public static void main(String[] args) {
		Mail m = new Mail();
		m.setId(100);
		m.setTitle("tedu");
		m.setContent("tedu-cgb1903");
		m.setCreatedTime(new Date());
		//基于Kryo将对象序列化
		Kryo kryo = new Kryo();
		//将默认类的自动注册功能关闭
		kryo.setRegistrationRequired(false);
//		kryo.register(Mail.class);
//		kryo.register(Date.class);
		ByteArrayOutputStream bos 
		= new ByteArrayOutputStream();
		Output output = new Output(bos);
		kryo.writeObject(output, m);//写入到memory
		output.close();
		System.out.println("序列化OK");
		//基于Kryo框架将对象反序列化
		byte[] data = bos.toByteArray();
		Input input = new Input(data);
		Mail m2 
		= kryo.readObject(input, Mail.class);
		input.close();
		System.out.println(m2);
		
	}
}
