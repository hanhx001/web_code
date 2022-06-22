package com.hhx.web_code.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicService {

    private AtomicInteger atomicInteger = new AtomicInteger();

    public int add(int i){
        return atomicInteger.getAndAdd(i);
    }
}
