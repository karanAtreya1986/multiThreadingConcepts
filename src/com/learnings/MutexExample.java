package com.learnings;

import java.util.concurrent.Semaphore;

//Mutex-
//Give one thread to semaphore.
//All threads will work on one lock only. acquire - work - release process.

public class MutexExample {
	public static void main(String[] args) {
		int i33 = s1.availablePermits();
		System.out.println(" total number of semaphore permits " + i33);

		ATMMachineThread t1 = new ATMMachineThread("thread1");
		t1.start();

		ATMMachineThread t2 = new ATMMachineThread("thread2");
		t2.start();

		ATMMachineThread t3 = new ATMMachineThread("thread3");
		t3.start();

		ATMMachineThread t4 = new ATMMachineThread("thread4");
		t4.start();

		ATMMachineThread t5 = new ATMMachineThread("thread5");
		t5.start();

		ATMMachineThread t6 = new ATMMachineThread("thread6");
		t6.start();
	}

	static Semaphore s1 = new Semaphore(1);

	static class ATMMachineThread extends Thread {
		String nameString = "";

		ATMMachineThread(String nameString) {
			this.nameString = nameString;
		}

		public void run() {
			// little logic change
			// add try block from here
			try {
				System.out.println("acquire the lock");
				System.out.println(" name is " + nameString + " available permit is " + s1.availablePermits());
				s1.acquire();
				System.out.println(nameString + " got the permit ");

				try {
					// For loop – timepass code. Sleep.
					for (int i = 1; i <= 5; i++) {
						System.out.println(nameString + " is performing some operation " + i + " available permits "
								+ s1.availablePermits());
						// changed number of seconds.
						Thread.sleep(1000);

					}
				} finally {
					System.out.println(nameString + " is releasing the lock ");
					s1.release();

					// check how many permits available after releasing lock
					// now we get proper output, when one thread releases lock and another thread
					// picks it up it correctly shows how many permits available.
					System.out.println(nameString + " is performing some operation " + " available permits "
							+ s1.availablePermits());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
