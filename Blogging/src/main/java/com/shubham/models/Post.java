package com.shubham.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class Post 
{
	@Id
	private int Id;
	private String title;
	private String content;
	
	public Post()
	{
		
	}
	public Post(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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


	@Override
	public String toString() {
		return "Post [Id=" + Id + ", title=" + title + ", content=" + content
				+ "]";
	}
	
	
}
