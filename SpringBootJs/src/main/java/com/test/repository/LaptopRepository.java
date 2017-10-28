package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.beans.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,String>{

	public Laptop findOne(int laptopId);

	public Laptop delete(int laptopId);

	public Laptop isValid();

}
