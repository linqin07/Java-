package ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
	
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public static void main(String[] args) throws Exception {
		ConditionDemo demo = new ConditionDemo();
		new Thread(() -> demo.await(),"thread-1").start();
		Thread.sleep(5000);
		new Thread(() -> demo.signal(),"thread-2").start();
	}

	private  void await() {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName()+"开始await");
			condition.await();
			System.out.println(Thread.currentThread().getName()+" await结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private void signal() {
		lock.lock();
		System.out.println(Thread.currentThread().getName()+"开始signal");
		condition.signal();
		lock.unlock();
	}
}
