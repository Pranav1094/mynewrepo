package com.test.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Arrays1 {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("Sam");
		list.add("Pra");
		list.add("Dj");
		list.add("Har");
		
		for(String al:list){
			System.out.println(al);
		}

	}

}
