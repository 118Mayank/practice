package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test_3 {

	// odd even from range
	public static void main1(String[] args) {
		IntStream.range(1, 20).filter(a -> a % 2 == 0).forEach(System.out::println);
	}

	// odd even from given array
	public static void main2(String[] args) {
		int[] intarr = { 1, 4234, 2424, 2434, 4324, 434, 23432, 434, 453, 667, 655, 42, 424 };
		Arrays.stream(intarr).filter(a -> a % 2 == 0).forEach(System.out::println);
	}

	public static void main3(String[] args) {

		List<Emp>empList=new ArrayList<>();
		empList.add(new Emp(1L, "Raj", "HR", 20000));
		empList.add(new Emp(1L, "Ram", "IT", 30000));
		empList.add(new Emp(1L, "Ron", "HR", 50000));
		empList.add(new Emp(1L, "Aman", "IT", 60000));
		empList.add(new Emp(1L, "Hima", "Dev", 80000));
		empList.add(new Emp(1L, "Hina", "IT", 30000));
		empList.add(new Emp(1L, "Haxa", "Dev", 50000));
		empList.add(new Emp(1L, "Hiza", "Admin", 100000));
		empList.stream().collect(Collectors.groupingBy(Emp::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Emp::getSalary))))
		.forEach((department, employee) -> {System.out.println(department + ": " + employee.orElse(null));
        });

	}
	//max salary
	public static void main4(String[] args) {
		List<Emp>empList=new ArrayList<>();
		empList.add(new Emp(1L, "Raj", "HR", 20000));
		empList.add(new Emp(1L, "Ram", "IT", 30000));
		empList.add(new Emp(1L, "Ron", "HR", 50000));
		empList.add(new Emp(1L, "Aman", "IT", 60000));
		empList.add(new Emp(1L, "Hima", "Dev", 80000));
		empList.add(new Emp(1L, "Hina", "IT", 30000));
		empList.add(new Emp(1L, "Haxa", "Dev", 50000));
		empList.add(new Emp(1L, "Hiza", "Admin", 100000));
		Optional<Emp> emp=empList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Emp::getSalary)));
System.out.println(emp);
	}

	//Nth max salary
	public static void main(String[] args) {
		int n=2;
		List<Emp>empList=new ArrayList<>();
		empList.add(new Emp(1L, "Raj", "HR", 20000));
		empList.add(new Emp(1L, "Ram", "IT", 30000));
		empList.add(new Emp(1L, "Ron", "HR", 50000));
		empList.add(new Emp(1L, "Aman", "IT", 60000));
		empList.add(new Emp(1L, "Hima", "Dev", 80000));
		empList.add(new Emp(1L, "Hina", "IT", 30000));
		empList.add(new Emp(1L, "Haxa", "Dev", 50000));
		empList.add(new Emp(1L, "Hiza", "Admin", 100000));
		empList.stream().sorted(Comparator.comparingDouble(Emp::getSalary).reversed()).skip(n-1).limit(1).forEach(System.out::println);
	}
}
