package com.java.serializable;

import java.io.ByteArrayOutputStream;
import java.util.Date;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class TestSerializable07 {
	public static void main(String[] args) {
		Mail m = new Mail();
		m.setId(100);
		m.setTitle("tedu");
		m.setContent("tedu-cgb1903");
		m.setCreatedTime(new Date());
		//基于Kryo将对象序列化
		byte[] array = KryoSrializableUtil.serializable(m);
		System.out.println("序列化OK");
		//基于Kryo框架将对象反序列化
		Mail m2 = KryoSrializableUtil.deserialization(array,Mail.class);
		System.out.println(m2);
		
	}
}
