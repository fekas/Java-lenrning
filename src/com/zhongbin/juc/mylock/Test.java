package com.zhongbin.juc.mylock;

public class Test {
    public static void main(String[] args) {
        SynchTest synchTest = new SynchTest();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchTest.test();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchTest.test();
            }
        });

        t1.start();
        t2.start();

    }
}
