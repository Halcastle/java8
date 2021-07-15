package com.example.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Trader
 * @Description TODO
 * @Author pwang6
 * @Date 2021/7/15 9:14
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class Trader {
    private final String name;
    private final String city;
}
