package com.java.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Message implements Externalizable{
	private Integer id;//10
	private String title;
	private String content;
	private String createdTime;
	//对象序列化时调用,在方法内部自己指定序列化过程
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		out.writeUTF(title);
	}
	//对象反序列化时调用
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id=in.readInt();
		title=in.readUTF();
	}
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
		return "Message [id=" + id + ", title=" + title + ", content=" + content + ", createdTime=" + createdTime + "]";
	}
}
