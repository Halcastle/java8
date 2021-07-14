package com.example.java8.demo;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @ClassName StreamFindDemo
 * @Description TODO
 * @Author pwang6
 * @Date 2021/7/14 18:31
 * @Version 1.0
 **/
public class StreamFindDemo {

    public static void main(String[] args){
        Consumer consumer = System.out::println;

        Stream<Integer> integerStream = Stream.of(new Integer[]{1,2,3,4,5,6,7});
        Optional<Integer> anyoptional = integerStream.filter(integer -> integer % 2 == 0).findAny();
        Integer integer = anyoptional.get();
        consumer.accept(integer);

        integerStream = Stream.of(new Integer[]{1,2,3,4,5,6,7});
        Optional<Integer> firstoptional = integerStream.filter(i -> i % 2 == 0).findFirst();
        integer = firstoptional.get();
        consumer.accept(integer);

        integerStream = Stream.of(new Integer[]{1,2,3,4,5,6,7});
        firstoptional = integerStream.filter(i -> i > 200).findFirst();
//        integer = firstoptional.get();
//        consumer.accept(integer);

        int i1 = find(new Integer[]{1, 2, 3, 4, 5, 6, 7}, -1, i -> i > 200);
        consumer.accept(i1);


        integerStream = Stream.of(new Integer[]{1,2,3,4,5,6,7});
        firstoptional = integerStream.filter(i -> i > 6).findAny();
        boolean present = firstoptional.isPresent();
        consumer.accept(present);
        firstoptional.ifPresent(System.out::println);
        Integer integer1 = firstoptional.orElse(-1);
        consumer.accept(integer1);
        //对optional结果进行过滤
        Integer integer2 = firstoptional.filter(i -> i > 4).orElse(-1);
        consumer.accept(integer2);
    }

    private static int find(Integer[] integers, Integer defaultvalue, Predicate<Integer> predicate){
        for(Integer integer : integers){
            if(predicate.test(integer)){
                return integer;
            }
        }
        return defaultvalue;
    }
}
