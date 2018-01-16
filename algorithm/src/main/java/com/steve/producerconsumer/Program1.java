package com.steve.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 生产者消费者线程1；
 * 利用原始的 wait 和 notify
 */
public class Program1 {
    private static final int SOURCE_SIZE = 8;// 最大容量
    private volatile Queue<String> sources = new LinkedList<>();
    private final Object lock = new Object();

    private class Consumer implements Runnable {
        @Override
        public void run() {
            while (true)
                synchronized (lock) {
                    while (sources.size() == 0) {
                        try {
                            System.out.println("队列空，等待生成");
                            lock.wait(); // 挂起，释放锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 当当前线程被唤醒，将不再检查长度是否满足条件，这时，可能存在另外的消费线程在当前线程之前就进行了消费
                    System.out.println("消费:" + sources.poll());
                    lock.notifyAll();
                }
        }
    }

    private class Producer implements Runnable {
        private int index = 0;

        @Override
        public void run() {
            while (true)
                synchronized (lock) {
                    while (sources.size() == SOURCE_SIZE) {
                        try {
                            System.out.println("队满，等待消费");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    sources.add("" + index++);
                    lock.notifyAll();
                }
        }
    }


    public void start() {
        Producer target = new Producer();
        Consumer target1 = new Consumer();
        new Thread(target1).start();
        new Thread(target1).start();
        new Thread(target).start();
    }

    public static void main(String[] args) {
        Program1 program1 = new Program1();
        program1.start();
    }
}
