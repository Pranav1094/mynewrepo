package com.test.repository;

import java.util.List;

import com.test.bean.CollegeLog;
import com.test.bean.Register;

public interface RegisterRepository {

	public void create(Register register);
	public void create(CollegeLog collegeLog);
	public List<CollegeLog> aggregationByAll();
	public void drop();
}
