package com.example.java8.demo;

import com.example.java8.entity.Dish;

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
public class StreamMapDemo {

    public static void main(String[] args){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7, 8, 8);
        Consumer consumer = System.out::println;

        List<Integer> integerResult = integers.stream().map(integer -> integer * 2).collect(Collectors.toList());
        consumer.accept(integerResult);

        List<Boolean> booleanResult = integers.stream().map(integer -> integer > 2).collect(Collectors.toList());
        consumer.accept(booleanResult);

        //map：将一种类型转为另一种类型
        List<String> stringResult = integers.stream().map(integer -> {
            String s;
            switch (integer) {
                case 1:
                    s = "a";
                    break;
                case 2:
                    s = "b";
                    break;
                case 3:
                    s = "c";
                    break;
                default:
                    s = "w";
                    break;
            }
            return s;
        }).collect(Collectors.toList());
        consumer.accept(stringResult);

        //flateMap:将多个Stream合并
        String[] words = {"hello","world"};
        Stream<String[]> stream = Arrays.stream(words).map(s -> s.split(""));
//        List<String[]> stringResult2 = stream.collect(Collectors.toList());
//        consumer.accept(stringResult2);
        Stream<String> stringStream = stream.flatMap(Arrays::stream);
        stringResult = stringStream.collect(Collectors.toList());
        consumer.accept(stringResult);
    }

    private static List<Dish> getDishList(){
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
        return menu;
    }
}
