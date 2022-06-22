package com.hhx.web_code.thread;

import cn.hutool.core.collection.ListUtil;
import com.hhx.web_code.lambada.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                8,//corePoolSize线程池中核心线程数
                10,//maximumPoolSize 线程池中最大线程数
                60, //线程池中线程的最大空闲时间，超过这个时间空闲线程将被回收
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(500),//队列
                new ThreadPoolExecutor.CallerRunsPolicy()//拒绝策略
        );

        List<Student> studentList = new ArrayList<>();
        //此处应该添加一些数据

        for (Student student : studentList) {
            threadPool.submit(new Work(student));
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(studentList);
    }

    static class Work implements Runnable {

        private Student student;

        public Work(Student student) {
            this.student = student;
        }

        @Override
        public void run() {
            student.setSex(student.getSex() + "1");
        }
    }
}
