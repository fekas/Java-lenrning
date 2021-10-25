package com.zhongbin.jvm.classloader.memormodel;

public class Seeable {
    static  int a = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(a != 2){};
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                a = 2;
            }
        });
        t1.start();
        t2.start();
    }
}
