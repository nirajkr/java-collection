package com.example.demo;

import java.util.*;
import java.util.stream.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		sumOfEvenNumber();
		convertListToOther();
		filterList();
		findElement();
		findMaxMin();
	}
	

	public static void sumOfEvenNumber() {
		int[] intArray = {23,45,76,12,67,89};
		Arrays.stream(intArray).filter(i -> i %2==0).reduce(Integer::sum)
				.ifPresent(s -> System.out.println("Sum: " + s));
		
	}
	
	//Convert List of objects to another List of objects
	public static void convertListToOther() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("niraj", 18));
		students.add(new Student("dinesh", 38));
		
		List<String> names = students.stream().map(p -> p.getName()).collect(Collectors.toList());
		System.out.println(names);
	}
	
	//Create new list by filtering elements
	public static void filterList() {
		
		List<Integer> numbers = Stream.iterate(1, n -> n + 1).limit(20).collect(Collectors.toList());
		List<Integer> evenNumbers = numbers.stream().filter(n -> (n.intValue() % 2 == 0))
				.collect(Collectors.toList());
		System.out.println(evenNumbers);		
	}
	
	//find element from a List
	public static void findElement() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Ram", 18));
		students.add(new Student("Shyam", 20));
		
		Optional<Student> result = students.stream().filter(p -> p.getName().equals("Ram")).findAny();
		if (result.isPresent()) {
			System.out.println(result.get().getAge());
		} else {
			System.out.println("Not Found");
		}
	}
	
	public static void findMaxMin() {
		List<Integer> integers = Arrays.asList(3, 5, 45, 52, 5, 14);
		
		Optional<Integer> max = integers.stream().max(Comparator.naturalOrder());
		Optional<Integer> min = integers.stream().min(Comparator.naturalOrder());
		
		System.out.println("Max: " + max.get());
		System.out.println("Min: " + min.get());
	}
}
