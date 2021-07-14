package com.example.java8.demo;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @ClassName StreamReduceDemo
 * @Description Reduce 聚合操作
 * @Author Dream
 * @Date 2021-07-14 21:53
 * @Version 1.0
 **/
public class StreamReduceDemo {
    public static void main(String[] args) {
        Consumer consumer = System.out::println;
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Integer result = stream.reduce(0, (i, j) -> i + j);
        consumer.accept(result);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce((i, j) -> i + j).ifPresent(consumer);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce(Integer::max).ifPresent(consumer);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce(Integer::min).ifPresent(consumer);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce((i, j) -> i > j ? j : i).ifPresent(consumer);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.reduce(Integer::sum).ifPresent(consumer);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream.filter(i -> i % 2 == 0).reduce((i, j) -> i + j).ifPresent(consumer);
    }
}
