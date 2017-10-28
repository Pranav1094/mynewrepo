package com.test.bean;

import java.util.List;

public class CollegeLog {

	private String name;
	private List<Object> recCity;
	private String city;
	public CollegeLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CollegeLog(String name, List<Object> recCity, String city) {
		super();
		this.name = name;
		this.recCity = recCity;
		this.city = city;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public List<Object> getRecCity() {
		return recCity;
	}
	public void setRecCity(List<Object> recCity) {
		this.recCity = recCity;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "CollegeLog [name=" + name + ", recCity=" + recCity + ", city=" + city + "]";
	}
	

}

