package com.zhongbin.juc.mylock;

import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {

    //static Integer num = 0;

    //使用原子类实现CAS
    static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(num.get() < 1000){
                        System.out.println("thread" + Thread.currentThread().getId() + ", num: " + num.incrementAndGet());
                        //num.incrementAndGet();
                    }
                }
            });

            t.start();
        }
    }
}
