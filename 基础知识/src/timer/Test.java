package timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description:
 * @author: LinQin
 * @date: 2020/08/19
 */
public class Test {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行任务");
            }
        };

        timer.schedule(task, 0L,3000);
        timer.cancel();
        // timer不能复用
        timer = new Timer(true);
        timer.schedule(task, 0L,3000);

    }
}
