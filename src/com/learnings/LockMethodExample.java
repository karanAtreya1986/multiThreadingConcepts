package com.learnings;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMethodExample {

	// lock is interface.
	// Lock is nothing but synchronized block without synchronized word.

	public static void main(String[] args) {

		// Object of print queue.
		PrintQueue object1 = new PrintQueue();
		// this is how to create array of thread.
		// Create ten threads using array format.
		Thread t1[] = new Thread[10];

		// For loop. Initialise thread. Pass in the print job method. See how to pass
		// multiple values in the parameters. we pass in the class name for thread to be
		// seen in action.
		for (int i = 0; i < 10; i++) {
			// see how we can pass parameter - new way which i learnt now.
			t1[i] = new Thread(new PrintingJob(object1), " thread " + i);
		}
		// Another for loop. Call start method for every thread.
		for (int j = 0; j < 10; j++) {
			t1[j].start();
		}

	}

}

//this class implements runnable to see threads in action
class PrintingJob implements Runnable {
	PrintQueue printerQueue;

	// constructor
	PrintingJob(PrintQueue printerQueue) {
		this.printerQueue = printerQueue;
	}

	// run method
	// Run prints the thread names.
	public void run() {
		// Get thread name.
		String s1 = Thread.currentThread().getName();
		System.out.println(s1);
		// Call print job method.
		printerQueue.printJob();
	}
}

//PrintQueue uses lock interface, reentrant lock is the class implementing lock interface.
class PrintQueue {
	Lock queueLock = new ReentrantLock();

	// return time pass method.
	void printJob() {
		// lock returns void.
		// Apply lock on the method.
		queueLock.lock();
		// Write timepass code – calculate duration. Sleep thread.
		Long duration = (long) (Math.random() * 10000);
		try {
			// sleep returns void.
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// unlock returns void.
		// Then once done unlock it.

		queueLock.unlock();
	}
}