package com.java.serializablemyself;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SysLog implements Serializable{
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
	
	
}
public class TestSerialable01 {
	public static void main(String[] args) throws Exception {
		//1.构建日志对象,存储数据
		SysLog  log = new SysLog();
		log.setId(100);
		log.setUsername("admin");
		//2.构建对象输出流,将日志对象存储到文件
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("f1.data"));
		out.writeObject(log);
		out.writeInt(100);//整数序列化
		System.out.println("序列化ok");
		out.close();
		//3.将文件中的日志输出
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("f1.data"));
		SysLog obj = (SysLog) in.readObject();
		Integer result = in.readInt();//整数反序列化
		System.out.println(result);
		in.close();
		System.out.println(obj);
	}
}
