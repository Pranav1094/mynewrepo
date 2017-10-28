package com.test.hashMap;

import java.util.HashMap;
import java.util.Map;

public class Hash1 {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("name1", "ram");
		map.put("name2", "sham");
		map.put("name3", "dj");

		for (Map.Entry<String, String> set : map.entrySet()) {
			
			String name = set.getKey();
			String naValue=set.getValue();

			System.out.println(name  + ","  + naValue );
		}

	}

}
