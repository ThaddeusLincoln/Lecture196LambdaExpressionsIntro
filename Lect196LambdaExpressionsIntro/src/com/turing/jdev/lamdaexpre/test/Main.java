package com.turing.jdev.lamdaexpre.test;

public class Main {
	
	public static void main(String[] args){
	
		new Thread(()->System.out.println("Mostrando texto desde lamda expression, el cual usa Runnable")).start();
		
	}
}
