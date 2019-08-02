package com.java.serializable;

import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 * 1)广义的序列化:将对象转换为json格式字符串
 * 2)广义的反序列化:将json格式字符串转换为对象
 */
public class TestSerializable05 {
	public static void main(String[] args)throws Exception {
		//JSON格式的字符串
		String s1="{\"id\":10,\"title\":\"cgb\"}";
		//构建一个mail对象
		Mail mail=new Mail();
		mail.setId(1001);
		mail.setTitle("tedu");
		mail.setContent("tedu-cgb");
		mail.setCreatedTime(new Date());
		//将mail对象转换为json格式字符串.(借助jackson api)
		String s2=JSON.toJSONString(mail);
		System.out.println(s2);
		//将json格式的字符串转换为对象
		Mail mail2=JSON.parseObject(s2, Mail.class);
		System.out.println(mail2);
	}
}







