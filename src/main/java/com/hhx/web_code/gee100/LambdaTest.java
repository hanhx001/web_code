package com.hhx.web_code.gee100;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

public class LambdaTest {
    public static void main(String[] args) {
        //新建线程
        new Thread(() -> {
            System.out.println("Hello World!");
        }).start();

        //适用lambda表达睡提供Supplier接口实现，返回ok字符串
        Supplier<String> supplier = () -> "ok";
        //使用方法引用提供Supplier接口实现，返回空字符串
        Supplier<String> supplier1 = String::new;

        //Predicate接口是输入一个参数，返回布尔值，我们通过and方法组合两个Prdicate条件，判断是否值大于0并且是偶数
        Predicate<Integer> predicate = i -> i > 0;
        Predicate<Integer> evenNumber = i -> i % 2 == 0;
        predicate.and(evenNumber).test(2);

        //Consumer接口是消费一个数据。我们通过andThen方法组合调用两个Consumer，输出两行abcdefg
        Consumer<String> print = System.out::println;
        print.andThen(print).accept("abcdefg");

        //Function接口是输入一个数据，计算后输出一个数据。我们先把字符串转换为大写，然后通过andThen组合另一个Function实现字符串拼接
        Function<String,String> upperCase = String ::toUpperCase;
        Function<String,String> duplicate = s -> s.concat(s);
        upperCase.andThen(duplicate).apply("abc");

        //Supplier是提供一个数据的接口。这里我们实现获取一个随机数
        Supplier<Integer> random = ()-> ThreadLocalRandom.current().nextInt();
        random.get();

        //BinaryOperator是输入两个同类型参数，输出一个同类型参数的接口。这里我们通过方法引用获得一个整数加法操作，通过Lambda表达式定义一个减法操作，然后依次调用
        BinaryOperator<Integer> add = Integer::sum;
        BinaryOperator<Integer> subtraction = (a,b) -> a-b;
        subtraction.apply(add.apply(1,2),3);


    }


}
