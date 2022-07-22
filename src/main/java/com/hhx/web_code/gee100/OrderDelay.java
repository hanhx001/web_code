package com.hhx.web_code.gee100;

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


}
