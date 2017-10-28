package com.test.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.beans.Items;
import com.test.repository.InventoryRepository;

@Service
public class InventoryStatusImpl implements InventoryStatus{

	@Autowired
	InventoryRepository status; 
	public Items saveRec(Items items){
		return status.save(items);
	}
	
	public List<Items> findAll(){
		  return status.findAll();
		
	}
	public Items findOne(Integer itemId){
		return status.findOne(itemId);
	}
	public void deleteOne(Integer itemId){
		 status.delete(itemId);
	}
	public void deleteAll(){
		status.deleteAll();
	}
}
