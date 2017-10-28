package com.test.beans;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class School implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String schoolName;
	@Id
	private String schoolId;

	public School() {
		super();
		// TODO Auto-generated constructor stub
	}

	public School(String schoolName, String schoolId) {
		super();
		this.schoolName = schoolName;
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
}
