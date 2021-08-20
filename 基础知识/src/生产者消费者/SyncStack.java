package 生产者消费者;

import java.util.ArrayList;

public class SyncStack {

    private int Max = 3;

    private int index = 0;

    ArrayList list = new ArrayList();

    public synchronized void create(Object object) throws Exception {
        while (index >= Max) {
            this.wait();
        }
        this.notify();

        index++;
        list.add(object);

        System.out.println("生产了第 " + index + " 个");
    }

    public synchronized void cosume() throws Exception {
        while (index <= 0) {
            this.wait();
        }
        this.notify();
        index--;
        list.remove(0);

        System.out.println("消费了第 " + index + " 个");
    }
}
