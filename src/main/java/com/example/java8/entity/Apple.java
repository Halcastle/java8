package com.example.java8.entity;

import lombok.Data;

/**
 * @ClassName Apple
 * @Description TODO
 * @Author pwang6
 * @Date 2021/7/13 11:03
 * @Version 1.0
 **/
@Data
public class Apple {
    private int weight;
    private String color;
    private String name;

    public Apple(int weight, String color, String name) {
        this.weight = weight;
        this.color = color;
        this.name = name;
    }

    public Apple(int weight,String color){
        this.weight = weight;
        this.color = color;
    }
}
