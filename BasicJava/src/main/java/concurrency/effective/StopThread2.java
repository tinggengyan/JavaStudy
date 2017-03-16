package concurrency.effective;

import java.util.concurrent.TimeUnit;

/**
 * Created by Steve on 2017/3/13.
 */
public class StopThread2 {
    // volatile 不能确保互斥访问，但是能确保一个线程读取该域的值的时候，都将看到最近刚刚被写入的值，对于不需要互斥，仅仅是为了通信而已，可以采用这种简单的方式。
    private static  volatile boolean stopRequested;


    public static void main(String[] args) {
        Thread backGroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                double i = 0;
                while (!stopRequested) {
                    i++;
                }
            }
        });
        backGroundThread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
            stopRequested = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
