package 生产者消费者;

public class Consumer implements Runnable {

    SyncStack stack = null;

    public Consumer(SyncStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true) {
            try {
                stack.cosume();
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
