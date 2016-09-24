package com.turing.jdev.lamdaexpre.test;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args){
		
		Employee abraham = new Employee("Abraham Lincoln", 50);
		Employee rosa = new Employee("Rosa Parks", 35);
		Employee thaddeuss = new Employee("Thaddeus Stevens", 38);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(rosa);
		employees.add(thaddeuss);
		employees.add(abraham);
		
		/*AnotherClass anotherClass = new AnotherClass();
		String s = anotherClass.doSomething();
		System.out.println(s);*/
		
		for(Employee employee : employees){
			System.out.println(employee.getName());
			new Thread( () -> System.out.println(employee.getAge())).start();
		}
		
		
	}
	
	// this method is pretty useless, its purpose is to be used as sample when a
	// lambda expression will have more than one line of code
	public final static String doStringStuff(UpperConcat uc, String s1, String s2){
		return uc.upperConcat(s1, s2);
	}
}

class Employee{
	
	private String name;
	private int age;
	
	public Employee(String name, int age){
		this.setName(name);
		this.setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}

/**
 *Interface with simple method that all it does is upper case two strings
 */
interface UpperConcat {
	public String upperConcat(String s1, String s2);
}

class AnotherClass {
	
	public String doSomething(){
		
		// TODO : in the next lecture we'll see how lambda expressions are treated like in nested blocks
		int i = 0;

		// modifying the arrays value would cause a compile error
		// i++;
		
		// we're going to use a lambda now instead
		UpperConcat uc = (s1, s2) -> {
			System.out.println("The lambda expression class's name is: " + getClass().getSimpleName());
			
			System.out.println("i in the lambda expression = " + i);
			
			String result = s1.toUpperCase() + s2.toUpperCase();
			return result;
		};
		
		System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
		return Main.doStringStuff(uc, "String1", "String2");
		
	}
	
	public void printValue(){
		
		int number = 25;
		Runnable r = () -> {
			
			try{
				Thread.sleep(5000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("The value is " + number);
			
		};
		
	}
	
}