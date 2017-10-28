package com.test.inventory;

import java.util.List;

import com.test.beans.Items;

public interface InventoryStatus {

	public Items saveRec(Items items);
	public List<Items> findAll();
	public Items findOne(Integer itemId);
	public void deleteOne(Integer itemId);
	public void deleteAll();

}