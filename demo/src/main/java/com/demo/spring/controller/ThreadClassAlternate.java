package com.demo.spring.controller;

public class ThreadClassAlternate {

//	private final Object hello = new Object();
//	private final Object world = new Object();

	public static void mains(String arg[]) {

		ThreadClassAlternate threadClass = new ThreadClassAlternate();
		char a = 'A';
		int i = 0;
		for (int x = 0; x <= 5; x++) {
			final char aa = a++;
			final int ia = i++;
			Thread t1 = new Thread(() -> threadClass.alpha(aa));
			Thread t2 = new Thread(() -> threadClass.num(ia));
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

	private void alpha(char a) {
//		synchronized (world) {
		System.out.print(a);
//		}
	}

	private void num(int a) {
//		synchronized (world) {
		System.out.print(a);
//		}
	}

}
