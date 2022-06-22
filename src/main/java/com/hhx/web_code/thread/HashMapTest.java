package com.hhx.web_code.thread;

import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
    private static ConcurrentHashMap<String, Object> hashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                hashMap.put("key1", "value1");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                hashMap.put("key2", "value2");
            }
        }).start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(hashMap);
    }


}
