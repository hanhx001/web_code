package com.hhx.web_code.thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author hhx
 * @date 2022/6/24
 * @note
 */
public class SimpleDateFormatTest {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final ThreadLocal<DateFormat> SAFE_DATE_FORMAT = ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    //synchronized等方式加锁
    private void test1() {
        for (int i=0;i<20;++i){
            Thread thread = new Thread(()->{
                try {
                    synchronized (SIMPLE_DATE_FORMAT){
                        System.out.println(Thread.currentThread().getName()+"-"+
                                SIMPLE_DATE_FORMAT.format(System.currentTimeMillis()));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            },"Thread-"+i);
            thread.start();
        }
    }

    private void test2(){
        for (int i=0;i<20;++i){
            Thread thread = new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"-"+
                                    SAFE_DATE_FORMAT.get().format(System.currentTimeMillis()));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            },"Thread-"+i);
            thread.start();
        }
    }
}
