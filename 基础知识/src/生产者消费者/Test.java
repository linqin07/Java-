package 生产者消费者;

public class Test {
    public static void main(String[] args) {
        SyncStack stack = new SyncStack();
        Producer producer = new Producer(stack);
        Producer produce2r = new Producer(stack);
        Consumer consumer = new Consumer(stack);
        try {
            new Thread(producer).start();
            Thread.sleep(4000);
            new Thread(consumer).start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
