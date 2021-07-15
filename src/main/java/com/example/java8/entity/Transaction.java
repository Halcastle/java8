package com.example.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Transaction
 * @Description TODO
 * @Author pwang6
 * @Date 2021/7/15 9:18
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
}
