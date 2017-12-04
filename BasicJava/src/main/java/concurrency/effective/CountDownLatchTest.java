package concurrency.effective;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Steve on 2017/3/15.
 */
public class CountDownLatchTest {
    public static long time(Executor executor, int concurrency, final Runnable action) throws InterruptedException {
        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i < concurrency; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    ready.countDown(); // 通知计时线程，当前线程准备完毕
                    try {
                        System.out.println(Thread.currentThread() + "start.await()");
                        start.await(); // 挂起当前线程，等待放行
                        action.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        done.countDown(); // 通知计时线程，当前线程工作结束
                    }
                }
            });
        }
        System.out.println(Thread.currentThread() + "ready.await()");
        ready.await(); // 等到所有线程都准备就绪
        long startNanos = System.nanoTime();
        System.out.println(Thread.currentThread() + "startNanos:" + startNanos + "start.countDown():");
        start.countDown(); // 所有线程都已经准备就绪，可以放行
        System.out.println(Thread.currentThread() + "done.await():");
        done.await(); // 等待所有线程都运行完成的通知
        return System.nanoTime() - startNanos;
    }

    public static void main(String[] args) {
        try {
            ExecutorService executor = Executors.newCachedThreadPool();
            long l = time(executor, 3, new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程执行...");
                }
            });
            System.out.println(l);
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
