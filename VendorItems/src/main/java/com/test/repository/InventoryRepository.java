package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.beans.Items;
@Repository
public interface InventoryRepository extends JpaRepository<Items, Integer>{

}
