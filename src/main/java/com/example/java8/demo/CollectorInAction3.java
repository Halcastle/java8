package com.example.java8.demo;

import com.example.java8.entity.Dish;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @ClassName CollectorInAction3
 * @Description TODO
 * @Author Dream
 * @Date 2021-07-19 22:26
 * @Version 1.0
 **/
public class CollectorInAction3 {
    private static final List<Dish> dishs = getDishList();
    private static final Consumer consumer = System.out::println;

    public static void main(String[] args) {

        testPartitionByWithPreticate(dishs);
        testPartitionByWithPreticateAndCollector(dishs);
        testReducingBinaryOperator(dishs);
        testReducingBinaryOperatorAndIdentity(dishs);
        testReducingBinaryOperatorAndIdentityAndFunction();
        testSummarizingLong();
    }

    private static void testPartitionByWithPreticate(List<Dish> dishes){
        consumer.accept("----------testPartitionByWithPreticate---------------");
        Map<Boolean, List<Dish>> collect = dishes.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    //肉类和非肉类的平均卡路里
    private static void testPartitionByWithPreticateAndCollector(List<Dish> dishes){
        consumer.accept("----------testPartitionByWithPreticateAndCollector---------------");
        Map<Boolean, Double> collect = dishes.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.averagingDouble(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }
    private static void testReducingBinaryOperator(List<Dish> dishes){
        consumer.accept("----------testReducingBinaryOperator---------------");
        Optional<Dish> collect = dishes.stream().collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Dish::getCalories))));
        Optional.ofNullable(collect).ifPresent(consumer);
    }
    private static void testReducingBinaryOperatorAndIdentity(List<Dish> dishes){
        consumer.accept("----------testReducingBinaryOperatorAndIdentity---------------");
        Integer collect = dishes.stream().map(Dish::getCalories).collect(Collectors.reducing(0, (t1, t2) -> t1 + t2));
        Optional.ofNullable(collect).ifPresent(consumer);
    }
    private static void testReducingBinaryOperatorAndIdentityAndFunction(){
        consumer.accept("----------testReducingBinaryOperatorAndIdentity---------------");
        Integer collect = dishs.stream().collect(Collectors.reducing(0, Dish::getCalories, (t1, t2) -> t1 + t2));
        Optional.ofNullable(collect).ifPresent(consumer);
    }
    private static void testSummarizingLong(){
        consumer.accept("----------testSummarizingLong---------------");
        LongSummaryStatistics collect = dishs.stream().collect(Collectors.summarizingLong(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(consumer);
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
