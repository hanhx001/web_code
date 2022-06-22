package com.hhx.web_code.thread;

public class CanalService {
    //如果在多个线程中，有任意一个线程，把某个开关的状态设置为false，则整个功能停止。
    //volatile不能用于计数和统计等业务场景。因为volatile不能保证操作的原子性，可能会导致数据异常。
    private volatile boolean running = false;
    private Thread thread;

    public void handle() {
        while (running) {
            //业务处理
        }
    }

    public void start() {
        thread = new Thread(this::handle, "name");
        running = true;
        thread.start();
    }

    public void stop() {
        if (!running) {
            return;
        }
        running = false;
    }
}
