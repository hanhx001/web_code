package com.hhx.web_code.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockService {
    private ReentrantLock reentrantLock = new ReentrantLock();
    public int age = 1;

    public void add(int i) {
        try {
            reentrantLock.lock();
            age = age + i;
            System.out.println("age" + age);

        } finally {
            //需要在finally代码块中手动释放锁
            reentrantLock.unlock();
        }


    }
}
