package ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
	public static void main(String[] args) {
		
		Lock lock = new ReentrantLock();

		new Thread(() -> runMethod(lock), "thread1").start();
		new Thread(() -> runMethod(lock), "thread2").start();
		new Thread(() -> runMethod(lock), "thread3").start();
		new Thread(() -> runMethod(lock), "thread4").start();
	}

	public static void runMethod(Lock lock) {
		lock.lock();
		for (int i = 0; i < 5; i++) {
			System.out.println("ThreadName   " + Thread.currentThread().getName() + ("     i=" + i));
		}
		System.out.println();
		lock.unlock();
	}

}
