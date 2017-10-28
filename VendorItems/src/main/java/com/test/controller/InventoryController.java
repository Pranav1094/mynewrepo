package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.beans.Items;
import com.test.inventory.InventoryStatusImpl;

@RestController
public class InventoryController {
	
	@Autowired
	InventoryStatusImpl invent;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Items saveItems(@RequestBody Items items){
		return invent.saveRec(items);
	}
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public List<Items> find(@RequestBody Items items){
	return  invent.findAll();
	}
	
	@RequestMapping(value="/findOne/{id}", method= RequestMethod.GET)
	public ResponseEntity<Items> findOne(@PathVariable int itemId){
		Items items = invent.findOne(itemId);
		if(items==null){
			return new ResponseEntity<Items>(HttpStatus.NOT_FOUND);
		}
		else
			return new ResponseEntity<Items>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteAll", method=RequestMethod.DELETE)
	public void deleteAll(@RequestBody Items items){
		 invent.deleteAll();
	}
	
	@RequestMapping(value="/deleteAll/{id}", method=RequestMethod.DELETE)
	public void deleteOne(@PathVariable Integer itemId){
		invent.deleteOne(itemId);
		
	}
	
	
}
