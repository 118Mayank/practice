package com.demo.spring.controller;

public class ThreadClass {

//	private final Object hello = new Object();
//	private final Object world = new Object();

	public static void mains(String arg[]) {

		ThreadClass threadClass = new ThreadClass();
		for (int i = 0; i <= 3; i++) {
			Thread t1 = new Thread(() -> threadClass.hello());
			Thread t2 = new Thread(() -> threadClass.world());

			try {
				t1.start();
				t1.join();
				t2.start();
				t2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private void hello() {
//		synchronized (hello) {
			System.out.println("Hello");
//		}
	}

	private void world() {
//		synchronized (world) {
			System.out.println("World");
//		}
	}

}
