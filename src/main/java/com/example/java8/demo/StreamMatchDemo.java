package com.example.java8.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamFilterDemo
 * @Description TODO
 * @Author pwang6
 * @Date 2021/7/14 15:58
 * @Version 1.0
 **/
public class StreamMatchDemo {

    public static void main(String[] args){

        Stream<Integer> integerStream = Stream.of(new Integer[]{1,2,3,4,5,6,7});
        Consumer consumer = System.out::println;

        boolean result = integerStream.allMatch(integer -> integer > 7);
        consumer.accept(result);

        integerStream = Stream.of(new Integer[]{1,2,3,4,5,6,7});
        result = integerStream.anyMatch(integer -> integer > 7);
        consumer.accept(result);

        integerStream = Stream.of(new Integer[]{1,2,3,4,5,6,7});
        result = integerStream.noneMatch(integer -> integer > 10);
        consumer.accept(result);

    }
}
