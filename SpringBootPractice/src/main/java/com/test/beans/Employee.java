package com.test.beans;

public class Employee {
int eid;
String ename;
String ecity;

public Employee(){
	super();
}

public int getEid() {
	return eid;
}

public void setEid(int eid) {
	this.eid = eid;
}

public String getEname() {
	return ename;
}

public void setEname(String ename) {
	this.ename = ename;
}

public String getEcity() {
	return ecity;
}

public void setEcity(String ecity) {
	this.ecity = ecity;
}

@Override
public String toString() {
	return "Employee [eid=" + eid + ", ename=" + ename + ", ecity=" + ecity + "]";
}

public Employee(int eid, String ename, String ecity) {
	super();
	this.eid = eid;
	this.ename = ename;
	this.ecity = ecity;
}

}
