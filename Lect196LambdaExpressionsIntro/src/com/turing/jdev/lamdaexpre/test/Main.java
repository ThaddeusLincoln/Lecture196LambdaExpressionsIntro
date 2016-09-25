package com.turing.jdev.lamdaexpre.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
		
		// we're going to try Function interface
		
		// 1. getting last name
		Function<Employee, String> getLastName = (Employee employee)-> {
			return employee.getName().substring(employee.getName().indexOf(' ') + 1);
		};
		
		//2. getting first name
		Function<Employee, String> getFirstName = (Employee employee)-> {
			return employee.getName().substring(0, employee.getName().indexOf(' '));
		};
		
		String lastName = getLastName.apply(employees.get(1));
		System.out.println(lastName);
		
		Random random1 = new Random();
		for(Employee employee : employees){
			if(random1.nextBoolean()){
				System.out.println(getAName(getFirstName, employee));
			}else{
				System.out.println(getAName(getLastName, employee));
			}
		}
		
		// sample of chaining functions 
		Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
		Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
		Function chainedFunction = upperCase.andThen(firstName);
		System.out.println(chainedFunction.apply(employees.get(0)));
		
	}
	
	private static String getAName(Function<Employee, String> getName, Employee employee){
		return getName.apply(employee);
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


