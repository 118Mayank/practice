package com.example.demo.controller;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test_1 {

	public static void main1(String arg[]) {
		for (int i = 0; i <= 5; i++) {
			for (int j = 5 - i; j >= 0; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	public static void main2(String arg[]) {
		main1(arg);
		int[] a = { 2, 3, 4, 9, 9, 9 };
		int b[] = { 2, 3, 9 };
		int c[] = { 2, 8, 3 };
		int[] z1 = Arrays.stream(a).filter(i -> Arrays.stream(b).boxed().collect(Collectors.toList()).contains(i)
				&& Arrays.stream(c).boxed().collect(Collectors.toList()).contains(i)).toArray();
		System.out.println(Arrays.toString(z1));

	}

	public static void main3(String arg[]) {
		int[] a = { 2, 3, 4, 9, 9, 9 };
		int b[] = { 2, 3, 9 };
		int c[] = { 2, 8, 3 };

		Stream<Integer> aList = Arrays.stream(a).boxed();
		List<Integer> bList = Arrays.stream(b).boxed().collect(Collectors.toList());
		List<Integer> cList = Arrays.stream(c).boxed().collect(Collectors.toList());

		List<Integer> d = aList.filter(x -> bList.contains(x) && cList.contains(x)).collect(Collectors.toList());
		Object[] arrayd = aList.filter(x -> bList.contains(x) && cList.contains(x)).toArray();
		System.out.println(d);

	}

	public static void main4(String[] args) {
		int n = 1;
		List<Emp> empList = new ArrayList<>();
		empList.add(new Emp(1L, "Raj", "HR", 20000));
		empList.add(new Emp(1L, "Ram", "IT", 30000));
		empList.add(new Emp(1L, "Ron", "HR", 50000));
		empList.add(new Emp(1L, "Aman", "IT", 60000));
		empList.add(new Emp(1L, "Hima", "Dev", 80000));
		empList.add(new Emp(1L, "Hina", "IT", 30000));
		empList.add(new Emp(1L, "Haxa", "Dev", 50000));
		empList.add(new Emp(1L, "Hiza", "Admin", 100000));
		empList.stream()
				.collect(Collectors.groupingBy(Emp::getDepartment,
						Collectors.maxBy(Comparator.comparingLong(Emp::getSalary))))
				.forEach((dep, emp) -> System.out.println(dep + " dept: " + emp));
		System.out.println("------------");
		empList.stream().sorted(Comparator.comparingLong(Emp::getSalary).reversed()).skip(n - 1).limit(1)
				.forEach(System.out::println);
	}

	public static void main5(String[] args) {
		int n = 1;
		int[] intarr = { 1, 4235, 2424, 2434, 4224, 434, 23432, 434, 453, 667, 655, 42, 424 };
		Arrays.stream(intarr).sorted().skip(intarr.length - n - 1).limit(1).forEach(System.out::print);
	}

	public static void main6(String[] args) {
		String[] strArr = { "apple", "banana", "cherry" };
		Set<String> strList = new TreeSet<>();
		Arrays.stream(strArr).forEach(a -> Arrays.stream(a.split("")).forEach(b -> strList.add(b)));
		System.out.println(strList);
	}

	public static void main7(String[] args) {
		String[] strArr = { "apple", "banana", "cherry" };
		Map<String, Integer> strList = new HashMap<>();
		Arrays.stream(strArr).forEach(a -> Arrays.stream(a.split(""))
				.forEach(b -> strList.put(b, strList.containsKey(b) ? strList.get(b) + 1 : 1)));
		strList.entrySet().stream().filter(a -> a.getValue() == 1).forEach(System.out::println);
	}

	public static void main8(String[] args) {
		int i = 50;
		int[] intList = { 9, 5, 1, 2, 3, 4, 6, 7, 8, 0 };
		Arrays.stream(intList).sorted().skip(intList.length - i).limit(1).forEach(System.out::print);
		;
	}

	public static void main9(String[] args) {
		String[] str = { "gergger", "gerger", "ferge", "sss", "sss" };
		Set<String> strSet = new HashSet<>();
		Arrays.stream(str).filter(s -> !strSet.add(s)).collect(Collectors.toList()).forEach(System.out::println);
	}
	public static void main(String[] args) {
		String[] str = { "gergger", "gerger", "ferge", "sss", "sss" };
		Set<String> strSet = new HashSet<>();
		Arrays.stream(str).filter(s -> !strSet.add(s)).collect(Collectors.toList()).forEach(x->Arrays.stream(str).filter(a->!a.equals(x)).forEach(System.out::println));
	}
}
