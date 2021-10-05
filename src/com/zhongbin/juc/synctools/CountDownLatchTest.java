package com.zhongbin.juc.synctools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    private final static Random random = new Random();

    static class SearchTask implements Runnable{
        private Integer id;
        private  CountDownLatch latch;

        public SearchTask(Integer id, CountDownLatch latch){
            this.id = id;
            this.latch = latch;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            System.out.println("start to find No." + id + "ball");
            int second = random.nextInt(10);
            try {
                Thread.sleep(second * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Find No." + id + "Ball took " + second + "s");
            latch.countDown();
        }
    }
    //开七个子任务📱龙珠，七个龙珠收集完成才可以召唤神龙
    public static void main(String[] args) {
        List<Integer> idList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        CountDownLatch latch = new CountDownLatch(idList.size());

        for (Integer id : idList) {
            Thread thread = new Thread(new SearchTask(id, latch));
            thread.start();
        }
        try {
            latch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("competed!!!");
    }
}
