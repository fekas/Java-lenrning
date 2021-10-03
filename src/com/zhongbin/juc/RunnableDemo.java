package com.zhongbin.juc;

public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //遍历1-100内的奇数
        for (int i = 1; i < 101; i++){
            if(i % 2 != 0)
                System.out.print(i + " ");
        }
    }
}
class MyRunnable{

    public static void main(String[] args) {

        Runnable t1 = new RunnableDemo();

        new Thread(t1).start();

        System.out.println("Result :");


    }
}
