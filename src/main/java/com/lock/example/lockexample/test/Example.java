package com.lock.example.lockexample.test;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Example {
    public synchronized void test1(String objN) {
        for (int i = 0; i < 10; i++) {
            System.out.println(objN + "===>>" + i);
        }
    }

    public static void main(String[] args) {
        Example example1 = new Example();
        Example example2 = new Example();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1("线程一");
        });
        executorService.execute(() -> {
            example2.test1("线程二");
        });
    }


}
