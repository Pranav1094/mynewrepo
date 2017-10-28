package com.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.beans.Customer;

public interface CustomerRepository extends MongoRepository<Customer,String> {

}
