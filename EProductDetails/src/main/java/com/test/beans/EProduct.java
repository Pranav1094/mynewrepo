package com.test.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EProduct {

	private String name;
	@Id
	private String id;
	private String category;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public EProduct(String name, String id, String category) {
		super();
		this.name = name;
		this.id = id;
		this.category = category;
	}
	public EProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
}