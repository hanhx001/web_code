package com.hhx.web_code.lambada;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Testlambada {

    public static void main(String[] args) {
        Predicate<Integer> atLeast5 = x -> x > 5;
        assert atLeast5.test(6);

        List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
        Optional<String> c = Stream.of("a", "b", "c").reduce((a, b)->a+b);
        Optional<Integer> f = Stream.of(1, 1, 3).reduce((d, e) -> d * e);
        Stream.of(1,2,3).reduce(Integer::sum);

        //因此只有装箱类型才能作为泛型参
        List<Integer> list = Stream.of(1,2,3).collect(Collectors.toList());
        list.parallelStream().peek(x-> System.out.println(x)).collect(Collectors.toList()) ;
    }

    private String getStudent(List<Student> stuList){
        Map<String,List<Student>> map  = stuList.stream().filter((Student s)-> s.getHeight()>160).collect(Collectors.groupingBy(Student::getSex));
        stuList.parallelStream().filter((Student s)-> s.getHeight()>160).collect(Collectors.groupingBy(Student::getSex));
        return "";
    }


}
