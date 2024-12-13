package com.learnings;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallabableExample {

	// Callable-
	// Callable is interface. To see the value or output from a thread.
	// has method called as call().Takes in generics.

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(1);

		// Write call method using lambda, time pass code with return statement.
		Callable<Integer> task = () -> {
			TimeUnit.SECONDS.sleep(20);
			return 123;
		};

		// How to get the return value-
		// Use future interface.
		// Takes in generics.
		// Uses submit method to know the return value.

		Future<Integer> future = executor.submit(task);
		// Isdone method to check if the thread finished work and value returned.

		boolean b1 = future.isDone();
		System.out.println(b1);
		// to get the value and forcefully complete operation
		Integer result = future.get();
		boolean b2 = future.isDone();
		System.out.println(b2);
		System.out.println("result value is and output from thread is  " + result);
		executor.shutdown();
	}

}
