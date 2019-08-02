package com.java.serializable;

import java.io.Serializable;
import java.util.Date;

public class Mail implements Serializable{
	private static final long serialVersionUID = 6599166688654530165L;
	private Integer id;
	private String title;
	private String content;
	private Date createdTime;
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
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "Mail [id=" + id + ", title=" + title + ", content=" + content + ", createdTime=" + createdTime + "]";
	}

}
