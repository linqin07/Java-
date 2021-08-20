package ReentrantLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 读写、写读、写写都是互斥
 * 读读共享
 *
 */
public class ReentrantReadWriteLockDemo {
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public static void main(String[] args) {
		ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
		new Thread(() -> demo.read(),"thread-1").start();
		new Thread(() -> demo.write(),"thread-2").start();
	}
	
	private void read() {
		try {
			lock.readLock().lock();
			System.out.println("获得读锁:"+Thread.currentThread().getName()+" 时间："+System.currentTimeMillis());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
	}
	
	private void write() {
		try {
			lock.writeLock().lock();
			System.out.println("获得写锁:"+Thread.currentThread().getName()+" 时间："+System.currentTimeMillis());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.writeLock().unlock();
		}
	}

}
