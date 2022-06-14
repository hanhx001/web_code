package com.hhx.web_code.gee100;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadLocalTest {
    private static final  ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(()->null);

    private Map right(Integer userId){
        String before = Thread.currentThread().getName()+":"+currentUser.get();
        currentUser.set(userId);

        try {
            String after = Thread.currentThread().getName()+":"+currentUser.get();
            Map result = new HashMap();
            result.put("before",before);
            result.put("after",after);
            return result;
        }finally {
            // 在finall代码块中删除ThreadLOcal中的数据，却波啊数据不串
            currentUser.remove();
        }
    }


    private int thread(int taskCount,int threadCount) throws  InterruptedException{
      //总操作次数计数器
        AtomicInteger atomicInteger = new AtomicInteger();
        //使用CountDownLatch等待所有线程实行完成
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        //使用IntStream把数字直接转为Thread
        IntStream.rangeClosed(1,threadCount).mapToObj(i->new Thread(()->{
            //手动把taskCount分成taskCount份，每一份有一个线程执行
            IntStream.rangeClosed(1,taskCount/threadCount).forEach(j->{
                atomicInteger.incrementAndGet();
                //每一个线程处理完成自己那部分数据之后，countDown一次
                countDownLatch.countDown();
            });
        })).forEach(Thread::start);
        //等到所有线程执行完成
        countDownLatch.await();
        //查询计数器当前值
        return atomicInteger.get();


    }
}
