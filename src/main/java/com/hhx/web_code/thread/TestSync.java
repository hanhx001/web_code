package com.hhx.web_code.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhx
 * @date 2022/6/28
 * @note
 */
public class TestSync {

    static volatile  boolean notice = false;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Thread threadA = new Thread(()->{
            for(int i=1;i<=10;i++){
                list.add("abc");
                System.out.println("线程A");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(list.size() ==5){
                notice = true;
            }
        });

        Thread threadB = new Thread(()->{
            while(true){
                if(notice){
                    System.out.println("线程B");
                    break;
                }
            }
        });

        threadB.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        threadA.start();

    }


}
