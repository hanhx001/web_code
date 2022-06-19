package com.hhx.web_code.thread;

public class RunableTest {

    public void MyRunMain(String[] args) {
        MyRunable runable = new MyRunable();
        new Thread(runable).start();
    }


    class MyRunable implements Runnable{
        @Override
        public void run() {
            System.out.println("runable");
        }
    }

    //---------
    class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("runable2");
        }
    }

    public void MyThreadMain(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
