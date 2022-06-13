package com.hhx.web_code.gee100;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
@Slf4j
public class TimerTest {

    private AtomicInteger atomicInteger = new AtomicInteger();


    private void perSecend(){
          //每秒执行一次
          Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{
              log.info("DB QPS:{}",atomicInteger.getAndSet(0));
          },0,1, TimeUnit.SECONDS);
    }

    //
}
