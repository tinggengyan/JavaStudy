package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Created by Steve on 2017/3/13.
 */
public class StopThread {
    // 读和写都需要加锁，否则不能正确的关闭线程。
    private static boolean stopRequested;

    private static synchronized void stop() {
        stopRequested = true;
    }

    private static synchronized boolean canStop() {
        return stopRequested;
    }


    public static void main(String[] args) {
        Thread backGroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                double i = 0;
                while (!canStop()) {
                    i++;
                }
            }
        });
        backGroundThread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
            stop();
//            stopRequested = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
