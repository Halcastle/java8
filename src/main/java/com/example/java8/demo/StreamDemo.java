package com.example.java8.demo;

import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @ClassName StreamDemo
 * @Description
 * Stream from collections
 * Stream from values
 * Stream from arrays
 * Stream from files
 * Stream from functions:creating infinite streams!
 *  Fibonacci tuples series
 * Generate
 * iterater
 * @Author pwang6
 * @Date 2021/7/13 18:26
 * @Version 1.0
 **/
public class StreamDemo {

    public static void main(String[] args){

//        getStreamFromCollections().forEach(System.out::println);
//        getStreamFromValues().forEach(System.out::println);
//        getStreamFromArrays().forEach(System.out::println);
//        Stream<String> streamFromFiles = getStreamFromFiles();
//        System.out.println(streamFromFiles);
        //在方法中读取
//        getStreamFromFiles();
//        getStreamFromIterator().forEach(System.out::println);
//        getStreamFromGenerator().forEach(System.out::println);
        getStreamFromObjSupplier().forEach(System.out::println);
    }

    /**
     * Stream from collections
     * @return
     */
    public static Stream<String> getStreamFromCollections(){
        List<String> strings = Arrays.asList("a", "b", "c", "pwang6", "hello");
        return strings.stream();
    };

    /**
     * Stream from values
     * @return
     */
    public static Stream<String> getStreamFromValues(){
        Stream<String> result = Stream.of("a", "b", "c", "pwang6", "hello");
        return result;
    };

    /**
     * Stream from arrays
     * @return
     */
    public static Stream<String> getStreamFromArrays(){
        String[] strings = {"a", "b", "c", "pwang6", "hello"};
        Stream<String> result = Arrays.stream(strings);
        return result;
    };

    /**
     * Stream from files
     * @return
     */
    public static Stream<String> getStreamFromFiles(){
        Path path = Paths.get("D:\\git\\java8\\src\\main\\java\\com\\example\\java8\\entity\\Apple.java");
        try(Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    /**
     *Stream from Iterator
     * @return
     */
    public static Stream<Integer> getStreamFromIterator(){
        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2).limit(10);
        return iterate;
    };

    /**
     *Stream from generator
     * @return
     */
    public static Stream<Double> getStreamFromGenerator(){
        Stream<Double> generate = Stream.generate(Math::random).limit(10);
        return generate;
    };

    public static Stream<Obj> getStreamFromObjSupplier(){
        return Stream.generate(new ObjSupplier()).limit(10);
    }

    static class ObjSupplier implements Supplier<Obj>{
        private int index = 0;
        private Random random = new Random(System.currentTimeMillis());
        @Override
        public Obj get() {
            index = random.nextInt(100);
            return new Obj(index,"name->"+index);
        }
    }

    @Data
    static class Obj{
        private int id;
        private String name;

        public Obj(int id,String name){
            this.id = id;
            this.name = name;
        }
    }
}
