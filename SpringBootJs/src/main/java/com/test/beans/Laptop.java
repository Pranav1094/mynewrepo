package com.test.beans;

import org.springframework.data.annotation.Id;

public class Laptop {

	private String laptopName;

	private int laptopModel;
	@Id
	private String laptopId;
	private String laptopProcessor;

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public int getLaptopModel() {
		return laptopModel;
	}

	public void setLaptopModel(int laptopModel) {
		this.laptopModel = laptopModel;
	}

	public String getLaptopId() {
		return laptopId;
	}

	public void setLaptopSerialId(String laptopId) {
		this.laptopId = laptopId;
	}

	public String getLaptopProcessor() {
		return laptopProcessor;
	}

	public void setLaptopProcessor(String laptopProcessor) {
		this.laptopProcessor = laptopProcessor;
	}

	public Laptop(String laptopName, int laptopModel, String laptopId, String laptopProcessor) {
		super();
		this.laptopName = laptopName;
		this.laptopModel = laptopModel;
		this.laptopId = laptopId;
		this.laptopProcessor = laptopProcessor;
	}

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
}
