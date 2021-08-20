package Atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/08
 */
public class AtomicIntegerFieldUpdaterDemo {
    /**
     * CAS 存在ABA问题
     *
     * @param args
     */
    public static void main(String[] args) {

        AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

        /** 这里注意修改的字段要内存可见性，增加volitile */
        User user1 = new User("李四", 18);
        a.compareAndSet(user1, 18, 20);

        System.out.println(user1.toString());


    }
}
