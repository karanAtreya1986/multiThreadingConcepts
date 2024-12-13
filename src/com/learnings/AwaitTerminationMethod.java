package com.learnings;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AwaitTerminationMethod {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 10; i++) {

			Runnable r1 = new WorkerThread2(" " + i);
			executorService.execute(r1);
		}

		// second way to shutdown
		// use awaittermination()
		// pass in time value and the unit of time
		// returns boolean
		// true if this executor terminated and false if the timeout elapsed before
		// termination

		// note- await termination does not stop program run
		// it only gives true or false if the executor terminated or not
		try {
			boolean b1 = executorService.awaitTermination(10, TimeUnit.SECONDS);
			System.out.println(b1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

//create class to implement thread and run() method
class WorkerThread2 implements Runnable {
	String message; // class variable

	// constructor
	public WorkerThread2(String s) {
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