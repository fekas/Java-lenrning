package com.zhongbin.juc;

/**
 * 继承thread创建线程
 * 重写run方法
 * 创建子类对象
 * 调用start方法（非run方法，调用run方法不会创建子线程）
 */
public class ThreadDemo extends Thread{

    //重写run方法计算1+2+……+100
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sum = 0;
        for(int i = 1; i < 101; i++){
            sum += i;
        }
        this.yield();
        System.out.println(Thread.currentThread().getName() + "  " + sum);
    }

}
class MyThread {
    public static void main(String[] args) {


        ThreadDemo threadDemo = new ThreadDemo();

        /*
        threadDemo.start();         创建线程并调用run方法
        threadDemo.run();
        threadDemo.join();          插队
        Thread.currentThread();     获取当前线程
        yield();                    礼让
        */

        threadDemo.start();

        System.out.println(Thread.currentThread().getName() + "   Result: ");

        /**
         * 匿名类创建
         */
        new Thread(){
            @Override
            public void run() {
                int sum = 0;
                for(int i = 1; i < 101; i++){
                    sum += i;
                }
                try {
                    this.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  " + sum);
            }
        }.start();

        /**
         * lambda表达式
         */
        new Thread(() -> {
            int sum = 0;
            for(int i = 1; i < 10; i++){
                sum += i;
            }
            System.out.println(Thread.currentThread().getName() + "  " + sum);
        }).start();

    }
}
