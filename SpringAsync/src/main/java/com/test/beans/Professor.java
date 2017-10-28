package com.test.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Professor {
	
	String name;
	String blog;
	public Professor(String name, String blog) {
		super();
		this.name = name;
		this.blog = blog;
	}
	public Professor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	@Override
	public String toString() {
		return "Professor [name=" + name + ", blog=" + blog + "]";
	}
	

}
