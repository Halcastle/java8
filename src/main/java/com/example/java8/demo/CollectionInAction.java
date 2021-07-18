package com.example.java8.demo;

import com.example.java8.entity.Dish;

import java.nio.file.OpenOption;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @ClassName CollectionInAction
 * @Description TODO
 * @Author pwang6
 * @Date 2021/7/16 18:43
 * @Version 1.0
 **/
public class CollectionInAction {
    public static void main(String[] args) {
        Consumer consumer = System.out::println;
        consumer.accept("getDishCaloriesAverageByDouble");
        getDishCaloriesAverageByDouble(getDishList());
        consumer.accept("getDishCaloriesAverageByInt");
        getDishCaloriesAverageByInt(getDishList());
        consumer.accept("getDishCaloriesAverageByLong");
        getDishCaloriesAverageByLong(getDishList());
        consumer.accept("getDishCaloriesCollectingAndThen");
        getDishCaloriesCollectingAndThen(getDishList());
        consumer.accept("getDishCounting");
        getDishCounting(getDishList());
        consumer.accept("getDishGroupByFunction");
        getDishGroupByFunction(getDishList());
        consumer.accept("getDishGroupByFunctionAndCollectors");
        getDishGroupByFunctionAndCollectors(getDishList());
        consumer.accept("getDishGroupByFunctionAndSupplierAndCollector");
        getDishGroupByFunctionAndSupplierAndCollector(getDishList());
        consumer.accept("getDishSummarizingInt");
        getDishSummarizingInt(getDishList());


    }

    //获取食物卡路里平均值
    private static void getDishCaloriesAverageByDouble(List<Dish> dishes) {
        Double collect = dishes.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    //获取食物卡路里平均值
    private static void getDishCaloriesAverageByInt(List<Dish> dishes) {
        Double collect = dishes.stream().collect(Collectors.averagingInt(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    //获取食物卡路里平均值
    private static void getDishCaloriesAverageByLong(List<Dish> dishes) {
        Double collect = dishes.stream().collect(Collectors.averagingLong(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    //获取食物卡路里平均值,并且继续做些事情
    private static void getDishCaloriesCollectingAndThen(List<Dish> dishes) {
        String collect = dishes.stream().collect(Collectors.collectingAndThen(Collectors.averagingDouble(Dish::getCalories), a -> "这些食物的卡路里平均值为：" + a));
        Optional.ofNullable(collect).ifPresent(System.out::println);

        //获取食物中所有肉类的列表
//        List<Dish> meatCollect = dishes.stream().filter(t -> t.getType().equals(Dish.Type.MEAT)).collect(Collectors.toList());
//        //此处做了修改，改变了本身要实现的输出肉类的需求，若输出之后不让改？使用Collectors.collectingAndThen
//        meatCollect.add(new Dish("111french fries", true, 530, Dish.Type.OTHER));
//        Optional.ofNullable(meatCollect).ifPresent(System.out::println);
        //获取食物中所有肉类的列表,并不可改变
        List<Dish> meatCollect = dishes.stream().filter(t -> t.getType().equals(Dish.Type.MEAT)).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        //此处做了修改，改变了本身要实现的输出肉类的需求，若输出之后不让改？使用Collectors.collectingAndThen
//        meatCollect.add(new Dish("111french fries", true, 530, Dish.Type.OTHER));
        Optional.ofNullable(meatCollect).ifPresent(System.out::println);
    }

    private static void getDishCounting(List<Dish> dishes){
        Optional.ofNullable(dishes.stream().collect(Collectors.counting())).ifPresent(System.out::println);
    }

    private static void getDishGroupByFunction(List<Dish> dishes){
        Optional.ofNullable(dishes.stream().collect(Collectors.groupingBy(Dish::getType))).ifPresent(System.out::println);
    }

    private static void getDishGroupByFunctionAndCollectors(List<Dish> dishes){
//        Map<Dish.Type, Long> collect = dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
//        Optional.ofNullable(collect).ifPresent(System.out::println);
        Map<Dish.Type, Double> collect = dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.averagingDouble(Dish::getCalories)));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void getDishGroupByFunctionAndSupplierAndCollector(List<Dish> dishes){
        Map<Dish.Type, Double> collect = dishes.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.averagingDouble(Dish::getCalories)));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
        //更改返回值类型为TreeMap
        TreeMap<Dish.Type, Long> collect1 = dishes.stream().collect(Collectors.groupingBy(Dish::getType, TreeMap::new, Collectors.counting()));
        Optional.ofNullable(collect1.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect1).ifPresent(System.out::println);
    }

    private static void getDishSummarizingInt(List<Dish> dishes){
        IntSummaryStatistics collect = dishes.stream().collect(Collectors.summarizingInt(Dish::getCalories));
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
