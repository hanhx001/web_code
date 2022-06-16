package com.hhx.web_code.lambada;

import java.util.List;
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

    }

}
