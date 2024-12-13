package com.learnings;

public class ReEntrantThreadWorking {

	// Reentrant thead –
	// Dead thread which can be reused any number of times.

	public static void main(String[] args) {
		Reentrant object1 = new Reentrant();

		// anonymous way of implementing.
		// we are using only one thread to work with multiple sync methods and these
		// multiple sync methods are calling each
		// other due to reentrant concept..
		Thread t1 = new Thread() {
			public void run() {
				object1.m();
			}
		};
		t1.start();
	}

}

// class created
//two sync methods
//one sync calling another sync method.
class Reentrant {
	synchronized void m() {
		n();
		System.out.println("method m is called");
	}

	synchronized void n() {
		System.out.println("method n is called");

	}
}
