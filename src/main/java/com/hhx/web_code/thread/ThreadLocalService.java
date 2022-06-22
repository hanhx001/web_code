package com.hhx.web_code.thread;

public class ThreadLocalService {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();


    /**
     * ThreadLocal的核心思想是：
     * 共享变量在每个线程都有一个副本，每个线程操作的都是自己的副本，对另外的线程没有影响。
     * @param i
     */
    public void add(int i) {
        Integer integer = threadLocal.get();
        threadLocal.set(integer == null ? 0 : integer + i);
    }
}
