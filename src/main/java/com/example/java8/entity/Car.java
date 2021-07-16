package com.example.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

/**
 * @ClassName Car
 * @Description TODO
 * @Author Dream
 * @Date 2021-07-15 22:53
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class Car {
    private Insurance insurance;
    private Optional<Insurance> optionalInsurance;
}
