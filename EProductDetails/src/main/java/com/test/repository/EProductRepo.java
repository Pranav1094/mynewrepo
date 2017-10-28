package com.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.beans.EProduct;
//to use the mongoRepoaitory functions I am extending the mongoRepository which has CRUD methods predefined in it and it takes Eproduct as input with type String
public interface EProductRepo extends MongoRepository<EProduct, String> {

	

}
