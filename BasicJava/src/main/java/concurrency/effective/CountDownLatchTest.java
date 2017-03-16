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
                    ready.countDown(); // Tell timer we're ready
                    try {
                        System.out.println("start.await()");
                        start.await(); // Wait till peers are ready
                        action.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        done.countDown(); // Tell timer we're done
                    }
                }
            });
        }
        System.out.println("ready.await()");
        ready.await(); // Wait for all workers to be ready
        long startNanos = System.nanoTime();
        System.out.println("startNanos:" + startNanos);
        System.out.println("start.countDown():");
        start.countDown(); // And they're off!
        System.out.println("done.await():");
        done.await(); // Wait for all workers to finish
        return System.nanoTime() - startNanos;
    }

    public static void main(String[] args) {
        try {
            ExecutorService executor = Executors.newCachedThreadPool();
            long l = time(executor, 2, new Runnable() {
                @Override
                public void run() {
                    System.out.println("hhahah");
                }
            });
            System.out.println(l);
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
