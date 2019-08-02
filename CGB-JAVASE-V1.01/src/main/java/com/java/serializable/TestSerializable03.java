package com.java.serializable;

import java.util.Date;

public class TestSerializable03 {
	public static void main(String[] args)throws Exception {
		Mail obj = new Mail();
		obj.setId(200);
		obj.setTitle("tedu");
		obj.setContent("tedu-cgb1903");
		obj.setCreatedTime(new Date());
		//序列化
		SerializationUtil.doSerialization(obj,"text.xml");
		//反序列化
		Mail obj2 =SerializationUtil.doDeserialization("text.xml");
		System.out.println(obj2);
	}
	
}
