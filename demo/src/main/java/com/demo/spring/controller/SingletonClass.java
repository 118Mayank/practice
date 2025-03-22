package com.demo.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SingletonClass {


	public static void main(String arg[]) {
		List<Integer> intList = Arrays.asList(1, 2, 3, 45, 6, 7, 88, 45, 6);
		Set<Integer> mapList = new HashSet<>();
		List<Integer> repeated = intList.stream().filter(n -> !mapList.add(n)).distinct().collect(Collectors.toList());
		System.out.println(repeated);
	}
}
