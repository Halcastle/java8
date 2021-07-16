package com.example.java8.demo;

import com.example.java8.entity.Dish;

import java.util.Arrays;
import java.util.List;
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

    }

    //获取食物卡路里平均值
    private static Double getDishCaloriesAverageByDouble(List<Dish> dishes){
        Double collect = dishes.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        return collect;
    }

    //获取食物卡路里平均值
    private static Double getDishCaloriesAverageByDouble1(List<Dish> dishes){
        Double collect = dishes.stream().collect(Collectors.averagingInt(Dish::getCalories));
        return collect;
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
