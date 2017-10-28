package com.test.beans;

import java.io.Serializable;

public class Customer implements Serializable {

	String customerName;
	String customerId;
	String customerAge;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(String customerAge) {
		this.customerAge = customerAge;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerName, String customerId, String customerAge) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
		this.customerAge = customerAge;
	}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerId=" + customerId + ", customerAge=" + customerAge
				+ "]";
	}
}
