package com.demo.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void mains(String arg[]) {

		int[] ilist1 = { 11, 22, 33, 44, 55, 66 };
		int[] ilist2 = { 1, 2, 35, 57, 59 };

		List<Integer> finalLIst = new ArrayList<>();

		for (int i : ilist1) 
			finalLIst.add(i);
		
		for (int i : ilist2) 
			finalLIst.add(i);
		
		Collections.sort(finalLIst);
		Integer[] finalArray = finalLIst.toArray(new Integer[0]);

		System.out.println(Arrays.toString(finalArray));
	}

}
