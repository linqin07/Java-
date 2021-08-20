package Atomic;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Description:
 * author: LinQin
 * date: 2018/08/08
 */
public class AtomicReferenceDemo {
    /**
     * CAS 存在ABA问题
     *
     * @param args
     */
    public static void main(String[] args) {
        User user = new User("张三", 14);
        User user1 = new User("李四", 19);

        AtomicReference<User> reference = new AtomicReference<User>();
        reference.set(user);
        reference.compareAndSet(user, user1);
        System.out.println(reference.get().toString());

        //解决ABA,0代表时间戳,构造方法直接初始化
        AtomicStampedReference<User> stampedReference = new AtomicStampedReference<User>(user, 0);
        stampedReference.compareAndSet(user, user1, stampedReference.getStamp(), stampedReference.getStamp() + 1);
        System.err.println(stampedReference.getReference().toString());

    }
}

class User {
    String name;
    volatile int old;

    public User(String name, int old) {
        this.name = name;
        this.old = old;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", old=" + old + "]";
    }
}