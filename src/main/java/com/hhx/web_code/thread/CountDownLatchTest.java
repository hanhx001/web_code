package com.hhx.web_code.thread;

import java.util.concurrent.*;

/**
 * @author hhx
 * @date 2022/6/30
 * @note
 */
public class CountDownLatchTest {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for(int i=0;i<10;i++){
            cachedThreadPool.execute(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+" start");
                } finally {
                    latch.countDown();
                }
            });
        }

        try {
            latch.await(5, TimeUnit.SECONDS);
        } finally {
            System.out.println(latch.toString());
        }

    }



}
