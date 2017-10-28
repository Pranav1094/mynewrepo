package com.test.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arrays {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("Sam");
		list.add("tim");
		list.add("Har");

		Iterator itr = list.iterator();
		{
			while (itr.hasNext()) {

				System.out.println(itr.next());

			}

		}
		;
	}

}
