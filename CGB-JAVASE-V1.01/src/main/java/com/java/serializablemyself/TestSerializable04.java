package com.java.serializablemyself;

import com.fasterxml.jackson.databind.ObjectMapper;

// "id":10,"title":"Tom"
public class TestSerializable04 {
	public static void main(String[] args) throws Exception {
//		String t1 = "{\"id\":10,\"title\":\"Tom\"}";
		Mail mail = new Mail();
		mail.setId(1001);
		mail.setTitle("测试");
		//构建json的对象转换器
		ObjectMapper om = new ObjectMapper();
		//将对象转换为json格式的字符串(序列化)
		String json = om.writeValueAsString(mail);
		System.out.println(json);
		//将字符串转换为json的对象(反序列化)
		Mail bb = om.readValue(json,Mail.class);
		System.out.println(bb);
	}
}
