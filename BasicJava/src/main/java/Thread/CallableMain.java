package Thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable和Future，它俩很有意思的，一个产生结果，一个拿到结果。
 * Callable接口类似于Runnable，从名字就可以看出来了，但是Runnable不会返回结果，并且无法抛出返回结果的异常，
 * 而Callable功能更强大一些， 被线程执行后，可以返回值，这个返回值可以被Future拿到，
 * 也就是说，Future可以拿到异步执行任务的返回值
 * <p/>
 * Created by yantinggeng on 2015/11/5.
 */
public class CallableMain {

    public static void main(String[] args) {

        //类似于Runnable，定义了任务的内容，这里是返回随机数,这个是有返回值Integer的
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };

        //用以取得Callable的返回值
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();

        try {
            // TODO do anything
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
