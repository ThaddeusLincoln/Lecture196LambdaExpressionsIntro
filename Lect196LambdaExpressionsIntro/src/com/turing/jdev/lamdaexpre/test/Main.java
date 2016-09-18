package com.turing.jdev.lamdaexpre.test;

public class Main {
	
	public static void main(String[] args){
	
		new Thread(()->{
			
			System.out.println("Mostrando texto desde lamda expression, el cual usa Runnable");
			System.out.println("Line 2");
			System.out.println("This is line 3 of the body of the LAMBDA-EXPRESSION");
			
			
		}).start();
		
	}
}
