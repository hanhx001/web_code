package com.hhx.web_code.springlesson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

//@Aspect
@Service
@Slf4j
public class AopConfig {
   // @Around("execution(* com.hhx.web_code.springlesson.BeanAutowiredTest.test(..))")
    public void recordPayPerformance(){

    }
    //JDK 动态代理只能对实现了接口的类生成代理，而不能针对普通类。而 CGLIB 是可以针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法，来实现代理对象
}
