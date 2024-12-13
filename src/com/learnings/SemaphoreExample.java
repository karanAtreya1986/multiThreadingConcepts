package com.learnings;

import java.util.concurrent.Semaphore;

//Semaphore-
//Acquire locks.
//Release locks
//Restrict number of threads to access resources

//four threads will acquire the lock
//will work on them
//then release the lock
//then the other two pending threads will acquire the lock
//will work on them
//available permits show how many permits have been taken up.

//program terminates once done.

public class SemaphoreExample {
	public static void main(String[] args) {
		int i33 = s1.availablePermits();
		System.out.println(" total number of semaphore permits " + i33);

		// we create six threads but we mentioned only four process allowed
		// six start methods called for each thread
		ATMMachineThread t1 = new ATMMachineThread("ewrer");
		t1.start();

		ATMMachineThread t2 = new ATMMachineThread("ewrerewr4234324");
		t2.start();

		ATMMachineThread t3 = new ATMMachineThread("ewrer23443@#$#@$");
		t3.start();

		ATMMachineThread t4 = new ATMMachineThread("324324324");
		t4.start();

		ATMMachineThread t5 = new ATMMachineThread("$#@$@#$");
		t5.start();

		ATMMachineThread t6 = new ATMMachineThread("WEREWRWER@#$wer23434");
		t6.start();
	}

	// make it static to access it directly inside static main method.
	// Object of semaphore.
	// Restrict to four threads.
	static Semaphore s1 = new Semaphore(4);

	// Static class extending thread. Constructor. Run method. Available permits
	// method to
	// know how many threads are available at one point in time. Acquire method to
	// acquire the lock.
	static class ATMMachineThread extends Thread {
		String nameString = "";

		// constructor
		ATMMachineThread(String nameString) {
			this.nameString = nameString;
		}

		// run method
		public void run() {
			System.out.println("acquire the lock");
			int i1 = s1.availablePermits();
			System.out.println(" name is " + nameString + " available permit is " + i1);

			// acquire returns void
			try {
				s1.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nameString + " got the permit ");
			try {
				// For loop – timepass code. Sleep.
				for (int i = 0; i <= 5; i++) {
					int i2 = s1.availablePermits();
					System.out.println(nameString + " is performing some operation " + i + " available permits " + i2);
					Thread.sleep(10);

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println(nameString + " is releasing the lock ");

				// release method returns void
				// Release method to release lock.
				s1.release();
			}
		}
	}

}
