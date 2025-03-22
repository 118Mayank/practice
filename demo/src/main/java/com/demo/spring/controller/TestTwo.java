package com.demo.spring.controller;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestTwo {

	// odd even from range
	public static void main(String [] args) {
		IntStream.range(1, 20).filter(a -> a % 2 == 0).boxed().collect(Collectors.toList()).forEach(System.out::println);
	}
	
//	public static void main(String[] args) {
//        // Generate even numbers between 1 and 20
//         IntStream.rangeClosed(1, 20) // Numbers from 1 to 20
//                .filter(n -> n % 2 == 0) // Filter for even numbers
//                .boxed() // Convert IntStream to Stream<Integer>
//                .collect(Collectors.toList()).forEach(System.out::println);
//    }

}
