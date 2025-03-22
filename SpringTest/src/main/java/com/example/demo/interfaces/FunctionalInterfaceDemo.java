package com.example.demo.interfaces;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.demo.controller.Emp;

public class FunctionalInterfaceDemo implements Calculate {

	public static void main(String arg[]) {
		int i = 3;
		m1();
//		Emp s=(Emp s)->{
//			s.getName(1);
//		};
		Calculate calca = (int x) -> (x * x * x);
		Calculate calc = new Calculate() {
			@Override
			public int cube(int x) {
				return (x * x * x);
			}
		};
		System.out.println("Cube " + calc.cube(i));

		System.out.println("Even " + calc.even(i));

		System.out.println("Square " + Calculate.square(i));

		FunctionalInterfaceDemo fid = new FunctionalInterfaceDemo();
		System.out.println("Odd " + fid.odd(i));

		System.out.println(fid.defalutCheck());

		Calculate.ss();
	}

	@Override
	public boolean odd(int x) {
		return x % 2 != 0;
	}

	@Override
	public String defalutCheck() {
		return "From class";
	}

	@Override
	public int cube(int x) {
		return 0;
	}

	public static void m1() {
		int i[] = { 44, 43, 43423, 424, 4324234, 23424, 23424, 6456 };
		System.out.println(Collections.max(Arrays.stream(i).boxed().collect(Collectors.toList())));
		Arrays.stream(i).sorted().skip(i.length - 1).limit(1).forEach(s -> System.out.println(s));

	}

}
