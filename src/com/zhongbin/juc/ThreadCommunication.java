package com.zhongbin.juc;

import java.util.concurrent.Callable;

/**
 * 线程通信的三个方法（只能在同步代码块或同步方法里面）
 * wait（）       阻塞当前线程，释放锁
 * notify()      唤醒一个线程
 * notufyall()   唤醒所有线程
 *
 * sleep()  Thread类中声明的方法，任何需要的时候都可以调用，在同步代码块时不会释放锁
 * weit()   Object类中声明的方法，在同步代码块中调用，会释放锁。
 */
public class ThreadCommunication {

    public static void main(String[] args) {
        RunnableComm runnableComm = new RunnableComm();

        new Thread(runnableComm).start();
        new Thread(runnableComm).start();

    }

}

class RunnableComm implements Runnable{
    private int num = 100;

    //两个线程交替执行
    @Override
    public void run() {
        while(true){
            synchronized (this){
                notify();
                if (num > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + num--);
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else break;
            }
        }
    }
}
