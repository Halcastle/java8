package com.example.java8.demo;

import com.example.java8.entity.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @ClassName CollectorInAction2
 * @Description TODO
 * @Author Dream
 * @Date 2021-07-19 21:20
 * @Version 1.0
 **/
public class CollectorInAction2 {

    private static Consumer consumer = System.out::println;
    private static final List<Dish> dishs = getDishList();
    public static void main(String[] args) {

        testGroupingByConcurrent(dishs);
        testGroupingByConcurrentWithFunctionAndCollector(dishs);
        testGroupingByConcurrentWithFunctionAndSupplierAndCollector(dishs);
        testJoin(dishs);
        testJoinWithDelimiter(dishs);
        testJoinWithDelimiterAndPre(dishs);
        testMapping(dishs);
        testMaxBy(dishs);
        testMinBy(dishs);
    }
    private static void testGroupingByConcurrent(List<Dish> dishes){
        consumer.accept("-----------testGroupingByConcurrent--------------");
        ConcurrentMap<Dish.Type, List<Dish>> collect = dishes.stream().collect(Collectors.groupingByConcurrent(Dish::getType));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    private static void testGroupingByConcurrentWithFunctionAndCollector(List<Dish> dishes){
        consumer.accept("-----------testGroupingByConcurrentWithFunctionAndCollector--------------");
        ConcurrentMap<Dish.Type, Double> collect = dishes.stream().collect(Collectors.groupingByConcurrent(Dish::getType, Collectors.averagingDouble(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    private static void testGroupingByConcurrentWithFunctionAndSupplierAndCollector(List<Dish> dishes){
        consumer.accept("-----------testGroupingByConcurrentWithFunctionAndSupplierAndCollector--------------");
        ConcurrentMap<Dish.Type, Double> collect = dishes.stream().collect(Collectors.groupingByConcurrent(Dish::getType, ConcurrentSkipListMap::new, Collectors.averagingDouble(Dish::getCalories)));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    private static void testJoin(List<Dish> dishes){
        consumer.accept("-----------testJoin--------------");
        String collect = dishes.stream().map(Dish::getName).collect(Collectors.joining());
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    private static void testJoinWithDelimiter(List<Dish> dishes){
        consumer.accept("-----------testJoinWithDelimiter--------------");
        String collect = dishes.stream().map(Dish::getName).collect(Collectors.joining(","));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    private static void testJoinWithDelimiterAndPre(List<Dish> dishes){
        consumer.accept("-----------testJoinWithDelimiterAndPre--------------");
        String collect = dishes.stream().map(Dish::getName).collect(Collectors.joining(",","begin->","<-end"));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    private static void testMapping(List<Dish> dishes){
        consumer.accept("-----------testMapping--------------");
        String collect = dishes.stream().collect(Collectors.mapping(Dish::getName, Collectors.joining(",")));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    private static void testMaxBy(List<Dish> dishes){
        consumer.accept("-----------testMaxBy--------------");
        Optional<Dish> collect = dishes.stream().collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    private static void testMinBy(List<Dish> dishes){
        consumer.accept("-----------testMaxBy--------------");
        Optional<Dish> collect = dishes.stream().collect(Collectors.minBy(Comparator.comparing(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static List<Dish> getDishList() {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        return menu;
    }
}
