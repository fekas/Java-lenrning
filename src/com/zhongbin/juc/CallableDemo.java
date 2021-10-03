package com.zhongbin.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 有返回值，可抛出异常，借助FutureTask接收返回值
 *
 * 1.创建callable接口实现类
 * 2.创建对象
 * 3.将对象传入FutureTask构造器构造FutureTask对象
 * 4.将FutureTask对象传入Thread中s调用start方法创建线程
 * 5.获取FutureTask对象中的返回值
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*Callable<String> callable = () ->{
            Thread.sleep(2000);
            return "";
        };*/
        MyCallable myCallable = new MyCallable();

        FutureTask<String> stringFutureTask = new FutureTask<String>(myCallable);

        new Thread(stringFutureTask).start();

        System.out.println(stringFutureTask.get());

    }
}

class MyCallable implements Callable<String>{

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        int sum = 0;

        for (int i = 1; i < 100; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum + "";
    }
}
