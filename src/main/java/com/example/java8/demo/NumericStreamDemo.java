package com.example.java8.demo;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName NumericStreamDemo
 * @Description 数字demo，Int--Integer
 * @Author Dream
 * @Date 2021-07-14 22:15
 * @Version 1.0
 **/
public class NumericStreamDemo {
    public static void main(String[] args) {
        Consumer consumer = System.out::println;
        Stream<Integer> stream = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Stream<Integer> integerStream = stream.filter(i -> i > 3);
        Optional<Integer> reduce = integerStream.reduce(Integer::sum);
        reduce.ifPresent(consumer);

        //有具体类型最好用具体类型，会很可观的减少堆内存使用大小
        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        IntStream intStream = stream.mapToInt(i -> i);
        int sum = intStream.filter(i -> i > 3).sum();
        consumer.accept(sum);


        //使用stream求勾股数
//        int a = 9;
//        IntStream.rangeClosed(1, 100)
//                //实现a与b开平方为整数
//                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
//                //将intStream装箱为IntegerStream
//                .boxed()
//                //转换IntegerStream为int[] Stream
//                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
//                //输出
//                .forEach(r -> System.out.println("a= " + r[0] + ",b= " + r[1] + ",c= " + r[2]));

//        Stream<int[]> pythagoreanTriples =
//                IntStream.rangeClosed(1, 100).boxed()
//                        .flatMap(a ->
//                                IntStream.rangeClosed(a, 100)
//                                        .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
//                                        .mapToObj(b ->
//                                                new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
//                        );
//        pythagoreanTriples.forEach(r -> System.out.println("a= " + r[0] + ",b= " + r[1] + ",c= " + r[2]));

        IntStream.rangeClosed(1, 100).boxed()
                .flatMap(
                        a -> IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                ).forEach(r -> System.out.println("a= " + r[0] + ",b= " + r[1] + ",c= " + r[2]));

    }
}
