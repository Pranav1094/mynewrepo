package com.test.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.beans.School;

public interface SchoolService extends MongoRepository<School, String> {

}
