package concurrency;

import java.util.List;
import java.util.concurrent.*;

/**
 * 以任务为单位执行
 * <p>
 * Created by Steve on 2017/3/14.
 */
public class ExecutorTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 任务1
        Runnable command = new Runnable() {
            @Override
            public void run() {
                System.out.println("command1");
            }
        };
        // 任务2
        Runnable command2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("command2");
            }
        };
        // 提交任务，执行
        executorService.execute(command);
        Callable<String> stringCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "command3";
            }
        };
        // 提交执行有返回值的任务
        Future<?> submit = executorService.submit(stringCallable);
        try {
            Object o = submit.get();
            System.out.println(o.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
