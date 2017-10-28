package com.test.repository;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.previousOperation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;

import com.test.bean.CollegeLog;
import com.test.bean.Register;

public class RegisterRepositoryImpl implements RegisterRepository {

	private static final String COLLECTION1 = "registerLog";
	private static final String COLLECTION = "CollegeLog";

	@Autowired
	MongoTemplate mongotemplate;

	@Override
	public void create(Register register) {
		if (register != null) {
			this.mongotemplate.insert(register, COLLECTION);
		}

	}

	@Override
	public void create(CollegeLog collegeLog) {
		this.mongotemplate.insert(collegeLog, COLLECTION1);

	}

	@Override
	public List<CollegeLog> aggregationByAll() {
		Aggregation aggregation = new Aggregation(group("name", "city").push("city").as("recCity"),sort(Sort.Direction.ASC, previousOperation(), "name"));
		return null;
	}

	@Override
	public void drop() {	
		// TODO Auto-generated method stub

	}

}
