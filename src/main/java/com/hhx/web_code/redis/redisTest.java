package com.hhx.web_code.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author hhx
 * @date 2022/6/27
 * @note
 */
public class redisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    //分布式锁
    public String lock(String key,int timeOutSecond){
        for(;;){
            String stamp = String.valueOf(System.nanoTime());
            boolean exist = redisTemplate.opsForValue().setIfAbsent(key,stamp,timeOutSecond, TimeUnit.SECONDS)  ;
            if(exist){
                return stamp;
            }
        }
    }

}
