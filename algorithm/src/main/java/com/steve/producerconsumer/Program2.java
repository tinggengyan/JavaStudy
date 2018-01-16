package com.steve.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者线程2；
 * 利用 ReentrantLock 和  Condition 实现精准的条件锁定
 */
public class Program2 {
    private static final int SOURCE_SIZE = 8;// 最大容量
    private volatile Queue<String> sources = new LinkedList<>();

    private final ReentrantLock lock = new ReentrantLock();
    private Condition consumerCondition = lock.newCondition(), producerCondition = lock.newCondition();

    private class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                while (sources.size() == 0) {
                    try {
                        consumerCondition.await(); //挂起，释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费了--->" + sources.poll());
                producerCondition.signalAll();
                lock.unlock();
            }
        }
    }

    private class Producer implements Runnable {
        private int index = 0;

        @Override
        public void run() {
            while (true) {
                lock.lock();
                while (sources.size() == SOURCE_SIZE) {
                    try {
                        producerCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                sources.add("" + index++);
                consumerCondition.signalAll();
                lock.unlock();
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
        Program2 program1 = new Program2();
        program1.start();
    }
}
