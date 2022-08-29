package com.hhx.web_code.gee100;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author hhx
 * @date 2022/7/22
 * @note
 */
public class OrderDelay implements Delayed {

    private String orderId;

    private long timeout;

    OrderDelay(String orderId, long timeout) {
        this.orderId = orderId;
        this.timeout = timeout;
    }


    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeout - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == this) {
            return 0;
        }

        OrderDelay t = (OrderDelay) o;
        long d = getDelay(TimeUnit.MILLISECONDS) - t.getDelay(TimeUnit.MILLISECONDS);
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    void print() {
        System.out.println("OrderDelay.print");
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");


        DelayQueue<OrderDelay> queue = new DelayQueue<OrderDelay>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            queue.put(new OrderDelay(list.get(i), TimeUnit.NANOSECONDS.convert(10, TimeUnit.SECONDS)));
            try {
                queue.take().print();
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }
    }

}
