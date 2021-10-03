package com.zhongbin.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 使用线程池创建线程
 */
public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        //设置线程池的属性
        System.out.println(executorService.getClass());
        executorService.setCorePoolSize(5);

        executorService.execute(new RunnableDemo());                      //适合使用runnable
        executorService.submit(new MyCallable());                         //适合适用于callable

        //关闭连接池
        executorService.shutdown();
    }
}
