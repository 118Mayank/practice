package com.example.demo.interfaces;

@FunctionalInterface
public interface Calculate {

	int cube(int x);

	static int square(int x) {
		return x * x;
	}

	default boolean even(int x) {
		return x % 2 == 0;
	}

	default boolean odd(int x) {
		return false;
	}

	default String defalutCheck() {
		return "From interface";
	}

	public static void ss() {
		System.out.println("default "+new Object() {
		}.getClass().getEnclosingClass().getName());
	}

	public default void sss() {
		System.out.println("static "+new Object() {
		}.getClass().getEnclosingClass().getName());
	}
}
