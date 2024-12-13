package com.learnings;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AddLittleLogicToLock {

	public static void main(String[] args) {

		PrintQueue1 object1 = new PrintQueue1();

		Thread t1[] = new Thread[10];

		for (int i = 0; i < 10; i++) {

			t1[i] = new Thread(new PrintingJob1(object1), " thread " + i);
		}

		for (int j = 0; j < 10; j++) {
			t1[j].start();
		}

	}

}

//this class implements runnable to see threads in action
class PrintingJob1 implements Runnable {
	PrintQueue1 printerQueue;

	PrintingJob1(PrintQueue1 printerQueue) {
		this.printerQueue = printerQueue;
	}

	public void run() {
		String s1 = Thread.currentThread().getName();
		System.out.println(s1);
		//pass in the parameter value
		//since its object so we use the new keyword
		printerQueue.printJob(new Object());
	}
}

class PrintQueue1 {
	Lock queueLock = new ReentrantLock();

	// passed object parameter to add little extra logic
	void printJob(Object document) {

		queueLock.lock();
		// Write timepass code – calculate duration. Sleep thread.
		Long duration = (long) (Math.random() * 10000);
		String s2 = Thread.currentThread().getName();
		
		//during Run. We can clearly see the thread names.
		System.out.println(s2 + " printing job for more logic " + (duration / 1000) + " date time is " + new Date());
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		queueLock.unlock();
	}
}