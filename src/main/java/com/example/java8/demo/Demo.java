package com.example.java8.demo;

import com.example.java8.entity.Apple;
import com.example.java8.function.ThreeFunctionDef;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author pwang6
 * @Date 2021/7/13 10:46
 * @Version 1.0
 **/
public class Demo {

    public static void main(String[] args){
        BiFunction<String, Integer, Integer> stringIntegerIntegerBiFunction1 = Integer::parseInt;
        Function<String, Integer> stringIntegerIntegerBiFunction2 = Integer::parseInt;
        int i1 = stringIntegerIntegerBiFunction1.apply("1234",10);
        int i2 = stringIntegerIntegerBiFunction2.apply("1234");
        System.out.println("i1: "+i1);
        System.out.println("i2: "+i2);
        Consumer consumer = System.out::println;
        consumer.accept(i1);
        consumer.accept("------------------------");

        ThreeFunctionDef<Integer,String,String,Apple> threeFunctionDef = Apple::new;
        Apple a = threeFunctionDef.apply(12,"red","appleA");
        consumer.accept(a);

        consumer.accept("-------------");
        List<Apple> apples = Arrays.asList(threeFunctionDef.apply(42,"red","appleA"),threeFunctionDef.apply(13,"bed","appleB"),threeFunctionDef.apply(7,"aed","appleC"));
        consumer.accept(apples);
//        apples.sort(Comparator.comparing(Apple::getColor));
        List<String> appleName = getAppleNameByStream(apples);
        consumer.accept(appleName);
        ThreeFunctionDef<String, Integer, Integer, String> stringIntegerIntegerStringThreeFunctionDef = String::substring;
        consumer.accept(stringIntegerIntegerStringThreeFunctionDef.apply("abcd",1,4));
    }

    //重量小于20，按照颜色排序，获取apple.name
    private static List<String> getAppleNameByStream(List<Apple> apples){
        return apples.parallelStream().filter(apple -> {
//            try {
//                Thread.sleep(100000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            return apple.getWeight()<20;
        }).sorted(Comparator.comparing(Apple::getName)).map(Apple::getName).collect(Collectors.toList());
    }
}
