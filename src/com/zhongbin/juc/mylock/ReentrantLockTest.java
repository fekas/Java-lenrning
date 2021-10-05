package com.zhongbin.juc.mylock;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {

        MyReentrantLockTest myReentrantLockTest = new MyReentrantLockTest();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    myReentrantLockTest.test();
                }
            });
        }
        executorService.shutdown();
    }

}
class MyReentrantLockTest {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private int num = 0;

    public void test(){
        for (int i = 0; i < 1000; i++) {
            try{
                reentrantLock.lock();
                System.out.println("thread" + Thread.currentThread().getId() + ", num: " + num);
                num++;
            }finally {
                reentrantLock.unlock();
            }
        }
    }
}