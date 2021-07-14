package com.example.java8.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @ClassName StreamFilterDemo
 * @Description TODO
 * @Author pwang6
 * @Date 2021/7/14 15:58
 * @Version 1.0
 **/
public class StreamFilterDemo {

    public static void main(String[] args){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7, 8, 8);
        Consumer consumer = System.out::println;
        List<Integer> result = integers.stream().filter(integer -> integer > 6).collect(Collectors.toList());
        consumer.accept(result);

        result = integers.stream().distinct().collect(Collectors.toList());
        consumer.accept(result);

        result = integers.stream().skip(50).collect(Collectors.toList());
        consumer.accept(result);

        result = integers.stream().limit(5).collect(Collectors.toList());
        consumer.accept(result);
    }
}
