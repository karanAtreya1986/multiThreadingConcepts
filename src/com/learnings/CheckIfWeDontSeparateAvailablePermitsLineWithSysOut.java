package com.learnings;

import java.util.concurrent.Semaphore;

public class CheckIfWeDontSeparateAvailablePermitsLineWithSysOut {
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

	static Semaphore s1 = new Semaphore(4);

	static class ATMMachineThread extends Thread {
		String nameString = "";

		ATMMachineThread(String nameString) {
			this.nameString = nameString;
		}

		public void run() {
			System.out.println("acquire the lock");
//			int i1 = s1.availablePermits();
			// lets directly use available permits to check output is more clear
			// same output as earlier semaphore code when we first got the available permits
			// and then printed.
			System.out.println(" name is " + nameString + " available permit is " + s1.availablePermits());

			try {
				s1.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nameString + " got the permit ");
			try {
				// For loop – timepass code. Sleep.
				for (int i = 0; i <= 5; i++) {
//					int i2 = s1.availablePermits();
					// lets directly use available permits to check output is more clear
					// same output as earlier semaphore code when we first got the available permits
					// and then printed.
					System.out.println(nameString + " is performing some operation " + i + " available permits "
							+ s1.availablePermits());
					Thread.sleep(10);

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println(nameString + " is releasing the lock ");

				s1.release();
			}
		}
	}

}
