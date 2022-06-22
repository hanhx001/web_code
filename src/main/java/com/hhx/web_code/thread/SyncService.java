package com.hhx.web_code.thread;

public class SyncService {
    private int age = 1;
    private Object object = new Object();

    //同步方法
    public synchronized  void add(int i){
        age = age+i;
        System.out.println("age"+age);
    }

    public void update(int i){
        // 同步代码块，对象锁
        synchronized (object){
            age = age+i;
            System.out.println("age"+age);
        }
    }

    public void updateOne(int i){
        //同步代码块。类锁
        synchronized (SyncService.class){
            age =age+i;
            System.out.println("age"+age);
        }
    }

}
