package com.example.java8.function;

/**
 * @ClassName ThreeFunctionDef
 * @Description TODO
 * @Author pwang6
 * @Date 2021/7/13 11:00
 * @Version 1.0
 **/
@FunctionalInterface
public interface ThreeFunctionDef<A,B,C,R> {
    /**
     *
     * @return
     */
    public R apply(A a,B b,C c);
}
