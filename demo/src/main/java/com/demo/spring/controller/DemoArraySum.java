package com.demo.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DemoArraySum {

	public static void mainsss(String[] arg) {

		int[] array1 = { 1, 3, 5 };
		int[] array2 = { 2, 4, 6 };

		List<Integer> intList = new ArrayList<>();

		for (int i : array1)
			intList.add(i);
		for (int i : array2)
			intList.add(i);

		Collections.sort(intList);
		System.out.println(intList);

	}

	public static void main(String[] arg) {

		List<String> array = Arrays.asList("ram", "mayank", "aman", "Shyam");
		System.out.println(array.stream().filter(str -> str.length() >= 5).toList());
	}

}
