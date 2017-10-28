package com.test.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Items {

	int itemId;
	String itemName;
	String itemCategorty;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCategorty() {
		return itemCategorty;
	}

	public void setItemCategorty(String itemCategorty) {
		this.itemCategorty = itemCategorty;
	}

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", itemCategorty=" + itemCategorty + "]";
	}

	public Items() {
		// TODO Auto-generated constructor stub
	}

	public Items(int itemId, String itemName, String itemCategorty) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategorty = itemCategorty;
	}

}
