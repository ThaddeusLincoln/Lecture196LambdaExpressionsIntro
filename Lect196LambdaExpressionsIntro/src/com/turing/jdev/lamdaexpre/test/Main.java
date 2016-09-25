package com.turing.jdev.lamdaexpre.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
	
	public static void main(String[] args){
		
		Employee abraham = new Employee("Abraham Lincoln", 50);
		Employee rosa = new Employee("Rosa Parks", 35);
		Employee thaddeuss = new Employee("Thaddeus Stevens", 38);
		Employee alexander = new Employee("Alejandro Magno", 32);
		Employee martinL = new Employee("Martin Luther King", 42);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(rosa);
		employees.add(thaddeuss);
		employees.add(abraham);
		employees.add(alexander);
		employees.add(martinL);
		
		// 
		printEmployeesByAge(employees, "Employees over 40", employee -> employee.getAge() > 40);
		printEmployeesByAge(employees, "Employees under 40", employee -> employee.getAge() <= 40);
		
	}
	
	/**
	 * Given a predicate it  determines the employees that matches it.
	 */
	private static void printEmployeesByAge(List<Employee> employees,
											String agetText, Predicate<Employee> ageCondition ){
		
		System.out.println(agetText);
		System.out.println("=========================");
		for(Employee employee : employees){
			if(ageCondition.test(employee)){
				System.out.println(employee.getName());
			}
		}
		
		
	}
	
}


