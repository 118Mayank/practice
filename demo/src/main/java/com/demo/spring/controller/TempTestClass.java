package com.demo.spring.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TempTestClass {

	public static void main(String arg[]) {
		// smallest one
		// 2nd samllest
		List<Integer> intList = Arrays.asList(2, 4534, 534, 345, 553, 434, 345345, 54534, 345, 345345);

		if (!intList.isEmpty()) {
			int smallestOne = intList.get(0);
			int smallestTwo = intList.get(1);

			for (Integer i : intList) {
				if (smallestOne > i)
					smallestOne = i;

				if (smallestTwo > i && i > smallestOne)
					smallestTwo = i;

			}
			System.out.println("smallestOne " + smallestOne);
			System.out.println("smallestTwo " + smallestTwo);
		}

	}

	public static void mains(String arg[]) {

		List<Integer> intList = Arrays.asList(2, 4534, 534, 345, 553, 434, 345345, 54534, 345, 345345);

		Map<Integer, Integer> countList = new HashMap<>();
		if (!intList.isEmpty()) {

			for (Integer i : intList)
				countList.put(i, countList.containsKey(i) ? countList.get(i) + 1 : 1);

			for (Entry<Integer, Integer> mapList : countList.entrySet()) {
				if (mapList.getValue() > 1)
					System.out.println(mapList);
			}

		}
	}

}
