package com.test.hashMap;

import java.util.HashMap;
import java.util.Map;

public class Hash2 {

	public static void main(String[] args) {

		Map<String, Books> map = new HashMap<String, Books>();

		Books book1 = new Books("MyDrama", "Pran", 1223);
		Books book2 = new Books("Bhagavadgita", "Krishna", 02215);
		Books book3 = new Books("Saa", "Das", 456);

		map.put("One", book1);
		map.put("two", book2);
		map.put("Three", book3);
		
		for(Map.Entry<String, Books> getBooks:map.entrySet()){
			
			String key = getBooks.getKey();
			Books b = getBooks.getValue();
			
			System.out.println("Book number : " +key);
			System.out.println("Name is  " +b.name+  ", Author is "  +b.author+ ", Id is " +b.Id);
		}
		

	}

}
