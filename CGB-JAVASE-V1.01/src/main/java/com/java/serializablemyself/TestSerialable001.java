package com.java.serializablemyself;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

class SysLog1 implements Serializable{
	/**日志id*/
	private static final long serialVersionUID = -7582113134854805016L;
	private Integer id;
	private String username;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "SysLog [id=" + id + ", username=" + username + "]";
	}
	/**此方法会在调用对象流的的writeObject方法时执行*/
	private void writeObject(ObjectOutputStream out) 
			throws Exception {
		//1.获取一个加密对象
		Base64.Encoder encoder = Base64.getEncoder();
		//2.对内容进行加密
		byte[] array = encoder.encode(username.getBytes());
		//3.将加密结果重新赋值给username
		username = new String(array);
		//4.执行默认序列化
		out.defaultWriteObject();
	}
	private void readObject(ObjectInputStream in) 
			throws Exception {
		//1.执行默认反序列化
		in.defaultReadObject();
		//2.获取解密对象
		Base64.Decoder decoder = Base64.getDecoder();
		//3.执行解密操作
		byte[] array = decoder.decode(username);
		username = new String(array);
	}
}
public class TestSerialable001 {
	public static void main(String[] args) throws Exception {
		//1.构建日志对象,存储数据
		SysLog1  log = new SysLog1();
		log.setId(100);
		log.setUsername("admin");
		
		//2.构建对象输出流,将日志对象存储到文件
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("f2.data"));
		out.writeObject(log);
		out.writeInt(100);//整数序列化
		System.out.println("序列化ok");
		out.close();
		//3.将文件中的日志输出
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("f2.data"));
		SysLog1 obj = (SysLog1) in.readObject();
		Integer result = in.readInt();//整数反序列化
		System.out.println(result);
		in.close();
		System.out.println(obj);
	}
}
