package com.turing.jdev.lamdaexpre.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
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
		
		// passing lambda expressions as predicate
		printEmployeesByAge(employees, "\nEmployees over 40", employee -> employee.getAge() > 40);
		printEmployeesByAge(employees, "\nEmployees under 40", employee -> employee.getAge() <= 40);
		
		// using an anonymous class instead of a lambda expression
		printEmployeesByAge(employees, "\nEmployees under 35", new Predicate<Employee>() {
			
			@Override
			public boolean test(Employee employee) {
				return employee.getAge() <= 35;
			}
		});
		
		// now we're trying to chain 2 Predicates
		IntPredicate greaterThan15 = i -> i > 15;
		IntPredicate lessThan100 = i -> i < 100;
		
		System.out.println("Testing Predicates Chaining ================");
		System.out.println(greaterThan15.and(lessThan100).test(50));
		
		
		
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


