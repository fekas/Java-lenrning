package com.zhongbin.juc;

/**
 * 同步代码块解决线程安全问题
 */

public class TicketSellIThreadImp {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("w1");
        w2.setName("w2");
        w3.setName("w3");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window extends Thread{
    private static int ticketCount = 100;

    @Override
    public void run() {
        while (true){
            synchronized (Window.class) {//类在堆中只加载一次
                if (ticketCount > 0) {
                    System.out.println(Thread.currentThread().getName() + ": sold No." + ticketCount + " ticket");
                    ticketCount--;
                } else {
                    break;
                }
            }
        }
    }
}
