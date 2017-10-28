package com.test.lamda;

import java.util.function.Function;

public class App {

	public static void main(String[] args) {
		System.out.println(process("Hello WOrld",str ->str.toLowerCase()));
	}
	
	private static
	String process(String str, Function<String, String> processor){
		return processor.apply(str);
	}

}
