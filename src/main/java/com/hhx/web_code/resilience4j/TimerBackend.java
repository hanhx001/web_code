package com.hhx.web_code.resilience4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author hhx
 * @date 2022/7/6
 * @note
 */
@RestController
public class TimerBackend {
    private final Map<String,String> map = new HashMap<>();

    @PostConstruct
    private void init(){
        map.put("1","1");
    }

    @GetMapping("{timer}")
    public void getDemo(@PathVariable String timer) throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(10,10000));

    }
}
