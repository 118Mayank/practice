package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test_2 {

	public String s;

	private Test_2() {
		s = "this is it";
	}

	private static Test_2 sing_Inst = null;

	public static synchronized Test_2 singI() {
		if (sing_Inst == null) {
			sing_Inst = new Test_2();
		}
		return sing_Inst;
	}

//	-----------------------------------------------------------------
	public static void main1(String arg[]) {

		for (int i = 0; i <= 10; i++) {
			final int j = i;
			Thread thread1 = new Thread(() -> th1(j));
			Thread thread2 = new Thread(() -> th2(j));
			try {
				thread1.start();
				thread1.join();
				thread2.start();
				thread2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void th1(int i) {
		if (i % 2 != 0)
			System.out.println("th1 " + i);
	}

	public static void th2(int i) {
		if (i % 2 == 0)
			System.out.println("th2 " + i);
	}
//	------------------------------------------------------

	public static void main2(String arg[]) {
//		Stream.iterate(0, n -> n + 1).limit(100).filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));

//		int x = 1;
//		int[] i = { 22, 2343, 545, 3, 35, 53, 555, 5454, 54355, 5, 5334, 4545, 535, 53453 };
//		Arrays.stream(i).filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));
//		Arrays.stream(i).sorted().skip(i.length - x).limit(1).forEach(n -> System.out.println("max- " + n));
//		Arrays.stream(i).sorted().skip(x - 1).limit(1).forEach(n -> System.out.println("min- " + n));

//		List<Emp> empList = new ArrayList<>();
//		empList.add(new Emp(1L, "Raj", "HR", 20000));
//		empList.add(new Emp(2L, "Ram", "IT", 30000));
//		empList.add(new Emp(3L, "Ron", "HR", 50000));
//		empList.add(new Emp(4L, "Aman", "IT", 60000));
//		empList.add(new Emp(5L, "Hima", "Dev", 80000));
//		empList.add(new Emp(6L, "Hina", "IT", 30000));
//		empList.add(new Emp(7L, "Haxa", "Dev", 50000));
//		empList.add(new Emp(8L, "Hiza", "Admin", 100000));
//		empList.stream()
//				.collect(Collectors.groupingBy(Emp::getDepartment,
//						Collectors.maxBy(Comparator.comparing(Emp::getSalary))))
//				.forEach((d, e) -> System.out.println("dept " + d + " Emp " + e));
//		empList.stream().collect(Collectors.maxBy(Comparator.comparing(Emp::getSalary)))
//				.ifPresent(n -> System.out.println("max- " + n));
//		empList.stream().sorted(Comparator.comparingDouble(Emp::getSalary)).forEach(n -> System.out.println(n));

		String[] strArr = { "apple", "banana", "cherry" };
		Integer rep = 1;
		Map<String, Integer> intmap = new HashMap<>();
		Arrays.stream(strArr).forEach(s -> Arrays.stream(s.split(""))
				.forEach(a -> intmap.put(a, intmap.containsKey(a) ? intmap.get(a) + 1 : 1)));
		intmap.entrySet().stream().filter(m -> m.getValue() == rep).forEach(n -> System.out.println(n.getKey()));

	}
//	------------------------------------------------------

	public static void main3(String arg[]) {

		String str = "mayank";
		Stack<Character> schar = new Stack<>();

		for (char c : str.toCharArray())
			schar.push(c);

		while (!schar.isEmpty())
			System.out.print(schar.pop());

	}
//	-----------------------binary sarch-------------------------------

	public static void main(String arg[]) {

		int[] ilist = { 2, 4, 6, 7, 9, 30, 4234, 5646 };
		int target = 30;

		int lowlimit = 0;
		int highlimit = ilist.length - 1;

		while (lowlimit <= highlimit) {
			int midIndex = lowlimit + (highlimit - lowlimit) / 2;
			if (ilist[midIndex] == target) {
				System.out.println("-----" + midIndex);
				break;
			} else if (ilist[midIndex] > target) {
				highlimit = midIndex - 1;
			} else
				lowlimit = midIndex + 1;

		}
	}
	
//	------------------------------------------------------
}
