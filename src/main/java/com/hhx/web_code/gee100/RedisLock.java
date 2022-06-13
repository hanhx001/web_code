package com.hhx.web_code.gee100;

import cn.hutool.core.util.StrUtil;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisLock {
    private RedissonClient redissonClient;

    @GetMapping("/redisLock/right")
    public String right(){
        String data = "";//从reids 获取数据
        if(StrUtil.isEmpty(data)){
            RLock lock = redissonClient.getLock("locker");
           //获取分布式锁
            if(lock.tryLock()){
                try{
                    data = "";//从redis获取数据
                    // 双重检查，因为可能已经有一个线程B过了第一次判断，在等待锁，
                    // 然后A线程已经吧数据写入了redis中
                    if(StrUtil.isEmpty(data)){
                        data = "";//从数据库获取数据
                        //查询后再将db数据设置到redis中数据
                    }
                }finally{
                    lock.unlock();
                }

            }
        }

        return data;
    }
}
