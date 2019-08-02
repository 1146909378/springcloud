package com.java.serializablemyself;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class TestExternalizable implements Externalizable {
	private Integer id;
	private String title;
	private String content;
	private String createdTime;
	private transient Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return "TestExternalizable [id=" + id + ", title=" + title + ", content=" + content + ", createdTime="
				+ createdTime + "]";
	}
	
	//序列化时调用
	@Override
	public void writeExternal(ObjectOutput out) 
			throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(title);
	}
	//发序列化调用
	@Override
	public void readExternal(ObjectInput in) 
			throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		title=in.readUTF();
	}

	public static void main(String[] args) 
			throws Exception {

		//1.构建日志对象,存储数据
		TestExternalizable Ex = new TestExternalizable();
		Ex.setId(100);
		Ex.setTitle("admin");
		
		//2.构建对象输出流,将日志对象存储到文件
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("f3.data"));
		out.writeObject(Ex);
		out.writeInt(100);//整数序列化
		System.out.println("序列化ok");
		out.close();
		//3.将文件中的日志输出
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("f3.data"));
		TestExternalizable obj = (TestExternalizable) in.readObject();
		Integer result = in.readInt();//整数反序列化
		System.out.println(result);
		in.close();
		System.out.println(obj);
	
	}

}
class Test{
	
}