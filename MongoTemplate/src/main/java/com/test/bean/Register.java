package com.test.bean;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registerLog")
public class Register {

	private String name;
	private int age;
	private String city;
	private String country;

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Register(String name, int age, String city, String country) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Register [name=" + name + ", age=" + age + ", city=" + city + ", country=" + country + "]";
	}

}
