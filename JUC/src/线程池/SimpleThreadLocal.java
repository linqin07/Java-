package 线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadLocal {

	private static final int THREAD_LOOP_SIZE = 1;
	private static final int MOCK_DIB_DATA_LOOP_SIZE = 2;
    // 内存共享变量，但是线程不隔离
    private static List<User> list = null;

    // 线程隔离但是new一个子线程是无法共享数据的
	private static ThreadLocal<List<User>> threadLocal = new ThreadLocal<>();

    // 即使线程隔离。再new 子线程可以得到数据
    private static InheritableThreadLocal<List<User>> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

		ExecutorService executorService = Executors.newFixedThreadPool(THREAD_LOOP_SIZE);

		for (int i = 0; i < THREAD_LOOP_SIZE; i++) {
			executorService.execute(() -> {
                list = new SimpleThreadLocal().addBigList();
				threadLocal.set(new SimpleThreadLocal().addBigList());
                inheritableThreadLocal.set(new SimpleThreadLocal().addBigList());
				Thread t = Thread.currentThread();
				System.out.println(Thread.currentThread().getName());
                new Thread(() -> {
                    System.out.println(list);
                    List<User> users = inheritableThreadLocal.get();
                    System.out.println(Thread.currentThread().getName());
                }).start();
				// threadLocal.remove(); // 不取消注释的话就可能出现OOM
			});
			try {
				Thread.sleep(500L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// executorService.shutdown();
	}

	private List<User> addBigList() {
		List<User> params = new ArrayList<>(MOCK_DIB_DATA_LOOP_SIZE);
		for (int i = 0; i < MOCK_DIB_DATA_LOOP_SIZE; i++) {
			params.add(new User("xuliugen", "password" + i, "男", i));
		}
		return params;
	}

	class User {
		private String userName;
		private String password;
		private String sex;
		private int age;

		public User(String userName, String password, String sex, int age) {
			this.userName = userName;
			this.password = password;
			this.sex = sex;
			this.age = age;
		}
	}

}
