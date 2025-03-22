package com.example.demo.controller;

public class ThreadDemo {

	public static void main(String[] arg) {

		ThreadDemo threadClass = new ThreadDemo();
		for (int i = 1; i <= 20; i++) {
			final int j = i;
			Thread t1 = new Thread(() -> threadClass.printEven(j));
			Thread t2 = new Thread(() -> threadClass.printOdd(j));
			try {
				t1.start();
				t1.join();
				t2.start();
				t2.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void printEven(int i) {
		if (i % 2 == 0)
			System.out.println("even- " + i);
	}

	private void printOdd(int i) {
		if (i % 2 != 0)
			System.out.println("odd- " + i);
	}
}
