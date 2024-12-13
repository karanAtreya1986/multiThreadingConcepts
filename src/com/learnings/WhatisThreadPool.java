package com.learnings;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Thread pool-
//Concurrency api is new in java.

public class WhatisThreadPool {

	public static void main(String[] args) {
		// executor service is interface
		// create five threads to run the run() method.
		// Executor comes from java.util.concurrent.* package.
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 10; i++) {

			// this is new
			// workerthread has one constructor accepting string
			// we can pass string like this also
			// so in short any one parameter inside the object name has to be string to
			// match the constructor.
			Runnable r1 = new WorkerThread(" " + i);
			// to run the run() call execute method on executorService.
			// in output - Five threads executed run method ten times using for loop
			// five times for start thread and five times for end thread.
			// but we see that program did not stop, it keeps running until we stop it
			// manually.
			executorService.execute(r1);
		}
	}

}

//create class to implement thread and run() method
class WorkerThread implements Runnable {
	String message; // class variable

	// constructor
	public WorkerThread(String s) {
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