package com.example.java8.demo;

import com.example.java8.entity.Insurance;

import java.util.Optional;

/**
 * @ClassName OptionalUsage
 * @Description TODO
 * @Author Dream
 * @Date 2021-07-15 23:08
 * @Version 1.0
 **/
public class OptionalUsage {
    public static void main(String[] args) {
        //Optional的创建方法
        Optional<Insurance> empty = Optional.empty();
        empty.get();

        Optional<Insurance> of = Optional.of(new Insurance());

        //无值返回empty，有值创建
        Optional<Insurance> insurance = Optional.ofNullable(new Insurance());
        //有值返回值，无值返回Supplier
        insurance.orElseGet(Insurance::new);
        //有值返回值，无值创建对应的对象
        insurance.orElse(new Insurance());
        //有值返回值，无值抛异常
        insurance.orElseThrow(RuntimeException::new);


    }
}
