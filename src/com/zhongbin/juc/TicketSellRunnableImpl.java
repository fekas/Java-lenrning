package com.zhongbin.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java通过同步机制解决线程安全问题
 * 1.同步代码块
 *      synchronized (同步监视器){}     同步监视器(锁)可以是任何一个对象（可以考虑用this或者ClassName.class），多个线程必须使用同一个锁
 *         好处：解决线程安全
 *         坏处：慢
 * 2.同步方法
 *  在方法上添加synchronized修饰
 *      默认同步监视器：非静态：this 静态 类本身
 *
 * 3.lock   jdk5.0新增
 * private Lock lock = new ReentrantLock(true);//公平锁：FIFO
 * try{
 *      lock.lock();
 *      代码块
 *
 * }finally{
 *      lock.unlock();
 * }
 *
 */

public class TicketSellRunnableImpl {

    //实例化Lock
    private Lock lock = new ReentrantLock(true);//公平锁：FIFO

    public static void main(String[] args) {


        Runnable runnable = () -> {
            int ticketCount = 100;
            if(ticketCount > 0){
                while(true){
                    if(ticketCount > 0)
                        System.out.println(Thread.currentThread().getName() + ":sell No." + ticketCount-- + " ticket");
                    else
                        break;
                }
            }
        };

        Runnable runnable1 = new Runnable() {
            int ticketCount = 500;
            @Override
            public void run() {
                if(ticketCount > 0){
                    while(true){
                        synchronized (this) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (ticketCount > 0)
                                System.out.println(Thread.currentThread().getName() + ":sell No." + ticketCount-- + " ticket");
                            else break;
                        }
                    }
                }
            }
        };

        Window1 runnable2 = new Window1();

        new Thread(runnable1).start();
        new Thread(runnable1).start();
        new Thread(runnable1).start();
    }

}
class Window1 implements Runnable{

    volatile int ticketCount = 100;
    @Override
    public void run() {
        if(ticketCount > 0){
            while(true){
                if(ticketCount > 0)
                    System.out.println(Thread.currentThread().getName() + ":sell No." + ticketCount-- + " ticket");
                else break;
            }
        }
    }
}
