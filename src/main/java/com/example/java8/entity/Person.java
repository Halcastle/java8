package com.example.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @ClassName Person
 * @Description TODO
 * @Author Dream
 * @Date 2021-07-15 22:53
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Car car;
    private Optional<Car> optionalCar;
}
