package com.demo.spring.controller;

public class ThreadDemo {

	public static void main(String[] arg) {

		ThreadDemo threadClass = new ThreadDemo();

		Thread t1 = new Thread(() -> threadClass.printEven());
		Thread t2 = new Thread(() -> threadClass.printOdd());
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printEven() {
		for (int i = 1; i <= 20; i++)
			if (i % 2 == 0)
				System.out.println(i);
	}

	private void printOdd() {
		for (int i = 1; i <= 20; i++)
			if (i % 2 != 0)
				System.out.println(i);
	}
}
