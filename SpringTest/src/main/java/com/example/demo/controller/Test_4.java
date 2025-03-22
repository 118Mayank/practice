package com.example.demo.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test_4 {

	public static void main(String[] arg) {
		exeThread();
		cfThread();
		futThread();
	}

	public static void exeThread() {

		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("Executable thread");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		es.
	}

	public static void cfThread() {
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {

			try {
				Thread.sleep(1);
				System.out.println("CompletableFuture thread");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});
		cf.

	}

	public static void futThread() {

		ExecutorService executorService = Executors.newFixedThreadPool(3);

		Callable<String> task = () -> {
			Thread.sleep(1);
			return "Future Running";
		};

		Future<String> fut = executorService.submit(task);
		try {
			System.out.println(fut.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		executorService.
	}
	
}
