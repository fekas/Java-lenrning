package com.zhongbin.juc.mylock;

public class SynchTest {
    private int num = 0;

    public void test(){
        for (int i = 0; i < 1000; i++) {
            synchronized (this) {
                System.out.println("thread" + Thread.currentThread().getId() + ", num: " + num++);
            }
        }
    }
}
