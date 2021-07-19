package com.example.java8.entity;

import lombok.ToString;

/**
 * @ClassName Dish
 * @Description TODO
 * @Author pwang6
 * @Date 2021/7/14 16:16
 * @Version 1.0
 **/
@ToString
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;
    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    public int getCalories() {
        return calories;
    }
    public Type getType() {
        return type;
    }
    public enum Type { MEAT, FISH, OTHER }
}
