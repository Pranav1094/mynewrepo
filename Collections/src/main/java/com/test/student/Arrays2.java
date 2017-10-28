package com.test.student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arrays2 {

	public static void main(String[] args) {
		
		Student s1 = new Student(12,"Sam");
		Student s2 = new Student(13,"ram");
		
		List<Student> list = new ArrayList<Student>();
		
		list.add(s1);
		list.add(s2);
		
		Iterator itr = list.iterator();
		
		while(itr.hasNext()){
			Student student = (Student)itr.next();
			
			System.out.println("Age = " + student.age+ "," + "Name is :" + student.name);
		}
		

	}

}
