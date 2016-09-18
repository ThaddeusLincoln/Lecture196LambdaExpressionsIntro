package com.turing.jdev.lamdaexpre.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	
	public static void main(String[] args){
	
		new Thread(()->{
			
			System.out.println("Mostrando texto desde lamda expression, el cual usa Runnable");
			System.out.println("Line 2");
			System.out.println("This is line 3 of the body of the LAMBDA-EXPRESSION");
			
			
		}).start();
	
		// 
		Employee abraham = new Employee("Abraham Lincoln", 50);
		Employee rosa = new Employee("Rosa Parks", 35);
		Employee thaddeuss = new Employee("Thaddeus Stevens", 38);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(rosa);
		employees.add(thaddeuss);
		employees.add(abraham);
		
		// let's sort the employees by name in descending order without using Lambda-Expressions
		// and using the COMPARATOR-Interface
		
		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee employee1, Employee employee2) {
				return employee1.getName().compareTo(employee2.getName());
			}
			
		});
		
		for(Employee employee : employees){
			
			System.out.println(employee.getName());
		}
		
		
		
		
		
	
		
		
		
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