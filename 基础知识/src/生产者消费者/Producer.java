package 生产者消费者;

public class Producer implements Runnable {

    SyncStack stack = null;

    public Producer(SyncStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        while (true) {
            try {
                stack.create("面包");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
