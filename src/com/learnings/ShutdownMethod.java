package com.learnings;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ShutdownMethod {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 10; i++) {

			Runnable r1 = new WorkerThread1(" " + i);
			executorService.execute(r1);
		}
		//this is one way to stop thread and program
		//shutdown() method returns void.
		executorService.shutdown();
	}

}

//create class to implement thread and run() method
class WorkerThread1 implements Runnable {
	String message; // class variable

	// constructor
	public WorkerThread1(String s) {
		message = s;
	}

	@Override
	public void run() {
		// how to get the thread name
		String s1 = Thread.currentThread().getName();
		System.out.println(s1 + " start thread " + " message");
		try {
			// added sleep
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String s2 = Thread.currentThread().getName();
		System.out.println(s2 + " end thread " + " message");

	}
}