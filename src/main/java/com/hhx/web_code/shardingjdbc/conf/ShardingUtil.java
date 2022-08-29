package com.hhx.web_code.shardingjdbc.conf;

import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ShardingUtil {

    private static final int DB_COUNT = 10;

    public static Long getShardingNum(String routeKey) {
        if (StrUtil.isBlank(routeKey)) {
            throw new IllegalArgumentException("empty routeKey");
        }

        long hashValue = HashUtil.cityHash64(routeKey.getBytes());
        if (hashValue < 0) {
            hashValue = Math.abs(hashValue);
        }
        Long  value = hashValue % DB_COUNT;
        if(value>9 && value<0){
            log.error("分表异常:routeKey:{},value:{}",routeKey,value);
            throw new IllegalStateException();
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(ShardingUtil.getShardingNum("1122"));
    }
}
